package com.pracas.domain.controller;

import java.text.MessageFormat;
import java.util.Set;

import com.pracas.domain.model.Categoria;
import com.pracas.domain.model.Jugador;
import com.pracas.domain.model.Partida;
import com.pracas.exceptions.NoCategoriesException;
import com.pracas.exceptions.UserIsNotPlayerException;
import com.pracas.exceptions.UsernameNotExistsException;
import com.pracas.exceptions.WrongPasswordException;

import transaction.TxConsultarCategories;
import transaction.TxLogin;

public class CtrlJugarPartida {

	private String userN;
	private int idPartida;
	
	public void authenticate(String userN, String passwd) throws UsernameNotExistsException, WrongPasswordException, UserIsNotPlayerException {
		TxLogin txLogin = new TxLogin(userN, passwd);
		txLogin.executar();
		ICtrlJugador icj = DataFactory.getInstance().getCtrlJugador();
		boolean b = icj.exists(userN);
		if (!b)
			throw new UserIsNotPlayerException(MessageFormat.format("User {0} is not a player", userN));
		this.userN = userN;
	}
	
	public Set<String> obtenirCategories() throws NoCategoriesException {
		TxConsultarCategories txConsultarCategories = new TxConsultarCategories();
		return txConsultarCategories.executar();
	}
	
	public void crearPartida(String category) {
		ICtrlCategoria icc = DataFactory.getInstance().getCtrlCategoria();
		ICtrlJugador icj = DataFactory.getInstance().getCtrlJugador();
		
		Categoria categoria = icc.getCategoria(category);
		Jugador jugador = icj.getJugador(this.userN);
		
		int id = 0;
		// TODO getNextId parametres ...
		// TODO Partida partida = new Partida();
		
	}
	
	
	
}
