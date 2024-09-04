package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_retour_entete")
public class AchRetourEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "brf_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brfId;

    /**
     * date de creation
     */
    @Column(name = "brf_date_creat")
    private LocalDateTime brfDateCreat;

    /**
     * date de modification
     */
    @Column(name = "brf_date_modif")
    private LocalDateTime brfDateModif;

    /**
     * id user createur
     */
    @Column(name = "brf_id_createur")
    private Long brfIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "brf_nom_createur")
    private String brfNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "brf_id_modif")
    private Long brfIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "brf_nom_modif")
    private String brfNomModif;

    /**
     * date du bon de retour fournisseur
     */
    @Column(name = "brf_date")
    private LocalDateTime brfDate;

    /**
     * numero bon de retour
     */
    @Column(name = "brf_num")
    private String brfNum;

    /**
     * numero valorisation
     */
    @Column(name = "brf_valo")
    private String brfValo;

    /**
     * nom du commercial
     */
    @Column(name = "brf_nom_responsable")
    private String brfNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "brf_id_responsable")
    private Long brfIdResponsable = 0L;

    /**
     * nom du fournisseur
     */
    @Column(name = "brf_nom_tiers")
    private String brfNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "brf_civil_tiers")
    private String brfCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "brf_id_contact")
    private Long brfIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "brf_nom_contact")
    private String brfNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "brf_civil_contact")
    private String brfCivilContact;

    /**
     * serie
     */
    @Column(name = "brf_serie")
    private String brfSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "brf_exo_tva")
    private Integer brfExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "brf_exo_douane")
    private Integer brfExoDouane = 0;

    /**
     * categorie du fournisseur
     */
    @Column(name = "brf_cat")
    private String brfCat;

    /**
     * code devise
     */
    @Column(name = "brf_devise")
    private String brfDevise;

    /**
     * objet
     */
    @Column(name = "brf_object")
    private String brfObject;

    /**
     * observation
     */
    @Column(name = "brf_observation")
    private String brfObservation;

    /**
     * code budget
     */
    @Column(name = "brf_budget")
    private String brfBudget;

    /**
     * montant disponible sur budget
     */
    @Column(name = "brf_budget_dispo")
    private Double brfBudgetDispo = 0D;

    /**
     * montant disponible sur treso
     */
    @Column(name = "brf_budget_treso")
    private Double brfBudgetTreso = 0D;

    /**
     * budget mensuel dispo
     */
    @Column(name = "brf_budget_dispo_mois")
    private Double brfBudgetDispoMois = 0D;

    /**
     * budget mensuel treso
     */
    @Column(name = "brf_budget_treso_mois")
    private Double brfBudgetTresoMois = 0D;

    /**
     * total ht
     */
    @Column(name = "brf_tot_ht")
    private Double brfTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "brf_tot_remise")
    private Double brfTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "brf_tot_rabais")
    private Double brfTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "brf_tot_tva")
    private Double brfTotTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "brf_tot_tc")
    private Double brfTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "brf_tot_ttc")
    private Double brfTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "brf_tot_reglement")
    private Double brfTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "brf_solde")
    private Integer brfSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "brf_banque")
    private String brfBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    @Column(name = "brf_type_reg")
    private Integer brfTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "brf_mode_reg")
    private String brfModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "brf_nb_jour_reg")
    private Integer brfNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "brf_arrondi_reg")
    private Integer brfArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "brf_condition_reg")
    private String brfConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "brf_date_eche_reg")
    private LocalDate brfDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "brf_journal_reg")
    private String brfJournalReg;

    /**
     * code activite
     */
    @Column(name = "brf_activite")
    private String brfActivite;

    /**
     * code site
     */
    @Column(name = "brf_site")
    private String brfSite;

    /**
     * code departement
     */
    @Column(name = "brf_departement")
    private String brfDepartement;

    /**
     * code service
     */
    @Column(name = "brf_service")
    private String brfService;

    /**
     * code region
     */
    @Column(name = "brf_region")
    private String brfRegion;

    /**
     * code secteur
     */
    @Column(name = "brf_secteur")
    private String brfSecteur;

    /**
     * code point de vente
     */
    @Column(name = "brf_pdv")
    private String brfPdv;

    /**
     * code analytique 2
     */
    @Column(name = "brf_anal2")
    private String brfAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "brf_anal4")
    private String brfAnal4;

    /**
     * info 1
     */
    @Column(name = "brf_info1")
    private String brfInfo1;

    /**
     * info 2
     */
    @Column(name = "brf_info2")
    private String brfInfo2;

    /**
     * info 3
     */
    @Column(name = "brf_info3")
    private String brfInfo3;

    /**
     * info 4
     */
    @Column(name = "brf_info4")
    private String brfInfo4;

    /**
     * info 5
     */
    @Column(name = "brf_info5")
    private String brfInfo5;

    /**
     * info 6
     */
    @Column(name = "brf_info6")
    private String brfInfo6;

    /**
     * info 7
     */
    @Column(name = "brf_info7")
    private String brfInfo7;

    /**
     * info 8
     */
    @Column(name = "brf_info8")
    private String brfInfo8;

    /**
     * info 9
     */
    @Column(name = "brf_info9")
    private String brfInfo9;

    /**
     * info 10
     */
    @Column(name = "brf_info10")
    private String brfInfo10;

    /**
     * code formule 1
     */
    @Column(name = "brf_formule1")
    private String brfFormule1;

    /**
     * code formule 2
     */
    @Column(name = "brf_formule2")
    private String brfFormule2;

    /**
     * nom jasper anexe 1
     */
    @Column(name = "brf_annexe1")
    private String brfAnnexe1;

    /**
     * nom jasper anexe 2
     */
    @Column(name = "brf_annexe2")
    private String brfAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "brf_contrat")
    private String brfContrat;

    /**
     * code incoterm
     */
    @Column(name = "brf_incoterm")
    private String brfIncoterm;

    /**
     * lieu de livraison
     */
    @Column(name = "brf_lieu_livraison")
    private String brfLieuLivraison;

    /**
     * date de livraison
     */
    @Column(name = "brf_date_livraison")
    private LocalDate brfDateLivraison;

    /**
     * info sur la livraison
     */
    @Column(name = "brf_info_livraison")
    private String brfInfoLivraison;

    /**
     * date impression
     */
    @Column(name = "brf_date_imp")
    private LocalDate brfDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "brf_modele_imp")
    private String brfModeleImp;

    /**
     * 0=sans validation 1=avecc validation
     */
    @Column(name = "brf_etat_val")
    private Integer brfEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "brf_gele")
    private Integer brfGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "brf_etat")
    private Integer brfEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "brf_date_validite")
    private LocalDate brfDateValidite;

    /**
     * date de relance
     */
    @Column(name = "brf_date_relance")
    private LocalDate brfDateRelance;

    /**
     * date de validation
     */
    @Column(name = "brf_date_valide")
    private LocalDate brfDateValide;

    /**
     * date de transformation
     */
    @Column(name = "brf_date_transforme")
    private LocalDate brfDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "brf_type_transforme")
    private Integer brfTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "brf_date_annule")
    private LocalDate brfDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "brf_motif_annule")
    private String brfMotifAnnule;

    /**
     * nom du factor
     */
    @Column(name = "brf_factor_nom")
    private String brfFactorNom;

    /**
     * id du factor
     */
    @Column(name = "brf_factor_id")
    private Long brfFactorId = 0L;

    /**
     * 0=en cours 1=accepter 2=refuser
     */
    @Column(name = "brf_factor_etat")
    private Integer brfFactorEtat = 0;

    /**
     * commentaire sur la production
     */
    @Column(name = "brf_commentaire")
    private String brfCommentaire;

    /**
     * numero de production
     */
    @Column(name = "brf_production")
    private String brfProduction;

    /**
     * nom du livreur
     */
    @Column(name = "brf_livreur_nom")
    private String brfLivreurNom;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "brf_divers_tiers")
    private Integer brfDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "brf_divers_nom")
    private String brfDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "brf_divers_adresse")
    private String brfDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "brf_divers_ville")
    private String brfDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "brf_divers_tel")
    private String brfDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "brf_divers_mail")
    private String brfDiversMail;

}
