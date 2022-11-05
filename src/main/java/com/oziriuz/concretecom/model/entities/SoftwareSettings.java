package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.Column;
import com.oziriuz.concretecom.model.annotations.Entity;
import com.oziriuz.concretecom.model.annotations.Id;
import com.oziriuz.concretecom.model.annotations.Unique;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity("settings_soft")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class SoftwareSettings {
    @Id
    @Column("ind")
    private long id;

    @Unique
    @Column("parameter")
    private String parameter;

    @Column("value")
    private String value;
}
