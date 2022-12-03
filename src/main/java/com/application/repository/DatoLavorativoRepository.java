package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.model.DatoLavorativo;

@Repository
public interface DatoLavorativoRepository extends JpaRepository<DatoLavorativo, Long>{

}
