package com.global.hitss.store.domain.enums;

public enum ClientType {
	
	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String dsDescription;
	
	private ClientType(int cod, String dsDescription) {
		this.cod = cod;
		this.dsDescription = dsDescription;
	}

	public int getCod() {
		return cod;
	}

	public String getDsDescription() {
		return dsDescription;
	}

	public static ClientType toEnum(Integer cod) {
		if(cod==null) {
			return null;			
		}
		
		 for(ClientType x : ClientType.values()) {
			 if(cod.equals(x.getCod())) {
				 return x;
			 }
		 }
		 
		 throw new IllegalArgumentException("Id Inválido: " + cod);
	}


}
