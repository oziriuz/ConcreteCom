package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.Column;
import com.oziriuz.concretecom.model.annotations.Entity;
import com.oziriuz.concretecom.model.annotations.Id;

import java.time.LocalDate;

@Entity("entry_log")
public class EntryLog1 {
    @Id
    @Column("log_num")
    private long id;

    @Column("log_name")
    private String name;

    @Column("log_enter_date")
    private LocalDate dateEnter;

    @Column("log_enter")
    private String dateEnterStr;

    @Column("log_exit_date")
    private LocalDate dateExit;

    @Column("log_exit")
    private String dateExitStr;

    public EntryLog1() {
    }

    public EntryLog1(String name, LocalDate dateEnter, String dateEnterStr, LocalDate dateExit, String dateExitStr) {
        this.name = name;
        this.dateEnter = dateEnter;
        this.dateEnterStr = dateEnterStr;
        this.dateExit = dateExit;
        this.dateExitStr = dateExitStr;
    }
}
