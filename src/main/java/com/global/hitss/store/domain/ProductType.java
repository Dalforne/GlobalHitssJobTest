package com.global.hitss.store.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//@NoArgsConstructor
//@AllArgsContructor

@Entity
public class ProductType implements Serializable  {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProductType;
	private String dsProductType;
	
	@JsonManagedReference
	@ManyToMany(mappedBy="productTypes")
	private List<Product> products = new ArrayList<>();
	
	public ProductType() {
	}

	public ProductType(Integer idProductType, String dsProductType) {
		super();
		this.idProductType = idProductType;
		this.dsProductType = dsProductType;
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
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProductType == null) ? 0 : idProductType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductType other = (ProductType) obj;
		if (idProductType == null) {
			if (other.idProductType != null)
				return false;
		} else if (!idProductType.equals(other.idProductType))
			return false;
		return true;
	}


	
	
	
	

}
