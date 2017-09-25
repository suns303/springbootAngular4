package kr.co.micube.webapp01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import kr.co.micube.webapp01.model.Customer;
import kr.co.micube.webapp01.repo.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository repository;
	
	@GetMapping(value ="/customer", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAll() {
		List<Customer> list = new ArrayList<>();
		Iterable<Customer> customers = repository.findAll();
		
		customers.forEach(list::add);
		return list;
	}
	
	@PostMapping(value="/postcustomer")
	public Customer postCustomer(@RequestBody Customer customer) {
		
		repository.save(new Customer(customer.getImageName(),customer.getImage()));
		return customer;
	}
	@GetMapping(value="/findbyimagename/{imageName}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findByImageName(@PathVariable String imageName) {
 
		List<Customer> customers = repository.findByImageName(imageName);
		return customers;
	}
	
	@DeleteMapping(value="/customer/{id}")
	public void deleteCustomer(@PathVariable long id){
		
		repository.delete(id);
	}
		
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "<html>";
		
		for(Customer cust : repository.findAll()){
			result += "<div>" + cust.toString() + "</div>";
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/findbyimagename")
	public String fetchDataByImageName(@RequestParam("imagename") String imageName){
		String result = "<html>";
		
		for(Customer cust: repository.findByImageName(imageName)){
			result += "<div>" + cust.toString() + "</div>"; 
		}
		
		return result + "</html>";
	}
	
}
