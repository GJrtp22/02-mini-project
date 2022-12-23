package in.allstates.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

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
	
	@GetMapping("/{reportType}")
	public String generateReport(HttpServletResponse httpServletResponse, @PathVariable String reportType ) throws IOException, DocumentException
	{
		
		return insuranceService.generateReport(httpServletResponse, reportType);
		
	}
	
}
