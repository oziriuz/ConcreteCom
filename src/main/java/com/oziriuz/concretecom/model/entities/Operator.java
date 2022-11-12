package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity("oper_data")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Operator {
    @Id
    @Column("o_num")
    private long id;

    @Unique
    @Column("o_name")
    private String name;

    @Column("o_pass")
    private String password;

    public Operator(long id, String password) {
        this.id = id;
        this.password = password;
    }
}
