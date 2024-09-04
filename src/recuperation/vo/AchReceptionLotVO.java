package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

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
public class AchReceptionLotVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "reclotId can not null")
    private Long reclotId;


    /**
     * id ligne de reception
     */
    private Long reclotIdLigne;


    /**
     * numero de reception
     */
    private String reclotNum;


    /**
     * date achat
     */
    private LocalDate reclotDateAchat;


    /**
     * valable jusqu au
     */
    private LocalDate reclotDateValable;


    /**
     * quantite du lot
     */
    private Float reclotQte;


    /**
     * quantite pour le stock
     */
    private Float reclotQteUtil;


    /**
     * quantite consommee
     */
    private Float reclotQteConso;


    /**
     * quantite consomme pour le stock
     */
    private Float reclotQteUtilConso;


    /**
     * code produit
     */
    private String reclotCode;


    /**
     * code depot
     */
    private String reclotDepot;


    /**
     * prix de revient
     */
    private Double reclotPr;


    /**
     * longueur
     */
    private Float reclotLong;


    /**
     * largeur
     */
    private Float reclotLarg;


    /**
     * hauteur
     */
    private Float reclotHaut;


    /**
     * diametre
     */
    private Float reclotDiam;


    /**
     * nombre de piece
     */
    private Float reclotNb;


    /**
     * poids net
     */
    private Float reclotPoidsnet;


    /**
     * poids tare
     */
    private Float reclotPoidstare;


    /**
     * poids brut
     */
    private Float reclotPoidsbrut;


    /**
     * numero du lot
     */
    private String reclotNumero;

}
