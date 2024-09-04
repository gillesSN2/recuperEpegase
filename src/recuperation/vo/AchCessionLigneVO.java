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
public class AchCessionLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "cesligId can not null")
    private Long cesligId;


    /**
     * code produit
     */
    private String cesligCode;


    /**
     * code depot origine
     */
    private String cesligDepotOrigine;


    /**
     * code depot destination
     */
    private String cesligDepotDestination;


    /**
     * famille produit
     */
    private String cesligFamille;


    /**
     * libelle produit
     */
    private String cesligLibelle;


    /**
     * reference produit
     */
    private String cesligReference;


    /**
     * unite produit
     */
    private String cesligUnite;


    /**
     * conditionnement produit
     */
    private String cesligCondition;


    /**
     * quantite origine
     */
    private Float cesligQte;


    /**
     * casier origine
     */
    private String cesligCasierOrigine;


    /**
     * casier destination
     */
    private String cesligCasierDestination;


    /**
     * longueur
     */
    private Float cesligLong;


    /**
     * largeur
     */
    private Float cesligLarg;


    /**
     * hauteur
     */
    private Float cesligHaut;


    /**
     * diametre
     */
    private Float cesligDiam;


    /**
     * nombre de piece
     */
    private Float cesligNb;


    /**
     * poids net
     */
    private Float cesligPoidsnet;


    /**
     * poids brut
     */
    private Float cesligPoidsbrut;


    /**
     * volume
     */
    private Float cesligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float cesligQteUtil;


    /**
     * mode gestion en stock
     */
    private Integer cesligStock;


    /**
     * quantite en stock
     */
    private Float cesligQteStock;


    /**
     * pump
     */
    private Double cesligPump;


    /**
     * total pump
     */
    private Double cesligTotal;


    /**
     * obsrvations
     */
    private String cesligObs;

    @NotNull(message = "cesId can not null")
    private Long cesId;


    /**
     * code sommier sortie
     */
    private String cesligSommier;


    /**
     * description conditionnement produit
     */
    private String cesligDescription;

}
