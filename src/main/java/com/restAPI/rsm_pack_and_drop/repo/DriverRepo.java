package com.restAPI.rsm_pack_and_drop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restAPI.rsm_pack_and_drop.model.Driver;

public interface DriverRepo extends JpaRepository<Driver,Integer> {

}
