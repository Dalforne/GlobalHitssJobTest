package com.global.hitss.store.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.global.hitss.store.domain.Client;
import com.global.hitss.store.services.validation.ClientUpdate;

@ClientUpdate
public class ClientDTO  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idClient;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Size(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String dsClient;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="E-mail inválido")
	private String dsEmail;
	
	public ClientDTO() {}
	
	public ClientDTO(Client obj) {
		idClient = obj.getIdClient();
		dsClient = obj.getDsClient();
		dsEmail = obj.getDsEmail();
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

}
