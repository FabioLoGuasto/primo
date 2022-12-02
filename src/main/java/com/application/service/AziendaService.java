package com.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.application.model.Azienda;


@Service
public interface AziendaService {

	//GET
	List <Azienda> getAllAziende();
	
	//CREATE
	Azienda saveAzienda (Azienda az);
	
	//UPDATE
    void updateAzienda(Long id, Azienda az); 
    
    //DELETE
    void deleteAziendaById(Long id); 
}
