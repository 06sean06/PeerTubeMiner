package aiss.PeerTube.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import aiss.PeerTube.modelPT.channel.ChannelPT;
import aiss.PeerTube.modelPT.channel.ChannelPTResponse;
@Service
public class ChannelPTService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${peertube.url}")
    private String url; 
    //Obtener el listado de canales de PeerTube. Se devuelve una lista vacía si no hay canales.
    // GET https://peertube3.cpy.re/api/v1/video-channels
    public List<ChannelPT> findAllChannels() {
        String uri = url + "/video-channels";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<ChannelPTResponse> response = restTemplate.exchange(uri, HttpMethod.GET, request, ChannelPTResponse.class);
        return response.getBody().getData();
    }

    //Obtener un canal en concreto
    // GET https://peertube3.cpy.re/api/v1/video-channels/{ChannelHandle}
    public ChannelPT findChannelById(String channelHandle) {
        String uri = url + "/video-channels/" + channelHandle;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<ChannelPT> response = restTemplate.exchange(uri, HttpMethod.GET, request, ChannelPT.class);
        return response.getBody();
    }

    

}
