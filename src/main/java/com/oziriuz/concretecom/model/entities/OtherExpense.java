package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.Column;
import com.oziriuz.concretecom.model.annotations.Entity;
import com.oziriuz.concretecom.model.annotations.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity("other_expen")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class OtherExpense {
    @Id
    @Column("row_num")
    private long id;

    @Column("other_matname")
    private String name;

    @Column("other_matexp")
    private String expense;

    @Column("other_op")
    private String operatorName;

    @Column("other_date")
    private String dateStr;
}
