package in.allstates.service;

import java.util.List;

import in.allstates.bindings.InsurancePlan;
import in.allstates.bindings.InsurancePlanCustomers;


public interface InsuranceService {
	
	public List<InsurancePlanCustomers> getAllCustomers();
	
	public List<InsurancePlanCustomers> getCusotmers(InsurancePlan insurancePlan);
	
	public String generateReport(String reportType);
	
	
	

}
