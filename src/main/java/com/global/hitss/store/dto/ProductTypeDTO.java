package com.global.hitss.store.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.global.hitss.store.domain.ProductType;

public class ProductTypeDTO  implements Serializable  {
	

	private static final long serialVersionUID = 1L;
	
	private Integer idProductType;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Size(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String dsProductType;
	
	public ProductTypeDTO() {}
	
	public ProductTypeDTO(ProductType obj) {
		idProductType = obj.getIdProductType();
		dsProductType = obj.getDsProductType();
	}

	public Integer getIdProductType() {
		return idProductType;
	}

	public void setIdProductType(Integer idProductType) {
		this.idProductType = idProductType;
	}

	public String getDsProductType() {
		return dsProductType;
	}

	public void setDsProductType(String dsProductType) {
		this.dsProductType = dsProductType;
	}
	
	

}
