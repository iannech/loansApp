package com.org.mfs.creditstatus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.mfs.creditstatus.model.CreditStatus;
import com.org.mfs.creditstatus.repository.CreditStatusRepository;

@Service
public class CreditStatusService {

	@Autowired 
	CreditStatusRepository creditStatusRepository;
	
	
	public List<CreditStatus> getCreditScore(int customerId){
		return creditStatusRepository.findCreditScoreByCustomerId(customerId);
	}
}
