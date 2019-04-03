package com.nelioalves.cursomc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nelioalves.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	//função SpringData procura Clientes pelo email.
	//Transactional faz com que não seja feito só no BD
	@Transactional(readOnly=true)
	Cliente findByEmail(String email);
}