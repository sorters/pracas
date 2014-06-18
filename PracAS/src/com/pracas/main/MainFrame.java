/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pracas.main;

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
        
        loginFrame = new LoginFrame(cp);
        loginFrame.setVisible(true);
    }
}
