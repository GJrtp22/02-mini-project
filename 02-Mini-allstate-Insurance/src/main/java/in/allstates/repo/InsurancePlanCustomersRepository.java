package in.allstates.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.allstates.bindings.InsurancePlanCustomers;
import in.allstates.dto.CustomerDto;

public interface InsurancePlanCustomersRepository extends JpaRepository<InsurancePlanCustomers, Integer>{
	
	@Query("SELECT * FROM InsurancePlanCustomers IPC JOIN IPC.insurancePlan IP where IP.planName= :plan AND IP.planStatus=:status")
	List<InsurancePlanCustomers> findByPlanAndStatus(String plan, String status);
	
	@Query("SELECT * FROM InsurancePlanCustomers IPC JOIN IPC.insurancePlan IP where IP.planName= :plan ")
	List<InsurancePlanCustomers> findByPlan(String plan);
	
	@Query("SELECT * FROM InsurancePlanCustomers IPC JOIN IPC.insurancePlan IP where IP.planStatus=:status ")
	List<InsurancePlanCustomers> findByStatus(String status);

}
