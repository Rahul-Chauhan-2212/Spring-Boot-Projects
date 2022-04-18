package boot.spring.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringBootSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerApplication.class, args);
	}

}
