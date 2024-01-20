package com.emprestimo.demo.dtos;

import com.emprestimo.demo.domain.loan.LocationRegion;

import java.math.BigDecimal;

public record UserDTO(Integer age, String cpf, String name, BigDecimal income, LocationRegion location) {
}
