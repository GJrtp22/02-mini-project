package in.allstates.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import in.allstates.bindings.InsurancePlanCustomers;

@Repository
public interface InsurancePlanCustomersRepository extends JpaRepository<InsurancePlanCustomers, Integer>{
	
	List<InsurancePlanCustomers> findByPlanNameAndPlanStatus(String planName, String planStatus);
	
	List<InsurancePlanCustomers> findByPlanName(String planName);
	
	List<InsurancePlanCustomers> findByPlanStatus(String planStatus);
	
	
	


}
