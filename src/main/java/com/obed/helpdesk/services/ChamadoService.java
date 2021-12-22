package com.obed.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obed.helpdesk.domain.Chamado;
import com.obed.helpdesk.domain.Cliente;
import com.obed.helpdesk.domain.Tecnico;
import com.obed.helpdesk.dtos.ChamadoDTO;
import com.obed.helpdesk.enums.Prioridade;
import com.obed.helpdesk.enums.Status;
import com.obed.helpdesk.exceptions.ObjectNotFoundException;
import com.obed.helpdesk.repositories.ChamadoRepository;

@Service
public class ChamadoService {
	
    @Autowired
	private ChamadoRepository repository;
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;
   
	
	public Chamado findById(Integer id) {
    	Optional<Chamado> obj = repository.findById(id);
    	return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao foi encontrado! ID"  + id));
    }

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}
	
	
	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		Chamado chamado = new Chamado();
		if (obj.getId() !=null) {
			chamado.setId(obj.getId());
		}
		
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnnum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacaoes(obj.getObservacaoes());
		return chamado;
	}

	public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
		objDTO.setId(id);
		Chamado oldObj = findById(id);
		oldObj = newChamado(objDTO);
		return repository.save(oldObj);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
