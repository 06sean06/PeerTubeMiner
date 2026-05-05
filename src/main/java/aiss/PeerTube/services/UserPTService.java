package aiss.PeerTube.services;

import java.util.Arrays;
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

import aiss.PeerTube.model.modelPT.channel.OwnerAccountPT;
import aiss.PeerTube.model.modelPT.channel.OwnerAccountPTResponse;

@Service
public class UserPTService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${peertube.url}")
    private String url;

    //Obtener listado de usuarios de PeerTube
    // GET https://peertube3.cpy.re/api/v1/accounts
    public List<OwnerAccountPT> findAllUsers() {
        String uri = url + "/accounts";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);
        @SuppressWarnings("null")
        ResponseEntity<OwnerAccountPTResponse> response = restTemplate.exchange(uri, HttpMethod.GET, request, OwnerAccountPTResponse.class);
         
        OwnerAccountPTResponse body = response.getBody();
        if (body == null || body.getData() == null) {
            return List.of();
        }

        return Arrays.stream(body.getData()).toList();
    }

    //Obterner un usuario en concreto
    // GET https://peertube3.cpy.re/api/v1/accounts/{accountName}
    public OwnerAccountPT findUserByName(String accountName) {
        String uri = url + "/accounts/" + accountName;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);
       try {
        @SuppressWarnings("null")
        ResponseEntity<OwnerAccountPT> response = restTemplate.exchange(uri, HttpMethod.GET, request, OwnerAccountPT.class);
        return response.getBody();
    } catch (HttpClientErrorException.NotFound e) {
        return null;
    } catch (Exception e) {
        return null;
    }
    }

}
