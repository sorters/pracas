/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pracas.main;

import com.pracas.domain.controller.AdapterFactory;
import com.pracas.domain.model.Parametres;
import com.pracas.presentation.CtrlPresentation;

/**
 *
 * @author arkey
 */
public class MainFrame {
	
    private static CtrlPresentation cp;
    
    public static void main(String[] args) {

        cp = new CtrlPresentation();
        
        /* HARDCODE DATA INITIALIZER */ // TODO (words, categories)
        AdapterFactory.getEstrategiaPenalitzacio().setPuntuacioEncert(100);
        AdapterFactory.getEstrategiaPenalitzacio().setPuntuacioError(10);
        
        AdapterFactory.getEstrategiaNoPenalitzacio().setPuntuacioEncert(100);
        AdapterFactory.getEstrategiaNoPenalitzacio().setPuntuacioError(0);
        
        Parametres.setNombreMaximErrors(10);
        /* ------------------------ */
        
        cp.showLogin();
    }
}
