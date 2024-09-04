package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
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
public class CaiBonSortieVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "sortId can not null")
    private Long sortId;


    /**
     * concactenation du numero et de la nature
     */
    private String sortCle;


    /**
     * date de creation
     */
    private LocalDateTime sortDateCreat;


    /**
     * user de creation
     */
    private Long sortUserCreat;


    /**
     * date de modification
     */
    private LocalDateTime sortDateModif;


    /**
     * user de modification
     */
    private Long sortUserModif;


    /**
     * nature du bonument
     */
    private Integer sortNature;


    /**
     * date
     */
    private LocalDate sortDate;


    /**
     * numero du bon
     */
    private String sortNum;


    /**
     * nom du responsable
     */
    private String sortNomResponsable;


    /**
     * nom du tiers
     */
    private String sortNomTiers;


    /**
     * id du tiers
     */
    private Long sortIdTiers;


    /**
     * type du tiers 0:client,1:Fournisseur,2:Agent,3:PlanComptable 4=patient 5=eleve
     */
    private Integer sortTypeTiers;


    /**
     * 0=sortie normale 1=retrait dans compte tiers
     */
    private Integer sortDepotTiers;


    /**
     * serie
     */
    private String sortSerie;


    /**
     * libelle
     */
    private String sortLibelle;


    /**
     * devise
     */
    private String sortDevise;


    /**
     * montant
     */
    private Double sortMontant;


    /**
     * type de reglement
     */
    private Integer sortTypeReg;


    /**
     * activite
     */
    private String sortActivite;


    /**
     * site
     */
    private String sortSite;


    /**
     * departement
     */
    private String sortDepartement;


    /**
     * service
     */
    private String sortService;


    /**
     * region
     */
    private String sortRegion;


    /**
     * secteur
     */
    private String sortSecteur;


    /**
     * Pdv
     */
    private String sortPdv;


    /**
     * budget
     */
    private String sortBudget;


    /**
     * etat 0=a payer ; 1=regle
     */
    private Integer sortEtat;


    /**
     * date de valeur
     */
    private LocalDate sortDateRelance;


    /**
     * 0:actif, 1:inactif
     */
    private Integer sortActif;


    /**
     * modele impression recu
     */
    private String sortModeleImp;


    /**
     * date impression recu
     */
    private LocalDateTime sortDateImpression;


    /**
     * code caisse du bon
     */
    private String sortCodeCaiss;


    /**
     * libelle ciasse du bon
     */
    private String sortLibCaiss;


    /**
     * code banque du bon
     */
    private String sortCodeBanq;


    /**
     * libelle banque du bon
     */
    private String sortLibBanq;

    @NotNull(message = "execaiId can not null")
    private Long execaiId;


    /**
     * montant disponible sur budget
     */
    private Double sortBudgetDispo;


    /**
     * montant disponible sur treso
     */
    private Double sortBudgetTreso;


    /**
     * budget mensuel dispo
     */
    private Double sortBudgetDispoMois;


    /**
     * budget mensuel treso
     */
    private Double sortBudgetTresoMois;


    /**
     * dossier
     */
    private String sortDossier;


    /**
     * parc
     */
    private String sortParc;


    /**
     * cle 1 de repartition
     */
    private String sortCle1Repartition;


    /**
     * cle 2 de repartition
     */
    private String sortCle2Repartition;


    /**
     * banque du tireur
     */
    private String sortBanqueTireur;


    /**
     * numero cheque ou bordereau
     */
    private String sortNumChqBdx;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer sortEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer sortGele;


    /**
     * date de validation
     */
    private LocalDate sortDateValide;


    /**
     * numero du document origine
     */
    private String sortDocument;


    /**
     * objet du document
     */
    private String sortObjet;


    /**
     * code budget
     */
    private String sortCodeBudgetTreso;


    /**
     * code poste
     */
    private String sortCodePosteTreso;


    /**
     * code operation
     */
    private String sortOperation;

}
