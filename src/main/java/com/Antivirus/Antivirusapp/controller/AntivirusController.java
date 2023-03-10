package com.Antivirus.Antivirusapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Antivirus.Antivirusapp.Antivirusservice.Informationservice;
import com.Antivirus.Antivirusapp.model.Information;
import com.Antivirus.Antivirusapp.repository.RepositoySearch;

@CrossOrigin(origins = "*")
@RestController
public class AntivirusController {
	
	@Autowired
	private Informationservice information;
	
	@Autowired
	public RepositoySearch reposearch;
	
	@RequestMapping("/concept")
	public List<Information> getCart() {
		return information.getCars();
	}

	@RequestMapping("/concept/{id}")
	public Information getCar(@PathVariable long id) {
		return information.getCar(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/concept/{id}")
	public void deleteCar(@PathVariable long id) {
		information.deleteCar(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/concept")
	public void addCar(@RequestBody Information car) {
		information.addCar(car);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/concept/{id}" )
	public void updateCar(@RequestBody Information car, @PathVariable long id) {
		information.updateCar(car,id);
	}
	
	@GetMapping("/search" )
	public List<Information> list(
			@RequestParam(value="id",required = false)Long id,
			@RequestParam(value="nommachine",required = false)String nommachine, 
			@RequestParam(value="nomuser",required = false) String nomuser, 
			@RequestParam(value="adresseip",required = false) String adresseip,
			@RequestParam(value="typeantivirus",required = false) String typeantivirus,
			@RequestParam(value="statusmachine",required = false) String statusmachine){
		Specification<Information> specification=Informationservice.getdata(id,nommachine, nomuser, adresseip,typeantivirus,statusmachine);
		
		return reposearch.findAll(specification);
	}
	

}
