package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CptLoyerQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long loyId;


    /**
     * date de creation
     */
    private LocalDateTime loyDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime loyDateModif;


    /**
     * user de creation
     */
    private Long loyUserCreat;


    /**
     * user de modification
     */
    private Long loyUserModif;


    /**
     * numero du bail
     */
    private String loyNumBail;


    /**
     * compte tiers (client ou fournisseur)
     */
    private String loyCompteTiers;


    /**
     * libelle tiers (client ou fournisseur)
     */
    private String loyLibCompteTiers;


    /**
     * numero de contribuable
     */
    private String loyNumContribuable;


    /**
     * 0=particulier 1=sci locale 2=societe locale 3=sci locale 4=societe etrangere 5=administration
     */
    private Integer loyCategorie;


    /**
     * 0=loyer verse 1=loyer encaisse
     */
    private Integer loyType;


    /**
     * compte de loyer
     */
    private String loyCompteLoyer;


    /**
     * libelle compte de loyer
     */
    private String loyLibCompteLoyer;


    /**
     * compte de taxe
     */
    private String loyCompteTaxe;


    /**
     * libelle compte de taxe
     */
    private String loyLibCompteTaxe;


    /**
     * compte impot
     */
    private String loyCompteImpot;


    /**
     * libelle compte impot
     */
    private String loyLibCompteImpot;


    /**
     * date debut du bail
     */
    private LocalDate loyDateDebut;


    /**
     * date fin du bail
     */
    private LocalDate loyDateFin;


    /**
     * description du bien
     */
    private String loyDescription;


    /**
     * usage de la location
     */
    private String loyUsage;


    /**
     * 0=mensuel 1=trimestriel 2=semestriel 3=annuel
     */
    private Integer loyMode;


    /**
     * montant net du loyer
     */
    private Double loyMontantNet;


    /**
     * 0=sans taxe 1=tva 2=tsil
     */
    private Integer loyTypeTaxe;


    /**
     * taux de la taxe
     */
    private Float loyTauxTaxe;


    /**
     * 0=sans impot 1=tom
     */
    private Integer loyTypeImpot;


    /**
     * taux des impots
     */
    private Float loyTauxImpot;


    /**
     * montant brut du loyer
     */
    private Double loyMontantBrut;


    /**
     * montant de la taxe
     */
    private Double loyMontantTaxe;


    /**
     * montant des impots
     */
    private Double loyMontantImpot;


    /**
     * 0=actif 1=inactif
     */
    private Integer loyInactif;


    /**
     * code activite
     */
    private String loyActiviterCode;


    /**
     * libelle activite
     */
    private String loyActiviteLib;


    /**
     * code site
     */
    private String loySiteCode;


    /**
     * libelle site
     */
    private String loySiteLib;


    /**
     * code departement
     */
    private String loyDepartementCode;


    /**
     * libelle departement
     */
    private String loyDepartementLib;


    /**
     * code service
     */
    private String loyServiceCode;


    /**
     * libelle service
     */
    private String loyServiceLib;


    /**
     * code region
     */
    private String loyRegionCode;


    /**
     * libelle region
     */
    private String loyRegionLib;


    /**
     * secteur
     */
    private String loySecteurCode;


    /**
     * libelle secteur
     */
    private String loySecteurLib;


    /**
     * code pdv
     */
    private String loyPdvCode;


    /**
     * libellle pdv
     */
    private String loyPdvLib;


    /**
     * code dossier
     */
    private String loyDossierCode;


    /**
     * libelle dossier
     */
    private String loyDossierLib;


    /**
     * code mission
     */
    private String loyMissionCode;


    /**
     * libelle mission
     */
    private String loyMissionLib;


    /**
     * code parc
     */
    private String loyParcCode;


    /**
     * libelle parc
     */
    private String loyParcLib;


    /**
     * code cle1
     */
    private String loyCle1Code;


    /**
     * libelle cle 1
     */
    private String loyCle1Lib;


    /**
     * code agent
     */
    private String loyAgentCode;


    /**
     * libelle agent
     */
    private String loyAgentLib;


    /**
     * code budget
     */
    private String loyBudgetCode;


    /**
     * libelle budget
     */
    private String loyBudgetLib;

    private Long execptId;

}
