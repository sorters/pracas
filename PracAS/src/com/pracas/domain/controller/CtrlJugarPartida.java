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

/*
 * Controlador CtrlJugarPartida
 * Conté una Partida i els diferents events possibles a efectuar sobre una 
 * partida, des de l'autenticació fins a la finalització, forçada o normal.
 * 
 * Modificacions respecte el disseny inicial:
 * S'havia eliminat la Partida partida, que s'ha tornat a afegir per temes
 * d'eficiència principalment.
 */

public class CtrlJugarPartida {

	private String userN;
	private int idPartida;
	
	private Partida partida;
	
	/*
	 * Procés d'autenticació:
	 * Crea la transacció d'autenticació i l'executa.
	 */
	public void authenticate(String userN, String passwd) throws UsernameNotExistsException, WrongPasswordException, UserIsNotPlayerException {
		TxLogin txLogin = new TxLogin(userN, passwd);
		txLogin.executar();
		ICtrlJugador icj = DataFactory.getCtrlJugador();
		boolean b = icj.exists(userN);
		if (!b)
			throw new UserIsNotPlayerException(MessageFormat.format("User {0} is not a player", userN));
		this.userN = userN;
	}
	
	/*
	 * Obtenció de les categories disponibles:
	 * Crea la transacció d'obtenció de categories disponibles, l'executa
	 * i recull i retorna el resultat.
	 */
	public List<String> obtenirCategories() throws NoCategoriesException {
		TxConsultarCategories txConsultarCategories = new TxConsultarCategories();
		txConsultarCategories.executar();
		return txConsultarCategories.getResultat();
	}
	
	/*
	 * Creació d'una partida:
	 * Crea una partida i els seus paràmetres, la guarda a BD, i retorna 
	 * les dades inicialitzades de la nova partida.
	 * 
	 * Observacions:
	 * S'ha creat una classe ResponseType per a implementar la TupleType de
	 * l'especificació.
	 */
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
	
	/*
	 * Operació de jugada:
	 * Efectua una jugada sobre una partida.
	 * Retorna la informació del resultat de la jugada.
	 * 
	 * Observacions:
	 * S'ha creat una classe ResponseType per a implementar la TupleType
	 * de l'especificació.
	 */
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

	/*
	 * Operació d'aturar partida:
	 * Guarda la partida en l'estat actual a BD.
	 */
	public void aturarPartida() {
		ICtrlPartida icp = DataFactory.getCtrlPartida();
		icp.saveOrUpdatePartida(partida);
	}
	
	
	
}
