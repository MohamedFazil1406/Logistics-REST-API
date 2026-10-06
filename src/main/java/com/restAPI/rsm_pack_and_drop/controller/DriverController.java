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

import com.restAPI.rsm_pack_and_drop.model.Driver;
import com.restAPI.rsm_pack_and_drop.repo.DriverRepo;

@RestController
public class DriverController {
	@Autowired
	DriverRepo driverRepo;
	
	//http://localhost:1919/driversList
	@GetMapping("/driversList")
	List<Driver>getAllDrivers(){
		return driverRepo.findAll();
	}
	
	//http://localhost:1919/driver/{id}
	@GetMapping("/driver/{id}")
	Driver getDriver(@PathVariable Integer id) {
		return driverRepo.findById(id).orElseThrow();
	}
	
	// http://localhost:1919/newDriverEntry
	@PostMapping("/newDriverEntry")
	Driver newDriver(@RequestBody Driver driver) {
		return driverRepo.save(driver);
	}
	
	// http://localhost:1919/driverleft/{id}
	@DeleteMapping("/driverleft/{id}")
	String deleteDriver(@PathVariable Integer id) {
		driverRepo.deleteById(id);
		return "Driver with id="+id+" removed/deleted successfully";
	}
	
	// http://localhost:1919/updateDriver/{id}
	@PutMapping("/updateDriver/{id}")
	Driver updateDriverDetails(@RequestBody Driver driver,@PathVariable Integer id) {
		Driver dDb=getDriver(id);
		dDb.setDname(driver.getDname());
		dDb.setPhone(driver.getPhone());
		dDb.setLicenseNumber(driver.getLicenseNumber());
		dDb.setVehicleNumber(driver.getVehicleNumber());
		dDb.setAvailabilityStatus(driver.getAvailabilityStatus());
		return driverRepo.save(dDb);

	}

}
