package com.global.hitss.store.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProduct;
	private String dsProduct;
	private Double vlPrice;
	private Integer nrStock;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="PRODUCT_TYPE_REFERENCE",
			   joinColumns = @JoinColumn(name="id_product"),
			   inverseJoinColumns = @JoinColumn(name="id_product_type")
	)
	private List<ProductType> productTypes = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="id.product")
	private Set<SaleItem> itens = new HashSet<>();
	
	public Product() {}

	public Product(Integer idProduct, String dsProduct, Double vlPrice, Integer nrStock) {
		super();
		this.idProduct = idProduct;
		this.dsProduct = dsProduct;
		this.vlPrice = vlPrice;
		this.nrStock = nrStock;
	}

	@JsonIgnore
	public List<Sale> getSales(){
		List<Sale> list = new ArrayList<>();
		for (SaleItem i : itens) {
			 list.add(i.getSale());
		}
		return list;
	}
	
	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getDsProduct() {
		return dsProduct;
	}

	public void setDsProduct(String dsProduct) {
		this.dsProduct = dsProduct;
	}

	public Double getVlPrice() {
		return vlPrice;
	}

	public void setVlPrice(Double vlPrice) {
		this.vlPrice = vlPrice;
	}

	public List<ProductType> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}
	
	public Integer getNrStock() {
		return nrStock;
	}

	public void setNrStock(Integer nrStock) {
		this.nrStock = nrStock;
	}

	public Set<SaleItem> getItens() {
		return itens;
	}

	public void setItens(Set<SaleItem> itens) {
		this.itens = itens;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduct == null) ? 0 : idProduct.hashCode());
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
		Product other = (Product) obj;
		if (idProduct == null) {
			if (other.idProduct != null)
				return false;
		} else if (!idProduct.equals(other.idProduct))
			return false;
		return true;
	}


	
}
