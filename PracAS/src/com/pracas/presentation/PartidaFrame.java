package com.pracas.presentation;

import javax.swing.GroupLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author arkey
 */
public class PartidaFrame extends javax.swing.JFrame {
	
	static final int MAX_CASELLES = 9;
	
	static final double relacio = 1.618034;
	int alturaFinestra = 560;
	int ampladaFinestra = (int) (alturaFinestra * relacio);
	
	static final int margeVertical = 29;
	static final int margeHoritzontal = 29;
	
	static final int longitudText = 92;
	static final double prcEspaiEntreCaselles = 0.5;
    static final int longButtons = 155;
    static final int espaiEntreButtons = 38;
	
	int numCaselles = 0;
	int posicioSeleccionada = -1;
    private CtrlPresentation cp;

	
    /**
     * Creates new form PartidaFrame
     */
    public PartidaFrame(CtrlPresentation cp) {
		this.setMinimumSize(new Dimension(ampladaFinestra, alturaFinestra));
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Partida");
		this.cp = cp;
		initComponents();
    }
    
    public void setNumCaselles(int numCaselles) {
    	for (int i = 0; i < caselles.length; ++i) {
    		if (i < numCaselles) caselles[i].setVisible(true);
    		else caselles[i].setVisible(false);
    	}
    	this.numCaselles = numCaselles;
    	configPanellCaselles();
    }
    

