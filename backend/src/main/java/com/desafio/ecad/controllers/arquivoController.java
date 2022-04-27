package com.desafio.ecad.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.ecad.entities.Arquivo;
import com.desafio.ecad.entities.Tipo;
import com.desafio.ecad.repositories.ArquivoRepository;
import com.desafio.ecad.repositories.TipoRepository;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/arquivos")
public class arquivoController {
	
	@Autowired
	ArquivoRepository arquivoRepository;
	
	@Autowired
	TipoRepository tipoRepository;
	
	@GetMapping(value = "/listarTodos")
	public ResponseEntity<List<Arquivo>> findAll(){
		List<Arquivo> arquivos = arquivoRepository.findAll();
		return ResponseEntity.ok().body(arquivos);
	}
	
	@GetMapping(value = "/listarData")
	public ResponseEntity<List<Arquivo>> findDateBetween(@RequestParam(name = "Data Inicial (dd/mm/aaaa)") String dataInicial, @RequestParam(name = "Data Final (dd/mm/aaaa)") String dataFinal) throws ParseException{
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		List<Arquivo> arquivos = arquivoRepository.findAllDate(new Date(fmt.parse(dataInicial).getTime()), new Date(fmt.parse(dataFinal).getTime()));
		return ResponseEntity.ok().body(arquivos);
	}
	
	@GetMapping(value = "/listarTipo")
	public ResponseEntity<List<Arquivo>> findTipo(@RequestParam(name = "Tipo") String tipo){
		Tipo tp = tipoRepository.findByNomeTipo(tipo);
		List<Arquivo> arquivos = arquivoRepository.findByTipo(tp);
		return ResponseEntity.ok().body(arquivos);
	}
	
	@GetMapping(value = "/listarNome")
	public ResponseEntity<List<Arquivo>> findNome(@RequestParam(name = "Nome") String nome){
		List<Arquivo> arquivo = arquivoRepository.findByNome(nome);
		return ResponseEntity.ok().body(arquivo);
	}

}
