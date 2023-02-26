package com.fdm.bankapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.fdm.bankapp.dao.entities.BankAccountEntity;

public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	public BankAccountEntity save(BankAccountEntity bae) {
		Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();        
        int id = (int)session.save(bae);
        tx.commit();
        session.close();        
        session = sessionFactory.openSession();
        BankAccountEntity savedUae = session.get(BankAccountEntity.class, id);
        session.close();
        sessionFactory.close();
        return savedUae;
	}

	@Override
	public BankAccountEntity findById(int id) {
		Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        BankAccountEntity bae = session.get(BankAccountEntity.class, id);        
        session.close();
        sessionFactory.close();		
		return bae;
	}

	@Override
	public BankAccountEntity bankDeposit(int id, int suma) {
		BankAccountEntity bae = this.findById(id);
		bae.setSuma(bae.getSuma() + suma);
		this.deposit(id, bae.getSuma());
		return bae;
	}

	@Override
	public BankAccountEntity bankTransfer(int id, int recipientId, int suma) {
		BankAccountEntity senderId = this.findById(id);
		BankAccountEntity recipientBankId = this.findById(recipientId);
		senderId.setSuma(senderId.getSuma() - suma);
		this.deposit(id, senderId.getSuma());
		recipientBankId.setSuma(recipientBankId.getSuma() + suma);
		this.deposit(recipientId, recipientBankId.getSuma());		
		return senderId;
	}

	@Override
	public BankAccountEntity bankWithdrawal(int id, int suma) {
		BankAccountEntity bae = this.findById(id);
		bae.setSuma(bae.getSuma() - suma);
		this.deposit(id, bae.getSuma());
		return bae;
	}
	
	
	private void deposit(int bankId, int suma) {
		Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("update bankaccount set suma=? where id=?");
        query.setParameter(1, suma);
        query.setParameter(2, bankId);
        query.executeUpdate();
        session.close();
        sessionFactory.close();		
	}

}
