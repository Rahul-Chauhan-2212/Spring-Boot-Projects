package boot.spring.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Endpoint(id = "myendpoint", enableByDefault = true)
public class MyEndPoint {

	@ReadOperation
	public MyEndPointResponse feature() {
		return new MyEndPointResponse(123, "Rahul", "Active");
	}

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class MyEndPointResponse {
	private int id;
	private String name;
	private String status;
}
