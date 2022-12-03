package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.DatoLavorativo;
import com.application.repository.DatoLavorativoRepository;

@Service
public class DatoLavorativoImpl implements DatoLavorativoService{

	@Autowired
	DatoLavorativoRepository datoLavorativoRepository;
	
	@Override
	public List<DatoLavorativo> getAllDatiDipendenti() {
		return datoLavorativoRepository.findAll();
	}

}
