package aiss.PeerTube.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import aiss.PeerTube.model.modelPT.channel.ChannelPT;
import aiss.PeerTube.model.modelPT.channel.ChannelPTResponse;
import aiss.PeerTube.model.modelPT.video.VideoPT;
import aiss.PeerTube.model.modelPT.video.VideoPTResponse;
@Service
public class ChannelPTService {
    @Autowired
    RestTemplate restTemplate;

     @Value("${PeerTube.maxVideos}")
    private Integer defaultVideos;

    @Value("${peertube.url}")
    private String url; 

    // Obtener todos los videos de un canal.
    public List<VideoPT> getVideosOfAChannel(String channelHandle, Integer maxVideos) {
        //https://peertube3.cpy.re/api/v1  /video-channels/{blender_open_movies@video.blender.org}/videos
        int limit = (maxVideos != null) ? maxVideos : defaultVideos;
        String uri = url + "/video-channels/" + channelHandle + "/videos?count=" + limit;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<VideoPTResponse> request = new HttpEntity<>(headers);

        @SuppressWarnings("null") // Lo he añadido porque VSCode cree que HttpMethod.GET es null, pero no lo es, es un enum.
        ResponseEntity<VideoPTResponse> response = restTemplate.exchange(uri, HttpMethod.GET, request, VideoPTResponse.class);
        VideoPTResponse body = response.getBody();
        if (body == null || body.getData() == null) {
            return List.of();
        }

        return body.getData();
    }
    
    // A PARTIR DEL CHANNEL SE OBTIENE EL OWNER ACCOUT (USUARIO)
    // A PARTIR DEL CHANNEL SE OBTIENEN LOS VIDEOS (getVideosOfAChannel). 
    // A PARTIR DE LOS VIDEOS (desde el id) SE OBTIENEN LAS CAPTIONS (findAllCaptionsOfVid)
    // A PARTIR DE LOS VIDEOS (desde el id) SE OBTIENEN LOS COMMENTS (getCommentsByVideo)

    //Obtener el listado de canales de PeerTube. Se devuelve una lista vacía si no hay canales.
    // GET https://peertube3.cpy.re/api/v1/video-channels
    public List<ChannelPT> findAllChannels() {
        String uri = url + "/video-channels";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);
        @SuppressWarnings("null") // Lo he añadido porque VSCode cree que HttpMethod.GET es null, pero no lo es, es un enum.
        ResponseEntity<ChannelPTResponse> response = restTemplate.exchange(uri, HttpMethod.GET, request, ChannelPTResponse.class);
        ChannelPTResponse body = response.getBody();
        if (body == null || body.getData() == null) {
            return List.of();
        }
        return body.getData();
    }

    //Obtener un canal en concreto
    // GET https://peertube3.cpy.re/api/v1/video-channels/{ChannelHandle}
    public ChannelPT findChannelById(String channelHandle) {
        String uri = url + "/video-channels/" + channelHandle;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);
        try{
            @SuppressWarnings("null") // Lo he añadido porque VSCode cree que HttpMethod.GET es null, pero no lo es, es un enum.
            ResponseEntity<ChannelPT> response = restTemplate.exchange(uri, HttpMethod.GET, request, ChannelPT.class);
            return response.getBody();
    } catch (HttpClientErrorException.NotFound e) {
        return null;
    } catch (Exception e) {
        return null;
    }

}    

}
