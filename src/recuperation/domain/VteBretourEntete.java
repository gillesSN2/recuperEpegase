package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_bretour_entete")
public class VteBretourEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "brt_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brtId;

    /**
     * date de creation
     */
    @Column(name = "brt_date_creat")
    private LocalDateTime brtDateCreat;

    /**
     * date de modification
     */
    @Column(name = "brt_date_modif")
    private LocalDateTime brtDateModif;

    /**
     * id user createur
     */
    @Column(name = "brt_id_createur")
    private Long brtIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "brt_nom_createur")
    private String brtNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "brt_id_modif")
    private Long brtIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "brt_nom_modif")
    private String brtNomModif;

    /**
     * date du bon
     */
    @Column(name = "brt_date")
    private LocalDateTime brtDate;

    /**
     * numero devis
     */
    @Column(name = "brt_num")
    private String brtNum;

    /**
     * nom du commercial
     */
    @Column(name = "brt_nom_responsable")
    private String brtNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "brt_id_responsable")
    private Long brtIdResponsable = 0L;

    /**
     * nom du client
     */
    @Column(name = "brt_nom_tiers")
    private String brtNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "brt_civil_tiers")
    private String brtCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "brt_id_contact")
    private Long brtIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "brt_nom_contact")
    private String brtNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "brt_civil_contact")
    private String brtCivilContact;

    /**
     * serie
     */
    @Column(name = "brt_serie")
    private String brtSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "brt_exo_tva")
    private Integer brtExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "brt_exo_douane")
    private Integer brtExoDouane = 0;

    /**
     * categorie du client
     */
    @Column(name = "brt_cat")
    private String brtCat;

    /**
     * code devise
     */
    @Column(name = "brt_devise")
    private String brtDevise;

    /**
     * objet
     */
    @Column(name = "brt_object")
    private String brtObject;

    /**
     * observation
     */
    @Column(name = "brt_observation")
    private String brtObservation;

    /**
     * code budget
     */
    @Column(name = "brt_budget")
    private String brtBudget;

    /**
     * total ht
     */
    @Column(name = "brt_tot_ht")
    private Double brtTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "brt_tot_remise")
    private Double brtTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "brt_tot_rabais")
    private Double brtTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "brt_tot_tva")
    private Double brtTotTva = 0D;

    /**
     * taux taxe complementaire
     */
    @Column(name = "brt_taux_tc")
    private Float brtTauxTc = 0F;

    /**
     * total taxe complementaire
     */
    @Column(name = "brt_tot_tc")
    private Double brtTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "brt_tot_ttc")
    private Double brtTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "brt_tot_reglement")
    private Double brtTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "brt_solde")
    private Integer brtSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "brt_banque")
    private String brtBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    @Column(name = "brt_type_reg")
    private Integer brtTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "brt_mode_reg")
    private String brtModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "brt_nb_jour_reg")
    private Integer brtNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "brt_arrondi_reg")
    private Integer brtArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "brt_condition_reg")
    private String brtConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "brt_date_eche_reg")
    private LocalDate brtDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "brt_journal_reg")
    private String brtJournalReg;

    /**
     * code activite
     */
    @Column(name = "brt_activite")
    private String brtActivite;

    /**
     * code site
     */
    @Column(name = "brt_site")
    private String brtSite;

    /**
     * code departement
     */
    @Column(name = "brt_departement")
    private String brtDepartement;

    /**
     * code service
     */
    @Column(name = "brt_service")
    private String brtService;

    /**
     * code region
     */
    @Column(name = "brt_region")
    private String brtRegion;

    /**
     * code secteur
     */
    @Column(name = "brt_secteur")
    private String brtSecteur;

    /**
     * code point de vente
     */
    @Column(name = "brt_pdv")
    private String brtPdv;

    /**
     * code analytique 2
     */
    @Column(name = "brt_anal2")
    private String brtAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "brt_anal4")
    private String brtAnal4;

    /**
     * info 1
     */
    @Column(name = "brt_info1")
    private String brtInfo1;

    /**
     * info 2
     */
    @Column(name = "brt_info2")
    private String brtInfo2;

    /**
     * info 3
     */
    @Column(name = "brt_info3")
    private String brtInfo3;

    /**
     * info 4
     */
    @Column(name = "brt_info4")
    private String brtInfo4;

    /**
     * info 5
     */
    @Column(name = "brt_info5")
    private String brtInfo5;

    /**
     * info 6
     */
    @Column(name = "brt_info6")
    private String brtInfo6;

    /**
     * info 7
     */
    @Column(name = "brt_info7")
    private String brtInfo7;

    /**
     * info 8
     */
    @Column(name = "brt_info8")
    private String brtInfo8;

    /**
     * info 9
     */
    @Column(name = "brt_info9")
    private String brtInfo9;

    /**
     * info 10
     */
    @Column(name = "brt_info10")
    private String brtInfo10;

    /**
     * code formule 1
     */
    @Column(name = "brt_formule1")
    private String brtFormule1;

    /**
     * code formule 2
     */
    @Column(name = "brt_formule2")
    private String brtFormule2;

    /**
     * nom jasper de anexe 1
     */
    @Column(name = "brt_annexe1")
    private String brtAnnexe1;

    /**
     * nom jasper de anexe 2
     */
    @Column(name = "brt_annexe2")
    private String brtAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "brt_contrat")
    private String brtContrat;

    /**
     * code incoterm
     */
    @Column(name = "brt_incoterm")
    private String brtIncoterm;

    /**
     * lieu de livraison
     */
    @Column(name = "brt_lieu_livraison")
    private String brtLieuLivraison;

    /**
     * date de livraison
     */
    @Column(name = "brt_date_livraison")
    private LocalDate brtDateLivraison;

    /**
     * info sur la livraison
     */
    @Column(name = "brt_info_livraison")
    private String brtInfoLivraison;

    /**
     * date impression
     */
    @Column(name = "brt_date_imp")
    private LocalDate brtDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "brt_modele_imp")
    private String brtModeleImp;

    /**
     * nom jasper page de garde
     */
    @Column(name = "brt_garde")
    private String brtGarde;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "brt_etat_val")
    private Integer brtEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "brt_gele")
    private Integer brtGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "brt_etat")
    private Integer brtEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "brt_date_validite")
    private LocalDate brtDateValidite;

    /**
     * date de relance
     */
    @Column(name = "brt_date_relance")
    private LocalDate brtDateRelance;

    /**
     * date de validation
     */
    @Column(name = "brt_date_valide")
    private LocalDate brtDateValide;

    /**
     * date de transformation
     */
    @Column(name = "brt_date_transforme")
    private LocalDate brtDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "brt_type_transforme")
    private Integer brtTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "brt_date_annule")
    private LocalDate brtDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "brt_motif_annule")
    private String brtMotifAnnule;

    /**
     * nom du factor
     */
    @Column(name = "brt_factor_nom")
    private String brtFactorNom;

    /**
     * id du factor
     */
    @Column(name = "brt_factor_id")
    private Long brtFactorId = 0L;

    /**
     * 0=en cours 1=accepter 2=refuser
     */
    @Column(name = "brt_factor_etat")
    private Integer brtFactorEtat = 0;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "brt_divers_tiers")
    private Integer brtDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "brt_divers_nom")
    private String brtDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "brt_divers_adresse")
    private String brtDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "brt_divers_ville")
    private String brtDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "brt_divers_tel")
    private String brtDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "brt_divers_mail")
    private String brtDiversMail;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom du commercial
     */
    @Column(name = "brt_nom_commercial")
    private String brtNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "brt_id_commercial")
    private Long brtIdCommercial = 0L;

    /**
     * nom equipe
     */
    @Column(name = "brt_nom_equipe")
    private String brtNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "brt_id_equipe")
    private Long brtIdEquipe = 0L;

    /**
     * numero avoir
     */
    @Column(name = "brt_num_avoir")
    private String brtNumAvoir;

    /**
     * taux remise globale
     */
    @Column(name = "brt_taux_remise")
    private Float brtTauxRemise = 0F;

    /**
     * source du document
     */
    @Column(name = "brt_source")
    private String brtSource;

}
