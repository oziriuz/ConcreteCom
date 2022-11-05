package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.Column;
import com.oziriuz.concretecom.model.annotations.Entity;
import com.oziriuz.concretecom.model.annotations.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity("orders")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Order {
    @Id
    @Column("order_num")
    private long id;

    @Column("order_date")
    private String dateIssuedStr;

    @Column("order_date_que")
    private String dueDateStr;

    @Column("stamp_date")
    private LocalDate dueDate;

    @Column("order_q")
    private String quantityOrdered;

    @Column("order_qmade")
    private String quantityProduced;

    @Column("order_rec")
    private long recipeId;

    @Column("order_rec_name")
    private String recipeName;

    @Column("order_rec_class")
    private String recipeClass;

    @Column("order_clnt")
    private long clientId;

    @Column("order_clnt_name")
    private String clientName;

    @Column("order_clnt_obj")
    private String worksite;
}
