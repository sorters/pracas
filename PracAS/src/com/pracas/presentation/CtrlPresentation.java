/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pracas.presentation;

import java.awt.Frame;
import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import com.pracas.persistence.PersistenceSessionFactory;

/**
 *
 * @author arkey
 */
public class CtrlPresentation {
    
    private static CtrlJugarPartida cjp;

    private LoginFrame loginFrame;
    private SeleccionarFrame seleccionarFrame;
    private CrearPartidaFrame crearPartidaFrame;
    private PartidaFrame partidaFrame;
    
    private MessageFrame messageFrame;
    
    public CtrlPresentation() {
        cjp = new CtrlJugarPartida();

        loginFrame = new LoginFrame(this);
        seleccionarFrame = new SeleccionarFrame(this);
        crearPartidaFrame = new CrearPartidaFrame(this);
        partidaFrame = new PartidaFrame(this);
        
        messageFrame = new MessageFrame();
    }
    
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
    
    public void showMessage(String msg) {
    	messageFrame.setMessage(msg);
    	messageFrame.setVisible(true);
    }
    
    public void OKPressedAuthenticate(String username, String password) {
        try {
            cjp.authenticate(username, password);
            loginFrame.dispose();
            showSeleccionar();
            //showPartida(cjp.);
        } catch (UsernameNotExistsException ex) {
			String msg = MessageFormat.format("Error d'autenticació: El nom d'usuari {0} no existeix.", username); 
			showMessage(msg);
        } catch (WrongPasswordException ex) {
			String msg = "Error d'autenticació: La contrassenya és incorrecta."; 
			showMessage(msg);
        } catch (UserIsNotPlayerException ex) {
			String msg = MessageFormat.format("Error d'autenticació: L'usuari {0} no és un jugador.", username); 
			showMessage(msg);
        }
    }
    
    public void OKPressedPartida(int pos, char lletra) {
    	try {
			JugadaResponseType info = cjp.ferJugada(pos, lletra);
			partidaFrame.setPuntuacio(info.getPuntuacio());
			partidaFrame.setNumError(info.getErrors());
			if (info.isAcabada() && !info.isGuanyada()) {
				String msg = "Llastima! No has endevinat la paraula... Mes sort la propera vegada."; 
				showMessage(msg);
			}
			else if (info.isAcabada()) {
				if (info.isEncert()) partidaFrame.afegirLletra(pos, lletra);
				String msg = "Felicitats has endevinat la paraula. T'hem enviat un correu. :)"; 
				showMessage(msg);
			}
			else {
				if (info.isEncert()) {
					partidaFrame.afegirLletra(pos, lletra);
				} else {
					String msg = "La lletra és incorrecta."; 
					showMessage(msg);
				}
			}
		} catch (InvalidLetterException e) {
			showMessage("La lletra introduida no es un caracter valid!");
		}
    }
    
    public void OKPressedSeleccionar() {
    	try {
			List<String> categories = cjp.obtenirCategories();
			crearPartidaFrame.actualitzarCategories(categories);
			seleccionarFrame.dispose();
            showCrearPartida();
		} catch (NoCategoriesException e) {
			String msg = "No s'han trobat categories disponibles."; 
			showMessage(msg);
		}
    }
    
    public void OKPressedCrearPartida(String _category) {
    	try {
			DadesInicialsResponseType dirt = cjp.crearPartida(_category);
			crearPartidaFrame.dispose();
			showPartida(dirt.getNombreCaselles());
		} catch (CategoryHasNoWordsException e) {
			String msg = "No s'han trobat paraules en aquesta categoria."; 
			showMessage(msg);
		}
    }
    
    public void CancelPressedPartida(JFrame frame) {
    	frame.dispose();
    	System.exit(0);
    }
    
}
