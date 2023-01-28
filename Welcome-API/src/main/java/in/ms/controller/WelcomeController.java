package in.ms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ms.fiegnclienapi.GreetApiClient;

@RestController
public class WelcomeController {
	
	private Logger logger=LoggerFactory.getLogger(WelcomeController.class);
	
	@Autowired
	private GreetApiClient apiClient;
	
	@GetMapping("welcome/")
	public String welcomeMsg()
	{
		logger.info("welcome msg() executed");
		String welcomeMsg = "Welcome to Ashok IT..!!";
		String greetMsg=apiClient.greet();
		logger.info("welcome msg() end");
		
		return welcomeMsg+ " "+ greetMsg;
		
	}

}
