package com.pracas.domain.controller;

import java.util.Set;

import com.pracas.domain.model.Administrador;

/*
 * Interfície del controlador d'Administrador
 */
public interface ICtrlAdministrador {

	public Administrador getAdministrador(String username);
	
	public Set<Administrador> getAll();
	
}
