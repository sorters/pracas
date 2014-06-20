/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pracas.presentation;

import com.pracas.domain.controller.CtrlJugarPartida;
import com.pracas.exception.InvalidLetterException;
import com.pracas.exception.UserIsNotPlayerException;
import com.pracas.exception.UsernameNotExistsException;
import com.pracas.exception.WrongPasswordException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arkey
 */
public class CtrlPresentation {
    
    private static CtrlJugarPartida cjp;
    private MessageFrame messageFrame;
    private PartidaFrame partidaFrame;
    private LoginFrame loginFrame;
    
    public CtrlPresentation() {
        cjp = new CtrlJugarPartida();
        messageFrame = new MessageFrame();
        partidaFrame = new PartidaFrame(this);
        loginFrame = new LoginFrame(this);
    }
    
    public void showLogin() {
    	loginFrame.setVisible(true);
    }
    
    public void showMessage(String msg) {
    	messageFrame.setMessage(msg);
    	messageFrame.setVisible(true);
    }
    
    public void showPartida(int numCaselles) {
    	partidaFrame.setNumCaselles(numCaselles);
    	partidaFrame.setVisible(true);
    }
    
    public void OKPressedAuthenticate(String username, String password) {
        try {
        	//cjp.authenticate("rohert", "admin");
            cjp.authenticate(username, password);
        } catch (UsernameNotExistsException ex) {
            Logger.getLogger(CtrlPresentation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WrongPasswordException ex) {
            Logger.getLogger(CtrlPresentation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserIsNotPlayerException ex) {
            Logger.getLogger(CtrlPresentation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void OKPressedPartida(int pos, char lletra) {
    	/*try {
			ResponseType info = cjp.ferJugada(pos, lletra);
			if (info.acabada && !info.guanyada) {
				String msg = "Llastima! No has endevinat la paraula... Mes sort la propera vegada."; 
				showMessage(msg);
			}
			else if (info.acabada) {
				String msg = "Felicitats has endevinat la paraula. T'hem enviat un correu. :)"; 
				showMessage(msg);
			}
			else {
				partidaFrame.setPuntuacio(info.puntuacio);
				partidaFrame.setNumError(info.errors);
				if (info.encert) partidaFrame.afegirLletra(pos, lletra);	
			}
		} catch (InvalidLetterException e) {
			showMessage("La lletra introduida no es un caracter valid!");
		}*/
    }
    
    public void CancelPressedPartida() {
    	// TODO
    }
    
}
