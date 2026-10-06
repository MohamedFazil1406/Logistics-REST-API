package com.restAPI.rsm_pack_and_drop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restAPI.rsm_pack_and_drop.model.Customer;
import com.restAPI.rsm_pack_and_drop.repo.CustomerRepo;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepo custRepo;
	
	@GetMapping("/getCustList")
	List<Customer>getCustomersDetails(){
		return custRepo.findAll();
	}
	@PostMapping("/createCustomer")
	Customer createCustomer(@RequestBody Customer customer) {
		return custRepo.save(customer);
		
	}
	@GetMapping("/getCustomer/{cid}")
	Customer getCustomer(@PathVariable Integer cid) {
		return custRepo.findById(cid).orElseThrow();
	}
	@DeleteMapping("/deleteCustomer/{cid}")
	String deleteCustomer(@PathVariable Integer cid) {
		custRepo.deleteById(cid);
		return "Customer with "+cid+" removed Successfully";
	}
	@PutMapping("/updateCustomer/{cid}")
	Customer updateCustomer(@RequestBody Customer customer,@PathVariable Integer cid) {
		Customer custFromDb=getCustomer(cid);
		custFromDb.setCName(customer.getCName());
		custFromDb.setEmail(customer.getEmail());
		custFromDb.setPhoneNumber(customer.getPhoneNumber());
		custFromDb.setAddress(customer.getAddress());
		return custRepo.save(custFromDb);
	}
	

}
