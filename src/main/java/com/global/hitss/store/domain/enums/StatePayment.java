package com.global.hitss.store.domain.enums;

public enum StatePayment {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String dsDescription;
	
	private StatePayment(int cod, String dsDescription) {
		this.cod = cod;
		this.dsDescription = dsDescription;
	}

	public int getCod() {
		return cod;
	}

	public String getDsDescription() {
		return dsDescription;
	}

	public static StatePayment toEnum(Integer cod) {
		if(cod==null) {
			return null;			
		}
		
		 for(StatePayment x : StatePayment.values()) {
			 if(cod.equals(x.getCod())) {
				 return x;
			 }
		 }
		 
		 throw new IllegalArgumentException("Id Inválido: " + cod);
	}


}
