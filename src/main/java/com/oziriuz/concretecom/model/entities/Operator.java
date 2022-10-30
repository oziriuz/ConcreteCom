package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.Column;
import com.oziriuz.concretecom.model.annotations.Entity;
import com.oziriuz.concretecom.model.annotations.Id;
import com.oziriuz.concretecom.model.annotations.Unique;

@Entity("oper_data")
//@Table
public class Operator {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("o_num" )
    private int id;

    @Unique
    @Column("o_name")
    private String name;

    @Column("o_pass")
    private String password;

    public Operator() {
    }

    public Operator(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
