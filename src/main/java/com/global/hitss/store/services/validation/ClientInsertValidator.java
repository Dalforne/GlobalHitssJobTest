package com.global.hitss.store.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.global.hitss.store.domain.Client;
import com.global.hitss.store.domain.enums.ClientType;
import com.global.hitss.store.dto.ClientNewDTO;
import com.global.hitss.store.repositories.ClientRepository;
import com.global.hitss.store.resources.exceptions.FieldMessage;
import com.global.hitss.store.services.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO> {
	
	@Autowired
	private ClientRepository repo;
	
	@Override
	public void initialize(ClientInsert ann) {
	}

	@Override
	public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if (objDto.getNrType().equals(ClientType.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getDsLicense())) {
			list.add(new FieldMessage("dsLicense", "CPF Inválido"));
		}
		
		if (objDto.getNrType().equals(ClientType.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getDsLicense())) {
			list.add(new FieldMessage("dsLicense", "CNPJ Inválido"));
		}
		
		Client aux = repo.findByDsEmail(objDto.getDsEmail());
		if(aux!=null) {
			list.add(new FieldMessage("dsEmail", "E-mail já existe"));
		}
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}