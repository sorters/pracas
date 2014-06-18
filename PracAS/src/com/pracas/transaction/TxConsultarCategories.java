package com.pracas.transaction;

import java.util.HashSet;
import java.util.Set;

import com.pracas.domain.controller.DataFactory;
import com.pracas.domain.controller.ICtrlCategoria;
import com.pracas.domain.model.Categoria;
import com.pracas.exception.NoCategoriesException;

public class TxConsultarCategories {

	//private Set<String> resultat;
	
	public Set<String> executar() throws NoCategoriesException {
		Set<String> resultat = new HashSet<String>();
		
		ICtrlCategoria icc = DataFactory.getInstance().getCtrlCategoria();
		
		Set<Categoria> categories = icc.getAll();
		
		if (categories.size() == 0)
			throw new NoCategoriesException();
		
		for (Categoria c : categories)
			resultat.add(c.getNom());
		
		return resultat;
	}
	
}
