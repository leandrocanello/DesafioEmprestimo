package com.emprestimo.demo.dtos;

import com.emprestimo.demo.domain.loan.Loan;

import java.util.List;

public record LoanUserDTO (String customer, List<Loan> loanList){
}
