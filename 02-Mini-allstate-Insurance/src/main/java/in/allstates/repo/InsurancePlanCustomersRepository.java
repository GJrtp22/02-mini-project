package in.allstates.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import in.allstates.bindings.InsurancePlanCustomers;

@Repository
public interface InsurancePlanCustomersRepository extends JpaRepository<InsurancePlanCustomers, Integer>{
	
	
	
	


}
