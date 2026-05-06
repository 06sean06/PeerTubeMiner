package aiss.PeerTube.repositoryPT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import aiss.PeerTube.exception.ChannelAlreadyExistsException;
import aiss.PeerTube.model.modelPT.caption.CaptionPT;
import aiss.PeerTube.model.modelPT.channel.ChannelPT;
import aiss.PeerTube.model.modelPT.comment.CommentBasePT;
import aiss.PeerTube.model.modelPT.video.VideoPT;
import aiss.PeerTube.model.modelVM.CaptionVM;
import aiss.PeerTube.model.modelVM.ChannelVM;
import aiss.PeerTube.model.modelVM.CommentVM;
import aiss.PeerTube.model.modelVM.VideoVM;
import aiss.PeerTube.services.CaptionPTService;
import aiss.PeerTube.services.ChannelPTService;
import aiss.PeerTube.services.CommentPTService;
import aiss.PeerTube.transformer.Transformer;

@Repository
public class OficialRepository {

    @Autowired
    private ChannelPTService channelPTService;

    @Autowired
    private CaptionPTService captionPTService;

    @Autowired
    private CommentPTService commentPTService;

    @Autowired
    private Transformer transformer;
    
    @Value("${PeerTube.maxVideos}")
    private Integer defaultMaxVideos;

    @Value("${PeerTube.maxComments}")
    private Integer defaultMaxComments;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${videominer.url}")
    private String urlvm; //http://localhost:8080/VideoMiner

    public ChannelVM getAChannel(String channelHandle) {
        ChannelPT canalPT = channelPTService.findChannelById(channelHandle);
        if (canalPT == null) {
            return null; // el controller lanzará ChannelNotFoundException
        }
        ChannelVM canalVM = transformer.transformChannel(canalPT);
        List<VideoPT> videosPT = channelPTService.getVideosOfAChannel(channelHandle, defaultMaxVideos);
        List<VideoVM> videosVM = new ArrayList<>();

        for (VideoPT videoPT : videosPT) {
            String videoId = videoPT.getId().toString();
            List<CaptionPT> captionsPT = captionPTService.findAllCaptionsOfVid(videoId);
            List<CommentBasePT> commentsPT = commentPTService.getCommentsByVideo(videoId, defaultMaxComments);

            VideoVM videoVM = transformer.transformVideo(videoPT);
            List<CaptionVM> captionsVM = captionsPT.stream()
                    .map(transformer::transformCaption)
                    .collect(Collectors.toList());
            List<CommentVM> commentsVM = commentsPT.stream().map(transformer::transformComment).collect(Collectors.toList());

            videoVM.setCaptions(captionsVM);
            videoVM.setComments(commentsVM);
            videoVM.setUser(transformer.transformUser(videoPT.getAccount()));
            videosVM.add(videoVM);
        }
        canalVM.setVideos(videosVM);
        return canalVM;
    }

    public ChannelVM createAChannel(String channelHandle) throws ChannelAlreadyExistsException {
        ChannelVM channelVM = getAChannel(channelHandle);
        if (channelVM == null) {
            return null; 
        }
        String uriPost = urlvm + "/channels";
        String uriGet = urlvm + "/channels/" + channelHandle;
        try {
            ResponseEntity<ChannelVM> existingResponse = restTemplate.getForEntity(uriGet, ChannelVM.class);
            if (existingResponse.getStatusCode().is2xxSuccessful()) {
                throw new ChannelAlreadyExistsException();
            }
        } catch (ChannelAlreadyExistsException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("El canal no existe en VideoMiner, procediendo a crear...");
        }
        ResponseEntity<ChannelVM> response = restTemplate.postForEntity(uriPost, channelVM, ChannelVM.class);
        return response.getBody();
    }

}
