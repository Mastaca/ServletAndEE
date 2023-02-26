package com.fdm.bankapp.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fdm.bankapp.dao.entities.BankAccountEntity;
import com.fdm.bankapp.dao.entities.UserAccountEntity;

public class UserAccountDaoImpl implements UserAccountDao  {

	@Override
	public UserAccountEntity save(UserAccountEntity uae) {		
		Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        int id = (int)session.save(uae);
        tx.commit();
        UserAccountEntity savedUae = session.get(UserAccountEntity.class, id);
        session.close();
        sessionFactory.close();
        return savedUae;        
	}

	@Override
	public UserAccountEntity findById(int id) {
		Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        UserAccountEntity uae = session.get(UserAccountEntity.class, id);
        
        session.close();
        sessionFactory.close();
		
		return uae;
	}

	@Override
	public UserAccountEntity update(UserAccountEntity uae) {
		
		Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(uae);
        tx.commit();
        session.close();
        sessionFactory.close();
        return uae;
	}

	@Override
	public List<BankAccountEntity> findAllBankAccounts(int id) {
		Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        UserAccountEntity uae = session.get(UserAccountEntity.class, id);        
        Hibernate.initialize(uae.getAccounts());
        List<BankAccountEntity> listBAccounts = uae.getAccounts();
                
        session.close();
        sessionFactory.close();
		
		return listBAccounts;
	}

}
