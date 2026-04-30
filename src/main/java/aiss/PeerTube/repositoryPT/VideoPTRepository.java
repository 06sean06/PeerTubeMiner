package aiss.PeerTube.repositoryPT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aiss.PeerTube.model.modelPT.video.VideoPT;
import aiss.PeerTube.model.modelVM.VideoVM;
import aiss.PeerTube.services.VideoPTService;

@Repository
public class VideoPTRepository {

    @Autowired
    VideoPTService videoPTService;

    public List<VideoPT> findAllVideos() {
        List<VideoPT> videos = videoPTService.findAllVideos();
        return videos;
    }
    public VideoPT findVideoById(String idVideo) {
        VideoPT video = videoPTService.findVideoById(idVideo);
        return video;
    }

    //POST A VIDEO
    public VideoVM createVideo(VideoPT videoPT) {
        VideoVM caption = videoPTService.createVideo(videoPT);
        return caption;
    }

}
