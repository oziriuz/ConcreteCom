package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;

@Entity("admin_data")
public class Administrator{
    @Id
    @Column("a_num" )
    private long id;

    @Unique
    @Column("a_name")
    private String name;

    @Column("a_pass")
    private String password;

    public Administrator() {
    }

    public Administrator(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
