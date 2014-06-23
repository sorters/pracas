package com.pracas.domain.controller;

import com.pracas.domain.model.Jugador;

/*
 * Interfície del controlador de Jugador
 */
public interface ICtrlJugador {

	public boolean exists(String nom);
	
	public Jugador getJugador(String username);

	int saveOrUpdateJugador(Jugador _jugador);
	
}
