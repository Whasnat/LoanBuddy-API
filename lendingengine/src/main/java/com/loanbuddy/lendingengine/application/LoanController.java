package com.loanbuddy.lendingengine.application;

import com.loanbuddy.lendingengine.application.model.LoanRequest;
import com.loanbuddy.lendingengine.domain.model.LoanApplication;
import com.loanbuddy.lendingengine.domain.model.User;
import com.loanbuddy.lendingengine.domain.repository.LoanApplicationRepository;
import com.loanbuddy.lendingengine.domain.repository.UserRepository;
import com.loanbuddy.lendingengine.domain.service.LoanApplicationAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

	private final LoanApplicationRepository loanApplicationRepository;
	private final UserRepository userRepository;
	private final LoanApplicationAdapter loanApplicationAdapter;

	@Autowired
	public LoanController(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository, LoanApplicationAdapter loanApplicationAdapter) {
		this.loanApplicationRepository = loanApplicationRepository;
		this.userRepository = userRepository;
		this.loanApplicationAdapter = loanApplicationAdapter;
	}

	@PostMapping(value = "/loan/request")
	public void requestLoan(@RequestBody final LoanRequest loanRequest) {
		loanApplicationRepository.save(loanApplicationAdapter.transform(loanRequest));

//		System.out.println(loanRequest.toString());
	}

	@GetMapping(value = "/users")
	public List<User> findUsers() {
		return userRepository.findAll();
	}

}
