package com.emprestimo.demo.repositories;

import com.emprestimo.demo.domain.loan.Loan;
import com.emprestimo.demo.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
