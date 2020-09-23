package com.global.hitss.store.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Service;

import com.global.hitss.store.domain.Product;
import com.global.hitss.store.domain.ProductType;
import com.global.hitss.store.repositories.ProductRepository;
import com.global.hitss.store.repositories.ProductTypeRepository;
import com.global.hitss.store.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Lock(LockModeType.PESSIMISTIC_READ)
	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "3000")})
	public Product find(Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id +", Tipo: " + Product.class.getName()));		
	}
	
	public Page<Product> search(String dsProduct, List<Integer> ids, Integer page, Integer linesPerPager, String orderBy, String derection){
		PageRequest pageRequest = PageRequest.of(page, linesPerPager, Direction.valueOf(derection) , orderBy);
		List<ProductType> productTypes = productTypeRepository.findAllById(ids);
		//return repo.search(dsProduct, productTypes, pageRequest);
		return repo.findDistinctByDsProductContainingAndProductTypesIn(dsProduct, productTypes, pageRequest);
	}

}
