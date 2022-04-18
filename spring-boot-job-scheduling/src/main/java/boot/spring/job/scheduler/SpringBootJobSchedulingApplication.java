package boot.spring.job.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootJobSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJobSchedulingApplication.class, args);
	}

}
