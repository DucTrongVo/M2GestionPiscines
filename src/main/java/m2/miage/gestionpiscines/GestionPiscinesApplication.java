package m2.miage.gestionpiscines;

import m2.miage.gestionpiscines.exceptions.ErrorHandler;
import m2.miage.gestionpiscines.services.PiscineServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionPiscinesApplication {

    // URL micro service gestion Piscine
    public static final String GESTION_PISCINE_URL = "https://data.toulouse-metropole.fr/api/records/1.0/search/?dataset=piscines&";

    public static void main(String[] args) {
        SpringApplication.run(GestionPiscinesApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ErrorHandler());
        return restTemplate;
    }

    @Bean
    public PiscineServiceImpl piscineService() {
        return new PiscineServiceImpl(GESTION_PISCINE_URL);
    }

}
