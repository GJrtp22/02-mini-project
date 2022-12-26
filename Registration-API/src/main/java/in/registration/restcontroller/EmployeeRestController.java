package in.registration.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import in.registration.bindings.Employee;
import in.registration.repo.EmployeeRepo;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmp(@RequestBody List<Employee> employee)
	{
		employeeRepo.saveAll(employee);
		
		return ResponseEntity.ok("Data saved");
		
		
	}

}
