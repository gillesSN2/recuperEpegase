package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_bcommande_entete")
public class VteBcommandeEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bcm_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bcmId;

    /**
     * date de creation
     */
    @Column(name = "bcm_date_creat")
    private LocalDateTime bcmDateCreat;

    /**
     * date de modification
     */
    @Column(name = "bcm_date_modif")
    private LocalDateTime bcmDateModif;

    /**
     * id user createur
     */
    @Column(name = "bcm_id_createur")
    private Long bcmIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "bcm_nom_createur")
    private String bcmNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "bcm_id_modif")
    private Long bcmIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "bcm_nom_modif")
    private String bcmNomModif;

    /**
     * date du commande
     */
    @Column(name = "bcm_date")
    private LocalDateTime bcmDate;

    /**
     * numero commande
     */
    @Column(name = "bcm_num")
    private String bcmNum;

    /**
     * nom du commercial
     */
    @Column(name = "bcm_nom_responsable")
    private String bcmNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "bcm_id_responsable")
    private Long bcmIdResponsable = 0L;

    /**
     * nom du client
     */
    @Column(name = "bcm_nom_tiers")
    private String bcmNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "bcm_civil_tiers")
    private String bcmCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "bcm_id_contact")
    private Long bcmIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "bcm_nom_contact")
    private String bcmNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "bcm_civil_contact")
    private String bcmCivilContact;

    /**
     * serie
     */
    @Column(name = "bcm_serie")
    private String bcmSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "bcm_exo_tva")
    private Integer bcmExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "bcm_exo_douane")
    private Integer bcmExoDouane = 0;

    /**
     * categorie du client
     */
    @Column(name = "bcm_cat")
    private String bcmCat;

    /**
     * code devise
     */
    @Column(name = "bcm_devise")
    private String bcmDevise;

    /**
     * objet
     */
    @Column(name = "bcm_object")
    private String bcmObject;

    /**
     * observation
     */
    @Column(name = "bcm_observation")
    private String bcmObservation;

    /**
     * code budget
     */
    @Column(name = "bcm_budget")
    private String bcmBudget;

    /**
     * total ht
     */
    @Column(name = "bcm_tot_ht")
    private Double bcmTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "bcm_tot_remise")
    private Double bcmTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "bcm_tot_rabais")
    private Double bcmTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "bcm_tot_tva")
    private Double bcmTotTva = 0D;

    /**
     * taux taxe complementaire
     */
    @Column(name = "bcm_taux_tc")
    private Float bcmTauxTc = 0F;

    /**
     * total taxe complementaire
     */
    @Column(name = "bcm_tot_tc")
    private Double bcmTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "bcm_tot_ttc")
    private Double bcmTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "bcm_tot_reglement")
    private Double bcmTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "bcm_solde")
    private Integer bcmSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "bcm_banque")
    private String bcmBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement 5=demande credit
     */
    @Column(name = "bcm_type_reg")
    private Integer bcmTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "bcm_mode_reg")
    private String bcmModeReg;

    /**
     * date echeance reliquat si type reg = 5
     */
    @Column(name = "bcm_echeance_reliquat")
    private LocalDate bcmEcheanceReliquat;

    /**
     * motif du rejet accord du credit
     */
    @Column(name = "bcm_motif_rejet_credit")
    private String bcmMotifRejetCredit;

    /**
     * nombre de jour
     */
    @Column(name = "bcm_nb_jour_reg")
    private Integer bcmNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "bcm_arrondi_reg")
    private Integer bcmArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "bcm_condition_reg")
    private String bcmConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "bcm_date_eche_reg")
    private LocalDate bcmDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "bcm_journal_reg")
    private String bcmJournalReg;

    /**
     * code activite
     */
    @Column(name = "bcm_activite")
    private String bcmActivite;

    /**
     * code site
     */
    @Column(name = "bcm_site")
    private String bcmSite;

    /**
     * code departement
     */
    @Column(name = "bcm_departement")
    private String bcmDepartement;

    /**
     * code service
     */
    @Column(name = "bcm_service")
    private String bcmService;

    /**
     * code region
     */
    @Column(name = "bcm_region")
    private String bcmRegion;

    /**
     * code secteur
     */
    @Column(name = "bcm_secteur")
    private String bcmSecteur;

    /**
     * code point de vente
     */
    @Column(name = "bcm_pdv")
    private String bcmPdv;

    /**
     * code analytique 2
     */
    @Column(name = "bcm_anal2")
    private String bcmAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "bcm_anal4")
    private String bcmAnal4;

    /**
     * info 1
     */
    @Column(name = "bcm_info1")
    private String bcmInfo1;

    /**
     * info 2
     */
    @Column(name = "bcm_info2")
    private String bcmInfo2;

    /**
     * info 3
     */
    @Column(name = "bcm_info3")
    private String bcmInfo3;

    /**
     * info 4
     */
    @Column(name = "bcm_info4")
    private String bcmInfo4;

    /**
     * info 5
     */
    @Column(name = "bcm_info5")
    private String bcmInfo5;

    /**
     * info 6
     */
    @Column(name = "bcm_info6")
    private String bcmInfo6;

    /**
     * info 7
     */
    @Column(name = "bcm_info7")
    private String bcmInfo7;

    /**
     * info 8
     */
    @Column(name = "bcm_info8")
    private String bcmInfo8;

    /**
     * info 9
     */
    @Column(name = "bcm_info9")
    private String bcmInfo9;

    /**
     * info 10
     */
    @Column(name = "bcm_info10")
    private String bcmInfo10;

    /**
     * code formule 1
     */
    @Column(name = "bcm_formule1")
    private String bcmFormule1;

    /**
     * code formule 2
     */
    @Column(name = "bcm_formule2")
    private String bcmFormule2;

    /**
     * nom jasper de l annexe 1
     */
    @Column(name = "bcm_annexe1")
    private String bcmAnnexe1;

    /**
     * nom jasper de l annexe 2
     */
    @Column(name = "bcm_annexe2")
    private String bcmAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "bcm_contrat")
    private String bcmContrat;

    /**
     * code incoterm
     */
    @Column(name = "bcm_incoterm")
    private String bcmIncoterm;

    /**
     * lieu de livraison
     */
    @Column(name = "bcm_lieu_livraison")
    private String bcmLieuLivraison;

    /**
     * date de livraison
     */
    @Column(name = "bcm_date_livraison")
    private LocalDate bcmDateLivraison;

    /**
     * info sur la livraison
     */
    @Column(name = "bcm_info_livraison")
    private String bcmInfoLivraison;

    /**
     * date impression
     */
    @Column(name = "bcm_date_imp")
    private LocalDateTime bcmDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "bcm_modele_imp")
    private String bcmModeleImp;

    /**
     * nom jasper page de garde
     */
    @Column(name = "bcm_garde")
    private String bcmGarde;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "bcm_etat_val")
    private Integer bcmEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "bcm_gele")
    private Integer bcmGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme partiel 5=transforme total
     */
    @Column(name = "bcm_etat")
    private Integer bcmEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "bcm_date_validite")
    private LocalDate bcmDateValidite;

    /**
     * date de relance
     */
    @Column(name = "bcm_date_relance")
    private LocalDate bcmDateRelance;

    /**
     * date de validation
     */
    @Column(name = "bcm_date_valide")
    private LocalDateTime bcmDateValide;

    /**
     * date de transformation
     */
    @Column(name = "bcm_date_transforme")
    private LocalDateTime bcmDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "bcm_type_transforme")
    private Integer bcmTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "bcm_date_annule")
    private LocalDateTime bcmDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "bcm_motif_annule")
    private String bcmMotifAnnule;

    /**
     * 0=normal 1=urgent 2=prioritaire
     */
    @Column(name = "bcm_niveau")
    private Integer bcmNiveau = 0;

    /**
     * nom du preparateur
     */
    @Column(name = "bcm_preparateur")
    private String bcmPreparateur;

    /**
     * conseil pour la preparation
     */
    @Column(name = "bcm_conseil")
    private String bcmConseil;

    /**
     * nom du factor
     */
    @Column(name = "bcm_factor_nom")
    private String bcmFactorNom;

    /**
     * id du factor
     */
    @Column(name = "bcm_factor_id")
    private Long bcmFactorId = 0L;

    /**
     * 0=en cours 1=accepter 2=refuser
     */
    @Column(name = "bcm_factor_etat")
    private Integer bcmFactorEtat = 0;

    /**
     * 0=initiale 1=en cours production 2=finale
     */
    @Column(name = "bcm_phase")
    private Integer bcmPhase = 0;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "bcm_divers_tiers")
    private Integer bcmDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "bcm_divers_nom")
    private String bcmDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "bcm_divers_adresse")
    private String bcmDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "bcm_divers_ville")
    private String bcmDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "bcm_divers_tel")
    private String bcmDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "bcm_divers_mail")
    private String bcmDiversMail;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom du commercial
     */
    @Column(name = "bcm_nom_commercial")
    private String bcmNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "bcm_id_commercial")
    private Long bcmIdCommercial = 0L;

    /**
     * nom equipe
     */
    @Column(name = "bcm_nom_equipe")
    private String bcmNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "bcm_id_equipe")
    private Long bcmIdEquipe = 0L;

    /**
     * taux remise globale
     */
    @Column(name = "bcm_taux_remise")
    private Float bcmTauxRemise = 0F;

    /**
     * source du document
     */
    @Column(name = "bcm_source")
    private String bcmSource;

}
