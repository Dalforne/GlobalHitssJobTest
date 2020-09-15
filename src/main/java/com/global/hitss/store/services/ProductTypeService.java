package com.global.hitss.store.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hitss.store.domain.ProductType;
import com.global.hitss.store.repositories.ProductTypeRepository;
import com.global.hitss.store.services.exceptions.ObjectNotFoundException;

@Service
public class ProductTypeService {
	
	@Autowired
	private ProductTypeRepository repo;
	
	public ProductType find(Integer id) {
		Optional<ProductType> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id +", Tipo: " + ProductType.class.getName()));		
	}

}
