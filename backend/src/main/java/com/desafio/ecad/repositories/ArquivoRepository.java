package com.desafio.ecad.repositories;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafio.ecad.entities.Arquivo;
import com.desafio.ecad.entities.Tipo;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long>{
	
	List<Arquivo> findByNome(String nome);
	List<Arquivo> findByTipo(Tipo tipo);
	
	@Query(value = "SELECT * FROM arquivo WHERE dt_geracao > ?1 AND dt_geracao <= ?2", nativeQuery = true)
	List<Arquivo> findAllDate(Date dtFinal, Date dtInicial);
}
