package com.application.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

//CLASSE CHE RAPPRESENTA LA TABELLA

@Data
@Entity
@Table(name="dipendente", schema="negozio") // IL NOME DELLA CLASSE DI SOLITO RISPECCHIA IL NOME DELL'ENTITA SUL DB
public class Dipendente {
	
		
	public Dipendente() {};
	public Dipendente(Long id, String nome, String cognome, Integer eta, Integer anno_assunzione, Integer ore_contratto, Date data_di_nascita, Gender gender, Integer id_azienda) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.anno_assunzione = anno_assunzione;
		this.ore_contratto = ore_contratto;
		this.data_di_nascita = data_di_nascita;
		this.gender = gender;
		this.id_azienda = id_azienda;
	}
	
	// unique specifica se la colonna è univoca
	// x rendere un campo non persistente usare @Transient
	
	
	@Id // IDENTIFICA LA PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.AUTO) // STRATEGIA DI GENERATORE DELL'ID. 
	private Long id;
	
	@Column(nullable = true, name = "nome", length=50)
	private String nome;
	
	@Column(nullable = true, name = "cognome")
	private String cognome;
	
	@Column(nullable = true, name = "eta")
	private Integer eta;
	
	@Column(nullable = true, name = "anno_assunzione")
	private Integer anno_assunzione;
	
	@Column(nullable = true, name = "ore_contratto")
	private Integer ore_contratto;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = true, name = "data_di_nascita")
	private Date data_di_nascita;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = true, name = "gender")
    private Gender gender;
	
	@Column(nullable = true, name = "id_azienda")
	private Integer id_azienda;
	
}
