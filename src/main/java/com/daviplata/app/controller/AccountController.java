package com.daviplata.app.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Edwin Gamboa
 *
 */

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daviplata.app.dto.AccountRequest;
import com.daviplata.app.dto.AccountResponse;
import com.daviplata.app.entities.Account;
import com.daviplata.app.exceptions.ServiceException;
import com.daviplata.app.service.AccountService;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/account")

public class AccountController {

	@Autowired
	private AccountService accountService;

	@Operation(summary = "Crate a new account")
	@ApiResponse(responseCode = "201", description = "Account is created", content = {
			@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AccountResponse.class)) })
	@PostMapping(path = "/createAccount",  consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody AccountRequest accountRequest) throws ServiceException {

		AccountResponse accountResponse = accountService.createAccount(accountRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(accountResponse);

	}
	
	
	@Operation(summary = "Get an Account by its id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Account the order", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Account.class))}),
			@ApiResponse(responseCode = "404", description = "Account not found", content = @Content)})
	@GetMapping(value = "/getAccountById",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> loadOrder(@ApiParam(value = "numero documento", example = "124639")  @RequestParam String documento) {
	 Optional<Account> account = accountService.findByDocument(documento);
		if (!account.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(account.get());
	}

	
	@RequestMapping(value = "/getAllAcounts", method = RequestMethod.GET)
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the accounts", content = {@Content(mediaType = APPLICATION_JSON_VALUE)}),
			@ApiResponse(responseCode = "404", description = "Accounts not found", content = @Content)})
	public ResponseEntity<List<Account>> getAllAccounts() {
	Optional<List<Account>>accounts=accountService.getAllAccounts();
		   if(!accounts.isPresent()) {
		    	return    ResponseEntity.notFound().build();
		     }
		     
		     return ResponseEntity.ok(accounts.get());
	}

}
