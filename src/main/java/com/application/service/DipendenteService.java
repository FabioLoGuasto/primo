package com.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.model.Dipendente;

//DECIDO I MIEI SERVIZI
@Service
public interface DipendenteService {
	
	// GET
	Dipendente findDipendentiById (int id);
	
	// POST
	Dipendente insertDipendente(Dipendente s);

	
	// ------------------------------------------------------------------
	// CREATE
    Dipendente saveDepartment(Dipendente dip);
 
    // GET
    List<Dipendente> getAllDipendenti();
    
    Dipendente getDipendenteById(int id);
 
    // UPDATE
    Dipendente updateDipendenti(Dipendente dip,int dipendenteId);
 
    // DELETE
    void deleteDipendentiById(int dipendenteId);
}
