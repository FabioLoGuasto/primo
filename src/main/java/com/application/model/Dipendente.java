package com.application.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


//CLASSE CHE RAPPRESENTA LA TABELLA

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder

@Data
@Entity
@Table(name="dipendenti")
public class Dipendente {
	
	
	
	
	public Dipendente() {};
	public Dipendente(Long id, String nome, String cognome, Integer eta, Integer annoassunzione, Integer orecontratto,
			String categoriaprotetta, String articolo104, Integer livellocontratto, Integer ral, String negozio,
			Integer codicenegozio) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.annoassunzione = annoassunzione;
		this.orecontratto = orecontratto;
		this.categoriaprotetta = categoriaprotetta;
		this.articolo104 = articolo104;
		this.livellocontratto = livellocontratto;
		this.ral = ral;
		this.negozio = negozio;
		this.codicenegozio = codicenegozio;
	}
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	@Column(nullable = true, name = "nome")
	private String nome;
	
	@Column(nullable = true, name = "cognome")
	private String cognome;
	
	@Column(nullable = true, name = "eta")
	private Integer eta;
	
	@Column(nullable = true, name = "annoassunzione")
	private Integer annoassunzione;
	
	@Column(nullable = true, name = "orecontratto")
	private Integer orecontratto;
	
	@Column(nullable = true, name = "categoriaprotetta")
	private String categoriaprotetta;
	
	@Column(nullable = true, name = "articolo104")
	private String articolo104;
	
	@Column(nullable = true, name = "livellocontratto")
	private Integer livellocontratto;
	
	@Column(nullable = true, name = "ral")
	private Integer ral;
	
	@Column(nullable = true, name = "negozio")
	private String negozio;
	
	@Column(nullable = true, name = "codicenegozio")
	private Integer codicenegozio;

	
	
	
	
}
