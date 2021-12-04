package com.obed.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.obed.helpdesk.enums.Prioridade;
import com.obed.helpdesk.enums.Status;

@Entity
public class Chamado implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @JsonFormat(pattern = "dd/MM/yyy")
    private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyy")
    private LocalDate dataFechamento =LocalDate.now();
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacaoes;
	
	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		return Objects.equals(id, other.id);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public LocalDate getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public Prioridade getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getObservacaoes() {
		return observacaoes;
	}
	public void setObservacaoes(String observacaoes) {
		this.observacaoes = observacaoes;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacaoes,
			Cliente cliente, Tecnico tecnico) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulo = titulo;
		this.observacaoes = observacaoes;
		this.cliente = cliente;
		this.tecnico = tecnico;
	}
	public Chamado() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
