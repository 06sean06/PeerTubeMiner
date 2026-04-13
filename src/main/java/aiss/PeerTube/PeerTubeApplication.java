package aiss.PeerTube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
