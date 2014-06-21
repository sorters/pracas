package com.pracas.transaction;

import java.util.ArrayList;
import java.util.List;

import com.pracas.domain.controller.DataFactory;
import com.pracas.domain.controller.ICtrlCategoria;
import com.pracas.domain.model.Categoria;
import com.pracas.exception.NoCategoriesException;

public class TxConsultarCategories {

	private List<String> resultat;
	
	public void executar() throws NoCategoriesException {
		this.resultat = new ArrayList<String>();
		
		ICtrlCategoria icc = DataFactory.getCtrlCategoria();
		
		List<Categoria> categories = icc.getAll();
		
		if (categories.size() == 0)
			throw new NoCategoriesException();
		
		for (Categoria c : categories)
			this.resultat.add(c.getNom());
		
	}

	public List<String> getResultat() {
		return resultat;
	}
	
	
	
}
