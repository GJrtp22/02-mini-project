package in.allstates.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.allstates.bindings.InsurancePlan;
import in.allstates.bindings.InsurancePlanCustomers;
import in.allstates.service.InsuranceService;

@RestController
public class InsuranceCustomsersRestController {
	
	@Autowired
	private InsuranceService insuranceService;
	
	@GetMapping("/")
	public List<InsurancePlanCustomers> getAllCustomers(){
		return insuranceService.getAllCustomers();	}
	
	@GetMapping("/customer")
	public List<InsurancePlanCustomers> getCustomers(@RequestBody InsurancePlan insurancePlan)
	{
		return insuranceService.getCusotmers(insurancePlan);
	}
	
}
