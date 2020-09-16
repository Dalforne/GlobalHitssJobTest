package com.global.hitss.store.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity	
public class Sale implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSale;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date tmSale;
	private Integer nrAmount;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="sale")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="id_delivery_address")
	private Address deliveryAddress;
	
	@OneToMany(mappedBy="id.sale")
	private Set<SaleItem> itens = new HashSet<>();
	
	public Sale() {}

	public Sale(Integer idSale, Date tmSale, Client client, Address deliveryAddress, Integer nrAmount) {
		super();
		this.idSale = idSale;
		this.tmSale = tmSale;
		this.client = client;
		this.deliveryAddress = deliveryAddress;
		this.nrAmount = nrAmount;
	}

	public Integer getIdSale() {
		return idSale;
	}

	public void setIdSale(Integer idSale) {
		this.idSale = idSale;
	}

	public Date getTmSale() {
		return tmSale;
	}

	public void setTmSale(Date tmSale) {
		this.tmSale = tmSale;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public Integer getNrAmount() {
		return nrAmount;
	}

	public void setNrAmount(Integer nrAmount) {
		this.nrAmount = nrAmount;
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
		result = prime * result + ((idSale == null) ? 0 : idSale.hashCode());
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
		Sale other = (Sale) obj;
		if (idSale == null) {
			if (other.idSale != null)
				return false;
		} else if (!idSale.equals(other.idSale))
			return false;
		return true;
	}


	
}
