package com.pracas.domain.controller;

import java.util.List;
import com.pracas.domain.model.Partida;

public interface ICtrlPartida {

	public Partida getPartida(int idPartida);
	
	public int saveOrUpdatePartida(Partida partida);
	
	public List<Partida> getAll();
	
	public int getLastId();
	
}
