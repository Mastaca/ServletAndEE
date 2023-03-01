package com.fdm.bankapp.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fdm.bankapp.dao.entities.BankAccountEntity;
import com.fdm.bankapp.dao.entities.UserAccountEntity;

public class UserAccountDaoImpl implements UserAccountDao  {

	@Override
	public UserAccountEntity save(UserAccountEntity userAccountEntity, Session session) {		
		
        session.save(userAccountEntity);
        session.refresh(userAccountEntity);
        return userAccountEntity;        
	}

	@Override
	public UserAccountEntity findById(int id, Session session) {
		return session.get(UserAccountEntity.class, id);
	}

	@Override
	public UserAccountEntity update(UserAccountEntity userAccountEntity, Session session) {
        session.update(userAccountEntity);
        return userAccountEntity;
	}

	@Override
	public List<BankAccountEntity> findAllBankAccounts(int id, Session session) {        
        UserAccountEntity uae = session.get(UserAccountEntity.class, id);        
        Hibernate.initialize(uae.getAccounts());
        List<BankAccountEntity> listBankAccounts = uae.getAccounts();
		return listBankAccounts;
	}

	@Override
	public UserAccountEntity findByEmail(String email, Session session) {
		Query query = session.createQuery("from UserAccountEntity where email= :email");
        query.setParameter("email", email);
        UserAccountEntity userAccountEntity = (UserAccountEntity) query.uniqueResult();
		return userAccountEntity;
	}

}
