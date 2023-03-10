package in.ms.fiegnclienapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name= "GREET-API")
public interface GreetApiClient {
	
	@GetMapping("greet/")
	public String greet();
}
