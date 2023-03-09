package com.Antivirus.Antivirusapp.Antivirusservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Antivirus.Antivirusapp.model.Information;
import com.Antivirus.Antivirusapp.repository.RepositoryConcept;

@Service
public class Informationservice {
	
	@Autowired
	private RepositoryConcept repositoryConcept;
	
	public List<Information> getCars(){
		List<Information> informations= new ArrayList<>();
		repositoryConcept.findAll().forEach(info->{
			informations.add(info);
		});
		return informations;
	}

	public Information getCar(long id) {
		return repositoryConcept.findById(id).orElse(null);
	}

	public void deleteCar(long id) {
		
		repositoryConcept.deleteById(id);;	
	}
	
	public void addCar(Information info) {
		
		repositoryConcept.save(info);
	}

	public Information updateCar(Information info,long id) {
		Information information = repositoryConcept.findById(id).get();
		information.setNommachine(info.getNommachine());
		information.setNomuser(info.getNomuser());
		information.setAdresseip(info.getAdresseip());
		information.setTypeantivirus(info.getTypeantivirus());
		information.setStatusmachine(info.getStatusmachine());
		return repositoryConcept.save(information);
	}
}
