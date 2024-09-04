package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_commande_entete")
public class AchCommandeEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cmd_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cmdId;

    /**
     * date de creation
     */
    @Column(name = "cmd_date_creat")
    private LocalDateTime cmdDateCreat;

    /**
     * date de modification
     */
    @Column(name = "cmd_date_modif")
    private LocalDateTime cmdDateModif;

    /**
     * id user createur
     */
    @Column(name = "cmd_id_createur")
    private Long cmdIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "cmd_nom_createur")
    private String cmdNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "cmd_id_modif")
    private Long cmdIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "cmd_nom_modif")
    private String cmdNomModif;

    /**
     * 0=ferme 1=ouvert
     */
    @Column(name = "cmd_maj")
    private Integer cmdMaj = 0;

    /**
     * date du commande
     */
    @Column(name = "cmd_date")
    private LocalDateTime cmdDate;

    /**
     * numero commande
     */
    @Column(name = "cmd_num")
    private String cmdNum;

    /**
     * numero de valorisation
     */
    @Column(name = "cmd_valo")
    private String cmdValo;

    /**
     * nom du commercial
     */
    @Column(name = "cmd_nom_responsable")
    private String cmdNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "cmd_id_responsable")
    private Long cmdIdResponsable = 0L;

    /**
     * nom du fournisseur
     */
    @Column(name = "cmd_nom_tiers")
    private String cmdNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "cmd_civil_tiers")
    private String cmdCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "cmd_id_contact")
    private Long cmdIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "cmd_nom_contact")
    private String cmdNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "cmd_civil_contact")
    private String cmdCivilContact;

    /**
     * serie
     */
    @Column(name = "cmd_serie")
    private String cmdSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "cmd_exo_tva")
    private Integer cmdExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "cmd_exo_douane")
    private Integer cmdExoDouane = 0;

    /**
     * categorie du fournisseur
     */
    @Column(name = "cmd_cat")
    private String cmdCat;

    /**
     * code devise
     */
    @Column(name = "cmd_devise")
    private String cmdDevise;

    /**
     * objet
     */
    @Column(name = "cmd_object")
    private String cmdObject;

    /**
     * observation
     */
    @Column(name = "cmd_observation")
    private String cmdObservation;

    /**
     * code budget
     */
    @Column(name = "cmd_budget")
    private String cmdBudget;

    /**
     * total ht
     */
    @Column(name = "cmd_tot_ht")
    private Double cmdTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "cmd_tot_remise")
    private Double cmdTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "cmd_tot_rabais")
    private Double cmdTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "cmd_tot_tva")
    private Double cmdTotTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "cmd_tot_tc")
    private Double cmdTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "cmd_tot_ttc")
    private Double cmdTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "cmd_tot_reglement")
    private Double cmdTotReglement = 0D;

    /**
     * total ht local
     */
    @Column(name = "cmd_tot_ht_local")
    private Double cmdTotHtLocal = 0D;

    /**
     * total tva local
     */
    @Column(name = "cmd_tot_tva_local")
    private Double cmdTotTvaLocal = 0D;

    /**
     * total ttc local
     */
    @Column(name = "cmd_tot_ttc_local")
    private Double cmdTotTtcLocal = 0D;

    /**
     * total remise local
     */
    @Column(name = "cmd_tot_remise_local")
    private Double cmdTotRemiseLocal = 0D;

    /**
     * total rabais local
     */
    @Column(name = "cmd_tot_rabais_local")
    private Double cmdTotRabaisLocal = 0D;

    /**
     * total fret si CFR
     */
    @Column(name = "cmd_tot_fret")
    private Double cmdTotFret = 0D;

    /**
     * total fret si CFR
     */
    @Column(name = "cmd_tot_fretLocal")
    private Double cmdTotFretlocal = 0D;

    /**
     * budget annuel dispo
     */
    @Column(name = "cmd_budget_dispo")
    private Double cmdBudgetDispo = 0D;

    /**
     * budget annuel treso
     */
    @Column(name = "cmd_budget_treso")
    private Double cmdBudgetTreso = 0D;

    /**
     * budget mensuel dispo
     */
    @Column(name = "cmd_budget_dispo_mois")
    private Double cmdBudgetDispoMois = 0D;

    /**
     * budget mensuel treso
     */
    @Column(name = "cmd_budget_treso_mois")
    private Double cmdBudgetTresoMois = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "cmd_solde")
    private Integer cmdSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "cmd_banque")
    private String cmdBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    @Column(name = "cmd_type_reg")
    private Integer cmdTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "cmd_mode_reg")
    private String cmdModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "cmd_nb_jour_reg")
    private Integer cmdNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "cmd_arrondi_reg")
    private Integer cmdArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "cmd_condition_reg")
    private String cmdConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "cmd_date_eche_reg")
    private LocalDate cmdDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "cmd_journal_reg")
    private String cmdJournalReg;

    /**
     * code activite
     */
    @Column(name = "cmd_activite")
    private String cmdActivite;

    /**
     * code site
     */
    @Column(name = "cmd_site")
    private String cmdSite;

    /**
     * code departement
     */
    @Column(name = "cmd_departement")
    private String cmdDepartement;

    /**
     * code service
     */
    @Column(name = "cmd_service")
    private String cmdService;

    /**
     * code region
     */
    @Column(name = "cmd_region")
    private String cmdRegion;

    /**
     * code secteur
     */
    @Column(name = "cmd_secteur")
    private String cmdSecteur;

    /**
     * code point de vente
     */
    @Column(name = "cmd_pdv")
    private String cmdPdv;

    /**
     * code analytique 2 (parc)
     */
    @Column(name = "cmd_anal2")
    private String cmdAnal2;

    /**
     * code analytique 4 (dossier)
     */
    @Column(name = "cmd_anal4")
    private String cmdAnal4;

    /**
     * info 1
     */
    @Column(name = "cmd_info1")
    private String cmdInfo1;

    /**
     * info 2
     */
    @Column(name = "cmd_info2")
    private String cmdInfo2;

    /**
     * info 3
     */
    @Column(name = "cmd_info3")
    private String cmdInfo3;

    /**
     * info 4
     */
    @Column(name = "cmd_info4")
    private String cmdInfo4;

    /**
     * info 5
     */
    @Column(name = "cmd_info5")
    private String cmdInfo5;

    /**
     * info 6
     */
    @Column(name = "cmd_info6")
    private String cmdInfo6;

    /**
     * info 7
     */
    @Column(name = "cmd_info7")
    private String cmdInfo7;

    /**
     * info 8
     */
    @Column(name = "cmd_info8")
    private String cmdInfo8;

    /**
     * info 9
     */
    @Column(name = "cmd_info9")
    private String cmdInfo9;

    /**
     * info 10
     */
    @Column(name = "cmd_info10")
    private String cmdInfo10;

    /**
     * code formule 1
     */
    @Column(name = "cmd_formule1")
    private String cmdFormule1;

    /**
     * code formule 2
     */
    @Column(name = "cmd_formule2")
    private String cmdFormule2;

    /**
     * nom jasper annexe 1
     */
    @Column(name = "cmd_annexe1")
    private String cmdAnnexe1;

    /**
     * nom jasper annexe 2
     */
    @Column(name = "cmd_annexe2")
    private String cmdAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "cmd_contrat")
    private String cmdContrat;

    /**
     * code incoterm
     */
    @Column(name = "cmd_incoterm")
    private String cmdIncoterm;

    /**
     * lieu de livraison
     */
    @Column(name = "cmd_lieu_livraison")
    private String cmdLieuLivraison;

    /**
     * date de livraison
     */
    @Column(name = "cmd_date_livraison")
    private LocalDate cmdDateLivraison;

    /**
     * info sur la livraison
     */
    @Column(name = "cmd_info_livraison")
    private String cmdInfoLivraison;

    /**
     * date impression
     */
    @Column(name = "cmd_date_imp")
    private LocalDate cmdDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "cmd_modele_imp")
    private String cmdModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "cmd_etat_val")
    private Integer cmdEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "cmd_gele")
    private Integer cmdGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme partiel 5=transforme total
     */
    @Column(name = "cmd_etat")
    private Integer cmdEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "cmd_date_validite")
    private LocalDate cmdDateValidite;

    /**
     * date de relance
     */
    @Column(name = "cmd_date_relance")
    private LocalDate cmdDateRelance;

    /**
     * date de validation
     */
    @Column(name = "cmd_date_valide")
    private LocalDate cmdDateValide;

    /**
     * date de transformation
     */
    @Column(name = "cmd_date_transforme")
    private LocalDate cmdDateTransforme;

    /**
     * date de facturation
     */
    @Column(name = "cmd_date_facture")
    private LocalDate cmdDateFacture;

    /**
     * type de transformation
     */
    @Column(name = "cmd_type_transforme")
    private Integer cmdTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "cmd_date_annule")
    private LocalDate cmdDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "cmd_motif_annule")
    private String cmdMotifAnnule;

    /**
     * nom du factor
     */
    @Column(name = "cmd_factor_nom")
    private String cmdFactorNom;

    /**
     * id du factor
     */
    @Column(name = "cmd_factor_id")
    private Long cmdFactorId = 0L;

    /**
     * 0=en cours 1=accepter 2=refuser
     */
    @Column(name = "cmd_factor_etat")
    private Integer cmdFactorEtat = 0;

    /**
     * 0=basse 1=normal 2=urgent 3=prioritaire
     */
    @Column(name = "cmd_priorite")
    private Integer cmdPriorite = 0;

    /**
     * 0=realisation interne 1=realisation externe
     */
    @Column(name = "cmd_in_out")
    private Integer cmdInOut = 0;

    /**
     * commentaire sur la production
     */
    @Column(name = "cmd_commentaire")
    private String cmdCommentaire;

    /**
     * numero de production
     */
    @Column(name = "cmd_production")
    private String cmdProduction;

    /**
     * preparateur
     */
    @Column(name = "cmd_preparateur")
    private String cmdPreparateur;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * total poids brut
     */
    @Column(name = "cmd_tot_poids_brut")
    private Float cmdTotPoidsBrut = 0F;

    /**
     * total qte
     */
    @Column(name = "cmd_tot_qte")
    private Float cmdTotQte = 0F;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "cmd_divers_tiers")
    private Integer cmdDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "cmd_divers_nom")
    private String cmdDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "cmd_divers_adresse")
    private String cmdDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "cmd_divers_ville")
    private String cmdDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "cmd_divers_tel")
    private String cmdDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "cmd_divers_mail")
    private String cmdDiversMail;

    /**
     * numero de proforma fournisseur
     */
    @Column(name = "cmd_num_proforma")
    private String cmdNumProforma;

    /**
     * coefficient devise
     */
    @Column(name = "cmd_coef_devise")
    private Float cmdCoefDevise = 0F;

    /**
     * code tracking
     */
    @Column(name = "cmd_tracking")
    private String cmdTracking;

    /**
     * date depart usine
     */
    @Column(name = "cmd_date_depart_usine")
    private LocalDate cmdDateDepartUsine;

    /**
     * date arrivee transitaire
     */
    @Column(name = "cmd_date_arrivee_transit")
    private LocalDate cmdDateArriveeTransit;

    /**
     * date embarquement theorique
     */
    @Column(name = "cmd_date_embarquement_theo")
    private LocalDate cmdDateEmbarquementTheo;

    /**
     * date embarquement reel
     */
    @Column(name = "cmd_date_embarquement_reel")
    private LocalDate cmdDateEmbarquementReel;

    /**
     * date arrivee port theorique
     */
    @Column(name = "cmd_date_arrivee_port_theo")
    private LocalDate cmdDateArriveePortTheo;

    /**
     * date arrivee port reel
     */
    @Column(name = "cmd_date_arrivee_port_reel")
    private LocalDate cmdDateArriveePortReel;

    /**
     * date livraion dans nos entrepots
     */
    @Column(name = "cmd_date_livre_depot")
    private LocalDate cmdDateLivreDepot;

    /**
     * moyen de paiement
     */
    @Column(name = "cmd_moyen_paiement")
    private String cmdMoyenPaiement;

    /**
     * observation sur le paiement
     */
    @Column(name = "cmd_obs_paiement")
    private String cmdObsPaiement;

    /**
     * date paiement
     */
    @Column(name = "cmd_date_paiement")
    private LocalDate cmdDatePaiement;

    /**
     * 0=maritime 1=avion 2=express 3=route
     */
    @Column(name = "cmd_mode")
    private Integer cmdMode = 0;

    /**
     * prochaine action
     */
    @Column(name = "cmd_prochaine_action")
    private String cmdProchaineAction;

}
