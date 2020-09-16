package com.global.hitss.store.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hitss.store.domain.Sale;
import com.global.hitss.store.repositories.SaleRepository;
import com.global.hitss.store.services.exceptions.ObjectNotFoundException;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repo;
	
	public Sale find(Integer id) {
		Optional<Sale> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id +", Tipo: " + Sale.class.getName()));		
	}

}
