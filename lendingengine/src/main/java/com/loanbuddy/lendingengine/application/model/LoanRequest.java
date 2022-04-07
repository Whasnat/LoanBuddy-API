package com.loanbuddy.lendingengine.application.model;

import java.util.Objects;

public class LoanRequest {

	private long taker_userId;
	private int amount;
	private int repaymentTermInDays;
	private double interestRate;

	public LoanRequest(long taker_userId, int amount, int repaymentTermInDays, double interestRate) {
		this.taker_userId = taker_userId;
		this.amount = amount;
		this.repaymentTermInDays = repaymentTermInDays;
		this.interestRate = interestRate;
	}

	public long getTaker_userId() {
		return taker_userId;
	}

	public int getAmount() {
		return amount;
	}

	public int getRepaymentTermInDays() {
		return repaymentTermInDays;
	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LoanRequest that = (LoanRequest) o;
		return taker_userId == that.taker_userId && amount == that.amount && repaymentTermInDays == that.repaymentTermInDays && Double.compare(that.interestRate, interestRate) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(taker_userId, amount, repaymentTermInDays, interestRate);
	}

	@Override
	public String toString() {
		return "LoanRequest{" +
				"taker_userId=" + taker_userId +
				", amount=" + amount +
				", repaymentTermInDays=" + repaymentTermInDays +
				", interestRate=" + interestRate +
				'}';
	}
}
