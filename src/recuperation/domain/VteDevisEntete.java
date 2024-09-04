package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_devis_entete")
public class VteDevisEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dvs_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dvsId;

    /**
     * date de creation
     */
    @Column(name = "dvs_date_creat")
    private LocalDateTime dvsDateCreat;

    /**
     * date de modification
     */
    @Column(name = "dvs_date_modif")
    private LocalDateTime dvsDateModif;

    /**
     * id user createur
     */
    @Column(name = "dvs_id_createur")
    private Long dvsIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "dvs_nom_createur")
    private String dvsNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "dvs_id_modif")
    private Long dvsIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "dvs_nom_modif")
    private String dvsNomModif;

    /**
     * date du devis
     */
    @Column(name = "dvs_date")
    private LocalDateTime dvsDate;

    /**
     * numero devis
     */
    @Column(name = "dvs_num")
    private String dvsNum;

    /**
     * nom du commercial
     */
    @Column(name = "dvs_nom_responsable")
    private String dvsNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "dvs_id_responsable")
    private Long dvsIdResponsable = 0L;

    /**
     * nom du client
     */
    @Column(name = "dvs_nom_tiers")
    private String dvsNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "dvs_civil_tiers")
    private String dvsCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "dvs_id_contact")
    private Long dvsIdContact = 0L;

    /**
     * nom du contact ou destinataire
     */
    @Column(name = "dvs_nom_contact")
    private String dvsNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "dvs_civil_contact")
    private String dvsCivilContact;

    /**
     * serie A, B, C, D ou X
     */
    @Column(name = "dvs_serie")
    private String dvsSerie;

    /**
     * 0=avec tva 1=sans tva
     */
    @Column(name = "dvs_exo_tva")
    private Integer dvsExoTva = 0;

    /**
     * 0=avec douane 1=sans douane
     */
    @Column(name = "dvs_exo_douane")
    private Integer dvsExoDouane = 0;

    /**
     * categorie du client
     */
    @Column(name = "dvs_cat")
    private String dvsCat;

    /**
     * code devise
     */
    @Column(name = "dvs_devise")
    private String dvsDevise;

    /**
     * objet
     */
    @Column(name = "dvs_object")
    private String dvsObject;

    /**
     * observation
     */
    @Column(name = "dvs_observation")
    private String dvsObservation;

    /**
     * total ht
     */
    @Column(name = "dvs_tot_ht")
    private Double dvsTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "dvs_tot_remise")
    private Double dvsTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "dvs_tot_rabais")
    private Double dvsTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "dvs_tot_tva")
    private Double dvsTotTva = 0D;

    /**
     * taux taxe complementaire
     */
    @Column(name = "dvs_taux_tc")
    private Float dvsTauxTc = 0F;

    /**
     * total taxe complementaire
     */
    @Column(name = "dvs_tot_tc")
    private Double dvsTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "dvs_tot_ttc")
    private Double dvsTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "dvs_tot_reglement")
    private Double dvsTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "dvs_solde")
    private Integer dvsSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "dvs_banque")
    private String dvsBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement 5=demande credit
     */
    @Column(name = "dvs_type_reg")
    private Integer dvsTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "dvs_mode_reg")
    private String dvsModeReg;

    /**
     * date echeance reliquat si type reg = 5
     */
    @Column(name = "dvs_echeance_reliquat")
    private LocalDate dvsEcheanceReliquat;

    /**
     * motif du rejet accord du credit
     */
    @Column(name = "dvs_motif_rejet_credit")
    private String dvsMotifRejetCredit;

    /**
     * nombre de jour
     */
    @Column(name = "dvs_nb_jour_reg")
    private Integer dvsNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "dvs_arrondi_reg")
    private Integer dvsArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "dvs_condition_reg")
    private String dvsConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "dvs_date_eche_reg")
    private LocalDate dvsDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "dvs_journal_reg")
    private String dvsJournalReg;

    /**
     * code activite
     */
    @Column(name = "dvs_activite")
    private String dvsActivite;

    /**
     * code site
     */
    @Column(name = "dvs_site")
    private String dvsSite;

    /**
     * code departement
     */
    @Column(name = "dvs_departement")
    private String dvsDepartement;

    /**
     * code service
     */
    @Column(name = "dvs_service")
    private String dvsService;

    /**
     * code region
     */
    @Column(name = "dvs_region")
    private String dvsRegion;

    /**
     * code secteur
     */
    @Column(name = "dvs_secteur")
    private String dvsSecteur;

    /**
     * code point de vente
     */
    @Column(name = "dvs_pdv")
    private String dvsPdv;

    /**
     * code analytique 2 (parc)
     */
    @Column(name = "dvs_anal2")
    private String dvsAnal2;

    /**
     * code analytique 4 (dossier)
     */
    @Column(name = "dvs_anal4")
    private String dvsAnal4;

    /**
     * info 1
     */
    @Column(name = "dvs_info1")
    private String dvsInfo1;

    /**
     * info 2
     */
    @Column(name = "dvs_info2")
    private String dvsInfo2;

    /**
     * info 3
     */
    @Column(name = "dvs_info3")
    private String dvsInfo3;

    /**
     * info 4
     */
    @Column(name = "dvs_info4")
    private String dvsInfo4;

    /**
     * info 5
     */
    @Column(name = "dvs_info5")
    private String dvsInfo5;

    /**
     * info 6
     */
    @Column(name = "dvs_info6")
    private String dvsInfo6;

    /**
     * info 7
     */
    @Column(name = "dvs_info7")
    private String dvsInfo7;

    /**
     * info 8
     */
    @Column(name = "dvs_info8")
    private String dvsInfo8;

    /**
     * info 9
     */
    @Column(name = "dvs_info9")
    private String dvsInfo9;

    /**
     * info 10
     */
    @Column(name = "dvs_info10")
    private String dvsInfo10;

    /**
     * code formule 1
     */
    @Column(name = "dvs_formule1")
    private String dvsFormule1;

    /**
     * code formule 2
     */
    @Column(name = "dvs_formule2")
    private String dvsFormule2;

    /**
     * nom jasper du modele annexe 1
     */
    @Column(name = "dvs_annexe1")
    private String dvsAnnexe1;

    /**
     * nom jasper du modele annexe 2
     */
    @Column(name = "dvs_annexe2")
    private String dvsAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "dvs_contrat")
    private String dvsContrat;

    /**
     * code incoterm
     */
    @Column(name = "dvs_incoterm")
    private String dvsIncoterm;

    /**
     * lieu de livraison
     */
    @Column(name = "dvs_lieu_livraison")
    private String dvsLieuLivraison;

    /**
     * date de livraison
     */
    @Column(name = "dvs_date_livraison")
    private LocalDate dvsDateLivraison;

    /**
     * info sur la livraison
     */
    @Column(name = "dvs_info_livraison")
    private String dvsInfoLivraison;

    /**
     * date impression
     */
    @Column(name = "dvs_date_imp")
    private LocalDateTime dvsDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "dvs_modele_imp")
    private String dvsModeleImp;

    /**
     * nom jasper du modele page de garde
     */
    @Column(name = "dvs_garde")
    private String dvsGarde;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "dvs_etat_val")
    private Integer dvsEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "dvs_gele")
    private Integer dvsGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme partiel 5=transforme total
     */
    @Column(name = "dvs_etat")
    private Integer dvsEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "dvs_date_validite")
    private LocalDate dvsDateValidite;

    /**
     * date de relance
     */
    @Column(name = "dvs_date_relance")
    private LocalDate dvsDateRelance;

    /**
     * date de validation
     */
    @Column(name = "dvs_date_valide")
    private LocalDateTime dvsDateValide;

    /**
     * date de transformation
     */
    @Column(name = "dvs_date_transforme")
    private LocalDateTime dvsDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "dvs_type_transforme")
    private Integer dvsTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "dvs_date_annule")
    private LocalDateTime dvsDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "dvs_motif_annule")
    private String dvsMotifAnnule;

    /**
     * nom du factor
     */
    @Column(name = "dvs_factor_nom")
    private String dvsFactorNom;

    /**
     * id du factor
     */
    @Column(name = "dvs_factor_id")
    private Long dvsFactorId = 0L;

    /**
     * 0=en cours 1=accepter 2=refuser
     */
    @Column(name = "dvs_factor_etat")
    private Integer dvsFactorEtat = 0;

    /**
     * beneficiaires
     */
    @Column(name = "dvs_beneficiaire")
    private String dvsBeneficiaire;

    /**
     * numero accord
     */
    @Column(name = "dvs_accord")
    private String dvsAccord;

    /**
     * regime
     */
    @Column(name = "dvs_regime")
    private String dvsRegime;

    /**
     * bureau
     */
    @Column(name = "dvs_bureau")
    private String dvsBureau;

    /**
     * pays origine
     */
    @Column(name = "dvs_pays")
    private String dvsPays;

    /**
     * utilisation
     */
    @Column(name = "dvs_utilisation")
    private String dvsUtilisation;

    /**
     * fournisseur
     */
    @Column(name = "dvs_fournisseur")
    private String dvsFournisseur;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "dvs_divers_tiers")
    private Integer dvsDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "dvs_divers_nom")
    private String dvsDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "dvs_divers_adresse")
    private String dvsDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "dvs_divers_ville")
    private String dvsDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "dvs_divers_tel")
    private String dvsDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "dvs_divers_mail")
    private String dvsDiversMail;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom du commercial
     */
    @Column(name = "dvs_nom_commercial")
    private String dvsNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "dvs_id_commercial")
    private Long dvsIdCommercial = 0L;

    /**
     * nom equipe
     */
    @Column(name = "dvs_nom_equipe")
    private String dvsNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "dvs_id_equipe")
    private Long dvsIdEquipe = 0L;

    /**
     * taux remise globale
     */
    @Column(name = "dvs_taux_remise")
    private Float dvsTauxRemise = 0F;

    /**
     * source du document
     */
    @Column(name = "dvs_source")
    private String dvsSource;

}
