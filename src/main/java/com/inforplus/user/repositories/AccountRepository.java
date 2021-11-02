package com.inforplus.user.repositories;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.inforplus.user.models.Account;

public interface AccountRepository 
  extends CrudRepository<Account, Long>  {

	// for more complexy queries => @Query("SELECT * FROM account WHERE name = :name")   
	List<Account> findAccountsByName(String name);
	
	List<Account> findAll();
	
	@Modifying
	@Query("UPDATE account SET amount = :amount WHERE id = :id")
	void changeAmount(long id, BigDecimal amount);
}