package com.inforplus.user.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inforplus.user.dto.AccountCreateRequestDto;
import com.inforplus.user.models.Account;
import com.inforplus.user.models.Purchase;
import com.inforplus.user.repositories.AccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountController  {
 
  private final AccountRepository accountRepository;
 
  public AccountController(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }
 
  @PostMapping
  public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountCreateRequestDto request) {
    var account = new Account();
    account.setAmount(request.getAmount());
    account.setName(request.getName());
	var result = accountRepository.save(account);
	return ResponseEntity	
            .status(HttpStatus.CREATED)
            .body(result);            
  }
  
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Long> deleteAccount(@PathVariable long id) {
	  var findResult = accountRepository.findById(id);
	  if (findResult.isPresent() == false) {
		  return ResponseEntity	
		            .status(HttpStatus.NOT_FOUND)
		            .body(null);
	  }
	  accountRepository.deleteById(id);
	  return ResponseEntity	
			  .status(HttpStatus.NO_CONTENT)
	          .body(null);
  }
 
  @GetMapping
  public List<Account> findAll() {
    return accountRepository.findAll();         
  }
}