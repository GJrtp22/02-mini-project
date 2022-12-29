package in.umt.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.umt.bindings.City;
import in.umt.bindings.Country;
import in.umt.bindings.State;
import in.umt.repo.CityRepo;
import in.umt.repo.CountryRepo;
import in.umt.repo.StateRepo;

@Component
public class UserDataRunner implements CommandLineRunner{
	
	@Autowired
	private CountryRepo countryRepo;
	
	@Autowired
	private StateRepo staterepo;
	
	
	@Autowired
	private CityRepo cityRepo;
	

	@Override
	public void run(String... args) throws Exception {
		
		Country c1=new Country(101L, "India");
		Country c2=new Country(102L, "USA");
		
		countryRepo.saveAll(Arrays.asList(c1,c2));
		
		State s1=new State(201L, "AP", c1);
		State s2=new State(202L, "TS", c1);
		State s3=new State(203L, "MH", c1);
		State s4=new State(204L, "California", c2);
		State s5=new State(205L, "New York", c2);
		State s6=new State(206L, "Washington", c2);
		
		staterepo.saveAll(Arrays.asList(s1, s2, s3, s4, s5, s6));
		
		
		City ct1=new City(301L, "Kurnool", s1);
		City ct2=new City(302L, "Kadapa", s1);
		City ct3=new City(303L, "Vizag", s1);
		City ct4=new City(304L, "Hyderabad", s2);
		City ct5=new City(305L, "Warangal", s2);
		City ct6=new City(306L, "Mumbai", s3);
		City ct7=new City(307L, "Pune", s3);
		City ct8=new City(308L, "Los Angeles", s4);
		City ct9=new City(309L, "Atalnta", s4);
		City ct10=new City(310L, "Princeton", s5);
		City ct11=new City(311L, "Texas", s5);
		City ct12=new City(312L, "Dallas", s6);
		
		cityRepo.saveAll(Arrays.asList(ct1,ct2,ct3,ct4,ct5,ct6,ct7,ct8,ct9,ct10,ct11,ct12));
		
		
		
		
		
		
	}

}
