package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.BankAccount;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.BankAccountRepository;

@RestController
@RequestMapping("/api/bankaccounts")
public class BankAccountController {

	@Autowired
	BankAccountRepository bankAccountRepository;
	
	
	//Get All BankAccounts
	@GetMapping
	public List<BankAccount> getAllBankAccounts() {
		return this.bankAccountRepository.findAll();
	}
	
	//Get BankAccount By Id
	@GetMapping("/{id}")
	public BankAccount getBankAccountById(@PathVariable(value = "id") long bankAccountId) {
		return this.bankAccountRepository.findById(bankAccountId).
				orElseThrow(()-> new ResourceNotFoundException(" the bank Account with Id : "+ bankAccountId+ "does not exist"));
	}
		
	
	//Create a New Bank Account
	@PostMapping
	public BankAccount createNewBankAccount(@RequestBody BankAccount bankAccount) {
		
		return this.bankAccountRepository.save(bankAccount);
	}
	
	//Update a BankAccount
	@PutMapping("/{id}")
	public BankAccount EditBankAccount(@RequestBody BankAccount bankAccount, @PathVariable (value = "id") long bankAccountId) {
		
		BankAccount olderBankAccount= this.bankAccountRepository.findById(bankAccountId)
										.orElseThrow(() -> new ResourceNotFoundException("the bank Account with Id : "+ bankAccountId+ " does not exist"));
		olderBankAccount.setBankName(bankAccount.getBankName());
		olderBankAccount.setAccountNumber(bankAccount.getAccountNumber());
		olderBankAccount.setCountry(bankAccount.getCountry());
		olderBankAccount.setOwnerEmail(bankAccount.getOwnerEmail());
		olderBankAccount.setOwnerFullName(bankAccount.getOwnerFullName());
		olderBankAccount.setOwnerPhone(bankAccount.getOwnerPhone());
		olderBankAccount.setTotalAmount(bankAccount.getTotalAmount());
		olderBankAccount.setZipCode(bankAccount.getZipCode());
	 
	return this.bankAccountRepository.save(olderBankAccount);
	}
	
	//Delete a BankAccount
	@DeleteMapping("/{id}")
	public ResponseEntity<BankAccount> deleteBankAccount(@PathVariable (value = "id") long bankAccountId) {
		
		BankAccount olderBankAccount= this.bankAccountRepository.findById(bankAccountId)
				.orElseThrow(()-> new ResourceNotFoundException("the bank Account with Id : "+ bankAccountId+ " does not exist"));
		this.bankAccountRepository.delete(olderBankAccount);
		return ResponseEntity.ok().build();
	}
}
