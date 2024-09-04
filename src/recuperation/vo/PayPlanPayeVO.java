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
public class PayPlanPayeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "plpId can not null")
    private Long plpId;


    /**
     * date de creation
     */
    private LocalDateTime plpDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime plpDateModif;


    /**
     * utilisateur de creation
     */
    private Long plpUserCreat;


    /**
     * utilisateur de modification
     */
    private Long plpUserModif;


    /**
     * numero de code
     */
    private String plpCode;


    /**
     * libelle du rubrique en FR
     */
    private String plpLibelleFr;


    /**
     * commentaire
     */
    private String plpCommentaire;


    /**
     * libelle du rubrique en UK
     */
    private String plpLibelleUk;


    /**
     * libelle du rubrique en SP
     */
    private String plpLibelleSp;


    /**
     * code nature
     */
    private Integer plpNature;


    /**
     * libelle nature en FR
     */
    private String plpLibelleNatureFr;


    /**
     * 0=+ 1=- 2=calcul 3=resultat
     */
    private Integer plpSens;


    /**
     * 0=sans 1=fiche preparatoire 2=modification mensuelle
     */
    private Integer plpOption;


    /**
     * 0=groupe ...
     */
    private Integer plpGroupe;


    /**
     * 0=actif 1=inactif
     */
    private Integer plpInactif;


    /**
     * compte normal
     */
    private String plpCompteNormal;


    /**
     * compte prestataire
     */
    private String plpComptePrestataire;


    /**
     * contre partie normal
     */
    private String plpCpNormal;


    /**
     * contre partie prestataire
     */
    private String plpCpPrestataire;


    /**
     * 0=sans analytique 1=avec imputation analytique
     */
    private Integer plpAnalytique;


    /**
     * 0=sans ran 1=avec ran
     */
    private Integer plpRan;


    /**
     * 0=sans protection 1=avec protection
     */
    private Integer plpProtege;


    /**
     * true = integre dans la base fiscale
     */
    private Boolean plpBaseFiscale;


    /**
     * true = integre dans la base sociale
     */
    private Boolean plpBaseSociale;


    /**
     * true = integre dans la base autre
     */
    private Boolean plpBaseAutre;


    /**
     * true = integre dans la base patronale
     */
    private Boolean plpBasePatronale;


    /**
     * taux integre dans la base fiscale
     */
    private Float plpTauxFiscale;


    /**
     * taux integre dans la base sociale
     */
    private Float plpTauxSociale;


    /**
     * taux integre dans la base autre
     */
    private Float plpTauxAutre;


    /**
     * taux integre dans la base patronale
     */
    private Float plpTauxPatronale;


    /**
     * formule integre dans la base fiscale
     */
    private String plpFormuleFiscale;


    /**
     * formule integre dans la base sociale
     */
    private String plpFormuleSociale;


    /**
     * formule integre dans la base autre
     */
    private String plpFormuleAutre;


    /**
     * formule integre dans la base patronale
     */
    private String plpFormulePatronale;

    @NotNull(message = "exepayId can not null")
    private Long exepayId;


    /**
     * taux integre dans la base patronale
     */
    private Float plpTauxPatronal;


    /**
     * true = integre dans la base heure supplementaire
     */
    private Boolean plpBaseHeureSup;


    /**
     * true = integre dans la facture interim
     */
    private Boolean plpFacture;

}
