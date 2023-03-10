package com.Antivirus.Antivirusapp.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Antivirus.Antivirusapp.model.Information;

public interface RepositoySearch extends JpaRepository<Information, Long>{

	
	List<Information> findAll(Specification<Information> specification);

}
