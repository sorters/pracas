package com.pracas.domain.controller;

import java.text.MessageFormat;
import java.util.List;

import com.pracas.domain.model.Categoria;
import com.pracas.domain.model.DadesInicialsResponseType;
import com.pracas.domain.model.JugadaResponseType;
import com.pracas.domain.model.Jugador;
import com.pracas.domain.model.Parametres;
import com.pracas.domain.model.Partida;
import com.pracas.exception.CategoryHasNoWordsException;
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
	
	private Partida partida;
	
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
	
	public DadesInicialsResponseType crearPartida(String category) throws CategoryHasNoWordsException {
		ICtrlCategoria icc = DataFactory.getCtrlCategoria();
		ICtrlJugador icj = DataFactory.getCtrlJugador();
		ICtrlPartida icp = DataFactory.getCtrlPartida();
		
		Categoria categoria = icc.getCategoria(category);
		Jugador jugador = icj.getJugador(this.userN);
		
		this.idPartida = Parametres.getIdPartida();

		partida = new Partida(this.idPartida, categoria, jugador);
		icp.saveOrUpdatePartida(partida);
		
		return partida.getDadesInicials();
	}
	
	public JugadaResponseType ferJugada(int pos, char ch) throws InvalidLetterException {
		
		JugadaResponseType response = partida.ferJugada(pos, ch);
		
		if (response.isGuanyada()) {
			int errors = response.getErrors();
			String msgErrors = "no has comès cap equivocació";
			if (errors == 1) {
				msgErrors = "només has comès una equivocació";
			} else if (errors > 1) {
				msgErrors = MessageFormat.format("has comès {0} equivocacions", errors);
			}
			String message = MessageFormat.format("Felicitats {3}, has guanyat! Has endevinat la paraula {0}, {1} i la teva puntuació és {2}! :D",
													partida.getNomParaula(),
													msgErrors,
													response.getPuntuacio(),
													partida.getJugador().getNom());
			IMailServiceAdapter imsa = AdapterFactory.getMailService();
			imsa.sendMail(message, partida.getJugador().getEmail() );
		}
		return response;
	}

	public void aturarPartida() {
		ICtrlPartida icp = DataFactory.getCtrlPartida();
		icp.saveOrUpdatePartida(partida);
	}
	
	
	
}
