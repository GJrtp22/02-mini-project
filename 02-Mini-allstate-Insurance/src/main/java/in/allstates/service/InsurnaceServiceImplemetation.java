package in.allstates.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.allstates.bindings.InsurancePlan;
import in.allstates.bindings.InsurancePlanCustomers;
import in.allstates.dto.CustomerDto;
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
	public List<InsurancePlanCustomers> getAllCustomers() {
		insurancePlanCustomers=insurancePlanCustomersRepository.findAll();
		return insurancePlanCustomers;
	}

	@Override
	public List<InsurancePlanCustomers> getCusotmers(InsurancePlan insurancePlan) {
		if(insurancePlan.getPlanName()!=null && insurancePlan.getPlanStatus()!=null) {	
			insurancePlanCustomers= insurancePlanCustomersRepository.findByPlanAndStatus(insurancePlan.getPlanName(), insurancePlan.getPlanStatus());
			return insurancePlanCustomers;
		}
		else if(insurancePlan.getPlanName()!=null)
		{
			
			insurancePlanCustomers= insurancePlanCustomersRepository.findByPlan(insurancePlan.getPlanName());
			return insurancePlanCustomers;
		}
		else if(insurancePlan.getPlanStatus()!=null)
		{
			
			insurancePlanCustomers= insurancePlanCustomersRepository.findByStatus(insurancePlan.getPlanStatus());
			return insurancePlanCustomers;
		}
		
		insurancePlanCustomers= insurancePlanCustomersRepository.findAll();
		return insurancePlanCustomers;
	}

	@Override
	public String generateReport(String reportType) {
		if(reportType.equalsIgnoreCase("Excel"))
		{
			return reportGenerator.downloadToExcel(insurancePlanCustomers);			
		}
		if(reportType.equalsIgnoreCase("Pdf"))
		{
			return reportGenerator.downloadToPdf(insurancePlanCustomers);
		}
		
		return null;
	
		
	}

	
	

}
