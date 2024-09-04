package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class AchFabricationLigneAchatsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "fabligId can not null")
    private Long fabligId;


    /**
     * code produit
     */
    private String fabligCode;


    /**
     * code depot
     */
    private String fabligDepot;


    /**
     * famille produit
     */
    private String fabligFamille;


    /**
     * libelle produit
     */
    private String fabligLibelle;


    /**
     * reference produit
     */
    private String fabligReference;


    /**
     * unite produit
     */
    private String fabligUnite;


    /**
     * conditionnement produit
     */
    private String fabligCondition;


    /**
     * description conditionnement produit
     */
    private String fabligDescription;


    /**
     * quantite
     */
    private Float fabligQte;


    /**
     * quantite
     */
    private String fabligCasier;


    /**
     * longueur
     */
    private Float fabligLong;


    /**
     * largeur
     */
    private Float fabligLarg;


    /**
     * hauteur
     */
    private Float fabligHaut;


    /**
     * diametre
     */
    private Float fabligDiam;


    /**
     * nombre de piece
     */
    private Float fabligNb;


    /**
     * poids net
     */
    private Float fabligPoidsnet;


    /**
     * poids brut
     */
    private Float fabligPoidsbrut;


    /**
     * volume
     */
    private Float fabligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float fabligQteUtil;


    /**
     * mode gestion en stock
     */
    private Integer fabligStock;


    /**
     * quantite en stock
     */
    private Float fabligQteStock;


    /**
     * pump
     */
    private Double fabligPump;


    /**
     * total pump
     */
    private Double fabligTotal;


    /**
     * obsrvations
     */
    private String fabligObs;

    @NotNull(message = "fabId can not null")
    private Long fabId;

}
