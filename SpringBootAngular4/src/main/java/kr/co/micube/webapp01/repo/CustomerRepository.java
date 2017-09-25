package kr.co.micube.webapp01.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
 
import kr.co.micube.webapp01.model.Customer;
 
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByImageName(String imageName);
}