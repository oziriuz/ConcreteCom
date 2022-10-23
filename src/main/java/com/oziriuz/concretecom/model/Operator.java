package com.oziriuz.concretecom.model;

import javax.persistence.*;

@Entity
@Table(name = "oper_data")
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_num" )
    private int id;

    @Column(name = "o_name", unique = true)
    private String name;

    @Column(name = "o_pass")
    private String password;

    public Operator() {
    }

    public Operator(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
