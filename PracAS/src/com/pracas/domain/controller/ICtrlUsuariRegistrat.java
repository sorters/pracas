package com.pracas.domain.controller;

import java.util.Set;

import com.pracas.domain.model.UsuariRegistrat;

public interface ICtrlUsuariRegistrat {
	
	public UsuariRegistrat getUsuariRegistrat(String username);
	
	public Set<UsuariRegistrat> getAll();
	
}
