package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.Column;
import com.oziriuz.concretecom.model.annotations.Entity;
import com.oziriuz.concretecom.model.annotations.Id;
import com.oziriuz.concretecom.model.annotations.Unique;

@Entity("drivers")
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

    public Driver() {
    }

    public Driver(String name, String capacityVehicle, String modelVehicle, String phone, String note, boolean isVisible) {
        this.name = name;
        this.capacityVehicle = capacityVehicle;
        this.modelVehicle = modelVehicle;
        this.phone = phone;
        this.note = note;
        this.isVisible = isVisible;
    }
}
