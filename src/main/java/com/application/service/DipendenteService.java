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
//	Dipendente findDipendentiById (int id);
	List <Dipendente> listaDipendenti();//QUERY
	List <Dipendente> listaDipendentiAgeMore30(int eta);//QUERY
	List <Dipendente> listaDipendentiAgeMore30PathValue(int eta);//QUERY
	List<Dipendente> findEtaBetween(@Param("start") int start, @Param("end") int end);//QUERY  
    List<Dipendente> findNome(@Param("nome") String nome); //QUERY
    
	// POST
//	Dipendente insertDipendente(Dipendente s);

	
// -------------------------- GUIDA ----------------------------------------
	// CREATE
	Dipendente saveDipendente(Dipendente dip); // ---------------> NON FUNZIONA
	public void saveDipendenteVoid(Dipendente dip); // ---------------> NON FUNZIONA
	
    // GET
    List<Dipendente> getAllDipendenti(); // ------> OK
    Dipendente getDipendenteById(Long id); 	// ------> OK
    List<Dipendente> getDipendentiByName(String nome); // ------> OK  
    
    // UPDATE
    void updateDipendenti(Dipendente dip); // --------------> NON FUNZIONA
 
    // DELETE
    void deleteDipendentiById(Long id); // OK
}
