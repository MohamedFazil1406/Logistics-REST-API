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

import com.restAPI.rsm_pack_and_drop.model.Delivery;
import com.restAPI.rsm_pack_and_drop.repo.DeliveryRepo;

@RestController
public class DeliveryController {
	
	@Autowired
	DeliveryRepo dRepo;
	
	//    http://localhost:1919/getDeliveryDetails
	@GetMapping("/getDeliveryDetails")
	List<Delivery>getdeliveryDetails() {
		return dRepo.findAll();
	}

	//    http://localhost:1919/getDeliveryInfo/2
	@GetMapping("/getDeliveryInfo/{did}")
	Delivery getdeliveryInfo(@PathVariable Integer did) {
		return dRepo.findById(did).orElseThrow();
	}
	
	//    http://localhost:1919/createDeliveryInfo
	@PostMapping("/createDeliveryInfo")
	Delivery createDeliveryInfo(@RequestBody Delivery delivery) {
		return dRepo.save(delivery);	
	}
	
	//    http://localhost:1919/deleteDeliveryInfo/3
	@DeleteMapping("/deleteDeliveryInfo/{did}")
	String deleteDeliveryInfo(@PathVariable Integer did) {
		dRepo.deleteById(did);
		return "Delivery Info "+did+" deleted/paused due to no response from the Customer";
	}
	
	//    http://localhost:1919/updateDeliveryInfo/2
	@PutMapping("/updateDeliveryInfo/{did}")
	Delivery updateDeliveryInfo(@RequestBody Delivery delivery,@PathVariable Integer did) {
		Delivery dfDb=getdeliveryInfo(did);
		dfDb.setDeliveryId(delivery.getDeliveryId());
		dfDb.setOrderDetails(delivery.getOrderDetails());
		dfDb.setDriver(delivery.getDriver());
		dfDb.setPickupTime(delivery.getPickupTime());
		dfDb.setDeliveryTime(delivery.getDeliveryTime());
		dfDb.setStatus(delivery.getStatus());
		return dRepo.save(dfDb);
	}
}
