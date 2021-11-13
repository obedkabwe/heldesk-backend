package com.obed.helpdesk.services;


import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.obed.helpdesk.domain.Tecnico;
import com.obed.helpdesk.repositories.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	public TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto noa encontrado: " + id, null));
	}		
		
	
	
	
	
	
	
	
	
	
	
	
	
}
