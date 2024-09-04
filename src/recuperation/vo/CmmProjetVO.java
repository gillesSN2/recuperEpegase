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
public class CmmProjetVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "proId can not null")
    private Long proId;

    private Long proUserCreat;

    private LocalDate proDateCreat;

    private Long proUserModif;

    private LocalDate proDateModif;

    private String proCode;

    private String proNomFr;

    private String proNomUk;

    private String proNomSp;

    private String proDescription;

    private String proInitiateur;

    private LocalDate proDateDebut;

    private LocalDate proDateFin;

    private Double proMontantEuro;

    private Float proCoefPays;

    private Double proMontantPays;

    private String proContexte;

    private String proObjectif;

    private Integer proInactif;


    /**
     * id responsable
     */
    private Long proIdResponsable;


    /**
     * nom responsable
     */
    private String proNomResponsable;


    /**
     * source
     */
    private String proSource;


    /**
     * duree du projet
     */
    private Integer proDuree;


    /**
     * valeur en devise
     */
    private Double proMontantDevise;


    /**
     * devise
     */
    private String proDevise;


    /**
     * coef en euro
     */
    private Float proCoefEuro;


    /**
     * nombre de tranche
     */
    private Integer proNbTranche;


    /**
     * annee debut
     */
    private String proAnnee;


    /**
     * date echeance
     */
    private String proDateEcheance;


    /**
     * montant echeance
     */
    private String proMontantEcheance;


    /**
     * observation echeance
     */
    private String proObsEcheance;


    /**
     * liste des utilisateurs autorises
     */
    private String proIdUsers;


    /**
     * date echeance debut
     */
    private String proDateEcheanceDeb;


    /**
     * date echeance fin
     */
    private String proDateEcheanceFin;


    /**
     * date debut de la convention
     */
    private LocalDate proDateDebutConvention;


    /**
     * date fin de la convention
     */
    private LocalDate proDateFinConvention;

}
