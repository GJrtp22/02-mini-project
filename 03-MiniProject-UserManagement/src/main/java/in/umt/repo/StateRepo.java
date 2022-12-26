package in.umt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.umt.bindings.State;

public interface StateRepo extends JpaRepository<State, Long> {
	
	@Query("SELECT distinct(sc.city) FROM State S join S.cities sc where state= :stateName")
	public List<String> getCities(String stateName);

}
