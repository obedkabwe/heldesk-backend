package com.obed.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obed.helpdesk.domain.Chamado;
import com.obed.helpdesk.exceptions.ObjectNotFoundException;
import com.obed.helpdesk.repositories.ChamadoRepository;

@Service
public class ChamadoService {
	
    @Autowired
	private ChamadoRepository repository;
	
    public Chamado findById(Integer id) {
    	Optional<Chamado> obj = repository.findById(id);
    	return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao foi encontrado! ID"  + id));
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
