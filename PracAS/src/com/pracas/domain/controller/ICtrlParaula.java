package com.pracas.domain.controller;

import java.util.Set;

import com.pracas.domain.model.Paraula;

/*
 * Interfície del controlador de Paraula
 */
public interface ICtrlParaula {

	public Paraula getParaula(String nom);
	
	public Set<Paraula> getAll();
	
}
