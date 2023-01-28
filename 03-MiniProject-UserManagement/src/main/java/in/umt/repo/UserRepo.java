package in.umt.repo;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.umt.bindings.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByEmailAndPassword(String email, String password);

	Optional<User> findByEmail(String email);
	
	

}
