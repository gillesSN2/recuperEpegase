package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_reception_entete")
public class AchReceptionEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "rec_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recId;

    /**
     * date de creation
     */
    @Column(name = "rec_date_creat")
    private LocalDateTime recDateCreat;

    /**
     * date de modification
     */
    @Column(name = "rec_date_modif")
    private LocalDateTime recDateModif;

    /**
     * id user createur
     */
    @Column(name = "rec_id_createur")
    private Long recIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "rec_nom_createur")
    private String recNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "rec_id_modif")
    private Long recIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "rec_nom_modif")
    private String recNomModif;

    /**
     * 0=fermer 1=ouvert
     */
    @Column(name = "rec_maj")
    private Integer recMaj = 0;

    /**
     * date du reception
     */
    @Column(name = "rec_date")
    private LocalDateTime recDate;

    /**
     * numero reception
     */
    @Column(name = "rec_num")
    private String recNum;

    /**
     * nom du commercial
     */
    @Column(name = "rec_nom_responsable")
    private String recNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "rec_id_responsable")
    private Long recIdResponsable = 0L;

    /**
     * nom du fournisseur
     */
    @Column(name = "rec_nom_tiers")
    private String recNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "rec_civil_tiers")
    private String recCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "rec_id_contact")
    private Long recIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "rec_nom_contact")
    private String recNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "rec_civil_contact")
    private String recCivilContact;

    /**
     * serie
     */
    @Column(name = "rec_serie")
    private String recSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "rec_exo_tva")
    private Integer recExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "drec_exo_douane")
    private Integer drecExoDouane = 0;

    /**
     * categorie du fournisseur
     */
    @Column(name = "rec_cat")
    private String recCat;

    /**
     * code devise
     */
    @Column(name = "rec_devise")
    private String recDevise;

    /**
     * coefficient devise
     */
    @Column(name = "rec_coef_devise")
    private Float recCoefDevise = 0F;

    /**
     * objet
     */
    @Column(name = "rec_object")
    private String recObject;

    /**
     * observation
     */
    @Column(name = "rec_observation")
    private String recObservation;

    /**
     * code budget
     */
    @Column(name = "rec_budget")
    private String recBudget;

    /**
     * montant disponible sur budget
     */
    @Column(name = "rec_budget_dispo")
    private Double recBudgetDispo = 0D;

    /**
     * montant disponible sur treso
     */
    @Column(name = "rec_budget_treso")
    private Double recBudgetTreso = 0D;

    /**
     * budget mensuel dispo
     */
    @Column(name = "rec_budget_dispo_mois")
    private Double recBudgetDispoMois = 0D;

    /**
     * budget mensuel treso
     */
    @Column(name = "rec_budget_treso_mois")
    private Double recBudgetTresoMois = 0D;

    /**
     * total ht
     */
    @Column(name = "rec_tot_ht")
    private Double recTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "rec_tot_remise")
    private Double recTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "rec_tot_rabais")
    private Double recTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "rec_tot_tva")
    private Double recTotTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "rec_tot_tc")
    private Double recTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "rec_tot_ttc")
    private Double recTotTtc = 0D;

    /**
     * total poids brut
     */
    @Column(name = "rec_tot_poids_brut")
    private Float recTotPoidsBrut = 0F;

    /**
     * total reglement
     */
    @Column(name = "rec_tot_reglement")
    private Double recTotReglement = 0D;

    /**
     * total ht local
     */
    @Column(name = "rec_tot_ht_local")
    private Double recTotHtLocal = 0D;

    /**
     * total tva local
     */
    @Column(name = "rec_tot_tva_local")
    private Double recTotTvaLocal = 0D;

    /**
     * total ttc local
     */
    @Column(name = "rec_tot_ttc_local")
    private Double recTotTtcLocal = 0D;

    /**
     * total remise local
     */
    @Column(name = "rec_tot_remise_local")
    private Double recTotRemiseLocal = 0D;

    /**
     * total rabais local
     */
    @Column(name = "rec_tot_rabais_local")
    private Double recTotRabaisLocal = 0D;

    /**
     * total fret si CFR ou CIF
     */
    @Column(name = "rec_tot_fret")
    private Double recTotFret = 0D;

    /**
     * total fret si CFR ou CIF
     */
    @Column(name = "rec_tot_fretLocal")
    private Double recTotFretlocal = 0D;

    /**
     * total fret si CIF
     */
    @Column(name = "rec_tot_assurance")
    private Double recTotAssurance = 0D;

    /**
     * total fret si CIF
     */
    @Column(name = "rec_tot_assuranceLocal")
    private Double recTotAssurancelocal = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "rec_solde")
    private Integer recSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "rec_banque")
    private String recBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    @Column(name = "rec_type_reg")
    private Integer recTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "rec_mode_reg")
    private String recModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "rec_nb_jour_reg")
    private Integer recNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "rec_arrondi_reg")
    private Integer recArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "rec_condition_reg")
    private String recConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "rec_date_eche_reg")
    private LocalDate recDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "rec_journal_reg")
    private String recJournalReg;

    /**
     * code activite
     */
    @Column(name = "rec_activite")
    private String recActivite;

    /**
     * code site
     */
    @Column(name = "rec_site")
    private String recSite;

    /**
     * code departement
     */
    @Column(name = "rec_departement")
    private String recDepartement;

    /**
     * code service
     */
    @Column(name = "rec_service")
    private String recService;

    /**
     * code region
     */
    @Column(name = "rec_region")
    private String recRegion;

    /**
     * code secteur
     */
    @Column(name = "rec_secteur")
    private String recSecteur;

    /**
     * code point de vente
     */
    @Column(name = "rec_pdv")
    private String recPdv;

    /**
     * code analytique 2 (parc)
     */
    @Column(name = "rec_anal2")
    private String recAnal2;

    /**
     * code analytique 4 (dossier)
     */
    @Column(name = "rec_anal4")
    private String recAnal4;

    /**
     * info 1
     */
    @Column(name = "rec_info1")
    private String recInfo1;

    /**
     * info 2
     */
    @Column(name = "rec_info2")
    private String recInfo2;

    /**
     * info 3
     */
    @Column(name = "rec_info3")
    private String recInfo3;

    /**
     * info 4
     */
    @Column(name = "rec_info4")
    private String recInfo4;

    /**
     * info 5
     */
    @Column(name = "rec_info5")
    private String recInfo5;

    /**
     * info 6
     */
    @Column(name = "rec_info6")
    private String recInfo6;

    /**
     * info 7
     */
    @Column(name = "rec_info7")
    private String recInfo7;

    /**
     * info 8
     */
    @Column(name = "rec_info8")
    private String recInfo8;

    /**
     * info 9
     */
    @Column(name = "rec_info9")
    private String recInfo9;

    /**
     * info 10
     */
    @Column(name = "rec_info10")
    private String recInfo10;

    /**
     * code formule 1
     */
    @Column(name = "rec_formule1")
    private String recFormule1;

    /**
     * code formule 2
     */
    @Column(name = "rec_formule2")
    private String recFormule2;

    /**
     * nom jasper anexe 1
     */
    @Column(name = "rec_annexe1")
    private String recAnnexe1;

    /**
     * nom jasper anexe 2
     */
    @Column(name = "rec_annexe2")
    private String recAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "rec_contrat")
    private String recContrat;

    /**
     * code incoterm
     */
    @Column(name = "rec_incoterm")
    private String recIncoterm;

    /**
     * lieu de livraison
     */
    @Column(name = "rec_lieu_livraison")
    private String recLieuLivraison;

    /**
     * date de livraison
     */
    @Column(name = "rec_date_livraison")
    private LocalDate recDateLivraison;

    /**
     * info sur la livraison
     */
    @Column(name = "rec_info_livraison")
    private String recInfoLivraison;

    /**
     * date impression
     */
    @Column(name = "rec_date_imp")
    private LocalDate recDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "rec_modele_imp")
    private String recModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "rec_etat_val")
    private Integer recEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "rec_gele")
    private Integer recGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme partiel 5=transforme total
     */
    @Column(name = "rec_etat")
    private Integer recEtat = 0;

    /**
     * numero valorisation
     */
    @Column(name = "rec_valo")
    private String recValo;

    /**
     * 0=sur coef 1=sur frais
     */
    @Column(name = "rec_valorisation")
    private Integer recValorisation = 0;

    /**
     * coefficient de valorisation
     */
    @Column(name = "rec_coef_valo")
    private Float recCoefValo = 0F;

    /**
     * date de validite
     */
    @Column(name = "rec_date_validite")
    private LocalDate recDateValidite;

    /**
     * date de relance
     */
    @Column(name = "rec_date_relance")
    private LocalDate recDateRelance;

    /**
     * date de validation
     */
    @Column(name = "rec_date_valide")
    private LocalDate recDateValide;

    /**
     * date de facturation
     */
    @Column(name = "rec_date_facture")
    private LocalDate recDateFacture;

    /**
     * numero facture fournisseur
     */
    @Column(name = "rec_num_facture")
    private String recNumFacture;

    /**
     * date de transformation
     */
    @Column(name = "rec_date_transforme")
    private LocalDate recDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "rec_type_transforme")
    private Integer recTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "rec_date_annule")
    private LocalDate recDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "rec_motif_annule")
    private String recMotifAnnule;

    /**
     * nom du factor
     */
    @Column(name = "rec_factor_nom")
    private String recFactorNom;

    /**
     * id du factor
     */
    @Column(name = "rec_factor_id")
    private Long recFactorId = 0L;

    /**
     * 0=en cours 1=accepter 2=refuser
     */
    @Column(name = "rec_factor_etat")
    private Integer recFactorEtat = 0;

    /**
     * commentaire sur la production
     */
    @Column(name = "rec_commentaire")
    private String recCommentaire;

    /**
     * numero de production
     */
    @Column(name = "rec_production")
    private String recProduction;

    /**
     * nom du livreur
     */
    @Column(name = "rec_livreur_nom")
    private String recLivreurNom;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * total qte
     */
    @Column(name = "rec_tot_qte")
    private Float recTotQte = 0F;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "rec_divers_tiers")
    private Integer recDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "rec_divers_nom")
    private String recDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "rec_divers_adresse")
    private String recDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "rec_divers_ville")
    private String recDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "rec_divers_tel")
    private String recDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "rec_divers_mail")
    private String recDiversMail;

}
