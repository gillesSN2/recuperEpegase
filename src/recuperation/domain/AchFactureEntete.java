package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_facture_entete")
public class AchFactureEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "fcf_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fcfId;

    /**
     * date de creation
     */
    @Column(name = "fcf_date_creat")
    private LocalDateTime fcfDateCreat;

    /**
     * date de modification
     */
    @Column(name = "fcf_date_modif")
    private LocalDateTime fcfDateModif;

    /**
     * id user createur
     */
    @Column(name = "fcf_id_createur")
    private Long fcfIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "fcf_nom_createur")
    private String fcfNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "fcf_id_modif")
    private Long fcfIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "fcf_nom_modif")
    private String fcfNomModif;

    /**
     * date du reception
     */
    @Column(name = "fcf_date")
    private LocalDateTime fcfDate;

    /**
     * date de livrison
     */
    @Column(name = "fcf_date_livraison")
    private LocalDate fcfDateLivraison;

    /**
     * numero reception
     */
    @Column(name = "fcf_num")
    private String fcfNum;

    /**
     * nom du commercial
     */
    @Column(name = "fcf_nom_responsable")
    private String fcfNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "fcf_id_responsable")
    private Long fcfIdResponsable = 0L;

    /**
     * nom du fournisseur
     */
    @Column(name = "fcf_nom_tiers")
    private String fcfNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "fcf_civil_tiers")
    private String fcfCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "fcf_id_contact")
    private Long fcfIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "fcf_nom_contact")
    private String fcfNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "fcf_civil_contact")
    private String fcfCivilContact;

    /**
     * serie
     */
    @Column(name = "fcf_serie")
    private String fcfSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "fcf_exo_tva")
    private Integer fcfExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "fcf_exo_douane")
    private Integer fcfExoDouane = 0;

    /**
     * categorie du fournisseur
     */
    @Column(name = "fcf_cat")
    private String fcfCat;

    /**
     * code devise
     */
    @Column(name = "fcf_devise")
    private String fcfDevise;

    /**
     * coefficient devise
     */
    @Column(name = "fcf_coef_devise")
    private Float fcfCoefDevise = 0F;

    /**
     * objet
     */
    @Column(name = "fcf_object")
    private String fcfObject;

    /**
     * observation
     */
    @Column(name = "fcf_observation")
    private String fcfObservation;

    /**
     * code budget
     */
    @Column(name = "fcf_budget")
    private String fcfBudget;

    /**
     * montant disponible sur budget
     */
    @Column(name = "fcf_budget_dispo")
    private Double fcfBudgetDispo = 0D;

    /**
     * montant disponible sur treso
     */
    @Column(name = "fcf_budget_treso")
    private Double fcfBudgetTreso = 0D;

    /**
     * budget mensuel dispo
     */
    @Column(name = "fcf_budget_dispo_mois")
    private Double fcfBudgetDispoMois = 0D;

    /**
     * budget mensuel treso
     */
    @Column(name = "fcf_budget_treso_mois")
    private Double fcfBudgetTresoMois = 0D;

    /**
     * total ht
     */
    @Column(name = "fcf_tot_ht")
    private Double fcfTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "fcf_tot_remise")
    private Double fcfTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "fcf_tot_rabais")
    private Double fcfTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "fcf_tot_tva")
    private Double fcfTotTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "fcf_tot_tc")
    private Double fcfTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "fcf_tot_ttc")
    private Double fcfTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "fcf_tot_reglement")
    private Double fcfTotReglement = 0D;

    /**
     * total ht local
     */
    @Column(name = "fcf_tot_ht_local")
    private Double fcfTotHtLocal = 0D;

    /**
     * total tva local
     */
    @Column(name = "fcf_tot_tva_local")
    private Double fcfTotTvaLocal = 0D;

    /**
     * total ttc local
     */
    @Column(name = "fcf_tot_ttc_local")
    private Double fcfTotTtcLocal = 0D;

    /**
     * total remise local
     */
    @Column(name = "fcf_tot_remise_local")
    private Double fcfTotRemiseLocal = 0D;

    /**
     * total rabais local
     */
    @Column(name = "fcf_tot_rabais_local")
    private Double fcfTotRabaisLocal = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "fcf_solde")
    private Integer fcfSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "fcf_banque")
    private String fcfBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    @Column(name = "fcf_type_reg")
    private Integer fcfTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "fcf_mode_reg")
    private String fcfModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "fcf_nb_jour_reg")
    private Integer fcfNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "fcf_arrondi_reg")
    private Integer fcfArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "fcf_condition_reg")
    private String fcfConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "fcf_date_eche_reg")
    private LocalDate fcfDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "fcf_journal_reg")
    private String fcfJournalReg;

    /**
     * code activite
     */
    @Column(name = "fcf_activite")
    private String fcfActivite;

    /**
     * code site
     */
    @Column(name = "fcf_site")
    private String fcfSite;

    /**
     * code departement
     */
    @Column(name = "fcf_departement")
    private String fcfDepartement;

    /**
     * code service
     */
    @Column(name = "fcf_service")
    private String fcfService;

    /**
     * code region
     */
    @Column(name = "fcf_region")
    private String fcfRegion;

    /**
     * code secteur
     */
    @Column(name = "fcf_secteur")
    private String fcfSecteur;

    /**
     * code point de vente
     */
    @Column(name = "fcf_pdv")
    private String fcfPdv;

    /**
     * code analytique 2
     */
    @Column(name = "fcf_anal2")
    private String fcfAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "fcf_anal4")
    private String fcfAnal4;

    /**
     * info 1
     */
    @Column(name = "fcf_info1")
    private String fcfInfo1;

    /**
     * info 2
     */
    @Column(name = "fcf_info2")
    private String fcfInfo2;

    /**
     * info 3
     */
    @Column(name = "fcf_info3")
    private String fcfInfo3;

    /**
     * info 4
     */
    @Column(name = "fcf_info4")
    private String fcfInfo4;

    /**
     * info 5
     */
    @Column(name = "fcf_info5")
    private String fcfInfo5;

    /**
     * info 6
     */
    @Column(name = "fcf_info6")
    private String fcfInfo6;

    /**
     * info 7
     */
    @Column(name = "fcf_info7")
    private String fcfInfo7;

    /**
     * info 8
     */
    @Column(name = "fcf_info8")
    private String fcfInfo8;

    /**
     * info 9
     */
    @Column(name = "fcf_info9")
    private String fcfInfo9;

    /**
     * info 10
     */
    @Column(name = "fcf_info10")
    private String fcfInfo10;

    /**
     * code formule 1
     */
    @Column(name = "fcf_formule1")
    private String fcfFormule1;

    /**
     * code formule 2
     */
    @Column(name = "fcf_formule2")
    private String fcfFormule2;

    /**
     * nom jasper anexe 1
     */
    @Column(name = "fcf_annexe1")
    private String fcfAnnexe1;

    /**
     * nom jasper anexe 2
     */
    @Column(name = "fcf_annexe2")
    private String fcfAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "fcf_contrat")
    private String fcfContrat;

    /**
     * numero facture fournisseur
     */
    @Column(name = "fcf_num_four")
    private String fcfNumFour;

    /**
     * date impression
     */
    @Column(name = "fcf_date_imp")
    private LocalDate fcfDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "fcf_modele_imp")
    private String fcfModeleImp;

    /**
     * 0=sans validation 1=avecc validation
     */
    @Column(name = "fcf_etat_val")
    private Integer fcfEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "fcf_gele")
    private Integer fcfGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme 5=transferer en compta
     */
    @Column(name = "fcf_etat")
    private Integer fcfEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "fcf_date_validite")
    private LocalDate fcfDateValidite;

    /**
     * date de relance
     */
    @Column(name = "fcf_date_relance")
    private LocalDate fcfDateRelance;

    /**
     * date de validation
     */
    @Column(name = "fcf_date_valide")
    private LocalDate fcfDateValide;

    /**
     * date de transformation
     */
    @Column(name = "fcf_date_transforme")
    private LocalDate fcfDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "fcf_type_transforme")
    private Integer fcfTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "fcf_date_annule")
    private LocalDate fcfDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "fcf_motif_annule")
    private String fcfMotifAnnule;

    /**
     * date transfert en compta
     */
    @Column(name = "fcf_date_transfert")
    private LocalDate fcfDateTransfert;

    /**
     * nom du factor
     */
    @Column(name = "fcf_factor_nom")
    private String fcfFactorNom;

    /**
     * id du factor
     */
    @Column(name = "fcf_factor_id")
    private Long fcfFactorId = 0L;

    /**
     * 0=en cours 1=accepter 2=refuser
     */
    @Column(name = "fcf_factor_etat")
    private Integer fcfFactorEtat = 0;

    /**
     * date valorisation
     */
    @Column(name = "fcf_date_valo")
    private LocalDate fcfDateValo;

    /**
     * 0=sans valo 1=valo sur coef 2=valo sur frais
     */
    @Column(name = "fcf_type_valo")
    private Integer fcfTypeValo = 0;

    /**
     * coefficient de valorisation
     */
    @Column(name = "fcf_coef_valo_etat")
    private Float fcfCoefValoEtat = 0F;

    /**
     * numero de facture de frais
     */
    @Column(name = "fcf_frais_valo")
    private String fcfFraisValo;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "fcf_divers_tiers")
    private Integer fcfDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "fcf_divers_nom")
    private String fcfDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "fcf_divers_adresse")
    private String fcfDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "fcf_divers_ville")
    private String fcfDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "fcf_divers_tel")
    private String fcfDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "fcf_divers_mail")
    private String fcfDiversMail;

    /**
     * numero proforme fournisseur
     */
    @Column(name = "fcf_proforma_four")
    private String fcfProformaFour;

    /**
     * numero de transfert
     */
    @Column(name = "fcf_num_trf")
    private String fcfNumTrf;

}
