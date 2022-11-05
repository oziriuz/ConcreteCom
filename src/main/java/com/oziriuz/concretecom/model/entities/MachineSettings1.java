package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.Column;
import com.oziriuz.concretecom.model.annotations.Entity;
import com.oziriuz.concretecom.model.annotations.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity("settings_bc1")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MachineSettings1 {
    @Id
    @Column("ind")
    private long id;

    @Column("im_num")
    private String numberOfAggregates;

    @Column("cem_num")
    private String numberOfSilos;

    @Column("wat_num")
    private String numberOfWaterSupplies;

    @Column("chem_num")
    private String numberOfAdditives;

    @Column("work_permission")
    private String workPermission;

    @Column("stamp_date")
    private LocalDate date;
}
