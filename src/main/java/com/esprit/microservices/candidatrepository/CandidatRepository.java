package com.esprit.microservices.candidatrepository;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.microservices.candidatentity.Candidat;

public interface CandidatRepository extends CrudRepository<Candidat, Integer>{

	@Query("select c from Candidat c where c.nom like :nom")
	public Page<Candidat> candidatByNom(@Param("nom") String nom, Pageable pageable);
	

	
}