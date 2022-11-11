package com.application.service;
import java.util.List;
import java.util.Optional;

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
	
	@Override
	public List <Dipendente> listaDipendentiAgeMore30PathValue(int eta){
		return dipendenteRepository.listaDipendentiAgeMore30PathValue(eta);
	}
	
	@Override
	public List<Dipendente> findEtaBetween(@Param("start") int start, @Param("end") int end){
		return dipendenteRepository.findEtaBetween(start, end);
	}
	
	@Override
	public List <Dipendente> findNome(@Param("nome") String nome){
		return dipendenteRepository.findNome(nome);
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
	
	
	@Override
	public void saveDipendenteVoid(Dipendente dip) {
		dipendenteRepository.save(dip);
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
	public void updateDipendenti(Dipendente dip) {
		dipendenteRepository.save(dip);
	}

	
// ------------------------------- DELETE ------------------------------------------	
	@Override
	public void deleteDipendentiById(Long id) {
		dipendenteRepository.deleteById(id);		
	}

}
