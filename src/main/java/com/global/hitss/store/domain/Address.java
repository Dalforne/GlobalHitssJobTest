package com.global.hitss.store.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAdress;
	private String dsAddress;
	private String dsCity;
	private String dsState;
	private String dsNumber;
	private String dsComplement;
	private String cdZipCode;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	public Address() {}


	public Address(Integer idAdress, String dsAddress, String dsCity, String dsState, String dsNumber,
			String dsComplement, String cdZipCode, Client client) {
		super();
		this.idAdress = idAdress;
		this.dsAddress = dsAddress;
		this.dsCity = dsCity;
		this.dsState = dsState;
		this.dsNumber = dsNumber;
		this.dsComplement = dsComplement;
		this.cdZipCode = cdZipCode;
		this.client = client;
	}


	public Integer getIdAdress() {
		return idAdress;
	}


	public void setIdAdress(Integer idAdress) {
		this.idAdress = idAdress;
	}


	public String getDsAddress() {
		return dsAddress;
	}


	public void setDsAddress(String dsAddress) {
		this.dsAddress = dsAddress;
	}


	public String getDsCity() {
		return dsCity;
	}


	public void setDsCity(String dsCity) {
		this.dsCity = dsCity;
	}


	public String getDsState() {
		return dsState;
	}


	public void setDsState(String dsState) {
		this.dsState = dsState;
	}


	public String getDsNumber() {
		return dsNumber;
	}


	public void setDsNumber(String dsNumber) {
		this.dsNumber = dsNumber;
	}


	public String getDsComplement() {
		return dsComplement;
	}


	public void setDsComplement(String dsComplement) {
		this.dsComplement = dsComplement;
	}


	public String getCdZipCode() {
		return cdZipCode;
	}


	public void setCdZipCode(String cdZipCode) {
		this.cdZipCode = cdZipCode;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAdress == null) ? 0 : idAdress.hashCode());
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
		Address other = (Address) obj;
		if (idAdress == null) {
			if (other.idAdress != null)
				return false;
		} else if (!idAdress.equals(other.idAdress))
			return false;
		return true;
	}
	
	 

}
