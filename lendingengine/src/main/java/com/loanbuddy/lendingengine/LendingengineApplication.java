package com.loanbuddy.lendingengine;

import com.loanbuddy.lendingengine.domain.model.User;
import com.loanbuddy.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LendingengineApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(LendingengineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User(1,"Rahat", "Wasnat", 28,"Web Developer" ));
		userRepository.save(new User(2,"Meenu", "Pagli", 22,"Student" ));
	}
}
