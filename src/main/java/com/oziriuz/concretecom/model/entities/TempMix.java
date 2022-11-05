package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.Column;
import com.oziriuz.concretecom.model.annotations.Entity;
import com.oziriuz.concretecom.model.annotations.Id;
import com.oziriuz.concretecom.model.annotations.Unique;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity("tempmix_bc1")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class TempMix {
    @Id
    @Column("mix_id")
    private long id;

    @Unique
    @Column("exp_id")
    private long expedtionId;

    @Column("ordered_q")
    private String orderedQuantity;

    @Column("real_q")
    private String realQuantity;

    @Column("total_kg_temp")
    private String totalWeight;
}
