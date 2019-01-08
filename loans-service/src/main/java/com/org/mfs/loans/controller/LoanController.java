package com.org.mfs.loans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.mfs.loans.model.Loan;
import com.org.mfs.loans.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
	private LoanService loanService;

	// Get complete loan history for Customer
	@RequestMapping("/all")
	public ResponseEntity<List<Loan>> getLoans(@RequestParam("customerId") int customerId){
		List<Loan> loans = loanService.getAllLoans(customerId);
		if(loans.isEmpty()) {
			return new ResponseEntity<List<Loan>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Loan>>(loans, HttpStatus.OK);
	}
	
	// Get 3 month loan history of customer
	@RequestMapping("/statement")
	public ResponseEntity<List<Loan>> getLoansStatement(@RequestParam("customerId") int customerId){
		List<Loan> loans = loanService.getLoansMinistatement(customerId);
		if(loans.isEmpty()) {
			return new ResponseEntity<List<Loan>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Loan>>(loans, HttpStatus.OK);
	}
	
	// Check status of loans
	@RequestMapping("/status")
	public List<Loan> getCustomerLoanStatus(@RequestParam("customerId")int customerId, @RequestParam("loanStatus")String loanStatus) {
		return loanService.getCustomerLoanStatus(customerId, loanStatus);
	}
	
}
