package com.oziriuz.concretecom.model.entities;

import com.oziriuz.concretecom.model.annotations.*;

import java.time.LocalDate;

@Entity("mix_result_bc1")
public class MixResults2 {
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
    private String recipeClass;

    @Column("class_rec")
    private String recipeHardness;

    @Column("classv_rec")
    private String recipeConsistency;

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

    public MixResults2() {
    }

    public MixResults2(String expedition, String timeExpeditionStartStr, String timeExpeditionReadyStr,
                       LocalDate dateStamp, String operator, long orderNumber, String orderDateStr,
                       String orderQuantity, String expeditionQuantity, long expeditionOrderNumber,
                       long mixerOrderNumber, String clientName, String clientVATNumber, String clientWorksite,
                       String worksiteDistance, String driverName, String driverRegistrationPlate,
                       String vehicleCapacity, String recipeName, String recipeType, String recipeClass,
                       String recipeHardness, String recipeConsistency, String recipeChloride,
                       String recipeDensity, String recipeMaxSizeAgg, String aggregates1Name,
                       String aggregates1Recipe, String aggregates1Measured, String aggregates2Name,
                       String aggregates2Recipe, String aggregates2Measured, String aggregates3Name,
                       String aggregates3Recipe, String aggregates3Measured, String aggregates4Name,
                       String aggregates4Recipe, String aggregates4Measured, String aggregates5Name,
                       String aggregates5Recipe, String aggregates5Measured, String aggregates6Name,
                       String aggregates6Recipe, String aggregates6Measured, String cement1Name,
                       String cement1Recipe, String cement1Measured, String cement2Name,
                       String cement2Recipe, String cement2Measured, String cement3Name,
                       String cement3Recipe, String cement3Measured, String cement4Name,
                       String cement4Recipe, String cement4Measured, String water1Name,
                       String water1Recipe, String water1Measured, String water2Name,
                       String water2Recipe, String water2Measured, String additive1Name,
                       String additive1Recipe, String additive1Measured, String additive2Name,
                       String additive2Recipe, String additive2Measured, String additive3Name,
                       String additive3Recipe, String additive3Measured, String additive4Name,
                       String additive4Recipe, String additive4Measured, String additive5Name,
                       String additive5Recipe, String additive5Measured, String additive6Name,
                       String additive6Recipe, String additive6Measured, String totalRecipeWeight,
                       String totalMeasuredWeight, String totalVolume, boolean showRealVolume) {
        this.expedition = expedition;
        this.timeExpeditionStartStr = timeExpeditionStartStr;
        this.timeExpeditionReadyStr = timeExpeditionReadyStr;
        this.dateStamp = dateStamp;
        this.operator = operator;
        this.orderNumber = orderNumber;
        this.orderDateStr = orderDateStr;
        this.orderQuantity = orderQuantity;
        this.expeditionQuantity = expeditionQuantity;
        this.expeditionOrderNumber = expeditionOrderNumber;
        this.mixerOrderNumber = mixerOrderNumber;
        this.clientName = clientName;
        this.clientVATNumber = clientVATNumber;
        this.clientWorksite = clientWorksite;
        this.worksiteDistance = worksiteDistance;
        this.driverName = driverName;
        this.driverRegistrationPlate = driverRegistrationPlate;
        this.vehicleCapacity = vehicleCapacity;
        this.recipeName = recipeName;
        this.recipeType = recipeType;
        this.recipeClass = recipeClass;
        this.recipeHardness = recipeHardness;
        this.recipeConsistency = recipeConsistency;
        this.recipeChloride = recipeChloride;
        this.recipeDensity = recipeDensity;
        this.recipeMaxSizeAgg = recipeMaxSizeAgg;
        this.aggregates1Name = aggregates1Name;
        this.aggregates1Recipe = aggregates1Recipe;
        this.aggregates1Measured = aggregates1Measured;
        this.aggregates2Name = aggregates2Name;
        this.aggregates2Recipe = aggregates2Recipe;
        this.aggregates2Measured = aggregates2Measured;
        this.aggregates3Name = aggregates3Name;
        this.aggregates3Recipe = aggregates3Recipe;
        this.aggregates3Measured = aggregates3Measured;
        this.aggregates4Name = aggregates4Name;
        this.aggregates4Recipe = aggregates4Recipe;
        this.aggregates4Measured = aggregates4Measured;
        this.aggregates5Name = aggregates5Name;
        this.aggregates5Recipe = aggregates5Recipe;
        this.aggregates5Measured = aggregates5Measured;
        this.aggregates6Name = aggregates6Name;
        this.aggregates6Recipe = aggregates6Recipe;
        this.aggregates6Measured = aggregates6Measured;
        this.cement1Name = cement1Name;
        this.cement1Recipe = cement1Recipe;
        this.cement1Measured = cement1Measured;
        this.cement2Name = cement2Name;
        this.cement2Recipe = cement2Recipe;
        this.cement2Measured = cement2Measured;
        this.cement3Name = cement3Name;
        this.cement3Recipe = cement3Recipe;
        this.cement3Measured = cement3Measured;
        this.cement4Name = cement4Name;
        this.cement4Recipe = cement4Recipe;
        this.cement4Measured = cement4Measured;
        this.water1Name = water1Name;
        this.water1Recipe = water1Recipe;
        this.water1Measured = water1Measured;
        this.water2Name = water2Name;
        this.water2Recipe = water2Recipe;
        this.water2Measured = water2Measured;
        this.additive1Name = additive1Name;
        this.additive1Recipe = additive1Recipe;
        this.additive1Measured = additive1Measured;
        this.additive2Name = additive2Name;
        this.additive2Recipe = additive2Recipe;
        this.additive2Measured = additive2Measured;
        this.additive3Name = additive3Name;
        this.additive3Recipe = additive3Recipe;
        this.additive3Measured = additive3Measured;
        this.additive4Name = additive4Name;
        this.additive4Recipe = additive4Recipe;
        this.additive4Measured = additive4Measured;
        this.additive5Name = additive5Name;
        this.additive5Recipe = additive5Recipe;
        this.additive5Measured = additive5Measured;
        this.additive6Name = additive6Name;
        this.additive6Recipe = additive6Recipe;
        this.additive6Measured = additive6Measured;
        this.totalRecipeWeight = totalRecipeWeight;
        this.totalMeasuredWeight = totalMeasuredWeight;
        this.totalVolume = totalVolume;
        this.showRealVolume = showRealVolume;
    }
}
