package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_besoin_entete")
public class VteBesoinEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bes_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long besId;

    /**
     * date de creation
     */
    @Column(name = "bes_date_creat")
    private LocalDateTime besDateCreat;

    /**
     * date de modification
     */
    @Column(name = "bes_date_modif")
    private LocalDateTime besDateModif;

    /**
     * id user createur
     */
    @Column(name = "bes_id_createur")
    private Long besIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "bes_nom_createur")
    private String besNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "bes_id_modif")
    private Long besIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "bes_nom_modif")
    private String besNomModif;

    /**
     * date du devis
     */
    @Column(name = "bes_date")
    private LocalDateTime besDate;

    /**
     * numero devis
     */
    @Column(name = "bes_num")
    private String besNum;

    /**
     * nom du commercial
     */
    @Column(name = "bes_nom_responsable")
    private String besNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "bes_id_responsable")
    private Long besIdResponsable = 0L;

    /**
     * nom du commercial
     */
    @Column(name = "bes_nom_commercial")
    private String besNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "bes_id_commercial")
    private Long besIdCommercial = 0L;

    /**
     * code campagne
     */
    @Column(name = "bes_num_campagne")
    private String besNumCampagne;

    /**
     * id du campagne
     */
    @Column(name = "bes_id_campagne")
    private Long besIdCampagne = 0L;

    /**
     * nom du client
     */
    @Column(name = "bes_nom_tiers")
    private String besNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "bes_civil_tiers")
    private String besCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "bes_id_contact")
    private Long besIdContact = 0L;

    /**
     * nom du contact ou destinataire
     */
    @Column(name = "bes_nom_contact")
    private String besNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "bes_civil_contact")
    private String besCivilContact;

    /**
     * serie A, B, C, D ou X
     */
    @Column(name = "bes_serie")
    private String besSerie;

    /**
     * 0=avec tva 1=sans tva
     */
    @Column(name = "bes_exo_tva")
    private Integer besExoTva = 0;

    /**
     * 0=avec douane 1=sans douane
     */
    @Column(name = "bes_exo_douane")
    private Integer besExoDouane = 0;

    /**
     * categorie du tarif
     */
    @Column(name = "bes_cat")
    private String besCat;

    /**
     * code devise
     */
    @Column(name = "bes_devise")
    private String besDevise;

    /**
     * objet
     */
    @Column(name = "bes_object")
    private String besObject;

    /**
     * observation
     */
    @Column(name = "bes_observation")
    private String besObservation;

    /**
     * total ht
     */
    @Column(name = "bes_tot_ht")
    private Double besTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "bes_tot_remise")
    private Double besTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "bes_tot_rabais")
    private Double besTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "bes_tot_tva")
    private Double besTotTva = 0D;

    /**
     * taux taxe complementaire
     */
    @Column(name = "bes_taux_tc")
    private Float besTauxTc = 0F;

    /**
     * total taxe complementaire
     */
    @Column(name = "bes_tot_tc")
    private Double besTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "bes_tot_ttc")
    private Double besTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "bes_tot_reglement")
    private Double besTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "bes_solde")
    private Integer besSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "bes_banque")
    private String besBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement 5=demande credit
     */
    @Column(name = "bes_type_reg")
    private Integer besTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "bes_mode_reg")
    private String besModeReg;

    /**
     * date echeance reliquat si type reg = 5
     */
    @Column(name = "bes_echeance_reliquat")
    private LocalDate besEcheanceReliquat;

    /**
     * motif du rejet accord du credit
     */
    @Column(name = "bes_motif_rejet_credit")
    private String besMotifRejetCredit;

    /**
     * nombre de jour
     */
    @Column(name = "bes_nb_jour_reg")
    private Integer besNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "bes_arrondi_reg")
    private Integer besArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "bes_condition_reg")
    private String besConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "bes_date_eche_reg")
    private LocalDate besDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "bes_journal_reg")
    private String besJournalReg;

    /**
     * code activite
     */
    @Column(name = "bes_activite")
    private String besActivite;

    /**
     * code site
     */
    @Column(name = "bes_site")
    private String besSite;

    /**
     * code departement
     */
    @Column(name = "bes_departement")
    private String besDepartement;

    /**
     * code service
     */
    @Column(name = "bes_service")
    private String besService;

    /**
     * code region
     */
    @Column(name = "bes_region")
    private String besRegion;

    /**
     * code secteur
     */
    @Column(name = "bes_secteur")
    private String besSecteur;

    /**
     * code point de vente
     */
    @Column(name = "bes_pdv")
    private String besPdv;

    /**
     * code analytique 2 (parc)
     */
    @Column(name = "bes_anal2")
    private String besAnal2;

    /**
     * code analytique 4 (dossier)
     */
    @Column(name = "bes_anal4")
    private String besAnal4;

    /**
     * date impression
     */
    @Column(name = "bes_date_imp")
    private LocalDateTime besDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "bes_modele_imp")
    private String besModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "bes_etat_val")
    private Integer besEtatVal = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme partiel 5=transforme total
     */
    @Column(name = "bes_etat")
    private Integer besEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "bes_date_validite")
    private LocalDate besDateValidite;

    /**
     * date de relance
     */
    @Column(name = "bes_date_relance")
    private LocalDate besDateRelance;

    /**
     * date de validation
     */
    @Column(name = "bes_date_valide")
    private LocalDateTime besDateValide;

    /**
     * date de transformation
     */
    @Column(name = "bes_date_transforme")
    private LocalDateTime besDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "bes_type_transforme")
    private Integer besTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "bes_date_annule")
    private LocalDateTime besDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "bes_motif_annule")
    private String besMotifAnnule;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "bes_divers_tiers")
    private Integer besDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "bes_divers_nom")
    private String besDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "bes_divers_adresse")
    private String besDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "bes_divers_ville")
    private String besDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "bes_divers_tel")
    private String besDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "bes_divers_mail")
    private String besDiversMail;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "tie_id")
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom equipe
     */
    @Column(name = "bes_nom_equipe")
    private String besNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "bes_id_equipe")
    private Long besIdEquipe = 0L;

}
