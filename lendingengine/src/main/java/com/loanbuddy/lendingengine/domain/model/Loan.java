package com.loanbuddy.lendingengine.domain.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Loan{

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private User taker;

	@ManyToOne
	private User lender;

	private int amount;
	private double interestRate;
	private LocalDate startDate;
	private LocalDate endDate;

	public Loan() {
	}

	public Loan (User lender, LoanApplication loanApplication){
		this.taker = loanApplication.getTaker();
		this.lender = lender;
		this.amount = loanApplication.getAmount();
		this.interestRate = loanApplication.getInterestRate();
		this.startDate = LocalDate.now();
		this.endDate = LocalDate.now().plusDays(loanApplication.getRepaymentTerm());
	}
}
