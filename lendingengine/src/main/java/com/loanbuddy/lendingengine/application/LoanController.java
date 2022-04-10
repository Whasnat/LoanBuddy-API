package com.loanbuddy.lendingengine.application;

import com.loanbuddy.lendingengine.application.model.LoanRequest;
import com.loanbuddy.lendingengine.domain.model.LoanApplication;
import com.loanbuddy.lendingengine.domain.model.User;
import com.loanbuddy.lendingengine.domain.repository.LoanApplicationRepository;
import com.loanbuddy.lendingengine.domain.repository.UserRepository;
import com.loanbuddy.lendingengine.domain.service.LoanApplicationAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

	private LoanApplicationRepository loanApplicationRepository;
	private UserRepository userRepository;
	private LoanApplicationAdapter loanApplicationAdapter;

	@Autowired
	public LoanController(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository, LoanApplicationAdapter loanApplicationAdapter) {
		this.loanApplicationRepository = loanApplicationRepository;
		this.userRepository = userRepository;
		this.loanApplicationAdapter = loanApplicationAdapter;
	}

	@PostMapping(value = "/loan/request")
	public void requestLoan(@RequestBody LoanRequest loanRequest) {
		loanApplicationRepository.save(loanApplicationAdapter.transform(loanRequest));

		System.out.println(loanRequest.toString());
	}

	@GetMapping(value = "/loan/requests")
	public List<LoanApplication> findAllLoanRequests() {
		return loanApplicationRepository.findAll();
	}

	@PostMapping(value = "/loan/accept/{lender_userId}/{loanApplicationId}")
	public void acceptLoan(@PathVariable final String lender_userId,
	                       @PathVariable final String loanApplicationId) {

	}

	@GetMapping(value = "/users")
	public List<User> findUsers() {
		return userRepository.findAll();
	}

}
