package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_frais_entete")
public class AchFraisEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "fsf_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fsfId;

    /**
     * date de creation
     */
    @Column(name = "fsf_date_creat")
    private LocalDateTime fsfDateCreat;

    /**
     * date de modification
     */
    @Column(name = "fsf_date_modif")
    private LocalDateTime fsfDateModif;

    /**
     * id user createur
     */
    @Column(name = "fsf_id_createur")
    private Long fsfIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "fsf_nom_createur")
    private String fsfNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "fsf_id_modif")
    private Long fsfIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "fsf_nom_modif")
    private String fsfNomModif;

    /**
     * date du reception
     */
    @Column(name = "fsf_date")
    private LocalDateTime fsfDate;

    /**
     * numero frais
     */
    @Column(name = "fsf_num")
    private String fsfNum;

    /**
     * numero valorisation
     */
    @Column(name = "fsf_valo")
    private String fsfValo;

    /**
     * 0=non utilise 1=utilise sur achat 2=utilise sur reexpedition
     */
    @Column(name = "fsf_type_valo")
    private Integer fsfTypeValo = 0;

    /**
     * nom du commercial
     */
    @Column(name = "fsf_nom_responsable")
    private String fsfNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "fsf_id_responsable")
    private Long fsfIdResponsable = 0L;

    /**
     * nom du fournisseur
     */
    @Column(name = "fsf_nom_tiers")
    private String fsfNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "fsf_civil_tiers")
    private String fsfCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "fsf_id_contact")
    private Long fsfIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "fsf_nom_contact")
    private String fsfNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "fsf_civil_contact")
    private String fsfCivilContact;

    /**
     * serie
     */
    @Column(name = "fsf_serie")
    private String fsfSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "fsf_exo_tva")
    private Integer fsfExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "fsf_exo_douane")
    private Integer fsfExoDouane = 0;

    /**
     * categorie du fournisseur
     */
    @Column(name = "fsf_cat")
    private String fsfCat;

    /**
     * code devise
     */
    @Column(name = "fsf_devise")
    private String fsfDevise;

    /**
     * coef devise
     */
    @Column(name = "fsf_coef_devise")
    private Float fsfCoefDevise = 0F;

    /**
     * objet
     */
    @Column(name = "fsf_object")
    private String fsfObject;

    /**
     * observation
     */
    @Column(name = "fsf_observation")
    private String fsfObservation;

    /**
     * code budget
     */
    @Column(name = "fsf_budget")
    private String fsfBudget;

    /**
     * montant disponible sur budget
     */
    @Column(name = "fsf_budget_dispo")
    private Double fsfBudgetDispo = 0D;

    /**
     * montant disponible sur treso
     */
    @Column(name = "fsf_budget_treso")
    private Double fsfBudgetTreso = 0D;

    /**
     * budget mensuel dispo
     */
    @Column(name = "fsf_budget_dispo_mois")
    private Double fsfBudgetDispoMois = 0D;

    /**
     * budget mensuel treso
     */
    @Column(name = "fsf_budget_treso_mois")
    private Double fsfBudgetTresoMois = 0D;

    /**
     * total ht
     */
    @Column(name = "fsf_tot_ht")
    private Double fsfTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "fsf_tot_remise")
    private Double fsfTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "fsf_tot_rabais")
    private Double fsfTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "fsf_tot_tva")
    private Double fsfTotTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "fsf_tot_tc")
    private Double fsfTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "fsf_tot_ttc")
    private Double fsfTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "fsf_tot_reglement")
    private Double fsfTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "fsf_solde")
    private Integer fsfSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "fsf_banque")
    private String fsfBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    @Column(name = "fsf_type_reg")
    private Integer fsfTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "fsf_mode_reg")
    private String fsfModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "fsf_nb_jour_reg")
    private Integer fsfNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "fsf_arrondi_reg")
    private Integer fsfArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "fsf_condition_reg")
    private String fsfConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "fsf_date_eche_reg")
    private LocalDate fsfDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "fsf_journal_reg")
    private String fsfJournalReg;

    /**
     * code activite
     */
    @Column(name = "fsf_activite")
    private String fsfActivite;

    /**
     * code site
     */
    @Column(name = "fsf_site")
    private String fsfSite;

    /**
     * code departement
     */
    @Column(name = "fsf_departement")
    private String fsfDepartement;

    /**
     * code service
     */
    @Column(name = "fsf_service")
    private String fsfService;

    /**
     * code region
     */
    @Column(name = "fsf_region")
    private String fsfRegion;

    /**
     * code secteur
     */
    @Column(name = "fsf_secteur")
    private String fsfSecteur;

    /**
     * code point de vente
     */
    @Column(name = "fsf_pdv")
    private String fsfPdv;

    /**
     * code analytique 2
     */
    @Column(name = "fsf_anal2")
    private String fsfAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "fsf_anal4")
    private String fsfAnal4;

    /**
     * info 1
     */
    @Column(name = "fsf_info1")
    private String fsfInfo1;

    /**
     * info 2
     */
    @Column(name = "fsf_info2")
    private String fsfInfo2;

    /**
     * info 3
     */
    @Column(name = "fsf_info3")
    private String fsfInfo3;

    /**
     * info 4
     */
    @Column(name = "fsf_info4")
    private String fsfInfo4;

    /**
     * info 5
     */
    @Column(name = "fsf_info5")
    private String fsfInfo5;

    /**
     * info 6
     */
    @Column(name = "fsf_info6")
    private String fsfInfo6;

    /**
     * info 7
     */
    @Column(name = "fsf_info7")
    private String fsfInfo7;

    /**
     * info 8
     */
    @Column(name = "fsf_info8")
    private String fsfInfo8;

    /**
     * info 9
     */
    @Column(name = "fsf_info9")
    private String fsfInfo9;

    /**
     * info 10
     */
    @Column(name = "fsf_info10")
    private String fsfInfo10;

    /**
     * code formule 1
     */
    @Column(name = "fsf_formule1")
    private String fsfFormule1;

    /**
     * code formule 2
     */
    @Column(name = "fsf_formule2")
    private String fsfFormule2;

    /**
     * nom jasper anexe 1
     */
    @Column(name = "fsf_annexe1")
    private String fsfAnnexe1;

    /**
     * nom jasper anexe 2
     */
    @Column(name = "fsf_annexe2")
    private String fsfAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "fsf_contrat")
    private String fsfContrat;

    /**
     * numero facture fournisseur
     */
    @Column(name = "fsf_num_four")
    private String fsfNumFour;

    /**
     * date impression
     */
    @Column(name = "fsf_date_imp")
    private LocalDate fsfDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "fsf_modele_imp")
    private String fsfModeleImp;

    /**
     * 0=sans validation 1=avecc validation
     */
    @Column(name = "fsf_etat_val")
    private Integer fsfEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "fsf_gele")
    private Integer fsfGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "fsf_etat")
    private Integer fsfEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "fsf_date_validite")
    private LocalDate fsfDateValidite;

    /**
     * date de relance
     */
    @Column(name = "fsf_date_relance")
    private LocalDate fsfDateRelance;

    /**
     * date de validation
     */
    @Column(name = "fsf_date_valide")
    private LocalDate fsfDateValide;

    /**
     * date de transformation
     */
    @Column(name = "fsf_date_transforme")
    private LocalDate fsfDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "fsf_type_transforme")
    private Integer fsfTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "fsf_date_annule")
    private LocalDate fsfDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "fsf_motif_annule")
    private String fsfMotifAnnule;

    /**
     * nom du factor
     */
    @Column(name = "fsf_factor_nom")
    private String fsfFactorNom;

    /**
     * id du factor
     */
    @Column(name = "fsf_factor_id")
    private Long fsfFactorId = 0L;

    /**
     * 0=en cours 1=accepter 2=refuser
     */
    @Column(name = "fsf_factor_etat")
    private Integer fsfFactorEtat = 0;

    /**
     * date transfert en compta
     */
    @Column(name = "fsf_date_transfert")
    private LocalDate fsfDateTransfert;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "fsf_divers_tiers")
    private Integer fsfDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "fsf_divers_nom")
    private String fsfDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "fsf_divers_adresse")
    private String fsfDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "fsf_divers_ville")
    private String fsfDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "fsf_divers_tel")
    private String fsfDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "fsf_divers_mail")
    private String fsfDiversMail;

    /**
     * numero commande ou reception
     */
    @Column(name = "fsf_num_doc")
    private String fsfNumDoc;

    /**
     * numero de transfert
     */
    @Column(name = "fsf_num_trf")
    private String fsfNumTrf;

    /**
     * total tva douane
     */
    @Column(name = "fsf_tot_tva_douane")
    private Double fsfTotTvaDouane = 0D;

}
