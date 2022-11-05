package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity("worksites")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Worksite {
    @Id
    @Column("w_num")
    private long id;

    @Column("w_cnum")
    private long clientId;

    @Column("w_name")
    private String name;

    @Column("w_km")
    private String distance;

    @Column("w_show")
    private boolean isVisible = true;
}
