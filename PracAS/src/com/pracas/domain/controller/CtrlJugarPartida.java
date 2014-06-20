package com.pracas.domain.controller;

import java.text.MessageFormat;
import java.util.List;

import com.pracas.domain.model.Categoria;
import com.pracas.domain.model.Jugador;
import com.pracas.domain.model.Parametres;
import com.pracas.domain.model.Partida;
import com.pracas.exception.InvalidLetterException;
import com.pracas.exception.NoCategoriesException;
import com.pracas.exception.UserIsNotPlayerException;
import com.pracas.exception.UsernameNotExistsException;
import com.pracas.exception.WrongPasswordException;
import com.pracas.service.IMailServiceAdapter;
import com.pracas.transaction.TxConsultarCategories;
import com.pracas.transaction.TxLogin;

public class CtrlJugarPartida {

	private String userN;
	private int idPartida;
	
	public void authenticate(String userN, String passwd) throws UsernameNotExistsException, WrongPasswordException, UserIsNotPlayerException {
		TxLogin txLogin = new TxLogin(userN, passwd);
		txLogin.executar();
		ICtrlJugador icj = DataFactory.getCtrlJugador();
		boolean b = icj.exists(userN);
		if (!b)
			throw new UserIsNotPlayerException(MessageFormat.format("User {0} is not a player", userN));
		this.userN = userN;
	}
	
	public List<String> obtenirCategories() throws NoCategoriesException {
		TxConsultarCategories txConsultarCategories = new TxConsultarCategories();
		txConsultarCategories.executar();
		return txConsultarCategories.getResultat();
	}
	
	public void crearPartida(String category) {
		ICtrlCategoria icc = DataFactory.getCtrlCategoria();
		ICtrlJugador icj = DataFactory.getCtrlJugador();
		ICtrlPartida icp = DataFactory.getCtrlPartida();
		
		Categoria categoria = icc.getCategoria(category);
		Jugador jugador = icj.getJugador(this.userN);
		
		this.idPartida = Parametres.getIdPartida();

		Partida partida = new Partida(this.idPartida, categoria, jugador);
		icp.saveOrUpdatePartida(partida);
		
		//return partida.getDadesInicials();
	}
	
	public void ferJugada(int pos, char ch) throws InvalidLetterException {
		ICtrlPartida icp = DataFactory.getCtrlPartida();
		Partida partida = icp.getPartida(idPartida);
		partida.ferJugada(pos, ch);
		
		// TODO create classes ResponseType for the UML tupletypes?
		boolean guanyada = false;
		if (guanyada) {
			String message = MessageFormat.format("{0}", "Has guanyat!");
			IMailServiceAdapter imsa = AdapterFactory.getMailService();
			imsa.sendMail(message);
		}
	}
	
	
	
}
