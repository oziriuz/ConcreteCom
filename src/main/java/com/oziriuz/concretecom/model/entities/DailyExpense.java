package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity("daily_expenses")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DailyExpense {
    @Id
    @Column("row_num")
    private long id;

    @Column("mat_name")
    private String name;

    @Column("mat_sold")
    private String sold;

    @Column("date_sold")
    private String dateSold;

    @Column("stamp_date")
    private LocalDate dateStamp;
}
