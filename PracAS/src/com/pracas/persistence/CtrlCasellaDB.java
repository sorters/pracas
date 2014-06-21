package com.pracas.persistence;

import org.hibernate.Session;

import com.pracas.domain.controller.ICtrlCasella;
import com.pracas.domain.model.Casella;

public class CtrlCasellaDB implements ICtrlCasella {

	@Override
	public int saveOrUpdateCasella(Casella _casella) {
		Session s = PersistenceSessionFactory.getInstance().openSession();
		s.beginTransaction();
		s.saveOrUpdate(_casella);
		s.getTransaction().commit();
		s.close();
		return 0;
	}

}
