package com.global.hitss.store.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.global.hitss.store.domain.enums.ClientType;

@Entity
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idClient;
	private String dsClient;
	private String dsEmail;
	private String dsLicense;
	private Integer nrType; 
	
	@JsonManagedReference
	@OneToMany(mappedBy="client")
	private List<Address> adresses = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="PHONE")
	private Set<String> phones = new HashSet<>();

	public Client() {}

	public Client(Integer idClient, String dsClient, String dsEmail, String dsLicense, ClientType nrType) {
		super();
		this.idClient = idClient;
		this.dsClient = dsClient;
		this.dsEmail = dsEmail;
		this.dsLicense = dsLicense;
		this.nrType = nrType.getCod();
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getDsClient() {
		return dsClient;
	}

	public void setDsClient(String dsClient) {
		this.dsClient = dsClient;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsLicense() {
		return dsLicense;
	}

	public void setDsLicense(String dsLicense) {
		this.dsLicense = dsLicense;
	}

	public ClientType getNrType() {
		return ClientType.toEnum(nrType);
	}

	public void setNrType(ClientType nrType) {
		this.nrType = nrType.getCod();
	}

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClient == null) ? 0 : idClient.hashCode());
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
		Client other = (Client) obj;
		if (idClient == null) {
			if (other.idClient != null)
				return false;
		} else if (!idClient.equals(other.idClient))
			return false;
		return true;
	}
	
	
	
	

}
