package com.application.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Dipendente;
import com.application.repository.DipendenteRepository;

import javassist.NotFoundException;

/*
 * QUA IMPLEMENTO I MIEI SERVIZI ED
 * OGNI AZIONE CHE HO QUA DENTRO ANDRò A CHIAMARLA DAL MIO CONTROLLER
 */
@Service
public class DipendenteServiceImpl implements DipendenteService {
		
	@Autowired
	private DipendenteRepository dipendenteRepository; // dove ci sono i metodi di default

	@Override
	public Dipendente findDipendentiById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dipendente insertDipendente(Dipendente s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dipendente saveDepartment(Dipendente dip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DipendenteRepository> getAllDipendenti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dipendente getDipendenteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dipendente updateDipendenti(Dipendente dip, int dipendenteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDipendentiById(int dipendenteId) {
		// TODO Auto-generated method stub
		
	}

}
