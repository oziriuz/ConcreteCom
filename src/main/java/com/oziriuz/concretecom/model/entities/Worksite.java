package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;

@Entity("worksites")
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

    public Worksite() {
    }

    public Worksite(long clientId, String name, String distance, boolean isVisible) {
        this.clientId = clientId;
        this.name = name;
        this.distance = distance;
        this.isVisible = isVisible;
    }
}
