package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class AchFamillesProduitsAchatsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "famachId can not null")
    private Long famachId;


    /**
     * date de creation
     */
    private LocalDateTime famachDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime famachDateModif;


    /**
     * utilisateur de creation
     */
    private Long famachUserCreation;


    /**
     * utilisateur de modification
     */
    private Long famachUserModif;


    /**
     * code famille
     */
    private String famachCode;


    /**
     * nom du suivi en FR
     */
    private String famachLibelleFr;


    /**
     * nom du suivi en UK
     */
    private String famachLibelleUk;


    /**
     * nom du suivi en SP
     */
    private String famachLibelleSp;


    /**
     * code taxe achat
     */
    private String famachTaxe;


    /**
     * code douane
     */
    private String famachDouane;


    /**
     * compte local
     */
    private String famachCompteLocal;


    /**
     * compte dans la zone
     */
    private String famachCompteZone;


    /**
     * compte exterieur
     */
    private String famachCompteExterieur;


    /**
     * compte stock
     */
    private String famachCompteStock;


    /**
     * compte charge
     */
    private String famachCompteCharge;


    /**
     * 0=sans stock 1=simple 2=lifo 3=fifo 4=peremption 5=serialise 6=consigne 7=debours
     */
    private Integer famachStock;


    /**
     * 0=standard 1=production 2=consommable 3=services 4=immobilisation 90=famille
     */
    private Integer famachCat;


    /**
     * position du fichier xml
     */
    private String famachNature;


    /**
     * libelle nature
     */
    private String famachLibNature;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer famachInactif;


    /**
     * analytique 2
     */
    private String famachAnal2;


    /**
     * analytique 4
     */
    private String famachAnal4;


    /**
     * budget
     */
    private String famachBudget;


    /**
     * activite
     */
    private String famachActivite;


    /**
     * code depot achat
     */
    private String famachDepotAch;


    /**
     * code depot production
     */
    private String famachDepotPrd;


    /**
     * code service achat
     */
    private String famachService;


    /**
     * cle 1 de repartition
     */
    private String famachCle1;


    /**
     * cle 2 de repartition
     */
    private String famachCle2;


    /**
     * marque
     */
    private String famachMarque;


    /**
     * unite de stockage
     */
    private String famachUnite;


    /**
     * valeur unite de stockage
     */
    private Integer famachEchelle;


    /**
     * conditionnement 1
     */
    private String famachCondition1;


    /**
     * conditionnement 2
     */
    private String famachCondition2;


    /**
     * conditionnement 3
     */
    private String famachCondition3;


    /**
     * conditionnement 4
     */
    private String famachCondition4;


    /**
     * conditionnement 5
     */
    private String famachCondition5;

    @NotNull(message = "exeachId can not null")
    private Long exeachId;


    /**
     * coefficient valorisation par defaut
     */
    private Float famachCoefValDefaut;


    /**
     * compte acht en cours
     */
    private String famachCompteEncours;


    /**
     * coefficient de prg
     */
    private Float famachCoefPrg;


    /**
     * coefficient entrepot fictif
     */
    private Float famachCoefFictif;


    /**
     * famille liee avec les ventes
     */
    private Boolean famachLieeVte;

}
