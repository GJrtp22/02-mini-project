package in.umt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.umt.bindings.City;

public interface CityRepo extends JpaRepository<City, Long> {
	
	@Query("SELECT distinct(C.city) FROM City C join C.state sc where sc.state= :state")
	public List<String> getCities(String state);
	

}
