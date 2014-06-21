package com.pracas.presentation;

import javax.swing.GroupLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pracas.domain.model.DadesInicialsResponseType;

/**
 *
 * @author arkey
 */
public class PartidaFrame extends javax.swing.JFrame {
		
	private static final double relacio = 1.618034;
	private int alturaFinestra = 560;
	private int ampladaFinestra = (int) (alturaFinestra * relacio);
	
	private static final int margeVertical = 29;
	private static final int margeHoritzontal = 29;
	
	private static final int longitudText = 92;
	private static final int midaMaxCasella = 160;
	private static final double prcEspaiEntreCaselles = 0.5;
    private static final int longButtons = 155;
    private static final int espaiEntreButtons = 38;
	
	private int posicioSeleccionada = -1;
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

    public void setPuntuacio(int p) {
    	textPunts.setText(String.valueOf(p));
    }
    
    public void setNumError(int e) {
    	textErrors.setText(String.valueOf(e));
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
        
        //Configuracio dels valors inicials
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
    	
    	//Listener del button Aturar
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
        
        //Quan creem la vista de partida encara no sabem caselles hi haura
        //de moment inicialitzem la vista amb 0 caselles
        setNumCaselles(0);
        
        //Configuracio de la distribucio dels components de la vista
        configPanellPrincipal();
        configPanellInfo();
        configPanellBotons();
        this.setContentPane(panellPrincipal);
    }
    
    //Posa a la vista tantes caselles com indica el parametre numCaselles.
    //Cada una d'aquestes caselles es un JTextField i es configuren degudament.
    public void setNumCaselles(int numCaselles) {
        caselles = new JTextField[numCaselles];
        for (int i = 0; i < caselles.length; ++i) {
        	caselles[i] = new JTextField();
        	caselles[i].setHorizontalAlignment((int) JTextField.CENTER_ALIGNMENT);
        	caselles[i].setName(String.valueOf(i));
        	caselles[i].addKeyListener(new KeyListener() {
    			public void keyReleased(KeyEvent e) {
    				int pos = Integer.parseInt(e.getComponent().getName());
    				String text = caselles[pos].getText();
    				if (text.length() >= 1) {
    					
    					if (text.length() > 1) {
    						String lletra = text.substring(0, 1);
    						caselles[pos].setText(lletra);
    					}
    					
    					posicioSeleccionada = pos;
    					deshabilitarCaselles();
    				}
    				else if (text.length() == 0) {
    					posicioSeleccionada = -1;
    					habilitarCaselles();
    				}
    			}
    			public void keyTyped(KeyEvent e) {}
    			public void keyPressed(KeyEvent e) {}
            }); 
        }
    	configPanellCaselles();
    }
    
    // Operacio que s'executa quan es prem el button OK
	protected void okButtonActionPerformed(ActionEvent evt) {
		char lletra = caselles[posicioSeleccionada].getText().charAt(0);
		int posicio = posicioSeleccionada;
		caselles[posicio].setText("");
		habilitarCaselles();
		cp.OKPressedPartida(posicio, lletra);
	}
    
    // Operacio que s'executa quan es prem el button Aturar
    protected void stopButtonActionPerformed(ActionEvent evt) {
    	cp.CancelPressedPartida();
	}
    
    // Operacio que fixa una lletra en una posicio.
    // Aquesta lletra ja no podra ser modificada
    public void afegirLletra(int pos, char lletra) {
    	String text = Character.toString(lletra);
    	caselles[pos].setText(text);
    	caselles[pos].setEditable(false);
    }
    
    //Deshabilita totes les caselles menys la que s'esta editant en aquell moment
    private void deshabilitarCaselles() {
		for (int i = 0; i < caselles.length; ++i) {
			if (caselles[i].isEditable() && caselles[i].getText().isEmpty()) {
				caselles[i].setEditable(false);
			}
		}
    }
    
    //Habilita totes les caselles que no tinguin ja una lletra correcte introduida
    private void habilitarCaselles() {
		for (int i = 0; i < caselles.length; ++i) {
			String text = caselles[i].getText();
			if (text.equals("")) caselles[i].setEditable(true);
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
	        .addGap(margeHoritzontal)
	        .addGroup(PanellInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        	.addComponent(labelPunts)
	        	.addComponent(labelErrors))
	        .addGap(11)
	        .addGroup(PanellInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        	.addComponent(textPunts, longitudText, longitudText, longitudText)
	        	.addComponent(textErrors, longitudText, longitudText, longitudText))
	        .addGap(margeHoritzontal)
        );    
            
            
        PanellInfoLayout.setVerticalGroup(
        PanellInfoLayout.createSequentialGroup()
        .addGap(margeVertical)
        .addGroup(PanellInfoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
        	.addGroup(PanellInfoLayout.createSequentialGroup()
        		.addComponent(labelPunts)
        		.addGap(21)
        		.addComponent(labelErrors))
        	.addGroup(PanellInfoLayout.createSequentialGroup()
            	.addComponent(textPunts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            	.addGap(16)
                .addComponent(textErrors, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	    .addGap(margeVertical)
        );    
    }

    
    
    //Panell Caselles: on es mostren les caselles (TextFields) que l'usuari haura d'omplir
    private void configPanellCaselles() {
    	
    	//Calculem la mida optima de les caselles
    	double numerador = ampladaFinestra - 2*margeHoritzontal;
    	double denominador = caselles.length + (caselles.length + 1)*prcEspaiEntreCaselles;
        int midaCasella = (int) (numerador/denominador);
        if (midaCasella > midaMaxCasella) midaCasella = midaMaxCasella;
        
        double longReal = caselles.length * midaCasella + (caselles.length + 1) * midaCasella * prcEspaiEntreCaselles;
        int extra = (int) ((numerador - longReal) / 2);
        
        int espai = (int) (midaCasella * prcEspaiEntreCaselles);
    	
        panellCaselles.setMinimumSize(new Dimension(ampladaFinestra - 2*margeHoritzontal, midaCasella + espai));
        //------        
        
        //Inicialitzem el layout del panell de caselles
        GroupLayout PanellCasellesLayout = new GroupLayout(panellCaselles);
        panellCaselles.setLayout(PanellCasellesLayout);
        
        //definim la part horitzontal del grup de caselles
        SequentialGroup grupCasellesH = PanellCasellesLayout.createSequentialGroup().addGap(espai + extra);
        for (int i = 0; i < caselles.length; ++i) {
        	grupCasellesH = grupCasellesH.addComponent(caselles[i], midaCasella, midaCasella, midaCasella);
        	grupCasellesH = grupCasellesH.addGap(espai);
        }
        
        //posem la part horitzontal del grup de caselles en el layout
        PanellCasellesLayout.setHorizontalGroup(
        PanellCasellesLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
        	.addGroup(grupCasellesH)
        );
        
        //definim la part vertical del grup de caselles
        ParallelGroup grupCasellesV = PanellCasellesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING);
        for (int i = 0; i < caselles.length; ++i) {
        	grupCasellesV = grupCasellesV.addComponent(caselles[i], midaCasella, midaCasella, midaCasella);
        }

        //posem la part vertical del grup de caselles en el layout
        PanellCasellesLayout.setVerticalGroup(
        PanellCasellesLayout.createSequentialGroup()
        	.addGap(margeVertical)
        	.addGroup(grupCasellesV)
        	.addGap(margeVertical)       
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
