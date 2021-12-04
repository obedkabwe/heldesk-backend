package com.obed.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obed.helpdesk.domain.Chamado;
import com.obed.helpdesk.domain.Cliente;
import com.obed.helpdesk.domain.Tecnico;
import com.obed.helpdesk.enums.Perfil;
import com.obed.helpdesk.enums.Prioridade;
import com.obed.helpdesk.enums.Status;
import com.obed.helpdesk.repositories.ChamadoRepository;
import com.obed.helpdesk.repositories.ClienteRepository;
import com.obed.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	public void instanciaDB() {

		Tecnico tec1 = new Tecnico(null, "obed kabwe", "3947547543 ","kabwe@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Tecnico tec2 = new Tecnico(null, "Richard Stallman", "283.278.380-59", "stallman@mail.com", ("123"));
		Tecnico tec3 = new Tecnico(null, "Claude Elwood Shannon", "378.034.970-12", "shannon@mail.com", ("123"));
		Tecnico tec4 = new Tecnico(null, "Tim Berners-Lee", "573.335.340-65", "lee@mail.com", ("123"));
		Tecnico tec5 = new Tecnico(null, "Linus Torvalds", "663.998.200-57", "linus@mail.com", ("123"));
		
		
		Cliente cli1 = new Cliente(null, "nathan ngoya", "419.307.360-29", "oberson@gmail.com", "123");
		Cliente cli2 = new Cliente(null, "Marie Curie", "040.152.330-69", "curie@mail.com", ("123"));
		Cliente cli3 = new Cliente(null, "Charles Darwin", "515.779.820-29", "darwin@mail.com", ("123"));
		Cliente cli4 = new Cliente(null, "Stephen Hawking", "792.553.610-15", "hawking@mail.com", ("123"));
		Cliente cli5 = new Cliente(null, "Max Planck", "208.308.480-29", "planck@mail.com", ("123"));
		
		
		Chamado c1 = new Chamado(null,Prioridade.MEDIA,Status.ANDAMENTO,"Chamado 1" , "Primeiro chamada", cli1, tec1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", cli5, tec5);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2,tec3,tec4,tec5));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4,cli5));
		chamadoRepository.saveAll(Arrays.asList(c1,c2));
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
