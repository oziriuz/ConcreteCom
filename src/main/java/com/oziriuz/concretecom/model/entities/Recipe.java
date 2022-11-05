package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.Column;
import com.oziriuz.concretecom.model.annotations.Entity;
import com.oziriuz.concretecom.model.annotations.Id;
import com.oziriuz.concretecom.model.annotations.Unique;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity("recepies")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Recipe {
    @Id
    @Column("r_num")
    private long id;

    @Unique
    @Column("r_name")
    private String name;

    @Column("r_type")
    private String type;

    @Column("r_class")
    private String hardness;

    @Column("r_classk")
    private String consistency;

    @Column("r_classv")
    private String exposure;

    @Column("r_classh")
    private String chloride;

    @Column("r_classp")
    private String density;

    @Column("r_edm")
    private String maxSizeAgg;

    @Column("r_tpour")
    private String timeForPouring;

    @Column("r_tmix")
    private String timeForMixing;

    @Column("init_im1")
    private String idAggregates1;

    @Column("kg_im1")
    private String kgAggregates1;

    @Column("init_im2")
    private String idAggregates2;

    @Column("kg_im2")
    private String kgAggregates2;

    @Column("init_im3")
    private String idAggregates3;

    @Column("kg_im3")
    private String kgAggregates3;

    @Column("init_im4")
    private String idAggregates4;

    @Column("kg_im4")
    private String kgAggregates4;

    @Column("init_im5")
    private String idAggregates5;

    @Column("kg_im5")
    private String kgAggregates5;

    @Column("init_im6")
    private String idAggregates6;

    @Column("kg_im6")
    private String kgAggregates6;

    @Column("init_scr1")
    private String idCement1;

    @Column("kg_scr1")
    private String kgCement1;

    @Column("init_scr2")
    private String idCement2;

    @Column("kg_scr2")
    private String kgCement2;

    @Column("init_scr3")
    private String idCement3;

    @Column("kg_scr3")
    private String kgCement3;

    @Column("init_scr4")
    private String idCement4;

    @Column("kg_scr4")
    private String kgCement4;

    @Column("init_wat1")
    private String idWater1;

    @Column("kg_wat1")
    private String kgWater1;

    @Column("init_wat2")
    private String idWater2;

    @Column("kg_wat2")
    private String kgWater2;

    @Column("init_chem1")
    private String idAdditive1;

    @Column("kg_chem1")
    private String kgAdditive1;

    @Column("init_chem2")
    private String idAdditive2;

    @Column("kg_chem2")
    private String kgAdditive2;

    @Column("init_chem3")
    private String idAdditive3;

    @Column("kg_chem3")
    private String kgAdditive3;

    @Column("init_chem4")
    private String idAdditive4;

    @Column("kg_chem4")
    private String kgAdditive4;

    @Column("init_chem5")
    private String idAdditive5;

    @Column("kg_chem5")
    private String kgAdditive5;

    @Column("init_chem6")
    private String idAdditive6;

    @Column("kg_chem6")
    private String kgAdditive6;

    @Column("kg_total")
    private String totalWeight;

    @Column("r_show")
    private boolean isVisible;
}
