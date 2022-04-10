package com.loanbuddy.lendingengine.domain.service;

import com.loanbuddy.lendingengine.application.model.LoanRequest;
import com.loanbuddy.lendingengine.domain.exception.UserNotFoundException;
import com.loanbuddy.lendingengine.domain.model.LoanApplication;
import com.loanbuddy.lendingengine.domain.model.User;
import com.loanbuddy.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Optional;

@Component
public class LoanApplicationAdapter {


	private final UserRepository userRepository;

	@Autowired
	public LoanApplicationAdapter(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public LoanApplication transform(LoanRequest req) {
		Optional<User> userOptional = userRepository.findById(req.getTaker_userId());

		if (userOptional.isPresent()) {
				return new LoanApplication(req.getAmount(), userOptional.get(), req.getRepaymentTermInDays(), req.getInterestRate());

		} else {
			throw new UserNotFoundException(req.getTaker_userId());
		}
	}
}
