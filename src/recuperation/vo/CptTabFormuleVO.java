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
public class CptTabFormuleVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "tabforId can not null")
    private Long tabforId;


    /**
     * numero de colonne
     */
    private Integer tabforCol;


    /**
     * nom de la zone
     */
    private String tabforZone;


    /**
     * contenu de la formule
     */
    private String tabforFormule;


    /**
     * filtre analytique
     */
    private String tabforAnalytique;


    /**
     * filtre budget
     */
    private String tabforBudget;


    /**
     * 0=tout solde 1=solde crediteur 2=solde debiteur 3=mvts debiteur 4=mvts crediteur 5=saisie numerique 6=saisie texte 7=saisie liste
     */
    private Integer tabforSolde;


    /**
     * periode prioritaire par rapport ÃƒÂ  la periode de la colonne
     */
    private Integer tabforPeriode;


    /**
     * 0=actif 1=inactif
     */
    private Integer tabforInactif;


    /**
     * l ancien id cle etrangere
     */
    private Long tabforOldId;

    @NotNull(message = "tabeleId can not null")
    private Long tabeleId;


    /**
     * filtre site
     */
    private String tabforSite;


    /**
     * filtre departement
     */
    private String tabforDepartement;


    /**
     * filtre service
     */
    private String tabforService;


    /**
     * filtre region
     */
    private String tabforRegion;


    /**
     * filtre secteur
     */
    private String tabforSecteur;


    /**
     * filtre pdv
     */
    private String tabforPdv;


    /**
     * filtre activite
     */
    private String tabforActivite;


    /**
     * filtre dossier
     */
    private String tabforDossier;


    /**
     * filtre parc
     */
    private String tabforParc;

}
