package com.daviplata.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.daviplata.app.entities.Account;


@Repository
public class AccountDaoImpl implements AccountDao {
	@PersistenceContext
	
	EntityManager entity;

	@Override
	public void createAccout(Account account) {
		if (account.getId() != null && account.getId() > 0)
			entity.merge(account);
		else
			entity.persist(account);

	}

	@Override
	public Account findByDocument(String numeroDocumento) {
		
		Account accounts=null;

		Query query= entity.createQuery("select a from Account a where numeroDocumento=:numeroDocumento", Account.class);

		query.setParameter("numeroDocumento", numeroDocumento);
		
		accounts=(Account) query.getSingleResult();
		
		return accounts;
	}
	
	
	
	@Override
	public List<Account> getAllAccounts() {
		
		List<Account>accounts=   entity.createQuery("from Account",Account.class).getResultList();
		
		return accounts;

	}
	

}
