package com.application.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.application.model.Dipendente;
import com.application.repository.DipendenteRepository;

/*
 * QUA IMPLEMENTO I MIEI SERVIZI ED
 * OGNI AZIONE CHE HO QUA DENTRO ANDRò A CHIAMARLA DAL MIO CONTROLLER
 */
@Service
public class DipendenteServiceImpl implements DipendenteService {
		
	@Autowired
	private DipendenteRepository dipendenteRepository; // dove ci sono i metodi di default

// ------------------------------ QUERY GET ------------------------------------------------	
	@Override
	public List<Dipendente> listaDipendenti() {
		return dipendenteRepository.listaDipendenti();
	}
	
	@Override
	public List <Dipendente> listaDipendentiAgeMore30(int eta){
		return dipendenteRepository.listaDipendentiAgeMore30(eta);
	}
	
	@Override
	public List<Dipendente> findEtaBetween(@Param("start") int start, @Param("end") int end){
		return dipendenteRepository.findEtaBetween(start, end);
	}
		

	
// ------------------------------- GUIDA POST ------------------------------------------	
	@Override
	public Dipendente saveDipendente(Dipendente dip) {
		Dipendente dipendente = new Dipendente(dip.getId(),dip.getNome(),dip.getCognome(),dip.getEta(),dip.getAnnoassunzione(),dip.getOrecontratto(),dip.getCategoriaprotetta(),dip.getArticolo104(),dip.getLivellocontratto(),dip.getRal(),dip.getNegozio(),dip.getCodicenegozio());
		return dipendenteRepository.save(dipendente);
	}
	
	
// ------------------------------- GUIDA GET ------------------------------------------		
	/**
	 * ritorna la lista dei dipendenti
	 */
	@Override
	public List<Dipendente> getAllDipendenti() {
		return this.dipendenteRepository.findAll();
	}
	
// ------------------------------- GUIDA UPDATE ------------------------------------------		
	@Override
	public void updateDipendenti(Long id, Dipendente dip) {
		dip.setId(id);
		dipendenteRepository.save(dip);
	}
	
// ------------------------------- GUIDA DELETE ------------------------------------------	
	@Override
	public void deleteDipendentiById(Long id) {
		dipendenteRepository.deleteById(id);		
	}

}
