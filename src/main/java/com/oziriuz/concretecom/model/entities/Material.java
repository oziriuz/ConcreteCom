package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity("materials_bc1")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Material {
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
}
