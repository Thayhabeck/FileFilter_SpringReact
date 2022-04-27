package com.desafio.ecad.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Arquivo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private Tipo tipo;
	
	@Column(unique=true)
	private String nome;
	
	private String banco;
	private Date dtGeracao;
	private String geradoPor;
	private Date dtEnvio;
	private Integer qtdLinhas;
	private Double vlrTotal;
	
	public Arquivo() {}
	
	public Arquivo(Long id, String banco, Tipo tipo, String nome, Date date, String geradoPor, Date date2,
			Integer qtdLinhas, Double vlrTotal) {
		this.id = id;
		this.banco = banco;
		this.tipo = tipo;
		this.nome = nome;
		this.dtGeracao = date;
		this.geradoPor = geradoPor;
		this.dtEnvio = date2;
		this.qtdLinhas = qtdLinhas;
		this.vlrTotal = vlrTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtGeracao() {
		return dtGeracao;
	}

	public void setDtGeracao(Date dtGeracao) {
		this.dtGeracao = dtGeracao;
	}

	public String getGeradoPor() {
		return geradoPor;
	}

	public void setGeradoPor(String geradoPor) {
		this.geradoPor = geradoPor;
	}

	public Date getDtEnvio() {
		return dtEnvio;
	}

	public void setDtEnvio(Date dtEnvio) {
		this.dtEnvio = dtEnvio;
	}

	public Integer getQtdLinhas() {
		return qtdLinhas;
	}

	public void setQtdLinhas(Integer qtdLinhas) {
		this.qtdLinhas = qtdLinhas;
	}

	public Double getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(Double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

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
		Arquivo other = (Arquivo) obj;
		return Objects.equals(id, other.id);
	}
	
}
