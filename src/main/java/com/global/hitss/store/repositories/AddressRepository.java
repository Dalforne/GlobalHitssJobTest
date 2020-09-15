package com.global.hitss.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.hitss.store.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
