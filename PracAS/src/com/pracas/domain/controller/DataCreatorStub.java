package com.pracas.domain.controller;

import org.hibernate.Session;

import com.pracas.domain.model.Categoria;
import com.pracas.domain.model.Jugador;
import com.pracas.domain.model.Paraula;
import com.pracas.domain.model.UsuariRegistrat;
import com.pracas.persistence.PersistenceSessionFactory;

public class DataCreatorStub {

	public void execute() {
		Session s = PersistenceSessionFactory.getInstance().openSession();
		
		s.beginTransaction();
		
		Categoria c1 = new Categoria("NOMS");
		Categoria c2 = new Categoria("ADJECTIUS");
		
		Paraula p1 = new Paraula("GOS");
		s.save(p1);
		c1.afegeixParaula(p1);
		Paraula p2 = new Paraula("GAT");
		s.save(p2);
		c1.afegeixParaula(p2);
		Paraula p3 = new Paraula("POP");
		s.save(p3);
		c1.afegeixParaula(p3);
		Paraula p4 = new Paraula("VACA");
		s.save(p4);
		c1.afegeixParaula(p4);
		Paraula p5 = new Paraula("LLEO");
		s.save(p5);
		c1.afegeixParaula(p5);
		Paraula p6 = new Paraula("CAVALL");
		s.save(p6);
		c1.afegeixParaula(p6);
		Paraula p7 = new Paraula("FORMIGA");
		s.save(p7);
		c1.afegeixParaula(p7);
		Paraula p8 = new Paraula("TORTUGA");
		s.save(p8);
		c1.afegeixParaula(p8);
		Paraula p9 = new Paraula("TUCAN");
		s.save(p9);
		c1.afegeixParaula(p9);
		s.save(c1);
		
		Paraula p10 = new Paraula("GROS");
		s.save(p10);
		c2.afegeixParaula(p10);
		Paraula p11 = new Paraula("RALLAT");
		s.save(p11);
		c2.afegeixParaula(p11);
		Paraula p12 = new Paraula("PERDUT");
		s.save(p12);
		c2.afegeixParaula(p12);
		Paraula p13 = new Paraula("MACA");
		s.save(p13);
		c2.afegeixParaula(p13);
		Paraula p14 = new Paraula("FORT");
		s.save(p14);
		c2.afegeixParaula(p14);
		Paraula p15 = new Paraula("RAPID");
		s.save(p15);
		c2.afegeixParaula(p15);
		Paraula p16 = new Paraula("PETITA");
		s.save(p16);
		c2.afegeixParaula(p16);
		Paraula p17 = new Paraula("LENTA");
		s.save(p17);
		c2.afegeixParaula(p17);
		Paraula p18 = new Paraula("SOROLLOS");
		s.save(p18);
		c2.afegeixParaula(p18);
		s.save(c2);
		
		UsuariRegistrat u = new UsuariRegistrat("rohert", "esc", "rohert", "admin");
		s.save(u);
		UsuariRegistrat u2 = new UsuariRegistrat("ben", "sorter", "sorter", "admin");
		s.save(u2);
		
		s.getTransaction().commit();
		PersistenceSessionFactory.getInstance().closeSession();
		s = PersistenceSessionFactory.getInstance().openSession();
		s.beginTransaction();
		
		Jugador j = new Jugador(u, "rohert@rohert.com");
		s.save(j);

		s.getTransaction().commit();
		PersistenceSessionFactory.getInstance().closeSession();

	}
}
