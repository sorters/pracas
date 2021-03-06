
package com.pracas.main;

import com.pracas.domain.controller.AdapterFactory;
import com.pracas.domain.controller.DataCreatorStub;
import com.pracas.domain.model.Parametres;
import com.pracas.presentation.CtrlPresentation;

public class MainFrame {
	
    private static CtrlPresentation cp;
    
    public static void main(String[] args) {

        cp = new CtrlPresentation();
        
        /* HARDCODE DATA INITIALIZER */
        AdapterFactory.getEstrategiaPenalitzacio().setPuntuacioEncert(100);
        AdapterFactory.getEstrategiaPenalitzacio().setPuntuacioError(10);
        
        AdapterFactory.getEstrategiaNoPenalitzacio().setPuntuacioEncert(100);
        AdapterFactory.getEstrategiaNoPenalitzacio().setPuntuacioError(0);
        
        Parametres.setNombreMaximErrors(2);
        /* ------------------------ */
        
        DataCreatorStub dcs = new DataCreatorStub();
        dcs.execute();
        
        cp.showLogin();
    }
}
