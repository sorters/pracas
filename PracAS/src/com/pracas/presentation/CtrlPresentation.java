/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pracas.presentation;

import java.text.MessageFormat;
import java.util.List;

import javax.swing.JFrame;

import com.pracas.domain.controller.CtrlJugarPartida;
import com.pracas.domain.model.DadesInicialsResponseType;
import com.pracas.domain.model.JugadaResponseType;
import com.pracas.exception.CategoryHasNoWordsException;
import com.pracas.exception.InvalidLetterException;
import com.pracas.exception.NoCategoriesException;
import com.pracas.exception.UserIsNotPlayerException;
import com.pracas.exception.UsernameNotExistsException;
import com.pracas.exception.WrongPasswordException;

/*
 * Controlador de Presentació:
 * Connecta la capa de presentació amb la de negoci.
 * Aquest controlador es passa a cada vista per permetre que la vista invoqui 
 * de manera directa via el controlador els events de domini. 
 */
public class CtrlPresentation {
    
    private static CtrlJugarPartida cjp;

    // Vista d'autenticació
    private LoginFrame loginFrame;
    // Vista de Selecció d'opció
    private SeleccionarFrame seleccionarFrame;
    // Vista de Creació de partida (a partir de Categoria de paraules seleccionada)
    private CrearPartidaFrame crearPartidaFrame;
    // Vista de la Partida
    private PartidaFrame partidaFrame;
    // Diàleg de missatges
    private MessageFrame messageFrame;
    
    public CtrlPresentation() {
        cjp = new CtrlJugarPartida();

        loginFrame = new LoginFrame(this);
        seleccionarFrame = new SeleccionarFrame(this);
        crearPartidaFrame = new CrearPartidaFrame(this);
        partidaFrame = new PartidaFrame(this);
        
        messageFrame = new MessageFrame();
    }
    
    /* Invocadores de les vistes */
    public void showLogin() {
    	loginFrame.setVisible(true);
    }
    public void showSeleccionar() {
    	seleccionarFrame.setVisible(true);
    }
    public void showCrearPartida() {
    	crearPartidaFrame.setVisible(true);
    }
    public void showPartida(int numCaselles) {
    	partidaFrame.setNumCaselles(numCaselles);
    	partidaFrame.setVisible(true);
    }
    public void showMessage(String msg, boolean endOnClose, JFrame parent) {
    	messageFrame.configMessage(msg, endOnClose, parent);
    	messageFrame.setVisible(true);
    }
    
    /*
     * Event de Acceptar autenticació.
     */
    public void OKPressedAuthenticate(String username, String password) {
        try {
            cjp.authenticate(username, password);
            loginFrame.dispose();
            showSeleccionar();
            //showPartida(cjp.);
        } catch (UsernameNotExistsException ex) {
			String msg = MessageFormat.format("Error d''autenticació: El nom d''usuari {0} no existeix.", username); 
			showMessage(msg, false, null);
        } catch (WrongPasswordException ex) {
			String msg = "Error d'autenticació: La contrassenya és incorrecta."; 
			showMessage(msg, false, null);
        } catch (UserIsNotPlayerException ex) {
			String msg = MessageFormat.format("Error d''autenticació: L''usuari {0} no és un jugador.", username); 
			showMessage(msg, false, null);
        }
    }
    
    /*
     * Event d'intent de jugada.
     */
    public void OKPressedPartida(int pos, char lletra) {
    	try {
			JugadaResponseType info = cjp.ferJugada(pos, lletra);
			partidaFrame.setPuntuacio(info.getPuntuacio());
			partidaFrame.setNumError(info.getErrors());
			if (info.isAcabada() && !info.isGuanyada()) {
				String msg = "Llastima! No has endevinat la paraula... Mes sort la propera vegada."; 
				showMessage(msg, true, partidaFrame);
			}
			else if (info.isAcabada()) {
				if (info.isEncert()) partidaFrame.afegirLletra(pos, lletra);
				String msg = "Felicitats, has endevinat la paraula. T'hem enviat un correu. :)"; 
				showMessage(msg, true, partidaFrame);
			}
			else {
				if (info.isEncert()) {
					partidaFrame.afegirLletra(pos, lletra);
				} else {
					String msg = "La lletra és incorrecta."; 
					showMessage(msg, false, null);
				}
			}
		} catch (InvalidLetterException e) {
			showMessage("La lletra introduida no es un caracter valid!", false, null);
		}
    }
    
    /*
     * Event d'acceptació d'opcions (Només s'ofereix Jugar partida)
     */
    public void OKPressedSeleccionar() {
    	try {
			List<String> categories = cjp.obtenirCategories();
			crearPartidaFrame.actualitzarCategories(categories);
			seleccionarFrame.dispose();
            showCrearPartida();
		} catch (NoCategoriesException e) {
			String msg = "No s'han trobat categories disponibles."; 
			showMessage(msg, true, seleccionarFrame);
		}
    }
    
    /*
     * Event d'acceptació de selecció de Categoria de paraules
     * i posterior creació de la Partida.
     */
    public void OKPressedCrearPartida(String _category) {
    	try {
			DadesInicialsResponseType dirt = cjp.crearPartida(_category);
			crearPartidaFrame.dispose();
			showPartida(dirt.getNombreCaselles());
		} catch (CategoryHasNoWordsException e) {
			String msg = "No s'han trobat paraules en aquesta categoria."; 
			showMessage(msg, false, null);
		}
    }
    
    /*
     * Event d'aturada de Partida desde la Partida en curs.
     */
    public void AturarPressedPartida(JFrame frame) {
    	cjp.aturarPartida();
    	String msg = "La partida ha estat guardada."; 
		showMessage(msg, true, partidaFrame);
    }
    
    /*
     * Event de cancelació en qualsevol estadi del cas d'ús (Excepte en
     * una Partida en curs).
     */
    public void CancelPressedPartida(JFrame frame) {
    	frame.dispose();
    	System.exit(0);
    }
    
}
