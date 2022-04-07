package com.loanbuddy.lendingengine.application;

import com.loanbuddy.lendingengine.application.model.LoanRequest;
import com.loanbuddy.lendingengine.domain.model.LoanApplication;
import com.loanbuddy.lendingengine.domain.repository.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

	private final LoanRequestRepository loanRequestRepository;

	@Autowired
	public LoanController(LoanRequestRepository loanRequestRepository) {
		this.loanRequestRepository = loanRequestRepository;
	}

	@PostMapping(value = "/loan/request")
	public void requestLoan(@RequestBody final LoanRequest loanRequest){
		System.out.println(loanRequest.toString());
	}
}
