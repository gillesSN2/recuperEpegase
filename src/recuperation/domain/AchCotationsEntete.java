package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_cotations_entete")
public class AchCotationsEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cot_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cotId;

    /**
     * date de creation
     */
    @Column(name = "cot_date_creat")
    private LocalDateTime cotDateCreat;

    /**
     * date de modification
     */
    @Column(name = "cot_date_modif")
    private LocalDateTime cotDateModif;

    /**
     * id user createur
     */
    @Column(name = "cot_id_createur")
    private Long cotIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "cot_nom_createur")
    private String cotNomCreateur;

    /**
     * id utilisateur de modification
     */
    @Column(name = "cot_id_modif")
    private Long cotIdModif = 0L;

    /**
     * nom utilisateur de modification
     */
    @Column(name = "cot_nom_modif")
    private String cotNomModif;

    /**
     * date de cotation
     */
    @Column(name = "cot_date")
    private LocalDateTime cotDate;

    /**
     * numero
     */
    @Column(name = "cot_num")
    private String cotNum;

    /**
     * nom du commercial
     */
    @Column(name = "cot_nom_responsable")
    private String cotNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "cot_id_responsable")
    private Long cotIdResponsable = 0L;

    /**
     * nom du client
     */
    @Column(name = "cot_nom_tiers")
    private String cotNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "cot_civil_tiers")
    private String cotCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "cot_id_contact")
    private Long cotIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "cot_nom_contact")
    private String cotNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "cot_civil_contact")
    private String cotCivilContact;

    /**
     * serie
     */
    @Column(name = "cot_serie")
    private String cotSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "cot_exo_tva")
    private Integer cotExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "cot_exo_douane")
    private Integer cotExoDouane = 0;

    /**
     * categorie du fournisseur
     */
    @Column(name = "cot_cat")
    private String cotCat;

    /**
     * code devise
     */
    @Column(name = "cot_devise")
    private String cotDevise;

    /**
     * objet
     */
    @Column(name = "cot_object")
    private String cotObject;

    /**
     * observation
     */
    @Column(name = "cot_observation")
    private String cotObservation;

    /**
     * code budget
     */
    @Column(name = "cot_budget")
    private String cotBudget;

    /**
     * total ht
     */
    @Column(name = "cot_tot_ht")
    private Double cotTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "cot_tot_remise")
    private Double cotTotRemise = 0D;

    /**
     * budget treso
     */
    @Column(name = "cot_budget_treso")
    private Double cotBudgetTreso = 0D;

    /**
     * budget dispo
     */
    @Column(name = "cot_budget_dispo")
    private Double cotBudgetDispo = 0D;

    /**
     * budget mensuel dispo
     */
    @Column(name = "cot_budget_dispo_mois")
    private Double cotBudgetDispoMois = 0D;

    /**
     * budget mensuel treso
     */
    @Column(name = "cot_budget_treso_mois")
    private Double cotBudgetTresoMois = 0D;

    /**
     * total rabais
     */
    @Column(name = "cot_tot_rabais")
    private Double cotTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "cot_tot_tva")
    private Double cotTotTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "cot_tot_tc")
    private Double cotTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "cot_tot_ttc")
    private Double cotTotTtc = 0D;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "cot_banque")
    private String cotBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    @Column(name = "cot_type_reg")
    private Integer cotTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "cot_mode_reg")
    private String cotModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "cot_nb_jour_reg")
    private Integer cotNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "cot_arrondi_reg")
    private Integer cotArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "cot_condition_reg")
    private String cotConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "cot_date_eche_reg")
    private LocalDate cotDateEcheReg;

    /**
     * code activite
     */
    @Column(name = "cot_activite")
    private String cotActivite;

    /**
     * code site
     */
    @Column(name = "cot_site")
    private String cotSite;

    /**
     * code departement
     */
    @Column(name = "cot_departement")
    private String cotDepartement;

    /**
     * code service
     */
    @Column(name = "cot_service")
    private String cotService;

    /**
     * code region
     */
    @Column(name = "cot_region")
    private String cotRegion;

    /**
     * code secteur
     */
    @Column(name = "cot_secteur")
    private String cotSecteur;

    /**
     * code point de vente
     */
    @Column(name = "cot_pdv")
    private String cotPdv;

    /**
     * code analytique 2
     */
    @Column(name = "cot_anal2")
    private String cotAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "cot_anal4")
    private String cotAnal4;

    /**
     * info 1
     */
    @Column(name = "cot_info1")
    private String cotInfo1;

    /**
     * info 2
     */
    @Column(name = "cot_info2")
    private String cotInfo2;

    /**
     * info 3
     */
    @Column(name = "cot_info3")
    private String cotInfo3;

    /**
     * info 4
     */
    @Column(name = "cot_info4")
    private String cotInfo4;

    /**
     * info 5
     */
    @Column(name = "cot_info5")
    private String cotInfo5;

    /**
     * info 6
     */
    @Column(name = "cot_info6")
    private String cotInfo6;

    /**
     * info 7
     */
    @Column(name = "cot_info7")
    private String cotInfo7;

    /**
     * info 8
     */
    @Column(name = "cot_info8")
    private String cotInfo8;

    /**
     * info 9
     */
    @Column(name = "cot_info9")
    private String cotInfo9;

    /**
     * info 10
     */
    @Column(name = "cot_info10")
    private String cotInfo10;

    /**
     * code formule 1
     */
    @Column(name = "cot_formule1")
    private String cotFormule1;

    /**
     * code formule 2
     */
    @Column(name = "cot_formule2")
    private String cotFormule2;

    /**
     * nom jasper de l annexe 1
     */
    @Column(name = "cot_annexe1")
    private String cotAnnexe1;

    /**
     * nom jasper de l annexe 2
     */
    @Column(name = "cot_annexe2")
    private String cotAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "cot_contrat")
    private String cotContrat;

    /**
     * code incoterm
     */
    @Column(name = "cot_incoterm")
    private String cotIncoterm;

    /**
     * lieu de livraison
     */
    @Column(name = "cot_lieu_livraison")
    private String cotLieuLivraison;

    /**
     * date de livraison
     */
    @Column(name = "cot_date_livraison")
    private LocalDate cotDateLivraison;

    /**
     * info sur la livraison
     */
    @Column(name = "cot_info_livraison")
    private String cotInfoLivraison;

    /**
     * date impression
     */
    @Column(name = "cot_date_imp")
    private LocalDate cotDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "cot_modele_imp")
    private String cotModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "cot_etat_val")
    private Integer cotEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "cot_gele")
    private Integer cotGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme partiel 5=transforme total
     */
    @Column(name = "cot_etat")
    private Integer cotEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "cot_date_validite")
    private LocalDate cotDateValidite;

    /**
     * date de relance
     */
    @Column(name = "cot_date_relance")
    private LocalDate cotDateRelance;

    /**
     * date de validation
     */
    @Column(name = "cot_date_valide")
    private LocalDate cotDateValide;

    /**
     * date de transformation
     */
    @Column(name = "cot_date_transforme")
    private LocalDate cotDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "cot_type_transforme")
    private Integer cotTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "cot_date_annule")
    private LocalDate cotDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "cot_motif_annule")
    private String cotMotifAnnule;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "cot_divers_tiers")
    private Integer cotDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "cot_divers_nom")
    private String cotDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "cot_divers_adresse")
    private String cotDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "cot_divers_ville")
    private String cotDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "cot_divers_tel")
    private String cotDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "cot_divers_mail")
    private String cotDiversMail;

}
