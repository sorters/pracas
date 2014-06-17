package com.pracas.domain.controller;

import java.util.Set;

import com.pracas.domain.model.Jugador;

public interface ICtrlJugador {

	public boolean exists(String nom);
	
	public Jugador getJugador(String username);
	
	public Set<Jugador> getAll();
	
}
