/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pracas.main;

import com.pracas.domain.controller.AdapterFactory;
import com.pracas.presentation.CtrlPresentation;
import com.pracas.presentation.LoginFrame;

/**
 *
 * @author arkey
 */
public class MainFrame {
    
    private static LoginFrame loginFrame;
    
    private static CtrlPresentation cp;
    
    public static void main(String[] args) {
        // TODO code application logic here
        cp = new CtrlPresentation();
        
        AdapterFactory.getEstrategiaPenalitzacio().setPuntuacioEncert(100);
        AdapterFactory.getEstrategiaPenalitzacio().setPuntuacioError(10);
        
        AdapterFactory.getEstrategiaNoPenalitzacio().setPuntuacioEncert(100);
        
        loginFrame = new LoginFrame(cp);
        loginFrame.setVisible(true);
    }
}
