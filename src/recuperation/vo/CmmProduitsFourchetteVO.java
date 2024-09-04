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
public class CmmProduitsFourchetteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "profchId can not null")
    private Long profchId;


    /**
     * 0=femme 1=homme 2=tout
     */
    private Integer profchSexe;


    /**
     * 0=sans filtre 1=age en annee 2=age en mois 3=age en jour
     */
    private Integer profchAge;


    /**
     * fourchette age debut
     */
    private Float profchAgeDebut;


    /**
     * fourchette age fin
     */
    private Float profchAgeFin;


    /**
     * fourchette minimale
     */
    private Float profchFmini;


    /**
     * fourchette maximale
     */
    private Float profchFmaxi;


    /**
     * limite minimale
     */
    private Float profchLmini;


    /**
     * limite maximale
     */
    private Float profchLmaxi;


    /**
     * normes dynamiques
     */
    private String profchNorme;

    private Long prolabId;

    private Long prodetId;

    @NotNull(message = "proId can not null")
    private Long proId;


    /**
     * code produit
     */
    private String profchCode;

}
