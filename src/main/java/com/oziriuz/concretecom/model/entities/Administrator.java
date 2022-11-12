package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity("admin_data")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Administrator {
    @Id
    @Column("a_num")
    private long id;

    @Unique
    @Column("a_name")
    private String name;

    @Column("a_pass")
    private String password;
}
