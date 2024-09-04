package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_avoir_entete")
public class AchAvoirEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "avf_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avfId;

    /**
     * date de creation
     */
    @Column(name = "avf_date_creat")
    private LocalDateTime avfDateCreat;

    /**
     * date de modification
     */
    @Column(name = "avf_date_modif")
    private LocalDateTime avfDateModif;

    /**
     * id user createur
     */
    @Column(name = "avf_id_createur")
    private Long avfIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "avf_nom_createur")
    private String avfNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "avf_id_modif")
    private Long avfIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "avf_nom_modif")
    private String avfNomModif;

    /**
     * date du reception
     */
    @Column(name = "avf_date")
    private LocalDateTime avfDate;

    /**
     * numero reception
     */
    @Column(name = "avf_num")
    private String avfNum;

    /**
     * nom du commercial
     */
    @Column(name = "avf_nom_responsable")
    private String avfNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "avf_id_responsable")
    private Long avfIdResponsable = 0L;

    /**
     * nom du fournisseur
     */
    @Column(name = "avf_nom_tiers")
    private String avfNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "avf_civil_tiers")
    private String avfCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "avf_id_contact")
    private Long avfIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "avf_nom_contact")
    private String avfNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "avf_civil_contact")
    private String avfCivilContact;

    /**
     * serie
     */
    @Column(name = "avf_serie")
    private String avfSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "avf_exo_tva")
    private Integer avfExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "avf_exo_douane")
    private Integer avfExoDouane = 0;

    /**
     * categorie du fournisseur
     */
    @Column(name = "avf_cat")
    private String avfCat;

    /**
     * code devise
     */
    @Column(name = "avf_devise")
    private String avfDevise;

    /**
     * objet
     */
    @Column(name = "avf_object")
    private String avfObject;

    /**
     * observation
     */
    @Column(name = "avf_observation")
    private String avfObservation;

    /**
     * code budget
     */
    @Column(name = "avf_budget")
    private String avfBudget;

    /**
     * montant disponible sur budget
     */
    @Column(name = "avf_budget_dispo")
    private Double avfBudgetDispo = 0D;

    /**
     * montant disponible sur treso
     */
    @Column(name = "avf_budget_treso")
    private Double avfBudgetTreso = 0D;

    /**
     * budget mensuel dispo
     */
    @Column(name = "avf_budget_dispo_mois")
    private Double avfBudgetDispoMois = 0D;

    /**
     * budget mensuel treso
     */
    @Column(name = "avf_budget_treso_mois")
    private Double avfBudgetTresoMois = 0D;

    /**
     * total ht
     */
    @Column(name = "avf_tot_ht")
    private Double avfTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "avf_tot_remise")
    private Double avfTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "avf_tot_rabais")
    private Double avfTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "avf_tot_tva")
    private Double avfTotTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "avf_tot_tc")
    private Double avfTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "avf_tot_ttc")
    private Double avfTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "avf_tot_reglement")
    private Double avfTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "avf_solde")
    private Integer avfSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "avf_banque")
    private String avfBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    @Column(name = "avf_type_reg")
    private Integer avfTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "avf_mode_reg")
    private String avfModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "avf_nb_jour_reg")
    private Integer avfNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "avf_arrondi_reg")
    private Integer avfArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "avf_condition_reg")
    private String avfConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "avf_date_eche_reg")
    private LocalDate avfDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "avf_journal_reg")
    private String avfJournalReg;

    /**
     * code activite
     */
    @Column(name = "avf_activite")
    private String avfActivite;

    /**
     * code site
     */
    @Column(name = "avf_site")
    private String avfSite;

    /**
     * code departement
     */
    @Column(name = "avf_departement")
    private String avfDepartement;

    /**
     * code service
     */
    @Column(name = "avf_service")
    private String avfService;

    /**
     * code region
     */
    @Column(name = "avf_region")
    private String avfRegion;

    /**
     * code secteur
     */
    @Column(name = "avf_secteur")
    private String avfSecteur;

    /**
     * code point de vente
     */
    @Column(name = "avf_pdv")
    private String avfPdv;

    /**
     * code analytique 2
     */
    @Column(name = "avf_anal2")
    private String avfAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "avf_anal4")
    private String avfAnal4;

    /**
     * info 1
     */
    @Column(name = "avf_info1")
    private String avfInfo1;

    /**
     * info 2
     */
    @Column(name = "avf_info2")
    private String avfInfo2;

    /**
     * info 3
     */
    @Column(name = "avf_info3")
    private String avfInfo3;

    /**
     * info 4
     */
    @Column(name = "avf_info4")
    private String avfInfo4;

    /**
     * info 5
     */
    @Column(name = "avf_info5")
    private String avfInfo5;

    /**
     * info 6
     */
    @Column(name = "avf_info6")
    private String avfInfo6;

    /**
     * info 7
     */
    @Column(name = "avf_info7")
    private String avfInfo7;

    /**
     * info 8
     */
    @Column(name = "avf_info8")
    private String avfInfo8;

    /**
     * info 9
     */
    @Column(name = "avf_info9")
    private String avfInfo9;

    /**
     * info 10
     */
    @Column(name = "avf_info10")
    private String avfInfo10;

    /**
     * code formule 1
     */
    @Column(name = "avf_formule1")
    private String avfFormule1;

    /**
     * code formule 2
     */
    @Column(name = "avf_formule2")
    private String avfFormule2;

    /**
     * nom jasper anexe 1
     */
    @Column(name = "avf_annexe1")
    private String avfAnnexe1;

    /**
     * nom jasper anexe 2
     */
    @Column(name = "avf_annexe2")
    private String avfAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "avf_contrat")
    private String avfContrat;

    /**
     * numero facture fournisseur
     */
    @Column(name = "avf_num_four")
    private String avfNumFour;

    /**
     * date impression
     */
    @Column(name = "avf_date_imp")
    private LocalDate avfDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "avf_modele_imp")
    private String avfModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "avf_etat_val")
    private Integer avfEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "avf_gele")
    private Integer avfGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "avf_etat")
    private Integer avfEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "avf_date_validite")
    private LocalDate avfDateValidite;

    /**
     * date de relance
     */
    @Column(name = "avf_date_relance")
    private LocalDate avfDateRelance;

    /**
     * date de validation
     */
    @Column(name = "avf_date_valide")
    private LocalDate avfDateValide;

    /**
     * date de transformation
     */
    @Column(name = "avf_date_transforme")
    private LocalDate avfDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "avf_type_transforme")
    private Integer avfTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "avf_date_annule")
    private LocalDate avfDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "avf_motif_annule")
    private String avfMotifAnnule;

    /**
     * date transfert en compta
     */
    @Column(name = "avf_date_transfert")
    private LocalDate avfDateTransfert;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "avf_divers_tiers")
    private Integer avfDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "avf_divers_nom")
    private String avfDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "avf_divers_adresse")
    private String avfDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "avf_divers_ville")
    private String avfDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "avf_divers_tel")
    private String avfDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "avf_divers_mail")
    private String avfDiversMail;

    /**
     * numero de transfert
     */
    @Column(name = "avf_num_trf")
    private String avfNumTrf;

}
