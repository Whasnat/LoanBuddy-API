package com.loanbuddy.lendingengine.application;

import com.loanbuddy.lendingengine.application.model.LoanRequest;
import com.loanbuddy.lendingengine.domain.model.User;
import com.loanbuddy.lendingengine.domain.repository.LoanRequestRepository;
import com.loanbuddy.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

	private final LoanRequestRepository loanRequestRepository;
	private final UserRepository userRepository;

	@Autowired
	public LoanController(LoanRequestRepository loanRequestRepository, UserRepository userRepository) {
		this.loanRequestRepository = loanRequestRepository;
		this.userRepository = userRepository;
	}

	@PostMapping(value = "/loan/request")
	public void requestLoan(@RequestBody final LoanRequest loanRequest){
		System.out.println(loanRequest.toString());
	}

	@GetMapping(value = "/users")
	public List<User> findUsers(){
		return userRepository.findAll();
	}
}
