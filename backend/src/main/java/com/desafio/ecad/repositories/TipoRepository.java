package com.desafio.ecad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.ecad.entities.Tipo;

@Repository
public interface TipoRepository  extends JpaRepository<Tipo, Long>{
	
	Tipo findByNomeTipo(String nome);
}
