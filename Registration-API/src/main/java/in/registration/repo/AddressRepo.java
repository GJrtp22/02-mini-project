package in.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.registration.bindings.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
