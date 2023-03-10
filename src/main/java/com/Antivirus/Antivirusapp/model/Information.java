package com.Antivirus.Antivirusapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Entity
@Table(name = "information")
public class Information {
	
	@Column(name="nommachine")
	private String nommachine;
	
	@Column(name="nomuser")
	private String nomuser;
	
	@Column(name="adresseip")
	private String adresseip;
	
	@Column(name="typeantivirus")
	private String typeantivirus;
	
	@Column(name="statusmachine")
	private String statusmachine;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public Information() {
		super();
	}

	public Information(long id,String nommachine,String nommuser, String adresseip, String typeantivirus, String statusmachine) {
		super();
		this.id=id;
		this.nommachine = nommachine;
		this.nomuser = nommuser;
		this.adresseip = adresseip;
		this.typeantivirus = typeantivirus;
		this.statusmachine = statusmachine;
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNommachine() {
		return nommachine;
	}
	public void setNommachine(String nommachine) {
		this.nommachine = nommachine;
	}
	
	public String getNomuser() {
		return nomuser;
	}


	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}


	public String getAdresseip() {
		return adresseip;
	}
	public void setAdresseip(String adresseip) {
		this.adresseip = adresseip;
	}
	public String getTypeantivirus() {
		return typeantivirus;
	}
	public void setTypeantivirus(String typeantivirus) {
		this.typeantivirus = typeantivirus;
	}
	public String getStatusmachine() {
		return statusmachine;
	}
	public void setStatusmachine(String statusmachine) {
		this.statusmachine = statusmachine;
	}
	
	

}
