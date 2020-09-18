package com.global.hitss.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.global.hitss.store.domain.ProductType;
import com.global.hitss.store.dto.ProductTypeDTO;
import com.global.hitss.store.repositories.ProductTypeRepository;
import com.global.hitss.store.services.exceptions.DataIntegrityException;
import com.global.hitss.store.services.exceptions.ObjectNotFoundException;

@Service
public class ProductTypeService {
	
	@Autowired
	private ProductTypeRepository repo;
	
	public ProductType find(Integer id) {
		Optional<ProductType> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id +", Tipo: " + ProductType.class.getName()));		
	}
	
	public ProductType insert(ProductType obj) {
		obj.setIdProductType(null);
		return repo.save(obj);
	}
	
	public ProductType update(ProductType obj) {
		ProductType newObj = find(obj.getIdProductType());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	public List<ProductType> findAll() {
		return repo.findAll();
	}
	
	public Page<ProductType> findPage(Integer page, Integer linesPerPager, String orderBy, String derection) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPager, Direction.valueOf(derection) , orderBy);
		return repo.findAll(pageRequest);
	}

	public ProductType fromDTO(ProductTypeDTO objDto) {
		return new ProductType(objDto.getIdProductType(), objDto.getDsProductType()); 
	}
	
	private void updateData(ProductType newObj, ProductType obj) {
		newObj.setDsProductType(obj.getDsProductType());
	}

}
