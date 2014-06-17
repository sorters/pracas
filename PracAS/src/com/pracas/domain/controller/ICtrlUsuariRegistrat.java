package com.pracas.domain.controller;

import java.util.Set;

import com.pracas.domain.model.UsuariRegistrat;
import com.pracas.exceptions.UsernameNotExistsException;

public interface ICtrlUsuariRegistrat {
	
	public UsuariRegistrat getUsuariRegistrat(String username) throws UsernameNotExistsException;
	
	public Set<UsuariRegistrat> getAll();
	
}
