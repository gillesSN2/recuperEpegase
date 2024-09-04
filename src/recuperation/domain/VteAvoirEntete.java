package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_avoir_entete")
public class VteAvoirEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "avr_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avrId;

    /**
     * date de creation
     */
    @Column(name = "avr_date_creat")
    private LocalDateTime avrDateCreat;

    /**
     * date de modification
     */
    @Column(name = "avr_date_modif")
    private LocalDateTime avrDateModif;

    /**
     * id user createur
     */
    @Column(name = "avr_id_createur")
    private Long avrIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "avr_nom_createur")
    private String avrNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "avr_id_modif")
    private Long avrIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "avr_nom_modif")
    private String avrNomModif;

    /**
     * date du devis
     */
    @Column(name = "avr_date")
    private LocalDateTime avrDate;

    /**
     * numero devis
     */
    @Column(name = "avr_num")
    private String avrNum;

    /**
     * nom du commercial
     */
    @Column(name = "avr_nom_responsable")
    private String avrNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "avr_id_responsable")
    private Long avrIdResponsable = 0L;

    /**
     * nom du client
     */
    @Column(name = "avr_nom_tiers")
    private String avrNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "avr_civil_tiers")
    private String avrCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "avr_id_contact")
    private Long avrIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "avr_nom_contact")
    private String avrNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "avr_civil_contact")
    private String avrCivilContact;

    /**
     * serie
     */
    @Column(name = "avr_serie")
    private String avrSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "avr_exo_tva")
    private Integer avrExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "avr_exo_douane")
    private Integer avrExoDouane = 0;

    /**
     * categorie du client
     */
    @Column(name = "avr_cat")
    private String avrCat;

    /**
     * code devise
     */
    @Column(name = "avr_devise")
    private String avrDevise;

    /**
     * objet
     */
    @Column(name = "avr_object")
    private String avrObject;

    /**
     * observation
     */
    @Column(name = "avr_observation")
    private String avrObservation;

    /**
     * code budget
     */
    @Column(name = "avr_budget")
    private String avrBudget;

    /**
     * total ht
     */
    @Column(name = "avr_tot_ht")
    private Double avrTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "avr_tot_remise")
    private Double avrTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "avr_tot_rabais")
    private Double avrTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "avr_tot_tva")
    private Double avrTotTva = 0D;

    /**
     * taux taxe complementaire
     */
    @Column(name = "avr_taux_tc")
    private Float avrTauxTc = 0F;

    /**
     * total taxe complementaire
     */
    @Column(name = "avr_tot_tc")
    private Double avrTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "avr_tot_ttc")
    private Double avrTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "avr_tot_reglement")
    private Double avrTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "avr_solde")
    private Integer avrSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "avr_banque")
    private String avrBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    @Column(name = "avr_type_reg")
    private Integer avrTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "avr_mode_reg")
    private String avrModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "avr_nb_jour_reg")
    private Integer avrNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "avr_arrondi_reg")
    private Integer avrArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "avr_condition_reg")
    private String avrConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "avr_date_eche_reg")
    private LocalDate avrDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "avr_journal_reg")
    private String avrJournalReg;

    /**
     * code activite
     */
    @Column(name = "avr_activite")
    private String avrActivite;

    /**
     * code site
     */
    @Column(name = "avr_site")
    private String avrSite;

    /**
     * code departement
     */
    @Column(name = "avr_departement")
    private String avrDepartement;

    /**
     * code service
     */
    @Column(name = "avr_service")
    private String avrService;

    /**
     * code region
     */
    @Column(name = "avr_region")
    private String avrRegion;

    /**
     * code secteur
     */
    @Column(name = "avr_secteur")
    private String avrSecteur;

    /**
     * code point de vente
     */
    @Column(name = "avr_pdv")
    private String avrPdv;

    /**
     * code analytique 2
     */
    @Column(name = "avr_anal2")
    private String avrAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "avr_anal4")
    private String avrAnal4;

    /**
     * info 1
     */
    @Column(name = "avr_info1")
    private String avrInfo1;

    /**
     * info 2
     */
    @Column(name = "avr_info2")
    private String avrInfo2;

    /**
     * info 3
     */
    @Column(name = "avr_info3")
    private String avrInfo3;

    /**
     * info 4
     */
    @Column(name = "avr_info4")
    private String avrInfo4;

    /**
     * info 5
     */
    @Column(name = "avr_info5")
    private String avrInfo5;

    /**
     * info 6
     */
    @Column(name = "avr_info6")
    private String avrInfo6;

    /**
     * info 7
     */
    @Column(name = "avr_info7")
    private String avrInfo7;

    /**
     * info 8
     */
    @Column(name = "avr_info8")
    private String avrInfo8;

    /**
     * info 9
     */
    @Column(name = "avr_info9")
    private String avrInfo9;

    /**
     * info 10
     */
    @Column(name = "avr_info10")
    private String avrInfo10;

    /**
     * code formule 1
     */
    @Column(name = "avr_formule1")
    private String avrFormule1;

    /**
     * code formule 2
     */
    @Column(name = "avr_formule2")
    private String avrFormule2;

    /**
     * nom jasper de anexe 1
     */
    @Column(name = "avr_annexe1")
    private String avrAnnexe1;

    /**
     * nom jasper de anexe 2
     */
    @Column(name = "avr_annexe2")
    private String avrAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "avr_contrat")
    private String avrContrat;

    /**
     * code incoterm
     */
    @Column(name = "avr_incoterm")
    private String avrIncoterm;

    /**
     * lieu de livraison
     */
    @Column(name = "avr_lieu_livraison")
    private String avrLieuLivraison;

    /**
     * date de livraison
     */
    @Column(name = "avr_date_livraison")
    private LocalDate avrDateLivraison;

    /**
     * info sur la livraison
     */
    @Column(name = "avr_info_livraison")
    private String avrInfoLivraison;

    /**
     * date impression
     */
    @Column(name = "avr_date_imp")
    private LocalDate avrDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "avr_modele_imp")
    private String avrModeleImp;

    /**
     * nom jasper page de garde
     */
    @Column(name = "avr_garde")
    private String avrGarde;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "avr_etat_val")
    private Integer avrEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "avr_gele")
    private Integer avrGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "avr_etat")
    private Integer avrEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "avr_date_validite")
    private LocalDate avrDateValidite;

    /**
     * date de relance
     */
    @Column(name = "avr_date_relance")
    private LocalDate avrDateRelance;

    /**
     * date de validation
     */
    @Column(name = "avr_date_valide")
    private LocalDate avrDateValide;

    /**
     * date de transformation
     */
    @Column(name = "avr_date_transforme")
    private LocalDate avrDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "avr_type_transforme")
    private Integer avrTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "avr_date_annule")
    private LocalDate avrDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "avr_motif_annule")
    private String avrMotifAnnule;

    /**
     * 0=non exo 1=exoneree
     */
    @Column(name = "avr_exo")
    private Integer avrExo = 0;

    /**
     * motif exoneration
     */
    @Column(name = "avr_motif_exo")
    private String avrMotifExo;

    /**
     * numero du visa
     */
    @Column(name = "avr_num_visa")
    private String avrNumVisa;

    /**
     * date du visa
     */
    @Column(name = "avr_date_visa")
    private LocalDate avrDateVisa;

    /**
     * rangement du visa
     */
    @Column(name = "avr_range_visa")
    private String avrRangeVisa;

    /**
     * date transfert en compta
     */
    @Column(name = "avr_date_transfert")
    private LocalDate avrDateTransfert;

    /**
     * nom du factor
     */
    @Column(name = "avr_factor_nom")
    private String avrFactorNom;

    /**
     * id du factor
     */
    @Column(name = "avr_factor_id")
    private Long avrFactorId = 0L;

    /**
     * 0=en cours 1=accepter 2=refuser
     */
    @Column(name = "avr_factor_etat")
    private Integer avrFactorEtat = 0;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "avr_divers_tiers")
    private Integer avrDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "avr_divers_nom")
    private String avrDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "avr_divers_adresse")
    private String avrDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "avr_divers_ville")
    private String avrDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "avr_divers_tel")
    private String avrDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "avr_divers_mail")
    private String avrDiversMail;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom du commercial
     */
    @Column(name = "avr_nom_commercial")
    private String avrNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "avr_id_commercial")
    private Long avrIdCommercial = 0L;

    /**
     * date dernier reglement
     */
    @Column(name = "avr_date_last_reg")
    private LocalDate avrDateLastReg;

    /**
     * nom equipe
     */
    @Column(name = "avr_nom_equipe")
    private String avrNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "avr_id_equipe")
    private Long avrIdEquipe = 0L;

    /**
     * numero de transfert
     */
    @Column(name = "avr_num_trf")
    private String avrNumTrf;

    /**
     * numero bon de retour
     */
    @Column(name = "avr_num_retour")
    private String avrNumRetour;

    /**
     * numero facture
     */
    @Column(name = "avr_num_facture")
    private String avrNumFacture;

    /**
     * numero bc
     */
    @Column(name = "avr_num_bc")
    private String avrNumBc;

    /**
     * taux remise globale
     */
    @Column(name = "avr_taux_remise")
    private Float avrTauxRemise = 0F;

    /**
     * source du document
     */
    @Column(name = "avr_source")
    private String avrSource;

}
