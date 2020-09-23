package com.global.hitss.store.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global.hitss.store.domain.Product;
import com.global.hitss.store.domain.ProductType;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//	@Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.productTypes pt WHERE obj.dsProduct LIKE %:dsProduct% AND pt IN :productTypes")
//	Page<Product> search(@Param("dsProduct") String dsProduct, @Param("productTypes") List<ProductType> productTypes, Pageable pageRequest);
	
	
	@Transactional(readOnly=true)
	Page<Product> findDistinctByDsProductContainingAndProductTypesIn(String dsProduct, List<ProductType> productTypes, Pageable pageRequest);
}
