package meenakshi.sundaram.moviescatalogservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MoviesCatalogServicesApplication {
    @Bean
    public RestTemplate gettemplate(){
        return new RestTemplate();
    }
    @Bean
    public WebClient.Builder getWebclient(){
        return  WebClient.builder();
    }

    public static void main(String[] args) {
		SpringApplication.run(MoviesCatalogServicesApplication.class, args);
 }

}