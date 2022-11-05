package com.application.service;

import java.util.List;
import com.application.model.Dipendente;
import com.application.repository.DipendenteRepository;

//DECIDO I MIEI SERVIZI

public interface DipendenteService {
	
	// GET
	Dipendente findDipendentiById (int id);
	
	// POST
	Dipendente insertDipendente(Dipendente s);

	
	// ------------------------------------------------------------------
	// CREATE
    Dipendente saveDepartment(Dipendente dip);
 
    // GET
    List<DipendenteRepository> getAllDipendenti();
    public Dipendente getDipendenteById(int id);
 
    // UPDATE
    Dipendente updateDipendenti(Dipendente dip,int dipendenteId);
 
    // DELETE
    void deleteDipendentiById(int dipendenteId);
}
