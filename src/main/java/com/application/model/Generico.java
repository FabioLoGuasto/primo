package com.application.model;
import java.util.Date;

public class Generico {
	

	private Long idGenerico;	
	private String nomeGenerico;	
	private String cognomeGenerico;	
	private Integer etaGenerico;	
	private Integer anno_assunzioneGenerico;
	private Integer ore_contrattoGenerico;
	private Date data_di_nascitaGenerico;
	private Gender genderGenerico;
	private Integer id_aziendaGenerico;

	
	public Generico() {}
	
	public Generico(Long idGenerico, String nomeGenerico, String cognomeGenerico, Integer etaGenerico,
			Integer anno_assunzioneGenerico, Integer ore_contrattoGenerico, Date data_di_nascitaGenerico,Gender genderGenerico,
			Integer id_aziendaGenerico) {
		this.idGenerico = idGenerico;
		this.nomeGenerico = nomeGenerico;
		this.cognomeGenerico = cognomeGenerico;
		this.etaGenerico = etaGenerico;
		this.anno_assunzioneGenerico = anno_assunzioneGenerico;
		this.ore_contrattoGenerico = ore_contrattoGenerico;
		this.data_di_nascitaGenerico = data_di_nascitaGenerico;
		this.genderGenerico = genderGenerico;
		this.id_aziendaGenerico = id_aziendaGenerico;
	}
	
	public Long getIdGenerico() {
		return idGenerico;
	}
	public void setIdGenerico(Long idGenerico) {
		this.idGenerico = idGenerico;
	}
	public String getNomeGenerico() {
		return nomeGenerico;
	}
	public void setNomeGenerico(String nomeGenerico) {
		this.nomeGenerico = nomeGenerico;
	}
	public String getCognomeGenerico() {
		return cognomeGenerico;
	}
	public void setCognomeGenerico(String cognomeGenerico) {
		this.cognomeGenerico = cognomeGenerico;
	}
	public Integer getEtaGenerico() {
		return etaGenerico;
	}
	public void setEtaGenerico(Integer etaGenerico) {
		this.etaGenerico = etaGenerico;
	}
	public Integer getAnno_assunzioneGenerico() {
		return anno_assunzioneGenerico;
	}
	public void setAnno_assunzioneGenerico(Integer anno_assunzioneGenerico) {
		this.anno_assunzioneGenerico = anno_assunzioneGenerico;
	}
	public Integer getOre_contrattoGenerico() {
		return ore_contrattoGenerico;
	}
	public void setOre_contrattoGenerico(Integer ore_contrattoGenerico) {
		this.ore_contrattoGenerico = ore_contrattoGenerico;
	}
	public Integer getId_aziendaGenerico() {
		return id_aziendaGenerico;
	}
	public void setId_aziendaGenerico(Integer id_aziendaGenerico) {
		this.id_aziendaGenerico = id_aziendaGenerico;
	}
	public Date getData_di_nascitaGenerico() {
		return data_di_nascitaGenerico;
	}
	public void setData_di_nascitaGenerico(Date data_di_nascitaGenerico) {
		this.data_di_nascitaGenerico = data_di_nascitaGenerico;
	}
	public Gender getGenderGenerico() {
		return genderGenerico;
	}
	public void setGenderGenerico(Gender genderGenerico) {
		this.genderGenerico = genderGenerico;
	}
	
	
	
}
