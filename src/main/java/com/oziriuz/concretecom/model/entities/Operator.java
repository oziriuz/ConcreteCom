package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.Column;
import com.oziriuz.concretecom.model.annotations.Table;
import com.oziriuz.concretecom.model.annotations.Id;

@Table("oper_data")
//@Table
public class Operator {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("o_num" )
    private int id;

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
