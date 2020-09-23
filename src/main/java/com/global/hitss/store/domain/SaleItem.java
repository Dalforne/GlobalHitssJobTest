package com.global.hitss.store.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SaleItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private SaleItemPK id = new SaleItemPK();
	
	private Double vlDiscount;
	private Integer nrAmount;
	private Double vlPrice; 
	
	public SaleItem() {}

	public SaleItem(Sale sale, Product product, Double vlDiscount, Integer nrAmount, Double vlPrice) {
		super();
		id.setSale(sale);
		id.setProduct(product);
		this.vlDiscount = vlDiscount;
		this.nrAmount = nrAmount;
		this.vlPrice = vlPrice;
	}
	
	public double getSubTotal() {
		return (vlPrice - vlDiscount) * nrAmount;		
	}
	
	@JsonIgnore
	public Sale getSale() {
		return id.getSale();
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setSale(Sale sale) {
		id.setSale(sale);		
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	public SaleItemPK getId() {
		return id;
	}

	public void setId(SaleItemPK id) {
		this.id = id;
	}

	public Double getVlDiscount() {
		return vlDiscount;
	}

	public void setVlDiscount(Double vlDiscount) {
		this.vlDiscount = vlDiscount;
	}

	public Integer getNrAmount() {
		return nrAmount;
	}

	public void setNrAmount(Integer nrAmount) {
		this.nrAmount = nrAmount;
	}

	public Double getVlPrice() {
		return vlPrice;
	}

	public void setVlPrice(Double vlPrice) {
		this.vlPrice = vlPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SaleItem other = (SaleItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
