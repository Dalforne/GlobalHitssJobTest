package com.global.hitss.store.dto;

import java.io.Serializable;

import com.global.hitss.store.domain.Product;

public class ProductDTO  implements Serializable  {
	

	private static final long serialVersionUID = 1L;
	
	private Integer idProduct;
	private String dsProduct;
	private Double vlPrice;
	private Integer nrStock;

	public ProductDTO() {}
	
	public ProductDTO(Product obj) {
		this.idProduct = obj.getIdProduct();
		this.dsProduct = obj.getDsProduct();
		this.vlPrice = obj.getVlPrice();
		this.nrStock = obj.getNrStock();
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

	public Integer getNrStock() {
		return nrStock;
	}

	public void setNrStock(Integer nrStock) {
		this.nrStock = nrStock;
	}


}
