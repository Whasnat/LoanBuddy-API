package com.loanbuddy.lendingengine.domain.repository;

import com.loanbuddy.lendingengine.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
