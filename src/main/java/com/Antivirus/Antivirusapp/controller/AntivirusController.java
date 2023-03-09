package com.Antivirus.Antivirusapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Antivirus.Antivirusapp.Antivirusservice.Informationservice;
import com.Antivirus.Antivirusapp.model.Information;

@CrossOrigin(origins = "*")
@RestController
public class AntivirusController {
	
	@Autowired
	private Informationservice information;
	
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
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}" )
	public void updateCar(@RequestBody Information car, @PathVariable long id) {
		information.updateCar(car,id);
	}
	

}
