package com.fdm.bankapp.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fdm.bankapp.dao.entities.BankAccountEntity;

public class BankAccountDaoImpl implements BankAccountDao {	

	@Override
	public BankAccountEntity save(BankAccountEntity bae, Session session) {
        session.save(bae);
        session.refresh(bae);
        return bae;
	}

	@Override
	public BankAccountEntity findById(int id, Session session) {		
        BankAccountEntity bae = session.get(BankAccountEntity.class, id);		
		return bae;
	}
	
	@Override
	public BankAccountEntity findByIban(String iban, Session session) {		        
        Query query = session.createQuery("from BankAccountEntity where iban= :iban");
        query.setParameter("iban", iban);
        BankAccountEntity bankAccountEntity = (BankAccountEntity) query.uniqueResult();
		return bankAccountEntity;
	}
	
	public void update(BankAccountEntity bankAccountEntity, Session session) {
        session.update(bankAccountEntity);
	}
}
