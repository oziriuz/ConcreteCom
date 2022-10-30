package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;

@Entity("suppliers")
public class Supplier{
    @Id
    @Column("s_num")
    private long id;

    @Unique
    @Column("s_name")
    private String name;

    @Column("s_bg")
    String VATNumber;

    @Column("s_mol")
    String accountablePerson;

    @Column("s_add")
    String address;

    @Column("s_tel")
    String phone;

    @Column("s_show")
    boolean isVisible = true;

    public Supplier() {
    }

    public Supplier(String name, String VATNumber, String accountablePerson, String address, String phone, boolean isVisible) {
        this.name = name;
        this.VATNumber = VATNumber;
        this.accountablePerson = accountablePerson;
        this.address = address;
        this.phone = phone;
        this.isVisible = isVisible;
    }
}
