package com.org.mfs.loans.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.mfs.loans.model.CreditStatus;
import com.org.mfs.loans.service.CreditScoreService;


@RestController
@RequestMapping("/credit")
public class CreditScoreController {

	@Autowired
	private CreditScoreService creditScoreService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping("/score")
	public Optional<CreditStatus> getCustomerCreditScore(@RequestParam("customerId") int customerId){
		return creditScoreService.getCreditScore(customerId);
	}
}
