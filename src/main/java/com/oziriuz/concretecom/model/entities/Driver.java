package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity("drivers")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Driver {
    @Id
    @Column("d_num")
    private long id;

    @Unique
    @Column("d_name")
    private String name;

    @Column("d_reg")
    private String registrationPlate;
    @Column("d_cap")
    String capacityVehicle;

    @Column("d_mod")
    String modelVehicle;

    @Column("d_tel")
    String phone;

    @Column("d_note")
    String note;

    @Column("d_show")
    boolean isVisible = true;
}
