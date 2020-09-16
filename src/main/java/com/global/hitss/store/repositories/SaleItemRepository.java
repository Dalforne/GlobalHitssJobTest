package com.global.hitss.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.hitss.store.domain.SaleItem;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Integer> {

}
