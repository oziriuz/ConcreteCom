package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity("deliveries")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Delivery {
    @Id
    @Column("del_num")
    private long id;

    @Column("del_mat")
    private String material;

    @Column("del_sup_name")
    private String supplierName;

    @Column("del_sup_bg")
    private String supplierVATNumber;

    @Column("del_doc_type")
    private String documentType;

    @Column("del_doc_num")
    private String documentNumber;

    @Column("del_date")
    private String date;

    @Column("stamp_date")
    private LocalDate dateStamp;

    @Column("del_q")
    private String quantity;

    @Column("del_op")
    private String operator;
}
