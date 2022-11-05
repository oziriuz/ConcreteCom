package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.Column;
import com.oziriuz.concretecom.model.annotations.Entity;
import com.oziriuz.concretecom.model.annotations.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity("revision")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Revision {
    @Id
    @Column("row_num")
    private long id;

    @Column("rev_num")
    private long number;

    @Column("rev_matname")
    private String materialName;

    @Column("rev_matqold")
    private String oldQuantity;

    @Column("rev_matqnew")
    private String newdQuantity;

    @Column("rev_op")
    private String operatorName;

    @Column("rev_supervisor")
    private boolean isSupervisor;

    @Column("rev_date")
    private String dateStr;

    @Column("stamp_date")
    private LocalDate date;
}
