package in.umt.repo;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.umt.bindings.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	boolean existsByEmail(String email);
	
	@Query("select password from User where email= : email")
	String getPassword(String email);
	
	@Query("Update User set password= :password where email= :email")
	void updatePassword(String email,String password);
	
	Optional<User> findByEmail(String email);

}
