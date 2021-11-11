package com.obed.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obed.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
