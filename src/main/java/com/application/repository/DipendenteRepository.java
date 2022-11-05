package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 

@Repository
public interface DipendenteRepository extends JpaRepository<DipendenteRepository,Integer> { 
	
	// qua c'è la string sql e
	// qua sotto la signature del metodo 
	// x delle query gia pronte
	
	
	
	
	// Query nativa
	// @Query("select * from Dipendente d where d.ral = :ral)
	//Dipendente customQuery(@Param("ral") Int ral);
}
