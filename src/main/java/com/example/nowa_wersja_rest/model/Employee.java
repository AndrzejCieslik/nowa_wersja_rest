package com.example.nowa_wersja_rest.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Table(name = "pracownicy")
@Data
public class Employee {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    private String emailId;

}
