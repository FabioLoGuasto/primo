package com.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.model.Dipendente;

//DECIDO I MIEI SERVIZI
@Service
public interface DipendenteService {
	
	// GET
//	Dipendente findDipendentiById (int id);
	List <Dipendente> listaDipendenti();
	
	// POST
//	Dipendente insertDipendente(Dipendente s);

	
// -------------------------- GUIDA ----------------------------------------
	// CREATE
	Dipendente saveDipendente(Dipendente dip);
 
    // GET
    List<Dipendente> getAllDipendenti();
    Dipendente getDipendenteById(Long id);
    List <Dipendente> getDipendentiByName(String nome);
 
    // UPDATE
    Dipendente updateDipendenti(Dipendente dip,int dipendenteId);
 
    // DELETE
    void deleteDipendentiById(int dipendenteId);
}
