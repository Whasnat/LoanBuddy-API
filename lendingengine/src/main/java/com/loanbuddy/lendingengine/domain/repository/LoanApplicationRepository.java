package com.loanbuddy.lendingengine.domain.repository;

import com.loanbuddy.lendingengine.domain.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

}
