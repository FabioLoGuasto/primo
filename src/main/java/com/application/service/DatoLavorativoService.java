package com.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.model.DatoLavorativo;

@Service
public interface DatoLavorativoService {
	
	// GUIDA GET
    List<DatoLavorativo> getAllDatiDipendenti();

}
