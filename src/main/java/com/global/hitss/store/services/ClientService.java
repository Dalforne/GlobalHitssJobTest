package com.global.hitss.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.hitss.store.domain.Address;
import com.global.hitss.store.domain.Client;
import com.global.hitss.store.domain.enums.ClientType;
import com.global.hitss.store.dto.ClientDTO;
import com.global.hitss.store.dto.ClientNewDTO;
import com.global.hitss.store.repositories.AddressRepository;
import com.global.hitss.store.repositories.ClientRepository;
import com.global.hitss.store.services.exceptions.DataIntegrityException;
import com.global.hitss.store.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id +", Tipo: " + Client.class.getName()));		
	}
	
	@Transactional
	public Client insert(Client obj) {
		obj.setIdClient(null);
		obj = repo.save(obj);
		addressRepository.saveAll(obj.getAdresses());
		return obj;
	}
	
	
	
	public Client update(Client obj) {
		Client newObj = find(obj.getIdClient());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}
	
	public List<Client> findAll() {
		return repo.findAll();
	}
	
	public Page<Client> findPage(Integer page, Integer linesPerPager, String orderBy, String derection) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPager, Direction.valueOf(derection) , orderBy);
		return repo.findAll(pageRequest);
	}

	public Client fromDTO(ClientDTO objDto) {
		return new Client(objDto.getIdClient(), objDto.getDsClient(), objDto.getDsEmail(), null, null);
	}
	
	public Client fromDTO(ClientNewDTO objDto) {
		Client cli = new Client(null,objDto.getDsClient(), objDto.getDsEmail(),  objDto.getDsLicense(), ClientType.toEnum(objDto.getNrType()));
		Address ads = new Address(null, objDto.getDsAddress(), objDto.getDsCity(), objDto.getDsState(), objDto.getDsNumber(), objDto.getDsComplement(), objDto.getCdZipCode(), cli);

		cli.getAdresses().add(ads);
		cli.getPhones().add(objDto.getPhone1());
		if(objDto.getPhone2()!=null) {
			cli.getPhones().add(objDto.getPhone2());
		}
		if(objDto.getPhone3()!=null) {
			cli.getPhones().add(objDto.getPhone3());
		}
		
		return cli;
	}

	private void updateData(Client newObj, Client obj) {
		newObj.setDsClient(obj.getDsClient());
		newObj.setDsEmail(obj.getDsEmail());
	}
}
