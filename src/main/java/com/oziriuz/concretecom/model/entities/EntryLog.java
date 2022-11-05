package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity("entry_log")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EntryLog {
    @Id
    @Column("log_num")
    protected long id;

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
}
