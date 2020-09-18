package com.global.hitss.store.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.global.hitss.store.domain.Address;
import com.global.hitss.store.services.AddressService;

@RestController
@RequestMapping(value="/addresses")
public class AddressResource {
	
	@Autowired
	private AddressService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Address> find(@PathVariable Integer id) {
		Address obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
