package com.desafio.ecad.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tipo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipo;
	private String nomeTipo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipo")
	private List<Arquivo> arquivos = new ArrayList<Arquivo>();

	public Tipo() {}
	
	public Tipo(Long idTipo, String nomeTipo) {
		this.idTipo = idTipo;
		this.nomeTipo = nomeTipo;
	}

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	public List<Arquivo> getArquivos() {
		return arquivos;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idTipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tipo other = (Tipo) obj;
		return Objects.equals(idTipo, other.idTipo);
	}	

}
