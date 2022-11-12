package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity("clients")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Client {
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
}
