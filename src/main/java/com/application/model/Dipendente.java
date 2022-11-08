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
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	@Column(nullable = true, name = "nome")
	private String nome;
	
	@Column(nullable = true, name = "cognome")
	private String cognome;
	
	@Column(nullable = true, name = "eta")
	private Integer eta;
	
	@Column(nullable = true, name = "annoAssunzione")
	private Integer annoAssunzione;
	
	@Column(nullable = true, name = "oreContratto")
	private Integer oreContratto;
	
	@Column(nullable = true, name = "categoriaProtetta")
	private String categoriaProtetta;
	
	@Column(nullable = true, name = "articolo104")
	private String articolo104;
	
	@Column(nullable = true, name = "livelloContratto")
	private Integer livelloContratto;
	
	@Column(nullable = true, name = "ral")
	private Integer ral;
	
	@Column(nullable = true, name = "negozio")
	private String negozio;
	
	@Column(nullable = true, name = "codiceNegozio")
	private Integer codiceNegozio;	
}
