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
public class AchInventaireLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "invligId can not null")
    private Long invligId;


    /**
     * code produit
     */
    private String invligCode;


    /**
     * code depot
     */
    private String invligDepot;


    /**
     * famille produit
     */
    private String invligFamille;


    /**
     * libelle produit
     */
    private String invligLibelle;


    /**
     * reference produit
     */
    private String invligReference;


    /**
     * unite produit
     */
    private String invligUnite;


    /**
     * conditionnement produit
     */
    private String invligCondition;


    /**
     * quantite
     */
    private Float invligQte;


    /**
     * quantite
     */
    private String invligCasier;


    /**
     * longueur
     */
    private Float invligLong;


    /**
     * largeur
     */
    private Float invligLarg;


    /**
     * hauteur
     */
    private Float invligHaut;


    /**
     * diametre
     */
    private Float invligDiam;


    /**
     * nombre de piece
     */
    private Float invligNb;


    /**
     * poids net
     */
    private Float invligPoidsnet;


    /**
     * poids brut
     */
    private Float invligPoidsbrut;


    /**
     * volume
     */
    private Float invligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float invligQteUtil;


    /**
     * mode gestion en stock
     */
    private Integer invligStock;


    /**
     * quantite en stock
     */
    private Float invligQteStock;


    /**
     * pump
     */
    private Double invligPump;


    /**
     * total pump
     */
    private Double invligTotal;


    /**
     * obsrvations
     */
    private String invligObs;


    /**
     * false si pas bon true si bon
     */
    private Boolean invligValide;

    @NotNull(message = "invId can not null")
    private Long invId;


    /**
     * description conditionnement produit
     */
    private String invligDescription;

}
