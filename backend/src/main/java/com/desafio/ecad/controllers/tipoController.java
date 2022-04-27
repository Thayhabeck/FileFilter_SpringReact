package com.desafio.ecad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.ecad.entities.Tipo;
import com.desafio.ecad.repositories.TipoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/tipos")
public class tipoController {
	
	@Autowired
	TipoRepository tipoRepository;
	
	@GetMapping
	public ResponseEntity<List<Tipo>> findAll(){
		List<Tipo> tipos = tipoRepository.findAll();
		return ResponseEntity.ok().body(tipos);
	}

}
