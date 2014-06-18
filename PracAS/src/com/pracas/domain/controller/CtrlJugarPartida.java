package com.pracas.domain.controller;

import java.text.MessageFormat;
import java.util.Set;

import com.pracas.domain.model.Categoria;
import com.pracas.domain.model.Jugador;
import com.pracas.domain.model.Lletra;
import com.pracas.domain.model.Parametres;
import com.pracas.domain.model.Partida;
import com.pracas.exception.NoCategoriesException;
import com.pracas.exception.UserIsNotPlayerException;
import com.pracas.exception.UsernameNotExistsException;
import com.pracas.exception.WrongPasswordException;
import com.pracas.transaction.TxConsultarCategories;
import com.pracas.transaction.TxLogin;

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
		
		this.idPartida = Parametres.getInstance().getIdPartida();

		Partida partida = new Partida(this.idPartida, categoria, jugador);
		// TODO s'ha de guardar la partida aqui a domini o a BD, no? a BD, amb el Ctrl
		//return partida.getDadesInicials();
	}
	
	public void ferJugada(int pos, Lletra lletra) {
		ICtrlPartida icp = DataFactory.getInstance().getCtrlPartida();
		Partida partida = icp.getPartida(idPartida);
		partida.ferJugada(pos, lletra);
		
		// TODO create classes ResponseType for the UML tupletypes?
		boolean guanyada = false;
		if (guanyada) {
			String message = MessageFormat.format("{0}", "Has guanyat!");
			AdapterFactory.getInstance().getMailService().sendMail(message); // TODO expand and use interface?
		}
	}
	
	
	
}
