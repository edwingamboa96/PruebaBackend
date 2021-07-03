package com.daviplata.app.dao;

import java.util.List;

import com.daviplata.app.entities.Account;

public interface AccountDao {
	
	
	public void createAccout(Account account);
	
	
	public Account findByDocument(String numeroDocumento);
	
	public  List<Account> getAllAccounts();

}
