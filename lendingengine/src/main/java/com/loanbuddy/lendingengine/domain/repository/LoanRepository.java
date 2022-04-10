package com.loanbuddy.lendingengine.domain.repository;

import com.loanbuddy.lendingengine.domain.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
