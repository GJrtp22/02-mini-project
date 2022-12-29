package in.umt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.umt.bindings.State;

public interface StateRepo extends JpaRepository<State, Long> {
	
	@Query("SELECT distinct(S.state) FROM State S join S.country sc where sc.countryName= :country")
	public List<String> getStates(String country);

}
