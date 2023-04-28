package com.tailor.Shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tailor.Shop.Entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
