package lavajato.crm.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LavaJatoCrmApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(LavaJatoCrmApplication.class, args);
	}

	@Override
    public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:8080")
            .allowedMethods("*")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}