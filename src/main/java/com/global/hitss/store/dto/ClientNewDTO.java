package com.global.hitss.store.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.global.hitss.store.services.validation.ClientInsert;

@ClientInsert
public class ClientNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Size(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String dsClient;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="E-mail inválido")
	private String dsEmail;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String dsLicense;
	
	private Integer nrType; 	
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String dsAddress;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String dsCity;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String dsState;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String dsNumber;
	
	private String dsComplement;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String cdZipCode;	
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String phone1;
	private String phone2;
	private String phone3;
	
	public ClientNewDTO() {	}

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

	public Integer getNrType() {
		return nrType;
	}

	public void setNrType(Integer nrType) {
		this.nrType = nrType;
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

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	
	
	
}
