package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cpt_amortissements")
public class CptAmortissements implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "amo_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amoId;

    /**
     * date de creation d un amortissement
     */
    @Column(name = "amo_date_creat")
    private LocalDateTime amoDateCreat;

    /**
     * date de modification d un amortissement
     */
    @Column(name = "amo_date_modif")
    private LocalDateTime amoDateModif;

    /**
     * utilisateur de creation d un amortissement
     */
    @Column(name = "amo_user_creat")
    private Long amoUserCreat = 0L;

    /**
     * utilisateur de modification d un amortissement
     */
    @Column(name = "amo_user_modif")
    private Long amoUserModif = 0L;

    /**
     * numero d immobilisation calcul automatique
     */
    @Column(name = "amo_num")
    private Integer amoNum;

    /**
     * numero de compte de nature immobilisation (3)
     */
    @Column(name = "amo_compte_amo")
    private String amoCompteAmo;

    /**
     * description du bien
     */
    @Column(name = "amo_libelle")
    private String amoLibelle;

    /**
     * date d achat du bien
     */
    @Column(name = "amo_date_achat")
    private LocalDate amoDateAchat;

    /**
     * date de mise en service. cette date est prioritaire par rapport aÃ‚Â la date d achat
     */
    @Column(name = "amo_date_service")
    private LocalDate amoDateService;

    /**
     * valeur d achat dans la devise du pays
     */
    @Column(name = "amo_valeur_achat")
    private Double amoValeurAchat = 0D;

    /**
     * valeur reevaluee
     */
    @Column(name = "amo_valeur_reevalue")
    private Double amoValeurReevalue = 0D;

    /**
     * taux de la tva
     */
    @Column(name = "amo_tva_taux")
    private Float amoTvaTaux = 0F;

    /**
     * = amo_valeur_achat amo_tva_taux
     */
    @Column(name = "amo_tva_total")
    private Double amoTvaTotal = 0D;

    /**
     * montant de la tva residuelle
     */
    @Column(name = "amo_tva_residuelle")
    private Double amoTvaResiduelle = 0D;

    /**
     * 0=normal 1=accelere 2=degressif
     */
    @Column(name = "amo_mode")
    private Integer amoMode = 0;

    /**
     * taux d amortissement comptable
     */
    @Column(name = "amo_taux_comptable")
    private Float amoTauxComptable = 0F;

    /**
     * zone calculee par rapport a la zone taux comptable
     */
    @Column(name = "amo_nb_annee_cpte")
    private Integer amoNbAnneeCpte = 0;

    /**
     * taux d amortissement fiscal
     */
    @Column(name = "amo_taux_fiscal")
    private Float amoTauxFiscal = 0F;

    /**
     * zone calculee par rapport a la zone taux fiscale
     */
    @Column(name = "amo_nb_annee_fiscal")
    private Integer amoNbAnneeFiscal = 0;

    /**
     * amortissement anterieur a l annee en cours
     */
    @Column(name = "amo_anterieur")
    private Double amoAnterieur = 0D;

    /**
     * reference du bien (impression etiquettes)
     */
    @Column(name = "amo_reference")
    private String amoReference;

    /**
     * numero de piece de l achat du bien
     */
    @Column(name = "amo_piece_achat")
    private String amoPieceAchat;

    /**
     * numero de chassis ou numero de serie
     */
    @Column(name = "amo_chassis")
    private String amoChassis;

    /**
     * 0 nature non specifiee 1 amorti. immobilier 2 amortis. mobilier
     */
    @Column(name = "amo_nature")
    private Integer amoNature = 0;

    /**
     * suivant fichier xml nature parc
     */
    @Column(name = "amo_nature_detail")
    private Integer amoNatureDetail = 0;

    /**
     * suivant fichier xml nature parc
     */
    @Column(name = "amo_nature_detail_lib")
    private String amoNatureDetailLib;

    /**
     * informations complementaires
     */
    @Column(name = "amo_infos_cpl")
    private String amoInfosCpl;

    /**
     * nom du fournisseur d achat (texte libre)
     */
    @Column(name = "amo_fournisseur")
    private String amoFournisseur;

    /**
     * 0 origine non specifiee 1 dans le pays 2 dans la zone 3 hors de la zone
     */
    @Column(name = "amo_origine")
    private String amoOrigine;

    /**
     * imputation site
     */
    @Column(name = "amo_site")
    private String amoSite;

    /**
     * libelle site
     */
    @Column(name = "amo_lib_site")
    private String amoLibSite;

    /**
     * imputation departement
     */
    @Column(name = "amo_departement")
    private String amoDepartement;

    /**
     * libelle departement
     */
    @Column(name = "amo_lib_departement")
    private String amoLibDepartement;

    /**
     * imputation service
     */
    @Column(name = "amo_service")
    private String amoService;

    /**
     * libelle service
     */
    @Column(name = "amo_lib_service")
    private String amoLibService;

    /**
     * imputation region
     */
    @Column(name = "amo_region")
    private String amoRegion;

    /**
     * libelle region
     */
    @Column(name = "amo_lib_region")
    private String amoLibRegion;

    /**
     * imputation secteur
     */
    @Column(name = "amo_secteur")
    private String amoSecteur;

    /**
     * libelle secteur
     */
    @Column(name = "amo_lib_secteur")
    private String amoLibSecteur;

    /**
     * imputation point de vente
     */
    @Column(name = "amo_pdv")
    private String amoPdv;

    /**
     * libelle pdv
     */
    @Column(name = "amo_lib_pdv")
    private String amoLibPdv;

    /**
     * imputation dossier
     */
    @Column(name = "amo_dossier")
    private String amoDossier;

    /**
     * libelle dossier
     */
    @Column(name = "amo_lib_dossier")
    private String amoLibDossier;

    /**
     * imputation mission
     */
    @Column(name = "amo_mission")
    private String amoMission;

    /**
     * libelle mission
     */
    @Column(name = "amo_lib_mission")
    private String amoLibMission;

    /**
     * imputation parc
     */
    @Column(name = "amo_parc")
    private String amoParc;

    /**
     * libelle parc
     */
    @Column(name = "amo_lib_parc")
    private String amoLibParc;

    /**
     * imputation cle1
     */
    @Column(name = "amo_cle1")
    private String amoCle1;

    /**
     * libelle cle1
     */
    @Column(name = "amo_lib_cle1")
    private String amoLibCle1;

    /**
     * code agent
     */
    @Column(name = "amo_agent")
    private String amoAgent;

    /**
     * libelle agent
     */
    @Column(name = "amo_lib_agent")
    private String amoLibAgent;

    /**
     * code activite
     */
    @Column(name = "amo_activite")
    private String amoActivite;

    /**
     * libelle activite
     */
    @Column(name = "amo_lib_activite")
    private String amoLibActivite;

    /**
     * code projet
     */
    @Column(name = "amo_projet")
    private String amoProjet;

    /**
     * libelle projet
     */
    @Column(name = "amo_lib_projet")
    private String amoLibProjet;

    /**
     * imputation budgetaire
     */
    @Column(name = "amo_budget")
    private String amoBudget;

    /**
     * libelle budget
     */
    @Column(name = "amo_lib_budget")
    private String amoLibBudget;

    /**
     * date debut de calcul
     */
    @Column(name = "amo_periode_deb")
    private LocalDate amoPeriodeDeb;

    /**
     * date fin de calcul
     */
    @Column(name = "amo_periode_fin")
    private LocalDate amoPeriodeFin;

    /**
     * valeur de la dotation calulee pour la periode
     */
    @Column(name = "amo_dotation")
    private Double amoDotation = 0D;

    /**
     * = amo_anterieur + amo_dotation
     */
    @Column(name = "amo_total_amort")
    private Double amoTotalAmort = 0D;

    /**
     * = amo_valeur_achat - amo_total _amort
     */
    @Column(name = "amo_valeur_residuelle")
    private Double amoValeurResiduelle = 0D;

    /**
     * date de sortie
     */
    @Column(name = "amo_date_sortie")
    private LocalDate amoDateSortie;

    /**
     * 0=en cours 1=cession 2=rebut
     */
    @Column(name = "amo_type_sortie")
    private Integer amoTypeSortie = 0;

    /**
     * nom du client qui achete le bien cede (texte libre)
     */
    @Column(name = "amo_nom_client")
    private String amoNomClient;

    /**
     * valeur de cession
     */
    @Column(name = "amo_valeur_cession")
    private Double amoValeurCession = 0D;

    /**
     * montant des frais annexes lors d une cession
     */
    @Column(name = "amo_frais_annexe")
    private Double amoFraisAnnexe = 0D;

    /**
     * si cession alors soit oui soit non
     */
    @Column(name = "amo_reinvestissement")
    private Integer amoReinvestissement = 0;

    /**
     * numero de facture de cession des immobilisations
     */
    @Column(name = "amo_facture_cession")
    private String amoFactureCession;

    /**
     * numero de piece de la cession du bien
     */
    @Column(name = "amo_piece_cession")
    private String amoPieceCession;

    /**
     * total de la cession a payer par le client
     */
    @Column(name = "amo_net_a_payer")
    private Double amoNetAPayer = 0D;

    /**
     * total des reglements de la table AmortissementReglement
     */
    @Column(name = "amo_total_reglement")
    private Double amoTotalReglement = 0D;

    /**
     * = amo_net_a_payer - amo_total_reglement
     */
    @Column(name = "amo_solde")
    private Double amoSolde = 0D;

    /**
     * 0=sans financement 1=credit court terme 2=credit bail
     */
    @Column(name = "amo_financement")
    private Integer amoFinancement = 0;

    /**
     * libelle compte amortissement en FR
     */
    @Column(name = "amo_lib_compte_amo")
    private String amoLibCompteAmo;

    /**
     * libelle compte dotation en FR
     */
    @Column(name = "amo_lib_compte_dot")
    private String amoLibCompteDot;

    /**
     * compte de dotation
     */
    @Column(name = "amo_compte_dotation")
    private String amoCompteDotation;

    /**
     * compte de l immobilisation
     */
    @Column(name = "amo_compte_immo")
    private String amoCompteImmo;

    /**
     * libelle compte immobilisation en FR
     */
    @Column(name = "amo_lib_compte_imo")
    private String amoLibCompteImo;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "amo_inactif")
    private Integer amoInactif = 0;

    /**
     * numero facture d achat fournisseur
     */
    @Column(name = "amo_facture_achat")
    private String amoFactureAchat;

    /**
     * amortissement hors exploitation
     */
    @Column(name = "amo_hors_exp")
    private Double amoHorsExp = 0D;

    /**
     * code amortissement
     */
    @Column(name = "amo_cede")
    private Double amoCede = 0D;

    /**
     * compte de cession
     */
    @Column(name = "amo_compte_ces")
    private String amoCompteCes;

    /**
     * libelle compte cession
     */
    @Column(name = "amo_lib_compte_ces")
    private String amoLibCompteCes;

    /**
     * photo du bien
     */
    @Column(name = "amo_photo")
    private String amoPhoto;

    /**
     * memorisation ancien id
     */
    @Column(name = "amo_old_id")
    private Long amoOldId = 0L;

    /**
     * date amortissement anterieur
     */
    @Column(name = "amo_date_anterieur")
    private LocalDate amoDateAnterieur;

    /**
     * id de la ligne de reception
     */
    @Column(name = "amo_id_reception")
    private Long amoIdReception = 0L;

    /**
     * date reevaluee
     */
    @Column(name = "amo_date_reevalue")
    private LocalDate amoDateReevalue;

}
