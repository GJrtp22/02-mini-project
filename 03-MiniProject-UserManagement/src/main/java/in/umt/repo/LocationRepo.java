package in.umt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.umt.bindings.Location;

public interface LocationRepo extends JpaRepository<Location, Long>
{
	@Query("SELECT distinct(countryName) from Location")
	public List<String> getDistinctCountries();
	
	@Query("SELECT distinct(stateName) from Location where countryName= :country")
	public List<String> getStatesBycountry(String country);
	
	@Query("SELECT distinct(cityName) from Location where stateName= :state")
	public List<String> getCitiesByState(String state);
	

}
