package com.pracas.domain.controller;

public class CtrlDataFactory {

	private static CtrlDataFactory ctrlDataFactory = null;
	
	private CtrlDataFactory(){};
	
	public static CtrlDataFactory getInstance() {
		if (ctrlDataFactory == null) {
			ctrlDataFactory = new CtrlDataFactory();
		}
		return ctrlDataFactory;
	}
	
	/*public CtrlUsuariRegistrat getCtrlUsuariRegistrat() {
		
	}*/
	
}
