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
public class AchBonSortieLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "bouligId can not null")
    private Long bouligId;


    /**
     * code produit
     */
    private String bouligCode;


    /**
     * code depot
     */
    private String bouligDepot;


    /**
     * famille produit
     */
    private String bouligFamille;


    /**
     * libelle produit
     */
    private String bouligLibelle;


    /**
     * reference produit
     */
    private String bouligReference;


    /**
     * unite produit
     */
    private String bouligUnite;


    /**
     * conditionnement produit
     */
    private String bouligCondition;


    /**
     * quantite
     */
    private Float bouligQte;


    /**
     * quantite
     */
    private String bouligCasier;


    /**
     * longueur
     */
    private Float bouligLong;


    /**
     * largeur
     */
    private Float bouligLarg;


    /**
     * hauteur
     */
    private Float bouligHaut;


    /**
     * diametre
     */
    private Float bouligDiam;


    /**
     * nombre de piece
     */
    private Float bouligNb;


    /**
     * poids net
     */
    private Float bouligPoidsnet;


    /**
     * poids brut
     */
    private Float bouligPoidsbrut;


    /**
     * volume
     */
    private Float bouligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float bouligQteUtil;


    /**
     * mode gestion en stock
     */
    private Integer bouligStock;


    /**
     * quantite en stock
     */
    private Float bouligQteStock;


    /**
     * pump
     */
    private Double bouligPump;


    /**
     * total pump
     */
    private Double bouligTotal;


    /**
     * obsrvations
     */
    private String bouligObs;

    @NotNull(message = "bouId can not null")
    private Long bouId;


    /**
     * description conditionnement produit
     */
    private String bouligDescription;

}
