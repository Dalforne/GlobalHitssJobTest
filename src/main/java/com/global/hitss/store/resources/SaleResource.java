package com.global.hitss.store.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.global.hitss.store.domain.Sale;
import com.global.hitss.store.services.SaleService;

@RestController
@RequestMapping(value="/sales")
public class SaleResource {
	
	@Autowired
	private SaleService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Sale> find(@PathVariable Integer id) {
		Sale obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Sale obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getIdSale()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
