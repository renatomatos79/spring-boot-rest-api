package com.inforplus.user.repositories;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inforplus.user.config.ProjectConfig;
import com.inforplus.user.models.Purchase;

@Repository
public class PurchaseRepository {
	private final JdbcTemplate jdbc;

//	public PurchaseRepository(JdbcTemplate jdbc) {
//
//		this.jdbc = jdbc;
//	}
	
	@Autowired
	public PurchaseRepository(ProjectConfig dbConfig){
		var dataSource = dbConfig.dataSource();
	    this.jdbc = new JdbcTemplate(dataSource);
	}

	
	public void storePurchase(Purchase purchase) {        
	    String sql =                                        
	      "INSERT INTO purchase (product, price) VALUES (?, ?)";
	 
	    jdbc.update(sql,                                    
	          purchase.getProduct(), 
	          purchase.getPrice());
	  }
	
	public List<Purchase> findAllPurchases() {              
	    String sql = "SELECT * FROM purchase";                
	 
	    RowMapper<Purchase> purchaseRowMapper = new RowMapper<Purchase>() {
			public Purchase mapRow(ResultSet r, int i) throws SQLException {   
			  return new Purchase(r.getInt("id"), r.getString("product"), r.getBigDecimal("price"));                               
			}
		};
	 
	    return jdbc.query(sql, purchaseRowMapper);            
	  }

	@Transactional
	public void init() {
		this.storePurchase(new Purchase(1, "41001", BigDecimal.valueOf(4.25)));
		this.storePurchase(new Purchase(1, "51001", BigDecimal.valueOf(3.25))); 
		this.storePurchase(new Purchase(2, "51002", BigDecimal.valueOf(3.125)));
		this.storePurchase(new Purchase(3, "51003", BigDecimal.valueOf(3.75)));
		
	}
}
