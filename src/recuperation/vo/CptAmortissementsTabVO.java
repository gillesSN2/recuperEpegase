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
public class CptAmortissementsTabVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "amotabId can not null")
    private Long amotabId;


    /**
     * date debut periode
     */
    private LocalDate amotabDateDeb;


    /**
     * date fin periode
     */
    private LocalDate amotabDateFin;


    /**
     * montant amortissement
     */
    private Double amotabMontant;


    /**
     * date transfert en compta
     */
    private LocalDate amotabDateTrf;


    /**
     * valeur transferee
     */
    private Double amotabValeur;


    /**
     * valeur vnc
     */
    private Double amotabVnc;


    /**
     * imputation site
     */
    private String amotabSite;


    /**
     * libelle site
     */
    private String amotabLibSite;


    /**
     * imputation departement
     */
    private String amotabDepartement;


    /**
     * libelle departement
     */
    private String amotabLibDepartement;


    /**
     * imputation service
     */
    private String amotabService;


    /**
     * libelle service
     */
    private String amotabLibService;


    /**
     * imputation region
     */
    private String amotabRegion;


    /**
     * libelle region
     */
    private String amotabLibRegion;


    /**
     * imputation secteur
     */
    private String amotabSecteur;


    /**
     * libelle secteur
     */
    private String amotabLibSecteur;


    /**
     * imputation point de vente
     */
    private String amotabPdv;


    /**
     * libelle pdv
     */
    private String amotabLibPdv;


    /**
     * imputation analytique 1
     */
    private String amotabAnal1;


    /**
     * libelle anal1
     */
    private String amotabLibAnal1;


    /**
     * imputation analytique 2
     */
    private String amotabAnal2;


    /**
     * libelle anal2
     */
    private String amotabLibAnal2;


    /**
     * imputation analytique 3
     */
    private String amotabAnal3;


    /**
     * libelle anal3
     */
    private String amotabLibAnal3;


    /**
     * imputation analytique 4
     */
    private String amotabAnal4;


    /**
     * libelle anal4
     */
    private String amotabLibAnal4;


    /**
     * code activite
     */
    private String amotabActivite;


    /**
     * libelle activite
     */
    private String amotabLibActivite;


    /**
     * code projet
     */
    private String amotabProjet;


    /**
     * libelle projet
     */
    private String amotabLibProjet;


    /**
     * imputation budgetaire
     */
    private String amotabBudget;


    /**
     * libelle budget
     */
    private String amotabLibBudget;

    @NotNull(message = "amoId can not null")
    private Long amoId;


    /**
     * date de sortie
     */
    private LocalDate amotabDateSortie;


    /**
     * valeur cesssion
     */
    private Double amotabValeurCession;

}
