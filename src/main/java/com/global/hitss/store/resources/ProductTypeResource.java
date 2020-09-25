package com.global.hitss.store.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.global.hitss.store.domain.ProductType;
import com.global.hitss.store.dto.ProductTypeDTO;
import com.global.hitss.store.services.ProductTypeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/productTypes")
public class ProductTypeResource {
	
	@Autowired
	private ProductTypeService service;

	@ApiOperation(value="Busca por id")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ProductType> find(@PathVariable Integer id) {
		ProductType obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value="Insere Categoria")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProductTypeDTO objDto){
		ProductType obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getIdProductType()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value="Atualiza Categoria")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ProductTypeDTO objDto, @PathVariable Integer id){
		ProductType obj = service.fromDTO(objDto);
		obj.setIdProductType(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Remove Categoria")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui produtos"),
			@ApiResponse(code = 404, message = "Código inexistente") 
			})
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Retorna todas Categoria")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProductTypeDTO>> findAll() {
		List<ProductType> list  = service.findAll();
		List<ProductTypeDTO> listDto = list.stream().map(obj -> new ProductTypeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@ApiOperation(value="Retorna todas Categoria com paginação")
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ProductTypeDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPager", defaultValue="24") Integer linesPerPager, 
			@RequestParam(value="orderBy", defaultValue="dsProductType") String orderBy, 
			@RequestParam(value="derection", defaultValue="ASC") String derection) {
		Page<ProductType> list  = service.findPage(page, linesPerPager, orderBy, derection);
		Page<ProductTypeDTO> listDto = list.map(obj -> new ProductTypeDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
