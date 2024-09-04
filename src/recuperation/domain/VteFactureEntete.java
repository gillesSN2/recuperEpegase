package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_facture_entete")
public class VteFactureEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "fac_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facId;

    /**
     * date de creation
     */
    @Column(name = "fac_date_creat")
    private LocalDateTime facDateCreat;

    /**
     * date de modification
     */
    @Column(name = "fac_date_modif")
    private LocalDateTime facDateModif;

    /**
     * id user createur
     */
    @Column(name = "fac_id_createur")
    private Long facIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "fac_nom_createur")
    private String facNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "fac_id_modif")
    private Long facIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "fac_nom_modif")
    private String facNomModif;

    /**
     * date du devis
     */
    @Column(name = "fac_date")
    private LocalDateTime facDate;

    /**
     * numero devis
     */
    @Column(name = "fac_num")
    private String facNum;

    /**
     * nom du commercial
     */
    @Column(name = "fac_nom_responsable")
    private String facNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "fac_id_responsable")
    private Long facIdResponsable = 0L;

    /**
     * nom du client
     */
    @Column(name = "fac_nom_tiers")
    private String facNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "fac_civil_tiers")
    private String facCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "fac_id_contact")
    private Long facIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "fac_nom_contact")
    private String facNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "fac_civil_contact")
    private String facCivilContact;

    /**
     * serie
     */
    @Column(name = "fac_serie")
    private String facSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "fac_exo_tva")
    private Integer facExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "fac_exo_douane")
    private Integer facExoDouane = 0;

    /**
     * categorie du client
     */
    @Column(name = "fac_cat")
    private String facCat;

    /**
     * code devise
     */
    @Column(name = "fac_devise")
    private String facDevise;

    /**
     * objet
     */
    @Column(name = "fac_object")
    private String facObject;

    /**
     * observation
     */
    @Column(name = "fac_observation")
    private String facObservation;

    /**
     * code budget
     */
    @Column(name = "fac_budget")
    private String facBudget;

    /**
     * total ht
     */
    @Column(name = "fac_tot_ht")
    private Double facTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "fac_tot_remise")
    private Double facTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "fac_tot_rabais")
    private Double facTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "fac_tot_tva")
    private Double facTotTva = 0D;

    /**
     * taux taxe complementaire
     */
    @Column(name = "fac_taux_tc")
    private Float facTauxTc = 0F;

    /**
     * total taxe complementaire
     */
    @Column(name = "fac_tot_tc")
    private Double facTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "fac_tot_ttc")
    private Double facTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "fac_tot_reglement")
    private Double facTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "fac_solde")
    private Integer facSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "fac_banque")
    private String facBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    @Column(name = "fac_type_reg")
    private Integer facTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "fac_mode_reg")
    private String facModeReg;

    /**
     * date echeance reliquat si type reg = 5
     */
    @Column(name = "fac_echeance_reliquat")
    private LocalDate facEcheanceReliquat;

    /**
     * motif du rejet accord du credit
     */
    @Column(name = "fac_motif_rejet_credit")
    private String facMotifRejetCredit;

    /**
     * nombre de jour
     */
    @Column(name = "fac_nb_jour_reg")
    private Integer facNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "fac_arrondi_reg")
    private Integer facArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "fac_condition_reg")
    private String facConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "fac_date_eche_reg")
    private LocalDate facDateEcheReg;

    /**
     * date dernier reglement
     */
    @Column(name = "fac_date_last_reg")
    private LocalDate facDateLastReg;

    /**
     * code journal des reglements
     */
    @Column(name = "fac_journal_reg")
    private String facJournalReg;

    /**
     * code activite
     */
    @Column(name = "fac_activite")
    private String facActivite;

    /**
     * code site
     */
    @Column(name = "fac_site")
    private String facSite;

    /**
     * code departement
     */
    @Column(name = "fac_departement")
    private String facDepartement;

    /**
     * code service
     */
    @Column(name = "fac_service")
    private String facService;

    /**
     * code region
     */
    @Column(name = "fac_region")
    private String facRegion;

    /**
     * code secteur
     */
    @Column(name = "fac_secteur")
    private String facSecteur;

    /**
     * code point de vente
     */
    @Column(name = "fac_pdv")
    private String facPdv;

    /**
     * code analytique 2
     */
    @Column(name = "fac_anal2")
    private String facAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "fac_anal4")
    private String facAnal4;

    /**
     * info 1
     */
    @Column(name = "fac_info1")
    private String facInfo1;

    /**
     * info 2
     */
    @Column(name = "fac_info2")
    private String facInfo2;

    /**
     * info 3
     */
    @Column(name = "fac_info3")
    private String facInfo3;

    /**
     * info 4
     */
    @Column(name = "fac_info4")
    private String facInfo4;

    /**
     * info 5
     */
    @Column(name = "fac_info5")
    private String facInfo5;

    /**
     * info 6
     */
    @Column(name = "fac_info6")
    private String facInfo6;

    /**
     * info 7
     */
    @Column(name = "fac_info7")
    private String facInfo7;

    /**
     * info 8
     */
    @Column(name = "fac_info8")
    private String facInfo8;

    /**
     * info 9
     */
    @Column(name = "fac_info9")
    private String facInfo9;

    /**
     * info 10
     */
    @Column(name = "fac_info10")
    private String facInfo10;

    /**
     * code formule 1
     */
    @Column(name = "fac_formule1")
    private String facFormule1;

    /**
     * code formule 2
     */
    @Column(name = "fac_formule2")
    private String facFormule2;

    /**
     * nom jasper de anexe 1
     */
    @Column(name = "fac_annexe1")
    private String facAnnexe1;

    /**
     * nom jasper de anexe 2
     */
    @Column(name = "fac_annexe2")
    private String facAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "fac_contrat")
    private String facContrat;

    /**
     * code incoterm
     */
    @Column(name = "fac_incoterm")
    private String facIncoterm;

    /**
     * lieu de livraison
     */
    @Column(name = "fac_lieu_livraison")
    private String facLieuLivraison;

    /**
     * date de livraison
     */
    @Column(name = "fac_date_livraison")
    private LocalDate facDateLivraison;

    /**
     * info sur la livraison
     */
    @Column(name = "fac_info_livraison")
    private String facInfoLivraison;

    /**
     * date impression
     */
    @Column(name = "fac_date_imp")
    private LocalDate facDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "fac_modele_imp")
    private String facModeleImp;

    /**
     * nom jasper page de garde
     */
    @Column(name = "fac_garde")
    private String facGarde;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "fac_etat_val")
    private Integer facEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "fac_gele")
    private Integer facGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "fac_etat")
    private Integer facEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "fac_date_validite")
    private LocalDate facDateValidite;

    /**
     * date de relance
     */
    @Column(name = "fac_date_relance")
    private LocalDate facDateRelance;

    /**
     * date de validation
     */
    @Column(name = "fac_date_valide")
    private LocalDate facDateValide;

    /**
     * date de transformation
     */
    @Column(name = "fac_date_transforme")
    private LocalDate facDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "fac_type_transforme")
    private Integer facTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "fac_date_annule")
    private LocalDate facDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "fac_motif_annule")
    private String facMotifAnnule;

    /**
     * motif exoneration
     */
    @Column(name = "fac_motif_exo")
    private String facMotifExo;

    /**
     * numero du visa
     */
    @Column(name = "fac_num_visa")
    private String facNumVisa;

    /**
     * date du visa
     */
    @Column(name = "fac_date_visa")
    private LocalDate facDateVisa;

    /**
     * rangement du visa
     */
    @Column(name = "fac_range_visa")
    private String facRangeVisa;

    /**
     * date transfert en compta
     */
    @Column(name = "fac_date_transfert")
    private LocalDate facDateTransfert;

    /**
     * nom du factor
     */
    @Column(name = "fac_factor_nom")
    private String facFactorNom;

    /**
     * id du factor
     */
    @Column(name = "fac_factor_id")
    private Long facFactorId = 0L;

    /**
     * 0=en cours 1=accepter 2=refuser
     */
    @Column(name = "fac_factor_etat")
    private Integer facFactorEtat = 0;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "fac_divers_tiers")
    private Integer facDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "fac_divers_nom")
    private String facDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "fac_divers_adresse")
    private String facDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "fac_divers_ville")
    private String facDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "fac_divers_tel")
    private String facDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "fac_divers_mail")
    private String facDiversMail;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom du commercial
     */
    @Column(name = "fac_nom_commercial")
    private String facNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "fac_id_commercial")
    private Long facIdCommercial = 0L;

    /**
     * si facture directe et stock alors 1 sinon 0
     */
    @Column(name = "fac_stock")
    private Integer facStock = 0;

    /**
     * nom equipe
     */
    @Column(name = "fac_nom_equipe")
    private String facNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "fac_id_equipe")
    private Long facIdEquipe = 0L;

    /**
     * numero de transfert
     */
    @Column(name = "fac_num_trf")
    private String facNumTrf;

    /**
     * numero dernier bl
     */
    @Column(name = "fac_num_bl")
    private String facNumBl;

    /**
     * numero avoir
     */
    @Column(name = "fac_num_avoir")
    private String facNumAvoir;

    /**
     * total timbre
     */
    @Column(name = "fac_tot_timbre")
    private Double facTotTimbre = 0D;

    /**
     * taux remise globale
     */
    @Column(name = "fac_taux_remise")
    private Float facTauxRemise = 0F;

    /**
     * source du document
     */
    @Column(name = "fac_source")
    private String facSource;

}
