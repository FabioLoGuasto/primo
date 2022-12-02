package com.application.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Azienda;
import com.application.repository.AziendaRepository;

@Service
public class AziendaServiceImp implements AziendaService{

	@Autowired
	private AziendaRepository aziendaRepository;
	
	/*
	 * GET AZIENDE
	 */
	@Override
	public List<Azienda> getAllAziende() {
		return this.aziendaRepository.findAll();
	}

	/*
	 * INSERT NEW AZIENDE
	 */
	@Override
	public Azienda saveAzienda(Azienda az) {
		Azienda azienda = new Azienda(az.getId_azienda(), az.getNome_azienda(), az.getSede_azienda());
		return aziendaRepository.save(azienda);
	}

	/*
	 * UPDATE AZIEDA
	 */
	@Override
	public void updateAzienda(Long id, Azienda az) {
		az.setId_azienda(id);
		aziendaRepository.save(az);
	}

	/*
	 * DELETE AZIENDA BY ID
	 */
	@Override
	public void deleteAziendaById(Long id) {
		aziendaRepository.deleteById(id);		
	}
	
	
	
	

}
