package in.allstates.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.allstates.bindings.InsurancePlanCustomers;
import in.allstates.bindings.SearchRequest;
import in.allstates.constants.AllStatesConstants;
import in.allstates.repo.InsurancePlanCustomersRepository;
import in.allstates.util.ReportGenerator;


@Service
public class InsurnaceServiceImplemetation implements InsuranceService{
	
	
	

	public List<InsurancePlanCustomers> insurancePlanCustomers=new ArrayList<>();
	
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
	
	

	@Override
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
	}

	@Override
	public String generateReport(String reportType) {
		if(reportType.equalsIgnoreCase(AllStatesConstants.EXCEL))
		{
			return reportGenerator.downloadToExcel(insurancePlanCustomers);			
		}
		if(reportType.equalsIgnoreCase(AllStatesConstants.PDF))
		{
			return reportGenerator.downloadToPdf(insurancePlanCustomers);
		}
		
		return null;
	
		
	}

	

	
	

}
