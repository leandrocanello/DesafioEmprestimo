package com.emprestimo.demo.domain.loan;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Loan {
    private LoanType type;
    private Integer interest_rate;

    public Loan(LoanType loanType, int i) {
        this.type = loanType;
        this.interest_rate = i;
    }
}
