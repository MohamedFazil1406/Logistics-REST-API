package com.restAPI.rsm_pack_and_drop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restAPI.rsm_pack_and_drop.model.Delivery;


public interface DeliveryRepo extends JpaRepository<Delivery,Integer>{

}
