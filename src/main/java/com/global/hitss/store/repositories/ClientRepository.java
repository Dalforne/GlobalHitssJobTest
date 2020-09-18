package com.global.hitss.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.hitss.store.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

//	@Transactional(readOnly=true)
	Client findByDsEmail(String dsEmail);
}
