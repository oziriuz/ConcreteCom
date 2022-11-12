package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity("suppliers")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Supplier {
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

    @Column("s_note")
    String note;

    @Column("s_show")
    boolean isVisible = true;
}
