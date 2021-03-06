package com.pracas.domain.controller;

import java.util.List;

import com.pracas.domain.model.Categoria;

/*
 * Interfície del controlador de Categoria
 */
public interface ICtrlCategoria {

	public Categoria getCategoria(String nom);
	
	public List<Categoria> getAll();
	
}
