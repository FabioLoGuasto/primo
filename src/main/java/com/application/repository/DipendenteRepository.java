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
	

	@Query(value = "SELECT * FROM negozio.dipendenti", nativeQuery = true) // ---------> OK
	List <Dipendente> listaDipendenti();
		
	@Query(value ="select * from dipendenti d where d.eta > ?1", nativeQuery = true) // ---------> OK
	List <Dipendente> listaDipendentiAgeMore30(int eta);
		
	@Query(value = "SELECT * FROM dipendenti d WHERE d.eta BETWEEN :start AND :end", nativeQuery = true) // ---------> OK
	List<Dipendente> findEtaBetween(@Param("start") int start, @Param("end") int end);
	
	
}
