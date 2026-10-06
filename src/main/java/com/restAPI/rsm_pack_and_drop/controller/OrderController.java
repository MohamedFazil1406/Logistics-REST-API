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

import com.restAPI.rsm_pack_and_drop.model.Order;
import com.restAPI.rsm_pack_and_drop.repo.OrderRepo;

@RestController
public class OrderController {
	@Autowired
	OrderRepo orderRepo;
	
	@GetMapping("/getOrderDetails")
	List<Order>getOrderDetails(){
		return orderRepo.findAll();	
	}
	@GetMapping("/getOrderDetails/{order_id}")
	Order getOrder(@PathVariable Integer order_id) {
		return orderRepo.findById(order_id).orElseThrow();
	}
	@PostMapping("/createOrders")
	Order createOrders(@RequestBody Order order) {
		return orderRepo.save(order);
	}
	@DeleteMapping("/deleteOrder/{order_id}")
	String deleteOrder(@PathVariable Integer order_id) {
		orderRepo.deleteById(order_id);
		return "Order of id number "+order_id+" deleted successfully";
	}
	@PutMapping("/updateOrder/{order_id}")
	Order updateOrder(@RequestBody Order order,@PathVariable Integer order_id) {
		Order OFDb=getOrder(order_id);
		OFDb.setOrderNumber(order.getOrderNumber());
		OFDb.setProductName(order.getProductName());
		OFDb.setQuantity(order.getQuantity());
		OFDb.setWeight(order.getWeight());
		OFDb.setPickupAddress(order.getPickupAddress());
		OFDb.setDeliveryAddress(order.getDeliveryAddress());
		OFDb.setOrderDate(order.getOrderDate());
		OFDb.setStatus(order.getStatus());
		return orderRepo.save(OFDb);
	}
}
