package com.org.mfs.loans.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.mfs.loans.model.Loan;
import com.org.mfs.loans.repository.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;
	
	public List<Loan> getAllLoans(int customerId){
		return loanRepository.findByCustomerId(customerId);	
	}
	
	public List<Loan> getLoansMinistatement(int customerId){
		return loanRepository.findLastThreeMonthsByCustomerId(customerId);
	}
	
	public List<Loan> getCustomerLoanStatus(int customerId, String loanStatus) {
	
		return loanRepository.findCustomerLoanStatusById(customerId, loanStatus);
	}
}
