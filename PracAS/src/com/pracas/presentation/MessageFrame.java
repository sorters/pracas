package com.pracas.presentation;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author arkey
 */
public class MessageFrame extends JFrame {
	
	private static final double relacio = 1.618034;
	private int alturaFinestra = 222;
	private int ampladaFinestra = (int) (alturaFinestra * relacio);
	
	private static final int margeVertical = 29;
	private static final int margeHoritzontal = 29;
	
	private static final int margeHorText = 10;
	private static final int margeVertText = 10;
    private static final int longButtons = 155;


    /**
     * Creates new form MessageFrame
     */
    public MessageFrame() {
		this.setMinimumSize(new Dimension(ampladaFinestra, alturaFinestra));
		this.setTitle("Missatge");
        this.setResizable(false);        
        initComponents();
    }
    
    public void setMessage(String msg) {
    	textMsg.setText(msg);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

    	okButton = new JButton();
        textMsg = new JTextArea();
        
        textMsg.setMargin(new Insets(margeVertText, margeHorText, margeVertText, margeHorText));
        textMsg.setEditable(false);
        textMsg.setLineWrap(true);
        textMsg.setWrapStyleWord(true);
        int ampladaText = ampladaFinestra - 2*margeHoritzontal;     
        textMsg.setMaximumSize(new Dimension(ampladaText, 100));       

        okButton.setText("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        
        configContentPane();

    }
    
    private void configContentPane() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
        layout.createSequentialGroup()
        	.addGap(margeHoritzontal)
        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	            .addComponent(textMsg)
	            .addComponent(okButton, longButtons, longButtons, longButtons))
	        .addGap(margeHoritzontal)
        );
        layout.setVerticalGroup(
        layout.createSequentialGroup()
        	.addGap(margeVertical)
        	.addComponent(textMsg)
        	.addGap(margeVertical)
            .addComponent(okButton)
        );
        pack();
    }
    
    private void okButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
    }

    // Variables declaration
    private JButton okButton;
    private JTextArea textMsg;
    // End of variables declaration
}
