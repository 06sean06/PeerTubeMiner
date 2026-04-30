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

import aiss.PeerTube.model.modelPT.channel.ChannelPT;
import aiss.PeerTube.model.modelPT.channel.ChannelPTResponse;
import aiss.PeerTube.model.modelVM.ChannelVM;
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
        @SuppressWarnings("null") // Lo he añadido porque VSCode cree que HttpMethod.GET es null, pero no lo es, es un enum.
        ResponseEntity<ChannelPT> response = restTemplate.exchange(uri, HttpMethod.GET, request, ChannelPT.class);
        return response.getBody();
    }    

}
