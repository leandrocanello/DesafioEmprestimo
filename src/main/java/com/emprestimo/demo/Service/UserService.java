package com.emprestimo.demo.Service;

import com.emprestimo.demo.domain.loan.Loan;
import com.emprestimo.demo.domain.loan.LoanType;
import com.emprestimo.demo.domain.loan.LocationRegion;
import com.emprestimo.demo.domain.user.User;
import com.emprestimo.demo.dtos.UserDTO;
import com.emprestimo.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<Loan> loansDisponili(User user){
        BigDecimal caseA = new BigDecimal(3000);
        BigDecimal caseB = new BigDecimal(5000);
        List<Loan> listLoan = new ArrayList<>();
        if(user.getIncome().compareTo(caseA) <= 0)
            listLoan.add(new Loan(LoanType.PERSONAL, 4));
       if(user.getAge() < 30 && user.getLocation().equals(LocationRegion.SP) &&
                user.getIncome().compareTo(caseA) >= 0 && user.getIncome().compareTo(caseB) <= 0)
           listLoan.add(new Loan(LoanType.PERSONAL, 4));
       if(user.getIncome().compareTo(caseB) >= 0)
           listLoan.add(new Loan(LoanType.CONSIGNMENT, 2));
       if(user.getIncome().compareTo(caseA) <= 0)
           listLoan.add(new Loan(LoanType.GUARANTEED, 3));
       if(user.getIncome().compareTo(caseA) >= 0 && user.getIncome().compareTo(caseB) <= 0
       && user.getAge() < 30 && user.getLocation().equals(LocationRegion.SP))
           listLoan.add(new Loan(LoanType.GUARANTEED, 3));

       return listLoan;
    }

    public User createUser(UserDTO user){
        User newUser = new User(user);
        userRepository.save(newUser);
        return newUser;
    }
}
