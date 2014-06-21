/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pracas.presentation;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.GroupLayout;

/**
 *
 * @author arkey
 */
public class MessageFrame extends javax.swing.JFrame {
	
	private static final double relacio = 1.618034;
	private int alturaFinestra = 222;
	private int ampladaFinestra = (int) (alturaFinestra * relacio);
	
	private static final int margeVertical = 29;
	private static final int margeHoritzontal = 29;
	
	private static final int margeHortText = 10;
	private static final int margeVertText = 10;
    private static final int longButtons = 155;


    /**
     * Creates new form MessageFrame
     */
    public MessageFrame() {
		this.setMinimumSize(new Dimension(ampladaFinestra, alturaFinestra));
		this.setTitle("Missatge");
        this.setResizable(false);
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                alturaFinestra = e.getComponent().getSize().height;
                ampladaFinestra = e.getComponent().getSize().width;
                configTextArea();
            }
        });        
        
        initComponents();
    }
    
    public void setMessage(String msg) {
    	textMsg.setText(msg);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

    	okButton = new javax.swing.JButton();
        textMsg = new javax.swing.JTextArea();
        
        textMsg.setMargin(new Insets(margeVertText, margeHortText, margeVertText, margeHortText));
        textMsg.setEditable(false);
        textMsg.setLineWrap(true);
        textMsg.setWrapStyleWord(true);
        configTextArea();        

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
    
    private void configTextArea() {
        int ampladaText = ampladaFinestra - 2*margeHoritzontal;     
        textMsg.setMaximumSize(new Dimension(ampladaText, 100));
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    // Variables declaration
    private javax.swing.JButton okButton;
    private javax.swing.JTextArea textMsg;
    // End of variables declaration
}
