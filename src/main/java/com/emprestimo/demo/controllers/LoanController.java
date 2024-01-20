package com.emprestimo.demo.controllers;

import com.emprestimo.demo.Service.UserService;
import com.emprestimo.demo.domain.loan.Loan;
import com.emprestimo.demo.domain.loan.ResponseLoan;
import com.emprestimo.demo.domain.user.User;
import com.emprestimo.demo.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<ResponseLoan> createTransaction(@RequestBody UserDTO user) throws Exception {
        User userloan = new User(user);
        List<Loan> loans = userService.loansDisponili(userloan);
        ResponseLoan newResponseLoan = new ResponseLoan(userloan.getName(), loans);
        return new ResponseEntity<>(newResponseLoan, HttpStatus.OK);
    }

}
