package com.emprestimo.demo.domain.user;

import com.emprestimo.demo.domain.loan.LocationRegion;
import com.emprestimo.demo.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private BigDecimal income;
    private LocationRegion location;
    @Column(unique = true)
    private String cpf;

    public User(UserDTO user){
        this.name = user.name();
        this.age = user.age();
        this.income = user.income();
        this.location = user.location();
        this.cpf = user.cpf();
    }
}
