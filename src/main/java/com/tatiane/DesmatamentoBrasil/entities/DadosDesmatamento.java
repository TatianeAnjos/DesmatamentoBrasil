package com.tatiane.DesmatamentoBrasil.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DadosDesmatamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String ano;
	private String uf;
	private Double areaMetros;
	private Double tamanhoForma;
	private Double areaForma;
	
	public DadosDesmatamento() {
		
		
	}
		

	public DadosDesmatamento(Long id, String ano, String uf, Double areaMetros, Double tamanhoForma, Double areaForma) {
		super();
		this.id = id;
		this.ano = ano;
		this.uf = uf;
		this.areaMetros = areaMetros;
		this.tamanhoForma = tamanhoForma;
		this.areaForma = areaForma;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Double getAreaMetros() {
		return areaMetros;
	}

	public void setAreaMetros(Double areaMetros) {
		this.areaMetros = areaMetros;
	}

	public Double getTamanhoForma() {
		return tamanhoForma;
	}

	public void setTamanhoForma(Double tamanhoForma) {
		this.tamanhoForma = tamanhoForma;
	}

	public Double getAreaForma() {
		return areaForma;
	}

	public void setAreaForma(Double areaForma) {
		this.areaForma = areaForma;
	}

}