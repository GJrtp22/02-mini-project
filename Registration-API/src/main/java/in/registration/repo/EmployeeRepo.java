package in.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.registration.bindings.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
