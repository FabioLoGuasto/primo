package com.application.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

//	@Override
//	public Dipendente findDipendentiById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public List<Dipendente> listaDipendenti() {
		return dipendenteRepository.listaDipendenti();
	}
	
	@Override
	public List <Dipendente> listaDipendentiAgeMore30(int eta){
		return dipendenteRepository.listaDipendentiAgeMore30(eta);
	}
	
	
//	@Override
//	public Dipendente insertDipendente(Dipendente s) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
// ------------------------------- GUIDA ------------------------------------------
	

	
// ------------------------------- INSERT ------------------------------------------	
	@Override
	public Dipendente saveDipendente(Dipendente dip) {
		return dipendenteRepository.save(dip);
	}

	
// ------------------------------- GET ------------------------------------------		
	/**
	 * ritorna la lista dei dipendenti
	 */
	@Override
	public List<Dipendente> getAllDipendenti() {
		return this.dipendenteRepository.findAll();
	}

	
	/*
	 * Optional contiene un valore opzionale, e la find torna un Optional xkè non è detto che esista
	 * se non trova nulla il metodo orElse mi restituisce null
	 */
	@Override
	public Dipendente getDipendenteById(Long id) { 
		Optional<Dipendente> dip = dipendenteRepository.findById(id);
		return dip.orElse(null);
	}
	
	/*
	 * ritorna una lista di dipendente con un certo nome o un pezzo di nome
	 */
	@Override
	public List<Dipendente> getDipendentiByName(String nome) {
		return dipendenteRepository.findByNomeContaining(nome);
	}

	
	
	
// ------------------------------- UPDATE ------------------------------------------		
	@Override
	public Dipendente updateDipendenti(Dipendente dip, int dipendenteId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
// ------------------------------- DELETE ------------------------------------------	
	@Override
	public void deleteDipendentiById(int dipendenteId) {
		// TODO Auto-generated method stub
		
	}

}
