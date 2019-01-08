package com.org.mfs.loans.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.mfs.loans.model.CreditStatus;
import com.org.mfs.loans.repository.CreditScoreRepository;

@Service
public class CreditScoreService {

	@Autowired
	private CreditScoreRepository creditScoreRepository;
	
//	public ResponseEntity<Object> getCreditStatus(int customerId) {
//		JsonRepsonse jsonResponse =  new JsonResponse(creditScoreRepository.findCreditScoreByCustomerId(customerId));
//	
//	}
	
	
	public Optional<CreditStatus> getCreditScore(int customerId){
		return creditScoreRepository.findCreditScoreByCustomerId(customerId);
	}
	
}
