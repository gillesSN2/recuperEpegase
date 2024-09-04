package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_note_debit_entete")
public class AchNoteDebitEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ndf_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ndfId;

    /**
     * date de creation
     */
    @Column(name = "ndf_date_creat")
    private LocalDateTime ndfDateCreat;

    /**
     * date de modification
     */
    @Column(name = "ndf_date_modif")
    private LocalDateTime ndfDateModif;

    /**
     * id user createur
     */
    @Column(name = "ndf_id_createur")
    private Long ndfIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "ndf_nom_createur")
    private String ndfNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "ndf_id_modif")
    private Long ndfIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "ndf_nom_modif")
    private String ndfNomModif;

    /**
     * date de la note de debit
     */
    @Column(name = "ndf_date")
    private LocalDateTime ndfDate;

    /**
     * numero note de debit
     */
    @Column(name = "ndf_num")
    private String ndfNum;

    /**
     * numero valorisation
     */
    @Column(name = "ndf_valo")
    private String ndfValo;

    /**
     * nom du commercial
     */
    @Column(name = "ndf_nom_responsable")
    private String ndfNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "ndf_id_responsable")
    private Long ndfIdResponsable = 0L;

    /**
     * nom du fournisseur
     */
    @Column(name = "ndf_nom_tiers")
    private String ndfNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "ndf_civil_tiers")
    private String ndfCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "ndf_id_contact")
    private Long ndfIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "ndf_nom_contact")
    private String ndfNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "ndf_civil_contact")
    private String ndfCivilContact;

    /**
     * serie
     */
    @Column(name = "ndf_serie")
    private String ndfSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "ndf_exo_tva")
    private Integer ndfExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "ndf_exo_douane")
    private Integer ndfExoDouane = 0;

    /**
     * categorie du fournisseur
     */
    @Column(name = "ndf_cat")
    private String ndfCat;

    /**
     * code devise
     */
    @Column(name = "ndf_devise")
    private String ndfDevise;

    /**
     * objet
     */
    @Column(name = "ndf_object")
    private String ndfObject;

    /**
     * observation
     */
    @Column(name = "ndf_observation")
    private String ndfObservation;

    /**
     * code budget
     */
    @Column(name = "ndf_budget")
    private String ndfBudget;

    /**
     * montant disponible sur budget
     */
    @Column(name = "ndf_budget_dispo")
    private Double ndfBudgetDispo = 0D;

    /**
     * montant disponible sur treso
     */
    @Column(name = "ndf_budget_treso")
    private Double ndfBudgetTreso = 0D;

    /**
     * budget mensuel dispo
     */
    @Column(name = "ndf_budget_dispo_mois")
    private Double ndfBudgetDispoMois = 0D;

    /**
     * budget mensuel treso
     */
    @Column(name = "ndf_budget_treso_mois")
    private Double ndfBudgetTresoMois = 0D;

    /**
     * total ht
     */
    @Column(name = "ndf_tot_ht")
    private Double ndfTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "ndf_tot_remise")
    private Double ndfTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "ndf_tot_rabais")
    private Double ndfTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "ndf_tot_tva")
    private Double ndfTotTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "ndf_tot_tc")
    private Double ndfTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "ndf_tot_ttc")
    private Double ndfTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "ndf_tot_reglement")
    private Double ndfTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "ndf_solde")
    private Integer ndfSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "ndf_banque")
    private String ndfBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    @Column(name = "ndf_type_reg")
    private Integer ndfTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "ndf_mode_reg")
    private String ndfModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "ndf_nb_jour_reg")
    private Integer ndfNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "ndf_arrondi_reg")
    private Integer ndfArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "ndf_condition_reg")
    private String ndfConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "ndf_date_eche_reg")
    private LocalDate ndfDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "ndf_journal_reg")
    private String ndfJournalReg;

    /**
     * code activite
     */
    @Column(name = "ndf_activite")
    private String ndfActivite;

    /**
     * code site
     */
    @Column(name = "ndf_site")
    private String ndfSite;

    /**
     * code departement
     */
    @Column(name = "ndf_departement")
    private String ndfDepartement;

    /**
     * code service
     */
    @Column(name = "ndf_service")
    private String ndfService;

    /**
     * code region
     */
    @Column(name = "ndf_region")
    private String ndfRegion;

    /**
     * code secteur
     */
    @Column(name = "ndf_secteur")
    private String ndfSecteur;

    /**
     * code point de vente
     */
    @Column(name = "ndf_pdv")
    private String ndfPdv;

    /**
     * code analytique 2
     */
    @Column(name = "ndf_anal2")
    private String ndfAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "ndf_anal4")
    private String ndfAnal4;

    /**
     * info 1
     */
    @Column(name = "ndf_info1")
    private String ndfInfo1;

    /**
     * info 2
     */
    @Column(name = "ndf_info2")
    private String ndfInfo2;

    /**
     * info 3
     */
    @Column(name = "ndf_info3")
    private String ndfInfo3;

    /**
     * info 4
     */
    @Column(name = "ndf_info4")
    private String ndfInfo4;

    /**
     * info 5
     */
    @Column(name = "ndf_info5")
    private String ndfInfo5;

    /**
     * info 6
     */
    @Column(name = "ndf_info6")
    private String ndfInfo6;

    /**
     * info 7
     */
    @Column(name = "ndf_info7")
    private String ndfInfo7;

    /**
     * info 8
     */
    @Column(name = "ndf_info8")
    private String ndfInfo8;

    /**
     * info 9
     */
    @Column(name = "ndf_info9")
    private String ndfInfo9;

    /**
     * info 10
     */
    @Column(name = "ndf_info10")
    private String ndfInfo10;

    /**
     * code formule 1
     */
    @Column(name = "ndf_formule1")
    private String ndfFormule1;

    /**
     * code formule 2
     */
    @Column(name = "ndf_formule2")
    private String ndfFormule2;

    /**
     * nom jasper anexe 1
     */
    @Column(name = "ndf_annexe1")
    private String ndfAnnexe1;

    /**
     * nom jasper anexe 2
     */
    @Column(name = "ndf_annexe2")
    private String ndfAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "ndf_contrat")
    private String ndfContrat;

    /**
     * date impression
     */
    @Column(name = "ndf_date_imp")
    private LocalDate ndfDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "ndf_modele_imp")
    private String ndfModeleImp;

    /**
     * 0=sans validation 1=avecc validation
     */
    @Column(name = "ndf_etat_val")
    private Integer ndfEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "ndf_gele")
    private Integer ndfGele = 0;

    /**
     * 0=En cour
     */
    @Column(name = "ndf_etat")
    private Integer ndfEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "ndf_date_validite")
    private LocalDate ndfDateValidite;

    /**
     * date de relance
     */
    @Column(name = "ndf_date_relance")
    private LocalDate ndfDateRelance;

    /**
     * date de validation
     */
    @Column(name = "ndf_date_valide")
    private LocalDate ndfDateValide;

    /**
     * date de transformation
     */
    @Column(name = "ndf_date_transforme")
    private LocalDate ndfDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "ndf_type_transforme")
    private Integer ndfTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "ndf_date_annule")
    private LocalDate ndfDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "ndf_motif_annule")
    private String ndfMotifAnnule;

    /**
     * date transfert en compta
     */
    @Column(name = "ndf_date_transfert")
    private LocalDate ndfDateTransfert;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "ndf_divers_tiers")
    private Integer ndfDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "ndf_divers_nom")
    private String ndfDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "ndf_divers_adresse")
    private String ndfDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "ndf_divers_ville")
    private String ndfDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "ndf_divers_tel")
    private String ndfDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "ndf_divers_mail")
    private String ndfDiversMail;

    /**
     * numero de transfert
     */
    @Column(name = "ndf_num_trf")
    private String ndfNumTrf;

}
