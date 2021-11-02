package com.inforplus.user.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inforplus.user.models.Purchase;
import com.inforplus.user.repositories.PurchaseRepository;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
 
  private final PurchaseRepository purchaseRepository;
 
  public PurchaseController(                                  
    PurchaseRepository purchaseRepository) {
    this.purchaseRepository = purchaseRepository;
  }
 
  @PostMapping
  public void storePurchase(@RequestBody Purchase purchase) {
    purchaseRepository.storePurchase(purchase);               
  }
  
  @PostMapping(value = "/init")
  public ResponseEntity<String> initDB() {
    try{
    	purchaseRepository.init();
    	return ResponseEntity	
                .status(HttpStatus.NO_CONTENT)
                .body(null);
    } catch (Exception e) {
    	return ResponseEntity	
                .status(HttpStatus.CONFLICT)
                .body("Duplicated resources");
    }
  }
 
  @GetMapping
  public List<Purchase> findPurchases() {
    return purchaseRepository.findAllPurchases();             
  }
}