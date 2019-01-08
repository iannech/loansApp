package com.org.mfs.creditstatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.mfs.creditstatus.model.CreditStatus;
import com.org.mfs.creditstatus.service.CreditStatusService;


@Controller
@RequestMapping("creditstatus")
public class CreditStatusController {

	@Autowired
	CreditStatusService creditStatusService;
	

	@RequestMapping("/score")
	public List<CreditStatus> getCustomerCreditScore(@RequestParam("customerId") int customerId){
		return creditStatusService.getCreditScore(customerId);
	}
	
}
