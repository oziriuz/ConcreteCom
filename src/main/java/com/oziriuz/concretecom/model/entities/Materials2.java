package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;

@Entity("materials_bc2")
public class Materials2 {
    @Id
    @Column("m_num")
    private long id;

    @Unique
    @Column("m_name")
    private String name;

    @Column("m_type")
    private String type;

    @Column("m_load")
    private String loaded;

    @Column("m_del")
    private String delivered;

    @Column("m_sold")
    private String sold;

    @Column("m_humidity")
    private String humidity;

    public Materials2() {
    }

    public Materials2(String name, String type, String loaded, String delivered, String sold, String humidity) {
        this.name = name;
        this.type = type;
        this.loaded = loaded;
        this.delivered = delivered;
        this.sold = sold;
        this.humidity = humidity;
    }
}
