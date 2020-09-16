package com.global.hitss.store.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hitss.store.domain.Address;
import com.global.hitss.store.repositories.AddressRepository;
import com.global.hitss.store.services.exceptions.ObjectNotFoundException;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repo;
	
	public Address find(Integer id) {
		Optional<Address> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id +", Tipo: " + Address.class.getName()));		
	}

}
