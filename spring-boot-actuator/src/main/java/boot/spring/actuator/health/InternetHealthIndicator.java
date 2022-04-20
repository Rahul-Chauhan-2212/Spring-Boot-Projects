package boot.spring.actuator.health;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class InternetHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		return checkInternetConnnection() == true
				? Health.up().withDetail("success code", "Active Internet Connection").build()
				: Health.down().withDetail("error code", "No Active Internet Connection").build();
	}

	private boolean checkInternetConnnection() {
		boolean flag = false;
		try {
			URL url = new URL("https://www.google.com");
			URLConnection connection = url.openConnection();
			connection.connect();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

}
