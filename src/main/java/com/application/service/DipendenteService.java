package com.application.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.application.model.Dipendente;

//DECIDO I MIEI SERVIZI
@Service
public interface DipendenteService {
	
// --------------------- QUERY -------------------------------	
	// GET
	List <Dipendente> listaDipendenti();//QUERY
	List <Dipendente> listaDipendentiAgeMore30(int eta);//QUERY
	List<Dipendente> findEtaBetween(@Param("start") int start, @Param("end") int end);//QUERY  
 
	
	// GUIDA CREATE
	Dipendente saveDipendente(Dipendente dip); // ---------------> OK
	
    // GUIDA GET
    List<Dipendente> getAllDipendenti(); // ------> OK
    
    // GUIDA UPDATE
    void updateDipendenti(Long id, Dipendente dip); // --------------> OK
    
    // GUIDA DELETE
    void deleteDipendentiById(Long id); // OK
}
