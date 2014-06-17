package com.pracas.domain.controller;

import java.util.Set;

import com.pracas.domain.model.Categoria;

public interface ICtrlCategoria {

	public Categoria getCategoria(String nom);
	
	public Set<Categoria> getAll();
	
}
