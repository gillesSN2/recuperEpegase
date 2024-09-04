package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "imm_bien_facture")
public class ImmBienFacture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "biefac_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long biefacId;

    /**
     * date de creation
     */
    @Column(name = "biefac_date_creat")
    private LocalDateTime biefacDateCreat;

    /**
     * date de modification
     */
    @Column(name = "biefac_date_modif")
    private LocalDateTime biefacDateModif;

    /**
     * id user createur
     */
    @Column(name = "biefac_id_createur")
    private Long biefacIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "biefac_nom_createur")
    private String biefacNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "biefac_id_modif")
    private Long biefacIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "biefac_nom_modif")
    private String biefacNomModif;

    /**
     * date facture
     */
    @Column(name = "biefac_date")
    private LocalDateTime biefacDate;

    /**
     * date debut periode
     */
    @Column(name = "biefac_date_debut")
    private LocalDate biefacDateDebut;

    /**
     * date fin periode
     */
    @Column(name = "biefac_date_fin")
    private LocalDate biefacDateFin;

    /**
     * numero facture
     */
    @Column(name = "biefac_num")
    private String biefacNum;

    /**
     * numero du bail
     */
    @Column(name = "biefac_bail")
    private String biefacBail;

    /**
     * numero du bien
     */
    @Column(name = "biefac_bien")
    private String biefacBien;

    /**
     * zone fiscal
     */
    @Column(name = "biefac_zone")
    private String biefacZone;

    /**
     * nom du commercial
     */
    @Column(name = "biefac_nom_responsable")
    private String biefacNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "biefac_id_responsable")
    private Long biefacIdResponsable = 0L;

    /**
     * nom du commercial
     */
    @Column(name = "biefac_nom_commercial")
    private String biefacNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "biefac_id_commercial")
    private Long biefacIdCommercial = 0L;

    /**
     * ref du client
     */
    @Column(name = "biefac_tiers")
    private String biefacTiers;

    /**
     * nom du client
     */
    @Column(name = "biefac_nom_tiers")
    private String biefacNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "biefac_civil_tiers")
    private String biefacCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "biefac_id_contact")
    private Long biefacIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "biefac_nom_contact")
    private String biefacNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "biefac_civil_contact")
    private String biefacCivilContact;

    /**
     * serie
     */
    @Column(name = "biefac_serie")
    private String biefacSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "biefac_exo_tva")
    private Integer biefacExoTva = 0;

    /**
     * 0=avec tom 1=sans tom
     */
    @Column(name = "biefac_exo_tom")
    private Integer biefacExoTom = 0;

    /**
     * 0=jour 1=semaine 2=mois 3=trimestre 4=semestre 5=annee
     */
    @Column(name = "biefac_mode")
    private Integer biefacMode = 0;

    /**
     * 0=habitation 1=professionnel 2=mixte
     */
    @Column(name = "biefac_usage")
    private Integer biefacUsage = 0;

    /**
     * categorie du client
     */
    @Column(name = "biefac_cat")
    private String biefacCat;

    /**
     * code devise
     */
    @Column(name = "biefac_devise")
    private String biefacDevise;

    /**
     * objet
     */
    @Column(name = "biefac_object")
    private String biefacObject;

    /**
     * observation
     */
    @Column(name = "biefac_observation")
    private String biefacObservation;

    /**
     * code budget
     */
    @Column(name = "biefac_budget")
    private String biefacBudget;

    /**
     * total reglement
     */
    @Column(name = "biefac_tot_reglement")
    private Double biefacTotReglement = 0D;

    /**
     * total timbre
     */
    @Column(name = "biefac_tot_timbre")
    private Double biefacTotTimbre = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "biefac_solde")
    private Integer biefacSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "biefac_banque")
    private String biefacBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    @Column(name = "biefac_type_reg")
    private Integer biefacTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "biefac_mode_reg")
    private String biefacModeReg;

    /**
     * date echeance reliquat si type reg = 5
     */
    @Column(name = "biefac_echeance_reliquat")
    private LocalDate biefacEcheanceReliquat;

    /**
     * nombre de jour
     */
    @Column(name = "biefac_nb_jour_reg")
    private Integer biefacNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "biefac_arrondi_reg")
    private Integer biefacArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "biefac_condition_reg")
    private String biefacConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "biefac_date_eche_reg")
    private LocalDate biefacDateEcheReg;

    /**
     * date dernier reglement
     */
    @Column(name = "biefac_date_last_reg")
    private LocalDate biefacDateLastReg;

    /**
     * code journal des reglements
     */
    @Column(name = "biefac_journal_reg")
    private String biefacJournalReg;

    /**
     * code site
     */
    @Column(name = "biefac_site")
    private String biefacSite;

    /**
     * code departement
     */
    @Column(name = "biefac_departement")
    private String biefacDepartement;

    /**
     * code service
     */
    @Column(name = "biefac_service")
    private String biefacService;

    /**
     * code region
     */
    @Column(name = "biefac_region")
    private String biefacRegion;

    /**
     * code secteur
     */
    @Column(name = "biefac_secteur")
    private String biefacSecteur;

    /**
     * code point de vente
     */
    @Column(name = "biefac_pdv")
    private String biefacPdv;

    /**
     * info 1
     */
    @Column(name = "biefac_info1")
    private String biefacInfo1;

    /**
     * info 2
     */
    @Column(name = "biefac_info2")
    private String biefacInfo2;

    /**
     * info 3
     */
    @Column(name = "biefac_info3")
    private String biefacInfo3;

    /**
     * info 4
     */
    @Column(name = "biefac_info4")
    private String biefacInfo4;

    /**
     * info 5
     */
    @Column(name = "biefac_info5")
    private String biefacInfo5;

    /**
     * info 6
     */
    @Column(name = "biefac_info6")
    private String biefacInfo6;

    /**
     * info 7
     */
    @Column(name = "biefac_info7")
    private String biefacInfo7;

    /**
     * info 8
     */
    @Column(name = "biefac_info8")
    private String biefacInfo8;

    /**
     * info 9
     */
    @Column(name = "biefac_info9")
    private String biefacInfo9;

    /**
     * info 10
     */
    @Column(name = "biefac_info10")
    private String biefacInfo10;

    /**
     * code formule 1
     */
    @Column(name = "biefac_formule1")
    private String biefacFormule1;

    /**
     * code formule 2
     */
    @Column(name = "biefac_formule2")
    private String biefacFormule2;

    /**
     * code contrat = periode MM:AAAA et num bail
     */
    @Column(name = "biefac_contrat")
    private String biefacContrat;

    /**
     * date impression
     */
    @Column(name = "biefac_date_imp")
    private LocalDate biefacDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "biefac_modele_imp")
    private String biefacModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "biefac_etat_val")
    private Integer biefacEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "biefac_gele")
    private Integer biefacGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "biefac_etat")
    private Integer biefacEtat = 0;

    /**
     * numero de transfert
     */
    @Column(name = "biefac_num_trf")
    private String biefacNumTrf;

    /**
     * date de validite
     */
    @Column(name = "biefac_date_validite")
    private LocalDate biefacDateValidite;

    /**
     * date de relance
     */
    @Column(name = "biefac_date_relance")
    private LocalDate biefacDateRelance;

    /**
     * date de validation
     */
    @Column(name = "biefac_date_valide")
    private LocalDate biefacDateValide;

    /**
     * date de transformation
     */
    @Column(name = "biefac_date_transforme")
    private LocalDate biefacDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "biefac_type_transforme")
    private Integer biefacTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "biefac_date_annule")
    private LocalDate biefacDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "biefac_motif_annule")
    private String biefacMotifAnnule;

    /**
     * motif exoneration
     */
    @Column(name = "biefac_motif_exo")
    private String biefacMotifExo;

    /**
     * numero du visa
     */
    @Column(name = "biefac_num_visa")
    private String biefacNumVisa;

    /**
     * date du visa
     */
    @Column(name = "biefac_date_visa")
    private LocalDate biefacDateVisa;

    /**
     * rangement du visa
     */
    @Column(name = "biefac_range_visa")
    private String biefacRangeVisa;

    /**
     * date transfert en compta
     */
    @Column(name = "biefac_date_transfert")
    private LocalDate biefacDateTransfert;

    /**
     * numero avoir
     */
    @Column(name = "biefac_num_avoir")
    private String biefacNumAvoir;

    /**
     * source du document
     */
    @Column(name = "biefac_source")
    private String biefacSource;

    /**
     * montant ht
     */
    @Column(name = "biefac_tot_ht")
    private Double biefacTotHt = 0D;

    /**
     * montant tva
     */
    @Column(name = "biefac_tot_tva")
    private Double biefacTotTva = 0D;

    /**
     * montant ttc
     */
    @Column(name = "biefac_tot_ttc")
    private Double biefacTotTtc = 0D;

    /**
     * montant taxes complementaire
     */
    @Column(name = "biefac_tot_tc")
    private Double biefacTotTc = 0D;

    /**
     * montant loyer brut
     */
    @Column(name = "biefac_loyer_brut")
    private Double biefacLoyerBrut = 0D;

    /**
     * taux remise globale
     */
    @Column(name = "biefac_taux_remise")
    private Double biefacTauxRemise = 0D;

    /**
     * total remise
     */
    @Column(name = "biefac_tot_remise")
    private Double biefacTotRemise = 0D;

    /**
     * taux tom
     */
    @Column(name = "biefac_taux_tom")
    private Double biefacTauxTom = 0D;

    /**
     * montant tom
     */
    @Column(name = "biefac_tom")
    private Double biefacTom = 0D;

    /**
     * 0=sans 1=enregistrement 2=tlv
     */
    @Column(name = "biefac_mode_tlv")
    private Integer biefacModeTlv = 0;

    /**
     * taux tlv
     */
    @Column(name = "biefac_taux_tlv")
    private Double biefacTauxTlv = 0D;

    /**
     * montant tlv
     */
    @Column(name = "biefac_tlv")
    private Double biefacTlv = 0D;

    /**
     * taux tva
     */
    @Column(name = "biefac_taux_tva")
    private Double biefacTauxTva = 0D;

    /**
     * montant loyer net
     */
    @Column(name = "biefac_loyer_net")
    private Double biefacLoyerNet = 0D;

    /**
     * montant des charges immeuble
     */
    @Column(name = "biefac_charges_immeuble")
    private Double biefacChargesImmeuble = 0D;

    /**
     * taux des charges immeuble
     */
    @Column(name = "biefac_taux_charges")
    private Double biefacTauxCharges = 0D;

    /**
     * eau
     */
    @Column(name = "biefac_eau")
    private Double biefacEau = 0D;

    /**
     * electricite
     */
    @Column(name = "biefac_electricite")
    private Double biefacElectricite = 0D;

    /**
     * parking
     */
    @Column(name = "biefac_parking")
    private Double biefacParking = 0D;

    /**
     * gardiennage
     */
    @Column(name = "biefac_gardiennage")
    private Double biefacGardiennage = 0D;

    /**
     * jardinnier
     */
    @Column(name = "biefac_jardinnier")
    private Double biefacJardinnier = 0D;

    /**
     * groupe electrogene
     */
    @Column(name = "biefac_groupe_electro")
    private Double biefacGroupeElectro = 0D;

    /**
     * divers frais
     */
    @Column(name = "biefac_divers_frais")
    private Double biefacDiversFrais = 0D;

    /**
     * libelle frais
     */
    @Column(name = "biefac_libelle_frais")
    private String biefacLibelleFrais;

    /**
     * frais complementaire
     */
    @Column(name = "biefac_frais_complement")
    private Double biefacFraisComplement = 0D;

    /**
     * net a payer au proprietaire
     */
    @Column(name = "biefac_net_payer")
    private Double biefacNetPayer = 0D;

    /**
     * ref du proprietaire
     */
    @Column(name = "biefac_proprietaire")
    private String biefacProprietaire;

    /**
     * nom du proprietaire
     */
    @Column(name = "biefac_nom_proprietaire")
    private String biefacNomProprietaire;

    /**
     * civilite du proprietaire
     */
    @Column(name = "biefac_civil_proprietaire")
    private String biefacCivilProprietaire;

    /**
     * id du proprietaire
     */
    @Column(name = "biefac_id_proprietaire")
    private Long biefacIdProprietaire = 0L;

    /**
     * type du proprietaire
     */
    @Column(name = "biefac_type_proprietaire")
    private Integer biefacTypeProprietaire = 0;

    /**
     * taux irpp
     */
    @Column(name = "biefac_taux_irpp")
    private Double biefacTauxIrpp = 0D;

    /**
     * total irpp si proprietaire est assujetti irrp
     */
    @Column(name = "biefac_total_irpp")
    private Double biefacTotalIrpp = 0D;

    /**
     * taux commisison agence
     */
    @Column(name = "biefac_taux_com")
    private Double biefacTauxCom = 0D;

    /**
     * total commission agence
     */
    @Column(name = "biefac_total_com")
    private Double biefacTotalCom = 0D;

    /**
     * tva commission agence
     */
    @Column(name = "biefac_tva_com")
    private Double biefacTvaCom = 0D;

    @Column(name = "exevte_id")
    private Long exevteId;

    @Column(name = "tie_id")
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

}
