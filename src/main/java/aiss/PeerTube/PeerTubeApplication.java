package aiss.PeerTube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
 

@SpringBootApplication
public class PeerTubeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeerTubeApplication.class, args);
	}
	
	// ¿No haría falta este método?
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
