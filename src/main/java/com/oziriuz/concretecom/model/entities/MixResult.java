package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity("mix_result_bc1")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MixResult {
    @Id
    @Column("mix_num")
    private long id;

    @Column("exp_num")
    private String expedition;

    @Column("time_exp_start")
    private String timeExpeditionStartStr;

    @Column("time_mix_ready")
    private String timeExpeditionReadyStr;

    @Column("stamp_date")
    private LocalDate dateStamp;

    @Column("name_op")
    private String operator;

    @Column("ord_num")
    private long orderNumber;

    @Column("ord_date")
    private String orderDateStr;

    @Column("ord_q")
    private String orderQuantity;

    @Column("exp_q")
    private String expeditionQuantity;

    @Column("exp_ord_num")
    private long expeditionOrderNumber;

    @Column("mix_ord_num")
    private long mixerOrderNumber;

    @Column("name_clnt")
    private String clientName;

    @Column("bg_clnt")
    private String clientVATNumber;

    @Column("obj_clnt")
    private String clientWorksite;

    @Column("km_clnt")
    private String worksiteDistance;

    @Column("name_drv")
    private String driverName;

    @Column("reg_drv")
    private String driverRegistrationPlate;

    @Column("cap_drv")
    private String vehicleCapacity;
    //  name_rec text,
    @Column("name_rec")
    private String recipeName;

    @Column("type_rec")
    private String recipeType;

    @Column("class_rec")
    private String recipeHardness;

    @Column("classk_rec")
    private String recipeConsistency;

    @Column("classv_rec")
    private String recipeExposure;

    @Column("classh_rec")
    private String recipeChloride;

    @Column("classp_rec")
    private String recipeDensity;

    @Column("edm_rec")
    private String recipeMaxSizeAgg;

    @Column("im1_name")
    private String aggregates1Name;

    @Column("im1z")
    private String aggregates1Recipe;

    @Column("im1i")
    private String aggregates1Measured;

    @Column("im2_name")
    private String aggregates2Name;

    @Column("im2z")
    private String aggregates2Recipe;

    @Column("im2i")
    private String aggregates2Measured;

    @Column("im3_name")
    private String aggregates3Name;

    @Column("im3z")
    private String aggregates3Recipe;

    @Column("im3i")
    private String aggregates3Measured;

    @Column("im4_name")
    private String aggregates4Name;

    @Column("im4z")
    private String aggregates4Recipe;

    @Column("im4i")
    private String aggregates4Measured;

    @Column("im5_name")
    private String aggregates5Name;

    @Column("im5z")
    private String aggregates5Recipe;

    @Column("im5i")
    private String aggregates5Measured;

    @Column("im6_name")
    private String aggregates6Name;

    @Column("im6z")
    private String aggregates6Recipe;

    @Column("im6i")
    private String aggregates6Measured;

    @Column("cem1_name")
    private String cement1Name;

    @Column("cem1z")
    private String cement1Recipe;

    @Column("cem1i")
    private String cement1Measured;

    @Column("cem2_name")
    private String cement2Name;

    @Column("cem2z")
    private String cement2Recipe;

    @Column("cem2i")
    private String cement2Measured;

    @Column("cem3_name")
    private String cement3Name;

    @Column("cem3z")
    private String cement3Recipe;

    @Column("cem3i")
    private String cement3Measured;

    @Column("cem4_name")
    private String cement4Name;

    @Column("cem4z")
    private String cement4Recipe;

    @Column("cem4i")
    private String cement4Measured;

    @Column("wat1_name")
    private String water1Name;

    @Column("wat1z")
    private String water1Recipe;

    @Column("wat1i")
    private String water1Measured;

    @Column("wat2_name")
    private String water2Name;

    @Column("wat2z")
    private String water2Recipe;

    @Column("wat2i")
    private String water2Measured;

    @Column("chem1_name")
    private String additive1Name;

    @Column("chem1z")
    private String additive1Recipe;

    @Column("chem1i")
    private String additive1Measured;

    @Column("chem2_name")
    private String additive2Name;

    @Column("chem2z")
    private String additive2Recipe;

    @Column("chem2i")
    private String additive2Measured;

    @Column("chem3_name")
    private String additive3Name;

    @Column("chem3z")
    private String additive3Recipe;

    @Column("chem3i")
    private String additive3Measured;

    @Column("chem4_name")
    private String additive4Name;

    @Column("chem4z")
    private String additive4Recipe;

    @Column("chem4i")
    private String additive4Measured;

    @Column("chem5_name")
    private String additive5Name;

    @Column("chem5z")
    private String additive5Recipe;

    @Column("chem5i")
    private String additive5Measured;

    @Column("chem6_name")
    private String additive6Name;

    @Column("chem6z")
    private String additive6Recipe;

    @Column("chem6i")
    private String additive6Measured;

    @Column("total_rec_kg")
    private String totalRecipeWeight;

    @Column("total_real_kg")
    private String totalMeasuredWeight;

    @Column("total_vol")
    private String totalVolume;

    @Column("avstat")
    private boolean showRealVolume;
}
