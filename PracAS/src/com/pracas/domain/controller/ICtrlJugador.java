package com.pracas.domain.controller;

import com.pracas.domain.model.Jugador;

public interface ICtrlJugador {

	public boolean exists(String nom);
	
	public Jugador getJugador(String username);

	int saveOrUpdateJugador(Jugador _jugador);
	
}
