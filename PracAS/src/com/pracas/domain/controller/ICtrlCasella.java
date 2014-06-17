package com.pracas.domain.controller;

import java.util.Set;

import com.pracas.domain.model.Casella;

public interface ICtrlCasella {

	public Casella getCasella(int posicio, int idPartida);
	
	public Set<Casella> getAll();
	
}
