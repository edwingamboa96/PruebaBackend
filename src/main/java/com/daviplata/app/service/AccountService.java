package com.daviplata.app.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daviplata.app.dao.AccountDaoImpl;
import com.daviplata.app.dto.AccountRequest;
import com.daviplata.app.dto.AccountResponse;
import com.daviplata.app.entities.Account;
import com.daviplata.app.exceptions.ServiceException;

@Service
public class AccountService {

	@Autowired
	private AccountDaoImpl accountDaoImpl;

	public static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Transactional
	public AccountResponse createAccount(AccountRequest accountRquest) throws ServiceException {

		try {
			validateAccount(accountRquest.getSaldo());
			Account account = MODEL_MAPPER.map(accountRquest, Account.class);
			accountDaoImpl.createAccout(account);

		} catch (ServiceException e) {
			throw new ServiceException("El monto minimo para la apertura de la cuenta es 50.000", e);
		}

		return customResponse(accountRquest);

	}
	@Transactional
	public Optional<Account> findByDocument(String documento) {
		  Optional<Account> account= Optional.ofNullable(accountDaoImpl.findByDocument(documento));
		  
		  return account;
	}

	@Transactional(readOnly = true)
	public Optional<List<Account>> getAllAccounts() {

		Optional<List<Account>> listAccounts = Optional.ofNullable(accountDaoImpl.getAllAccounts());
		return listAccounts;
	}

	private AccountResponse customResponse(AccountRequest accountRquest) {
		String message = "account created";

		AccountResponse response = new AccountResponse();
		response.setCreationDate(new Date());
		response.setMessage(message);

		return response;

	}

	private void validateAccount(BigDecimal saldo) throws ServiceException {

		if (   saldo.intValue() < 50000) {
			throw new ServiceException(saldo + "El monto minimo para la apertura de la cuenta es 50.000");
		}
	}

}
