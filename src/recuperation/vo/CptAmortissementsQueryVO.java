package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CptAmortissementsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long amoId;


    /**
     * date de creation d un amortissement
     */
    private LocalDateTime amoDateCreat;


    /**
     * date de modification d un amortissement
     */
    private LocalDateTime amoDateModif;


    /**
     * utilisateur de creation d un amortissement
     */
    private Long amoUserCreat;


    /**
     * utilisateur de modification d un amortissement
     */
    private Long amoUserModif;


    /**
     * numero d immobilisation calcul automatique
     */
    private Integer amoNum;


    /**
     * numero de compte de nature immobilisation (3)
     */
    private String amoCompteAmo;


    /**
     * description du bien
     */
    private String amoLibelle;


    /**
     * date d achat du bien
     */
    private LocalDate amoDateAchat;


    /**
     * date de mise en service. cette date est prioritaire par rapport aÃ‚Â la date d achat
     */
    private LocalDate amoDateService;


    /**
     * valeur d achat dans la devise du pays
     */
    private Double amoValeurAchat;


    /**
     * valeur reevaluee
     */
    private Double amoValeurReevalue;


    /**
     * taux de la tva
     */
    private Float amoTvaTaux;


    /**
     * = amo_valeur_achat amo_tva_taux
     */
    private Double amoTvaTotal;


    /**
     * montant de la tva residuelle
     */
    private Double amoTvaResiduelle;


    /**
     * 0=normal 1=accelere 2=degressif
     */
    private Integer amoMode;


    /**
     * taux d amortissement comptable
     */
    private Float amoTauxComptable;


    /**
     * zone calculee par rapport a la zone taux comptable
     */
    private Integer amoNbAnneeCpte;


    /**
     * taux d amortissement fiscal
     */
    private Float amoTauxFiscal;


    /**
     * zone calculee par rapport a la zone taux fiscale
     */
    private Integer amoNbAnneeFiscal;


    /**
     * amortissement anterieur a l annee en cours
     */
    private Double amoAnterieur;


    /**
     * reference du bien (impression etiquettes)
     */
    private String amoReference;


    /**
     * numero de piece de l achat du bien
     */
    private String amoPieceAchat;


    /**
     * numero de chassis ou numero de serie
     */
    private String amoChassis;


    /**
     * 0 nature non specifiee 1 amorti. immobilier 2 amortis. mobilier
     */
    private Integer amoNature;


    /**
     * suivant fichier xml nature parc
     */
    private Integer amoNatureDetail;


    /**
     * suivant fichier xml nature parc
     */
    private String amoNatureDetailLib;


    /**
     * informations complementaires
     */
    private String amoInfosCpl;


    /**
     * nom du fournisseur d achat (texte libre)
     */
    private String amoFournisseur;


    /**
     * 0 origine non specifiee 1 dans le pays 2 dans la zone 3 hors de la zone
     */
    private String amoOrigine;


    /**
     * imputation site
     */
    private String amoSite;


    /**
     * libelle site
     */
    private String amoLibSite;


    /**
     * imputation departement
     */
    private String amoDepartement;


    /**
     * libelle departement
     */
    private String amoLibDepartement;


    /**
     * imputation service
     */
    private String amoService;


    /**
     * libelle service
     */
    private String amoLibService;


    /**
     * imputation region
     */
    private String amoRegion;


    /**
     * libelle region
     */
    private String amoLibRegion;


    /**
     * imputation secteur
     */
    private String amoSecteur;


    /**
     * libelle secteur
     */
    private String amoLibSecteur;


    /**
     * imputation point de vente
     */
    private String amoPdv;


    /**
     * libelle pdv
     */
    private String amoLibPdv;


    /**
     * imputation dossier
     */
    private String amoDossier;


    /**
     * libelle dossier
     */
    private String amoLibDossier;


    /**
     * imputation mission
     */
    private String amoMission;


    /**
     * libelle mission
     */
    private String amoLibMission;


    /**
     * imputation parc
     */
    private String amoParc;


    /**
     * libelle parc
     */
    private String amoLibParc;


    /**
     * imputation cle1
     */
    private String amoCle1;


    /**
     * libelle cle1
     */
    private String amoLibCle1;


    /**
     * code agent
     */
    private String amoAgent;


    /**
     * libelle agent
     */
    private String amoLibAgent;


    /**
     * code activite
     */
    private String amoActivite;


    /**
     * libelle activite
     */
    private String amoLibActivite;


    /**
     * code projet
     */
    private String amoProjet;


    /**
     * libelle projet
     */
    private String amoLibProjet;


    /**
     * imputation budgetaire
     */
    private String amoBudget;


    /**
     * libelle budget
     */
    private String amoLibBudget;


    /**
     * date debut de calcul
     */
    private LocalDate amoPeriodeDeb;


    /**
     * date fin de calcul
     */
    private LocalDate amoPeriodeFin;


    /**
     * valeur de la dotation calulee pour la periode
     */
    private Double amoDotation;


    /**
     * = amo_anterieur + amo_dotation
     */
    private Double amoTotalAmort;


    /**
     * = amo_valeur_achat - amo_total _amort
     */
    private Double amoValeurResiduelle;


    /**
     * date de sortie
     */
    private LocalDate amoDateSortie;


    /**
     * 0=en cours 1=cession 2=rebut
     */
    private Integer amoTypeSortie;


    /**
     * nom du client qui achete le bien cede (texte libre)
     */
    private String amoNomClient;


    /**
     * valeur de cession
     */
    private Double amoValeurCession;


    /**
     * montant des frais annexes lors d une cession
     */
    private Double amoFraisAnnexe;


    /**
     * si cession alors soit oui soit non
     */
    private Integer amoReinvestissement;


    /**
     * numero de facture de cession des immobilisations
     */
    private String amoFactureCession;


    /**
     * numero de piece de la cession du bien
     */
    private String amoPieceCession;


    /**
     * total de la cession a payer par le client
     */
    private Double amoNetAPayer;


    /**
     * total des reglements de la table AmortissementReglement
     */
    private Double amoTotalReglement;


    /**
     * = amo_net_a_payer - amo_total_reglement
     */
    private Double amoSolde;


    /**
     * 0=sans financement 1=credit court terme 2=credit bail
     */
    private Integer amoFinancement;


    /**
     * libelle compte amortissement en FR
     */
    private String amoLibCompteAmo;


    /**
     * libelle compte dotation en FR
     */
    private String amoLibCompteDot;


    /**
     * compte de dotation
     */
    private String amoCompteDotation;


    /**
     * compte de l immobilisation
     */
    private String amoCompteImmo;


    /**
     * libelle compte immobilisation en FR
     */
    private String amoLibCompteImo;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer amoInactif;


    /**
     * numero facture d achat fournisseur
     */
    private String amoFactureAchat;


    /**
     * amortissement hors exploitation
     */
    private Double amoHorsExp;


    /**
     * code amortissement
     */
    private Double amoCede;


    /**
     * compte de cession
     */
    private String amoCompteCes;


    /**
     * libelle compte cession
     */
    private String amoLibCompteCes;


    /**
     * photo du bien
     */
    private String amoPhoto;


    /**
     * memorisation ancien id
     */
    private Long amoOldId;


    /**
     * date amortissement anterieur
     */
    private LocalDate amoDateAnterieur;


    /**
     * id de la ligne de reception
     */
    private Long amoIdReception;


    /**
     * date reevaluee
     */
    private LocalDate amoDateReevalue;

}
