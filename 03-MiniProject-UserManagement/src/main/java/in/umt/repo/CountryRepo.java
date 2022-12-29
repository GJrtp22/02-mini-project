package in.umt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.umt.bindings.Country;

public interface CountryRepo extends JpaRepository<Country, Long> {
	
	@Query("select distinct(countryName) from Country")
	public List<String> getCountries();

	

}
