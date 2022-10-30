package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;

import java.time.LocalDate;

@Entity("daily_expenses")
public class DailyExpenses {
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
    private LocalDate dateStamp = LocalDate.now();

    public DailyExpenses() {
    }

    public DailyExpenses(String name, String sold, String dateSold, LocalDate dateStamp) {
        this.name = name;
        this.sold = sold;
        this.dateSold = dateSold;
        this.dateStamp = dateStamp;
    }
}
