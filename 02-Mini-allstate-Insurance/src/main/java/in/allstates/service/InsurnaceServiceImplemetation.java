package in.allstates.service;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

import in.allstates.bindings.InsurancePlanCustomers;
import in.allstates.bindings.SearchRequest;
import in.allstates.constants.AllStatesConstants;
import in.allstates.repo.InsurancePlanCustomersRepository;
import in.allstates.util.ReportGenerator;


@Service
public class InsurnaceServiceImplemetation implements InsuranceService{
	
	
	

	private List<InsurancePlanCustomers> insurancePlanCustomers=new ArrayList<>();
	
	@Autowired
	private InsurancePlanCustomersRepository insurancePlanCustomersRepository;
	
	@Autowired
	private ReportGenerator reportGenerator;

	
	
	@Override
	public List<String> getPlanNames() {
		
		/*Set<String> uniqueStrings=new HashSet<>();
		
		List<String> list2 = insurancePlanCustomersRepository.findAll().stream().
		 map(customer -> customer.getPlanName()).toList();
		
		Set<String> duplicates = list2.stream().filter(name -> !uniqueStrings.add(name)).collect(Collectors.toSet());
		
		System.out.println(duplicates);*/
		
		 List<String> list = insurancePlanCustomersRepository.findAll().stream().
				 map(customer -> customer.getPlanName()).distinct().toList();
		 
		 return list;
		
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> list = insurancePlanCustomersRepository.findAll().stream()
			.map(customer -> customer.getPlanStatus()).distinct().toList();
		
		return list;
	}
	
	

	/*@Override
	public List<InsurancePlanCustomers> getPlanCusotmers(SearchRequest searchRequest) {
		if(searchRequest.getPlanName()!=null && searchRequest.getPlanStatus()!=null) {	
			
			 insurancePlanCustomers = insurancePlanCustomersRepository.findByPlanNameAndPlanStatus(searchRequest.getPlanName(), searchRequest.getPlanStatus());
			
				return insurancePlanCustomers;
		}
		else if(searchRequest.getPlanName()!=null)
		{
			insurancePlanCustomers = insurancePlanCustomersRepository.findByPlanName(searchRequest.getPlanName());
			return insurancePlanCustomers;
		}
		else if(searchRequest.getPlanStatus()!=null)
		{
			insurancePlanCustomers = insurancePlanCustomersRepository.findByPlanStatus(searchRequest.getPlanStatus());
			return insurancePlanCustomers;
		}
		
		insurancePlanCustomers= insurancePlanCustomersRepository.findAll();
		return insurancePlanCustomers;
	}*/
	
	@Override
	public List<InsurancePlanCustomers> getPlanCusotmers(SearchRequest searchRequest) {
		
		
		InsurancePlanCustomers entity=new InsurancePlanCustomers();
		
	
		if(searchRequest.getPlanName()!=null && !searchRequest.getPlanName().equals("")) {	
			
			entity.setPlanName(searchRequest.getPlanName());
				
		}
		
		if(searchRequest.getPlanStatus()!=null && !searchRequest.getPlanStatus().equals(""))
		{
			entity.setPlanStatus(searchRequest.getPlanStatus());
		}
		
		Example<InsurancePlanCustomers> entityQuery = Example.of(entity);
		
		insurancePlanCustomers= insurancePlanCustomersRepository.findAll(entityQuery);
		return insurancePlanCustomers;
	}
	
	@Override
	public String generateReport(HttpServletResponse response, String reportType) throws IOException, DocumentException {
		if(reportType.equalsIgnoreCase(AllStatesConstants.EXCEL))
		{
			return reportGenerator.downloadToExcel(insurancePlanCustomers, response);			
		}
		if(reportType.equalsIgnoreCase(AllStatesConstants.PDF))
		{
			reportGenerator.downloadToPdf(insurancePlanCustomers, response);
		}
		return "failed to download";
		
		
	
		
	}

	

	
	

}
