package com.global.hitss.store.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hitss.store.domain.Product;
import com.global.hitss.store.dto.ProductDTO;
import com.global.hitss.store.resources.utils.URL;
import com.global.hitss.store.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Product> find(@PathVariable Integer id) {
		Product obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<ProductDTO>> findPage(
			@RequestParam(value="dsProduct", defaultValue="") String dsProduct,
			@RequestParam(value="productTypes", defaultValue="") String productTypes, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPager", defaultValue="24") Integer linesPerPager, 
			@RequestParam(value="orderBy", defaultValue="dsProduct") String orderBy, 
			@RequestParam(value="derection", defaultValue="ASC") String derection) {
		String dsDecoded = URL.decodeParam(dsProduct);
		List<Integer> ids = URL.decodeIntList(productTypes);
		Page<Product> list  = service.search(dsDecoded, ids,  page, linesPerPager, orderBy, derection);
		Page<ProductDTO> listDto = list.map(obj -> new ProductDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
