package com.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.model.Dipendente; 

@Repository 
public interface DipendenteRepository extends JpaRepository<Dipendente, Long> { 
// @Repository è un component, come se fosse una sottoclasse. Tutti i component possono essere referenziati tramite l'@Autowired
	
	// Query nativa
	// @Query("select * from Dipendente d where d.ral = :ral)
	//Dipendente customQuery(@Param("ral") Int ral);
	
	
	
	
	List<Dipendente>findByNomeContaining(String nome);

	@Query(value = "SELECT * FROM negozio.dipendenti", nativeQuery = true)
	List <Dipendente> listaDipendenti();
	
	
	
	@Query(value ="select * from dipendenti d where d.eta > ?1", nativeQuery = true)
	List <Dipendente> listaDipendentiAgeMore30(int eta);
	//01:33
	
}
