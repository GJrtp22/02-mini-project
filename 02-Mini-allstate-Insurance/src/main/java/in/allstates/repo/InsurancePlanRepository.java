package in.allstates.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.allstates.bindings.InsurancePlan;

public interface InsurancePlanRepository extends JpaRepository<InsurancePlan, Integer> {

}
