package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;

@Entity("clients")
public class Client{
    @Id
    @Column("c_num")
    private long id;

    @Unique
    @Column("c_name")
    private String name;

    @Column("c_bg")
    String VATNumber;

    @Column("c_mol")
    String accountablePerson;

    @Column("c_add")
    String address;

    @Column("c_tel")
    String phone;

    @Column("c_show")
    boolean isVisible = true;

    public Client() {
    }

    public Client(String name, String VATNumber, String accountablePerson, String address, String phone, boolean isVisible) {
        this.name = name;
        this.VATNumber = VATNumber;
        this.accountablePerson = accountablePerson;
        this.address = address;
        this.phone = phone;
        this.isVisible = isVisible;
    }
}
