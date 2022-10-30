package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;

import java.time.LocalDate;

@Entity("deliveries")
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
    private LocalDate dateStamp = LocalDate.now();

    @Column("del_q")
    private String quantity;

    @Column("del_op")
    private String operator;

    public Delivery() {
    }

    public Delivery(String material, String supplierName, String supplierVATNumber,
                    String documentType, String documentNumber, String date,
                    LocalDate dateStamp, String quantity, String operator) {
        this.material = material;
        this.supplierName = supplierName;
        this.supplierVATNumber = supplierVATNumber;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.date = date;
        this.dateStamp = dateStamp;
        this.quantity = quantity;
        this.operator = operator;
    }
}
