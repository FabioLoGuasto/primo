package com.application.model;
// https://www.youtube.com/watch?v=8qhaDBCJh6I

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.ToString; //NON SO A COSA SERVE

@ToString
@Entity
@Table(name="azienda", schema="negozio")
public class Azienda {
	
	public Azienda () {}
	public Azienda (Long id_azienda, String nome_azienda, String sede_azienda) {
		this.id_azienda = id_azienda;
		this.nome_azienda = nome_azienda;
		this.sede_azienda = sede_azienda;
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ?????????????????????????????????????
	private Long id_azienda;
	
	@Column(nullable = true, name = "nome_azienda")
	private String nome_azienda;
	
	@Column(nullable = true, name = "sede_azienda")
	private String sede_azienda;
	
//  se aggiungo @JoinColumn mi da errore dicendo che se c'è mappedBy non posso aggiungere @JoinColumn
	@OneToMany(mappedBy = "azienda_id",fetch = FetchType.LAZY,targetEntity = Dipendente.class,cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set <Dipendente> listaDipendenti = new HashSet<>(); // set non ha duplicati

	
	
	public Long getId_azienda() {
		return id_azienda;
	}
	public void setId_azienda(Long id_azienda) {
		this.id_azienda = id_azienda;
	}
	public String getNome_azienda() {
		return nome_azienda;
	}
	public void setNome_azienda(String nome_azienda) {
		this.nome_azienda = nome_azienda;
	}
	public String getSede_azienda() {
		return sede_azienda;
	}
	public void setSede_azienda(String sede_azienda) {
		this.sede_azienda = sede_azienda;
	}
	
	
	public Set<Dipendente> getListaDipendenti() {
		return listaDipendenti;
	}
	public void setListaDipendenti(Set<Dipendente> listaDipendenti) {
		this.listaDipendenti = listaDipendenti;
	}

}
