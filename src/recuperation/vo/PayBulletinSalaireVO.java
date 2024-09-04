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
public class PayBulletinSalaireVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "bulsalId can not null")
    private Long bulsalId;


    /**
     * numero feuille
     */
    private String bulsalFeuille;


    /**
     * numero contrat
     */
    private String bulsalContrat;


    /**
     * periode MMAAAA
     */
    private String bulsalPeriode;


    /**
     * date debut
     */
    private LocalDate bulsalDateDebut;


    /**
     * date fin
     */
    private LocalDate bulsalDateFin;


    /**
     * matricule
     */
    private String bulsalMatricule;


    /**
     * voir nature salarie xml
     */
    private String bulsalNature;


    /**
     * 0=actif 1=en conges 2=licencie 3=demissionne 4=decede 5=retraite 6=fin de contrat 7=arret ou suspension
     */
    private Integer bulsalEtat;


    /**
     * civilite (suivant fichier xml)
     */
    private String bulsalCivilite;


    /**
     * fonction
     */
    private String bulsalFonction;


    /**
     * imputation service
     */
    private String bulsalSite;


    /**
     * imputation service
     */
    private String bulsalDepartement;


    /**
     * imputation service
     */
    private String bulsalService;


    /**
     * imputation activite
     */
    private String bulsalActicvite;


    /**
     * imputation budget
     */
    private String bulsalBudget;


    /**
     * imputation parc
     */
    private String bulsalParc;


    /**
     * 0=femme 1=homme
     */
    private Integer bulsalGenre;


    /**
     * 0=celibataire 1=marie 2=concubin 3=pacse 4=divorce 5=veuf
     */
    private Integer bulsalSitFamille;


    /**
     * nombre enfant
     */
    private Integer bulsalNbEnfant;


    /**
     * nombre de parts fiscales
     */
    private Float bulsalNbPartFiscal;


    /**
     * nombre de femme
     */
    private Integer bulsalNbFemme;


    /**
     * nombre de parts trimf
     */
    private Float bulsalNbPartTrimf;


    /**
     * regime de conges : nb jour de conges
     */
    private Float bulsalNbJourCp;


    /**
     * regime de conges : nb jour de travail
     */
    private Float bulsalNbJourTr;


    /**
     * date de sortie
     */
    private LocalDate bulsalDateSortie;


    /**
     * motif de sortie
     */
    private String bulsalMotifSortie;


    /**
     * code convention du salarie
     */
    private String bulsalConvention;


    /**
     * libelle convention du salarie
     */
    private String bulsalLibConvention;


    /**
     * code centres impots xml
     */
    private String bulsalCodCentresImpots;


    /**
     * libelle centres impots xml
     */
    private String bulsalLibCentresImpots;


    /**
     * code classement xml
     */
    private String bulsalClassement;


    /**
     * libelle classement xml
     */
    private String bulsalLibClassement;


    /**
     * code niveau emploi xml
     */
    private String bulsalNivEmploi;


    /**
     * libelle niveau emploi xml
     */
    private String bulsalLibNivEmploi;


    /**
     * code grille convention xml
     */
    private String bulsalGrille;


    /**
     * libelle grille convention xml
     */
    private String bulsalLibGrille;


    /**
     * avantage en nature
     */
    private Double bulsalAvNat;


    /**
     * salaire brut
     */
    private Double bulsalBrut;


    /**
     * conges payes
     */
    private Double bulsalCp;


    /**
     * nombre de jours e conges pris
     */
    private Float bulsalNbCpPris;


    /**
     * nombre de jours e conges pris
     */
    private Float bulsalNbCpAcquis;


    /**
     * base imposable fiscale
     */
    private Double bulsalBaseImposableFiscale;


    /**
     * base imposable sociale
     */
    private Double bulsalBaseImposableSociale;


    /**
     * salaire net à payer
     */
    private Double bulsalNetPayer;


    /**
     * cumul impot 1
     */
    private Double bulsalImpot1;


    /**
     * cumul impot 2
     */
    private Double bulsalImpot2;


    /**
     * cumul impot 3
     */
    private Double bulsalImpot3;


    /**
     * cumul impot 4
     */
    private Double bulsalImpot4;


    /**
     * cumul impot 5
     */
    private Double bulsalImpot5;


    /**
     * cumul impot 6
     */
    private Double bulsalImpot6;


    /**
     * cumul impot 7
     */
    private Double bulsalImpot7;


    /**
     * cumul impot 8
     */
    private Double bulsalImpot8;


    /**
     * cumul impot 9
     */
    private Double bulsalImpot9;


    /**
     * cumul impot 10
     */
    private Double bulsalImpot10;


    /**
     * date de transfert en compta
     */
    private LocalDate bulsalDateTransfert;


    /**
     * cle de repartition 1
     */
    private String bulsalCle1Anal;


    /**
     * cle de repartition 2
     */
    private String bulsalCle2Anal;

    @NotNull(message = "salId can not null")
    private Long salId;

    @NotNull(message = "exepayId can not null")
    private Long exepayId;


    /**
     * nombre de jours de conges feries
     */
    private Float bulsalNbCpFeries;


    /**
     * 0=espece 1=cheque 2=virement 3=bicitel 4=autre
     */
    private Integer bulsalModeReglement;


    /**
     * code banque
     */
    private String bulsalNumBanque;


    /**
     * code guichet
     */
    private String bulsalGuichetBanque;


    /**
     * numero de compte
     */
    private String bulsalCompteBanque;


    /**
     * cle rib
     */
    private String bulsalCleBanque;


    /**
     * code iban
     */
    private String bulsalIban;


    /**
     * code swift
     */
    private String bulsalSwift;


    /**
     * 0=automatique 1=manuel
     */
    private Integer bulsalManuel;


    /**
     * id tiers impute interim
     */
    private Long bulsalIdTiers;


    /**
     * code projet
     */
    private String bulsalProjet;


    /**
     * date entree
     */
    private LocalDate bulsalDateEntree;


    /**
     * type conges payes 0 ou 1=normal 2=bulletin de cp 3=cp travailles 4=cp immediat 5=cp maternite
     */
    private Integer bulsalTypeCp;


    /**
     * nombre de jours disponible
     */
    private Float bulsalNbDispo;

}
