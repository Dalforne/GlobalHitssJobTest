package com.global.hitss.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.hitss.store.domain.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
