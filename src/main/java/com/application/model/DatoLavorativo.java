package com.application.model;
// https://www.bezkoder.com/jpa-one-to-one/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@MapsId fa sì che il campo id funga sia da chiave primaria che da chiave esterna (chiave primaria condivisa).
//@JsonIgnoreProperties({"hibernateLazyInitializer"}) // ????????????????????????????????????
@Entity
@Table(name="dato_lavorativo", schema="negozio")
public class DatoLavorativo {

	public DatoLavorativo () {}
	public DatoLavorativo(Long id_dato_lavorativo, Integer codice_negozio, String negozio, Integer ral,
			Integer livello_contratto, String articolo_104, String categoria_protetta,Dipendente dipendente_id) {
		this.id_dato_lavorativo = id_dato_lavorativo;
		this.codice_negozio = codice_negozio;
		this.negozio = negozio;
		this.ral = ral;
		this.livello_contratto = livello_contratto;
		this.articolo_104 = articolo_104;
		this.categoria_protetta = categoria_protetta;
		this.dipendente_id = dipendente_id;
	}

	@Id // QUEST PK NON è AUTOINCREMENT
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_dato_lavorativo;
	
	@Column(nullable = true, name = "codice_negozio")
	private Integer codice_negozio;
	
	@Column(nullable = true, name = "negozio")
	private String negozio;
	
	@Column(nullable = true, name = "ral")
	private Integer ral;
	
	@Column(nullable = true, name = "livello_contratto")
	private Integer livello_contratto;
	
	@Column(nullable = true, name = "articolo_104")
	private String articolo_104;
	
	@Column(nullable = true, name = "categoria_protetta")
	private String categoria_protetta;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dipendente_id")
	private Dipendente dipendente_id;

	
	
	public Dipendente getDipendente_id() {
		return dipendente_id;
	}
	public void setDipendente_id(Dipendente dipendente_id) {
		this.dipendente_id = dipendente_id;
	}
	
	
	
	
	
	
	
	
	public Long getId_dato_lavorativo() {
		return id_dato_lavorativo;
	}
	public void setId_dato_lavorativo(Long id_dato_lavorativo) {
		this.id_dato_lavorativo = id_dato_lavorativo;
	}
	public Integer getCodice_negozio() {
		return codice_negozio;
	}
	public void setCodice_negozio(Integer codice_negozio) {
		this.codice_negozio = codice_negozio;
	}
	public String getNegozio() {
		return negozio;
	}
	public void setNegozio(String negozio) {
		this.negozio = negozio;
	}
	public Integer getRal() {
		return ral;
	}
	public void setRal(Integer ral) {
		this.ral = ral;
	}
	public Integer getLivello_contratto() {
		return livello_contratto;
	}
	public void setLivello_contratto(Integer livello_contratto) {
		this.livello_contratto = livello_contratto;
	}
	public String getArticolo_104() {
		return articolo_104;
	}
	public void setArticolo_104(String articolo_104) {
		this.articolo_104 = articolo_104;
	}
	public String getCategoria_protetta() {
		return categoria_protetta;
	}
	public void setCategoria_protetta(String categoria_protetta) {
		this.categoria_protetta = categoria_protetta;
	}

	
	



	
}
