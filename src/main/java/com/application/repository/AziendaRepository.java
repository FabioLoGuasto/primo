package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Azienda;

@Repository
public interface AziendaRepository extends JpaRepository<Azienda, Long>{

}
