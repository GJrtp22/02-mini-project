package in.allstates.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import in.allstates.bindings.InsurancePlanCustomers;
import in.allstates.bindings.SearchRequest;

import in.allstates.service.InsuranceService;

@RestController
public class InsuranceCustomsersRestController {
	
	@Autowired
	private InsuranceService insuranceService;
	
	
	@GetMapping("/plannames")
	public List<String> getPlaNames()
	{
		return insuranceService.getPlanNames();
	}
	
	@GetMapping("/planstatus")
	public List<String> getPlanStatus()
	{
		return insuranceService.getPlanStatus();
	}
	
	@GetMapping("/customer")
	public List<InsurancePlanCustomers> getCustomers(@RequestBody SearchRequest searchrequest)
	{
		return insuranceService.getPlanCusotmers(searchrequest);
	}
	
}
