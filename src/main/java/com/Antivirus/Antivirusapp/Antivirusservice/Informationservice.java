package com.Antivirus.Antivirusapp.Antivirusservice;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.Antivirus.Antivirusapp.model.Information;
import com.Antivirus.Antivirusapp.repository.RepositoryConcept;


import jakarta.persistence.criteria.Predicate;

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
	

	public static Specification<Information> getdata(Long id, String nommachine, String nomuser, String adresseip, String typeantivirus, String statusmachine){
		return ((root,query,cricteriaBuider)->{
			List<Predicate> predicate= new ArrayList<>(); 
			
			if(id!=null) {
				predicate.add(cricteriaBuider.equal(root.get("id"), id));
			}
			if(nommachine!=null&& !(nommachine.isEmpty())) {
				predicate.add(cricteriaBuider.equal(root.get("nommachine"), nommachine));
			}
			if(nomuser!=null&& !(nomuser.isEmpty())) {
				predicate.add(cricteriaBuider.equal(root.get("nomuser"), nomuser));
			}
			if(adresseip!=null&& !(adresseip.isEmpty())) {
				predicate.add(cricteriaBuider.equal(root.get("adresseip"), adresseip));
			}
			if(typeantivirus!=null&& !(typeantivirus.isEmpty())) {
				predicate.add(cricteriaBuider.equal(root.get("typeantivirus"), typeantivirus));
			}
			if(statusmachine!=null&& !(statusmachine.isEmpty())) {
				predicate.add(cricteriaBuider.equal(root.get("statusmachine"), statusmachine));
			}
			return cricteriaBuider.and(predicate.toArray(new Predicate[0]));
		});
	}
}
