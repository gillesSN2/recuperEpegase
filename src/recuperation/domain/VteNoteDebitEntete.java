package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_note_debit_entete")
public class VteNoteDebitEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ndb_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ndbId;

    /**
     * date de creation
     */
    @Column(name = "ndb_date_creat")
    private LocalDateTime ndbDateCreat;

    /**
     * date de modification
     */
    @Column(name = "ndb_date_modif")
    private LocalDateTime ndbDateModif;

    /**
     * id user createur
     */
    @Column(name = "ndb_id_createur")
    private Long ndbIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "ndb_nom_createur")
    private String ndbNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "ndb_id_modif")
    private Long ndbIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "ndb_nom_modif")
    private String ndbNomModif;

    /**
     * date du devis
     */
    @Column(name = "ndb_date")
    private LocalDateTime ndbDate;

    /**
     * numero devis
     */
    @Column(name = "ndb_num")
    private String ndbNum;

    /**
     * nom du commercial
     */
    @Column(name = "ndb_nom_responsable")
    private String ndbNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "ndb_id_responsable")
    private Long ndbIdResponsable = 0L;

    /**
     * nom du client
     */
    @Column(name = "ndb_nom_tiers")
    private String ndbNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "ndb_civil_tiers")
    private String ndbCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "ndb_id_contact")
    private Long ndbIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "ndb_nom_contact")
    private String ndbNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "ndb_civil_contact")
    private String ndbCivilContact;

    /**
     * serie
     */
    @Column(name = "ndb_serie")
    private String ndbSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "ndb_exo_tva")
    private Integer ndbExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "ndb_exo_douane")
    private Integer ndbExoDouane = 0;

    /**
     * categorie du client
     */
    @Column(name = "ndb_cat")
    private String ndbCat;

    /**
     * code devise
     */
    @Column(name = "ndb_devise")
    private String ndbDevise;

    /**
     * objet
     */
    @Column(name = "ndb_object")
    private String ndbObject;

    /**
     * observation
     */
    @Column(name = "ndb_observation")
    private String ndbObservation;

    /**
     * code budget
     */
    @Column(name = "ndb_budget")
    private String ndbBudget;

    /**
     * total ht
     */
    @Column(name = "ndb_tot_ht")
    private Double ndbTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "ndb_tot_remise")
    private Double ndbTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "ndb_tot_rabais")
    private Double ndbTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "ndb_tot_tva")
    private Double ndbTotTva = 0D;

    /**
     * taux taxe complementaire
     */
    @Column(name = "ndb_taux_tc")
    private Float ndbTauxTc = 0F;

    /**
     * total taxe complementaire
     */
    @Column(name = "ndb_tot_tc")
    private Double ndbTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "ndb_tot_ttc")
    private Double ndbTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "ndb_tot_reglement")
    private Double ndbTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "ndb_solde")
    private Integer ndbSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "ndb_banque")
    private String ndbBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    @Column(name = "ndb_type_reg")
    private Integer ndbTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "ndb_mode_reg")
    private String ndbModeReg;

    /**
     * date echeance reliquat si type reg = 5
     */
    @Column(name = "ndb_echeance_reliquat")
    private LocalDate ndbEcheanceReliquat;

    /**
     * motif du rejet accord du credit
     */
    @Column(name = "ndb_motif_rejet_credit")
    private String ndbMotifRejetCredit;

    /**
     * nombre de jour
     */
    @Column(name = "ndb_nb_jour_reg")
    private Integer ndbNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "ndb_arrondi_reg")
    private Integer ndbArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "ndb_condition_reg")
    private String ndbConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "ndb_date_eche_reg")
    private LocalDate ndbDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "ndb_journal_reg")
    private String ndbJournalReg;

    /**
     * code activite
     */
    @Column(name = "ndb_activite")
    private String ndbActivite;

    /**
     * code site
     */
    @Column(name = "ndb_site")
    private String ndbSite;

    /**
     * code departement
     */
    @Column(name = "ndb_departement")
    private String ndbDepartement;

    /**
     * code service
     */
    @Column(name = "ndb_service")
    private String ndbService;

    /**
     * code region
     */
    @Column(name = "ndb_region")
    private String ndbRegion;

    /**
     * code secteur
     */
    @Column(name = "ndb_secteur")
    private String ndbSecteur;

    /**
     * code point de vente
     */
    @Column(name = "ndb_pdv")
    private String ndbPdv;

    /**
     * code analytique 2
     */
    @Column(name = "ndb_anal2")
    private String ndbAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "ndb_anal4")
    private String ndbAnal4;

    /**
     * info 1
     */
    @Column(name = "ndb_info1")
    private String ndbInfo1;

    /**
     * info 2
     */
    @Column(name = "ndb_info2")
    private String ndbInfo2;

    /**
     * info 3
     */
    @Column(name = "ndb_info3")
    private String ndbInfo3;

    /**
     * info 4
     */
    @Column(name = "ndb_info4")
    private String ndbInfo4;

    /**
     * info 5
     */
    @Column(name = "ndb_info5")
    private String ndbInfo5;

    /**
     * info 6
     */
    @Column(name = "ndb_info6")
    private String ndbInfo6;

    /**
     * info 7
     */
    @Column(name = "ndb_info7")
    private String ndbInfo7;

    /**
     * info 8
     */
    @Column(name = "ndb_info8")
    private String ndbInfo8;

    /**
     * info 9
     */
    @Column(name = "ndb_info9")
    private String ndbInfo9;

    /**
     * info 10
     */
    @Column(name = "ndb_info10")
    private String ndbInfo10;

    /**
     * code formule 1
     */
    @Column(name = "ndb_formule1")
    private String ndbFormule1;

    /**
     * code formule 2
     */
    @Column(name = "ndb_formule2")
    private String ndbFormule2;

    /**
     * nom jasper de anexe 1
     */
    @Column(name = "ndb_annexe1")
    private String ndbAnnexe1;

    /**
     * nom jasper de anexe 2
     */
    @Column(name = "ndb_annexe2")
    private String ndbAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "ndb_contrat")
    private String ndbContrat;

    /**
     * code incoterm
     */
    @Column(name = "ndb_incoterm")
    private String ndbIncoterm;

    /**
     * lieu de livraison
     */
    @Column(name = "ndb_lieu_livraison")
    private String ndbLieuLivraison;

    /**
     * date de livraison
     */
    @Column(name = "ndb_date_livraison")
    private LocalDate ndbDateLivraison;

    /**
     * info sur la livraison
     */
    @Column(name = "ndb_info_livraison")
    private String ndbInfoLivraison;

    /**
     * date impression
     */
    @Column(name = "ndb_date_imp")
    private LocalDate ndbDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "ndb_modele_imp")
    private String ndbModeleImp;

    /**
     * nom jasper page de garde
     */
    @Column(name = "ndb_garde")
    private String ndbGarde;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "ndb_etat_val")
    private Integer ndbEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "ndb_gele")
    private Integer ndbGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "ndb_etat")
    private Integer ndbEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "ndb_date_validite")
    private LocalDate ndbDateValidite;

    /**
     * date de relance
     */
    @Column(name = "ndb_date_relance")
    private LocalDate ndbDateRelance;

    /**
     * date de validation
     */
    @Column(name = "ndb_date_valide")
    private LocalDate ndbDateValide;

    /**
     * date de transformation
     */
    @Column(name = "ndb_date_transforme")
    private LocalDate ndbDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "ndb_type_transforme")
    private Integer ndbTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "ndb_date_annule")
    private LocalDate ndbDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "ndb_motif_annule")
    private String ndbMotifAnnule;

    /**
     * 0=non exo 1=exoneree
     */
    @Column(name = "ndb_exo")
    private Integer ndbExo = 0;

    /**
     * motif exoneration
     */
    @Column(name = "ndb_motif_exo")
    private String ndbMotifExo;

    /**
     * numero du visa
     */
    @Column(name = "ndb_num_visa")
    private String ndbNumVisa;

    /**
     * date du visa
     */
    @Column(name = "ndb_date_visa")
    private LocalDate ndbDateVisa;

    /**
     * rangement du visa
     */
    @Column(name = "ndb_range_visa")
    private String ndbRangeVisa;

    /**
     * date transfert en compta
     */
    @Column(name = "ndb_date_transfert")
    private LocalDate ndbDateTransfert;

    /**
     * nom du factor
     */
    @Column(name = "ndb_factor_nom")
    private String ndbFactorNom;

    /**
     * id du factor
     */
    @Column(name = "ndb_factor_id")
    private Long ndbFactorId = 0L;

    /**
     * 0=en cours 1=accepter 2=refuser
     */
    @Column(name = "ndb_factor_etat")
    private Integer ndbFactorEtat = 0;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "ndb_divers_tiers")
    private Integer ndbDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "ndb_divers_nom")
    private String ndbDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "ndb_divers_adresse")
    private String ndbDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "ndb_divers_ville")
    private String ndbDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "ndb_divers_tel")
    private String ndbDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "ndb_divers_mail")
    private String ndbDiversMail;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom du commercial
     */
    @Column(name = "ndb_nom_commercial")
    private String ndbNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "ndb_id_commercial")
    private Long ndbIdCommercial = 0L;

    /**
     * date dernier reglement
     */
    @Column(name = "ndb_date_last_reg")
    private LocalDate ndbDateLastReg;

    /**
     * nom equipe
     */
    @Column(name = "ndb_nom_equipe")
    private String ndbNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "ndb_id_equipe")
    private Long ndbIdEquipe = 0L;

    /**
     * numero de transfert
     */
    @Column(name = "ndb_num_trf")
    private String ndbNumTrf;

    /**
     * taux remise globale
     */
    @Column(name = "ndb_taux_remise")
    private Float ndbTauxRemise = 0F;

    /**
     * source du document
     */
    @Column(name = "ndb_source")
    private String ndbSource;

}
