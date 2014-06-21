package com.pracas.domain.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="USUARIREGISTRAT")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class UsuariRegistrat {
	
	@Id
	private String nom;
	@Basic
	private String cognom;
	@Basic
	private String username;
	@Basic
	private String pwd;
	
	public UsuariRegistrat(){}
	
	public UsuariRegistrat(String _nom, String _cognom, String _username, String _pwd) {
		nom = _nom;
		cognom = _cognom;
		username = _username;
		pwd = _pwd;
	}
	
	public boolean checkPassword(String password) {
		return pwd.equals(password);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCognom() {
		return cognom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
