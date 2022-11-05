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
	private int id; 
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "eta")
	private int eta;
	
	@Column(name = "annoAssunzione")
	private int annoAssunzione;
	
	@Column(name = "oreContratto")
	private int oreContratto;
	
	@Column(name = "categoriaProtetta")
	private String categoriaProtetta;
	
	@Column(name = "articolo104")
	private String articolo104;
	
	@Column(name = "livelloContratto")
	private int livelloContratto;
	
	@Column(name = "ral")
	private int ral;
	
	@Column(name = "negozio")
	private String negozio;
	
	@Column(name = "codiceNegozio")
	private int codiceNegozio;

}
