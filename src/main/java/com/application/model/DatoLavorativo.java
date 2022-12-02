package com.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//@Data
//@Entity
//@Table(name="dato_lavorativo", schema="negozio")
public class DatoLavorativo {

	public DatoLavorativo () {}
	public DatoLavorativo(Long id_dato_lavorativo, Integer codice_negozio, String negozio, Integer ral,
			Integer livello_contratto, String articolo_104, String categoria_protetta, Long id_dipendente) {
		this.id_dato_lavorativo = id_dato_lavorativo;
		this.codice_negozio = codice_negozio;
		this.negozio = negozio;
		this.ral = ral;
		this.livello_contratto = livello_contratto;
		this.articolo_104 = articolo_104;
		this.categoria_protetta = categoria_protetta;
		this.id_dipendente = id_dipendente;
	}

//	@Id // IDENTIFICA LA PRIMARY KEY
//	@GeneratedValue(strategy = GenerationType.AUTO) // STRATEGIA DI GENERATORE DELL'ID. 
	private Long id_dato_lavorativo;
	
//	@Column(nullable = true, name = "codice_negozio")
	private Integer codice_negozio;
	
//	@Column(nullable = true, name = "negozio")
	private String negozio;
	
//	@Column(nullable = true, name = "ral")
	private Integer ral;
	
//	@Column(nullable = true, name = "livello_contratto")
	private Integer livello_contratto;
	
//	@Column(nullable = true, name = "articolo_104")
	private String articolo_104;
	
//	@Column(nullable = true, name = "categoria_protetta")
	private String categoria_protetta;
	
//	@Column(nullable = true, name = "id_dipendente")
	private Long id_dipendente;
}
