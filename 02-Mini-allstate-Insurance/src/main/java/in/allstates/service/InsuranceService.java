package in.allstates.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;


import in.allstates.bindings.InsurancePlanCustomers;
import in.allstates.bindings.SearchRequest;
import in.allstates.dto.CustomerDto;

@Service
public interface InsuranceService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<InsurancePlanCustomers> getPlanCusotmers(SearchRequest searchRequest);
	
	public String generateReport(HttpServletResponse response, String reportType) throws IOException;
	
	
	

}