    private void initComponents() {
        
    	//Inicialitzacio dels components
        labelPunts = new JLabel();
        labelErrors = new JLabel();
        textPunts = new JTextField();
        textErrors = new JTextField();
        okButton = new JButton();
        stopButton = new JButton();
        panellPrincipal = new JPanel();
        panellInfo = new JPanel();
        panellCaselles = new JPanel();
        panellBotons = new JPanel();
        
        caselles = new JTextField[MAX_CASELLES];
        for (int i = 0; i < caselles.length; ++i) {
        	caselles[i] = new JTextField();
        	caselles[i].setMinimumSize(new Dimension(56, 56));
        	caselles[i].setHorizontalAlignment((int) JTextField.CENTER_ALIGNMENT);
        	caselles[i].setName(String.valueOf(i));
        }
        
        
        //Configuració dels valors inicials
        labelPunts.setText("Puntuacio: ");
        labelErrors.setText("Errors: ");
        textPunts.setText("0");
        textErrors.setText("0");
        okButton.setText("Ok");
        stopButton.setText("Aturar");
        
        textPunts.setEditable(false);
        textErrors.setEditable(false);

        
        //Listener del button OK
    	okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	okButtonActionPerformed(evt);
            }
        });
    	
    	//Listener del button STOP
    	stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	stopButtonActionPerformed(evt);
            }
        });

        //Listener que modifica la mida de les caselles
        //quan es fa un resize de la finestra
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                alturaFinestra = e.getComponent().getSize().height;
                ampladaFinestra = e.getComponent().getSize().width;
                configPanellCaselles();
            }
        });
        
        
        //Un lisener per cada casella
        caselles[0].getDocument().addDocumentListener(new DocumentListener() {
        	final int me = 0;
			public void removeUpdate(DocumentEvent e) {doOnRemove(me);}
			public void insertUpdate(DocumentEvent e) {doOnInsert(me);}
			public void changedUpdate(DocumentEvent arg0) {}
        });
        caselles[1].getDocument().addDocumentListener(new DocumentListener() {
        	final int me = 1;
			public void removeUpdate(DocumentEvent e) {doOnRemove(me);}
			public void insertUpdate(DocumentEvent e) {doOnInsert(me);}
			public void changedUpdate(DocumentEvent arg0) {}
        });
        caselles[2].getDocument().addDocumentListener(new DocumentListener() {
        	final int me = 2;
			public void removeUpdate(DocumentEvent e) {doOnRemove(me);}
			public void insertUpdate(DocumentEvent e) {doOnInsert(me);}
			public void changedUpdate(DocumentEvent arg0) {}
        });
        caselles[3].getDocument().addDocumentListener(new DocumentListener() {
        	final int me = 3;
			public void removeUpdate(DocumentEvent e) {doOnRemove(me);}
			public void insertUpdate(DocumentEvent e) {doOnInsert(me);}
			public void changedUpdate(DocumentEvent arg0) {}
        });
        caselles[4].getDocument().addDocumentListener(new DocumentListener() {
        	final int me = 4;
			public void removeUpdate(DocumentEvent e) {doOnRemove(me);}
			public void insertUpdate(DocumentEvent e) {doOnInsert(me);}
			public void changedUpdate(DocumentEvent arg0) {}
        });
        caselles[5].getDocument().addDocumentListener(new DocumentListener() {
        	final int me = 5;
			public void removeUpdate(DocumentEvent e) {doOnRemove(me);}
			public void insertUpdate(DocumentEvent e) {doOnInsert(me);}
			public void changedUpdate(DocumentEvent arg0) {}
        });
        caselles[6].getDocument().addDocumentListener(new DocumentListener() {
        	final int me = 6;
			public void removeUpdate(DocumentEvent e) {doOnRemove(me);}
			public void insertUpdate(DocumentEvent e) {doOnInsert(me);}
			public void changedUpdate(DocumentEvent arg0) {}
        });
        caselles[7].getDocument().addDocumentListener(new DocumentListener() {
        	final int me = 7;
			public void removeUpdate(DocumentEvent e) {doOnRemove(me);}
			public void insertUpdate(DocumentEvent e) {doOnInsert(me);}
			public void changedUpdate(DocumentEvent arg0) {}
        });
        caselles[8].getDocument().addDocumentListener(new DocumentListener() {
        	final int me = 8;
			public void removeUpdate(DocumentEvent e) {doOnRemove(me);}
			public void insertUpdate(DocumentEvent e) {doOnInsert(me);}
			public void changedUpdate(DocumentEvent arg0) {}
        });
        
        
        //Configuracio de la distribucio dels components de la vista
        configPanellPrincipal();
        configPanellInfo();
        configPanellCaselles();
        configPanellBotons();
        this.setContentPane(panellPrincipal);

    }
    
    // Operacio que s'executa quan es prem el button OK
	protected void okButtonActionPerformed(ActionEvent evt) {
		String lletra = caselles[posicioSeleccionada].getText();
		int posicio = posicioSeleccionada;
		caselles[posicio].setText("");
		cp.OKPressedPartida(posicio, lletra);
		System.out.println(posicio + lletra);
	}
    
    // Operacio que s'executa quan es prem el button Aturar
    protected void stopButtonActionPerformed(ActionEvent evt) {
    	cp.CancelPressedPartida();
	}
    
    public void afegirLletra(int pos, String lletra) {
    	caselles[pos].setText(lletra);
    	caselles[pos].setEditable(false);
		for (int i = 0; i < caselles.length; ++i) {
			String text = caselles[i].getText();
			if (text.equals("")) caselles[i].setEditable(true);
		}
    }
    
    // Operacio que s'executa que s'esborra algun caracter
    // en alguna de les caselles
	private void doOnRemove(int pos) {
		if (caselles[pos].getText().length() == 0)
			posicioSeleccionada = -1;
			for (int i = 0; i < caselles.length; ++i) {
				String text = caselles[i].getText();
				if (text.equals("")) caselles[i].setEditable(true);
			}
	}
	
    // Operacio que s'executa que s'escriu text
    // en alguna de les caselles
	private void doOnInsert(int pos) {
		posicioSeleccionada = pos;
		if (caselles[pos].getText().length() == 1)
			for (int i = 0; i < caselles.length; ++i) {
				if (i != pos) caselles[i].setEditable(false);
			}
	}

	//Panell principal: conte a dins seu tots els altres panells
	private void configPanellPrincipal() {
				
    	GroupLayout PanellPrincipalLayout = new GroupLayout(panellPrincipal);
    	panellPrincipal.setLayout(PanellPrincipalLayout);
        
        PanellPrincipalLayout.setHorizontalGroup(
        PanellPrincipalLayout.createSequentialGroup()
        	.addGap(margeHoritzontal)
        	.addGroup(PanellPrincipalLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
        		.addComponent(panellInfo)
	        	.addComponent(panellCaselles)
	        	.addComponent(panellBotons))
	        .addGap(margeHoritzontal)
        );
                
        PanellPrincipalLayout.setVerticalGroup(
        PanellPrincipalLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(PanellPrincipalLayout.createSequentialGroup()
	        	.addGap(margeVertical)
	        	.addComponent(panellInfo)
	        	.addGap(29)
	        	.addComponent(panellCaselles)
	        	.addGap(29)
	        	.addComponent(panellBotons)
	        	.addGap(margeVertical))
        );
    }

	
	//Panell info: on es mostra la puntuacio i el nombre d'errors
    private void configPanellInfo() {
        GroupLayout PanellInfoLayout = new GroupLayout(panellInfo);
        panellInfo.setLayout(PanellInfoLayout);
        
        PanellInfoLayout.setHorizontalGroup(
        PanellInfoLayout.createSequentialGroup()
	        .addGap(29)
	        .addGroup(PanellInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        	.addComponent(labelPunts)
	        	.addComponent(labelErrors))
	        .addGap(11)
	        .addGroup(PanellInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        	.addComponent(textPunts, longitudText, longitudText, longitudText)
	        	.addComponent(textErrors, longitudText, longitudText, longitudText))
	        .addGap(29)
        );    
            
            
        PanellInfoLayout.setVerticalGroup(
        PanellInfoLayout.createSequentialGroup()
        .addGap(29)
        .addGroup(PanellInfoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
        	.addGroup(PanellInfoLayout.createSequentialGroup()
        		.addComponent(labelPunts)
        		.addGap(21)
        		.addComponent(labelErrors))
        	.addGroup(PanellInfoLayout.createSequentialGroup()
            	.addComponent(textPunts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            	.addGap(16)
                .addComponent(textErrors, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	    .addGap(29)
        );    
    }

    
    
    //Panell Caselles: on es mostren les caselles (TextFields)
    //que l'usuari haurà d'omplir
    private void configPanellCaselles() {
    	
    	double numerador = ampladaFinestra - 2*margeHoritzontal;
    	double denominador = numCaselles + (numCaselles + 1)*prcEspaiEntreCaselles;
        int longCasella = (int) (numerador/denominador);
        if (longCasella > 160) longCasella = 160;
        
        double longReal = numCaselles * longCasella + (numCaselles + 1) * longCasella * prcEspaiEntreCaselles;
        int add = (int) ((numerador - longReal) / 2);
        
        int espai = (int) (longCasella * prcEspaiEntreCaselles);
    	
        panellCaselles.setMinimumSize(new Dimension(ampladaFinestra - 2*margeHoritzontal - 1, longCasella + espai));
        
        GroupLayout PanellCasellesLayout = new GroupLayout(panellCaselles);
        panellCaselles.setLayout(PanellCasellesLayout);
        
        PanellCasellesLayout.setHorizontalGroup(
        PanellCasellesLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
        .addGroup(PanellCasellesLayout.createSequentialGroup()
        	.addGap(espai + add)
        	.addComponent(caselles[0], longCasella, longCasella, longCasella)
        	.addGap(espai)
        	.addComponent(caselles[1], longCasella, longCasella, longCasella)
        	.addGap(espai)
        	.addComponent(caselles[2], longCasella, longCasella, longCasella)
        	.addGap(espai)
        	.addComponent(caselles[3], longCasella, longCasella, longCasella)
        	.addGap(espai)
        	.addComponent(caselles[4], longCasella, longCasella, longCasella)
        	.addGap(espai)
        	.addComponent(caselles[5], longCasella, longCasella, longCasella)
        	.addGap(espai)
        	.addComponent(caselles[6], longCasella, longCasella, longCasella)
        	.addGap(espai)
        	.addComponent(caselles[7], longCasella, longCasella, longCasella)
        	.addGap(espai)
        	.addComponent(caselles[8], longCasella, longCasella, longCasella)
        	.addGap(espai)
        	//.addContainerGap(1000, 2000)
        	)
        );
        
        PanellCasellesLayout.setVerticalGroup(
        PanellCasellesLayout.createSequentialGroup()
        	.addGap(29)
        	.addGroup(PanellCasellesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        		.addComponent(caselles[0], longCasella, longCasella, longCasella)
        		.addComponent(caselles[1], longCasella, longCasella, longCasella)
        		.addComponent(caselles[2], longCasella, longCasella, longCasella)
        		.addComponent(caselles[3], longCasella, longCasella, longCasella)
        		.addComponent(caselles[4], longCasella, longCasella, longCasella)
        		.addComponent(caselles[5], longCasella, longCasella, longCasella)
        		.addComponent(caselles[6], longCasella, longCasella, longCasella)
        		.addComponent(caselles[7], longCasella, longCasella, longCasella)
        		.addComponent(caselles[8], longCasella, longCasella, longCasella))
        	.addGap(29)       
        ); 
        
            
    }
    
    private void configPanellBotons() {
    	
        GroupLayout PanellBotonsLayout = new GroupLayout(panellBotons);
        panellBotons.setLayout(PanellBotonsLayout);
        
        PanellBotonsLayout.setHorizontalGroup(
        PanellBotonsLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
        	.addGroup(PanellBotonsLayout.createSequentialGroup()
        		.addComponent(okButton, longButtons, longButtons, longButtons)
        		.addGap(espaiEntreButtons)
        		.addComponent(stopButton, longButtons, longButtons, longButtons))        
        );
        
        
        PanellBotonsLayout.setVerticalGroup(
        PanellBotonsLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
        	.addComponent(okButton)
        	.addComponent(stopButton)
        );
    }
	
    // Declaracio de variables
    private JLabel labelPunts;
    private JLabel labelErrors;
    
    private JTextField textPunts;
    private JTextField textErrors;
    
    private JButton okButton;
    private JButton stopButton;
    
    private JPanel panellPrincipal;
    private JPanel panellInfo;
    private JPanel panellCaselles;
    private JPanel panellBotons;
    
    private JTextField[] caselles;
    // End of variables declaration
}
