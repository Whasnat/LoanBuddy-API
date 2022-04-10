package com.loanbuddy.lendingengine.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Duration;
import java.util.Objects;

@Entity
public class LoanApplication {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private User taker;

	private int amount;
	private int repaymentTerm;
	private double interestRate;

	public LoanApplication() {
	}

	public LoanApplication(int amount, User taker, int repaymentTerm, double interestRate) {
		this.amount = amount;
		this.taker = taker;
		this.repaymentTerm = repaymentTerm;
		this.interestRate = interestRate;
	}

	public int getAmount() {
		return amount;
	}

	public User getTaker() {
		return taker;
	}

	public int getRepaymentTerm() {
		return repaymentTerm;
	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LoanApplication that = (LoanApplication) o;
		return amount == that.amount && Double.compare(that.interestRate, interestRate) == 0 && Objects.equals(taker, that.taker) && Objects.equals(repaymentTerm, that.repaymentTerm);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, taker, repaymentTerm, interestRate);
	}

	@Override
	public String toString() {
		return "LoanApplication{" +
				"amount=" + amount +
				", taker=" + taker +
				", repaymentTerm=" + repaymentTerm +
				", interestRate=" + interestRate +
				'}';
	}


}