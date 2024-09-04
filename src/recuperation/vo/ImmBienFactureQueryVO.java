package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ImmBienFactureQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long biefacId;


    /**
     * date de creation
     */
    private LocalDateTime biefacDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime biefacDateModif;


    /**
     * id user createur
     */
    private Long biefacIdCreateur;


    /**
     * nom du createur
     */
    private String biefacNomCreateur;


    /**
     * id user de modification
     */
    private Long biefacIdModif;


    /**
     * nom user de modification
     */
    private String biefacNomModif;


    /**
     * date facture
     */
    private LocalDateTime biefacDate;


    /**
     * date debut periode
     */
    private LocalDate biefacDateDebut;


    /**
     * date fin periode
     */
    private LocalDate biefacDateFin;


    /**
     * numero facture
     */
    private String biefacNum;


    /**
     * numero du bail
     */
    private String biefacBail;


    /**
     * numero du bien
     */
    private String biefacBien;


    /**
     * zone fiscal
     */
    private String biefacZone;


    /**
     * nom du commercial
     */
    private String biefacNomResponsable;


    /**
     * id du commercial
     */
    private Long biefacIdResponsable;


    /**
     * nom du commercial
     */
    private String biefacNomCommercial;


    /**
     * id du commercial
     */
    private Long biefacIdCommercial;


    /**
     * ref du client
     */
    private String biefacTiers;


    /**
     * nom du client
     */
    private String biefacNomTiers;


    /**
     * civilite du tiers
     */
    private String biefacCivilTiers;


    /**
     * id du contact
     */
    private Long biefacIdContact;


    /**
     * nom du contact
     */
    private String biefacNomContact;


    /**
     * civilite du contact
     */
    private String biefacCivilContact;


    /**
     * serie
     */
    private String biefacSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer biefacExoTva;


    /**
     * 0=avec tom 1=sans tom
     */
    private Integer biefacExoTom;


    /**
     * 0=jour 1=semaine 2=mois 3=trimestre 4=semestre 5=annee
     */
    private Integer biefacMode;


    /**
     * 0=habitation 1=professionnel 2=mixte
     */
    private Integer biefacUsage;


    /**
     * categorie du client
     */
    private String biefacCat;


    /**
     * code devise
     */
    private String biefacDevise;


    /**
     * objet
     */
    private String biefacObject;


    /**
     * observation
     */
    private String biefacObservation;


    /**
     * code budget
     */
    private String biefacBudget;


    /**
     * total reglement
     */
    private Double biefacTotReglement;


    /**
     * total timbre
     */
    private Double biefacTotTimbre;


    /**
     * 0=non solde 1=solde
     */
    private Integer biefacSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String biefacBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    private Integer biefacTypeReg;


    /**
     * mode de reglement xml
     */
    private String biefacModeReg;


    /**
     * date echeance reliquat si type reg = 5
     */
    private LocalDate biefacEcheanceReliquat;


    /**
     * nombre de jour
     */
    private Integer biefacNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer biefacArrondiReg;


    /**
     * condition de reglement
     */
    private String biefacConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate biefacDateEcheReg;


    /**
     * date dernier reglement
     */
    private LocalDate biefacDateLastReg;


    /**
     * code journal des reglements
     */
    private String biefacJournalReg;


    /**
     * code site
     */
    private String biefacSite;


    /**
     * code departement
     */
    private String biefacDepartement;


    /**
     * code service
     */
    private String biefacService;


    /**
     * code region
     */
    private String biefacRegion;


    /**
     * code secteur
     */
    private String biefacSecteur;


    /**
     * code point de vente
     */
    private String biefacPdv;


    /**
     * info 1
     */
    private String biefacInfo1;


    /**
     * info 2
     */
    private String biefacInfo2;


    /**
     * info 3
     */
    private String biefacInfo3;


    /**
     * info 4
     */
    private String biefacInfo4;


    /**
     * info 5
     */
    private String biefacInfo5;


    /**
     * info 6
     */
    private String biefacInfo6;


    /**
     * info 7
     */
    private String biefacInfo7;


    /**
     * info 8
     */
    private String biefacInfo8;


    /**
     * info 9
     */
    private String biefacInfo9;


    /**
     * info 10
     */
    private String biefacInfo10;


    /**
     * code formule 1
     */
    private String biefacFormule1;


    /**
     * code formule 2
     */
    private String biefacFormule2;


    /**
     * code contrat = periode MM:AAAA et num bail
     */
    private String biefacContrat;


    /**
     * date impression
     */
    private LocalDate biefacDateImp;


    /**
     * nom jasper du modele
     */
    private String biefacModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer biefacEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer biefacGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer biefacEtat;


    /**
     * numero de transfert
     */
    private String biefacNumTrf;


    /**
     * date de validite
     */
    private LocalDate biefacDateValidite;


    /**
     * date de relance
     */
    private LocalDate biefacDateRelance;


    /**
     * date de validation
     */
    private LocalDate biefacDateValide;


    /**
     * date de transformation
     */
    private LocalDate biefacDateTransforme;


    /**
     * type de transformation
     */
    private Integer biefacTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate biefacDateAnnule;


    /**
     * motif annulation
     */
    private String biefacMotifAnnule;


    /**
     * motif exoneration
     */
    private String biefacMotifExo;


    /**
     * numero du visa
     */
    private String biefacNumVisa;


    /**
     * date du visa
     */
    private LocalDate biefacDateVisa;


    /**
     * rangement du visa
     */
    private String biefacRangeVisa;


    /**
     * date transfert en compta
     */
    private LocalDate biefacDateTransfert;


    /**
     * numero avoir
     */
    private String biefacNumAvoir;


    /**
     * source du document
     */
    private String biefacSource;


    /**
     * montant ht
     */
    private Double biefacTotHt;


    /**
     * montant tva
     */
    private Double biefacTotTva;


    /**
     * montant ttc
     */
    private Double biefacTotTtc;


    /**
     * montant taxes complementaire
     */
    private Double biefacTotTc;


    /**
     * montant loyer brut
     */
    private Double biefacLoyerBrut;


    /**
     * taux remise globale
     */
    private Double biefacTauxRemise;


    /**
     * total remise
     */
    private Double biefacTotRemise;


    /**
     * taux tom
     */
    private Double biefacTauxTom;


    /**
     * montant tom
     */
    private Double biefacTom;


    /**
     * 0=sans 1=enregistrement 2=tlv
     */
    private Integer biefacModeTlv;


    /**
     * taux tlv
     */
    private Double biefacTauxTlv;


    /**
     * montant tlv
     */
    private Double biefacTlv;


    /**
     * taux tva
     */
    private Double biefacTauxTva;


    /**
     * montant loyer net
     */
    private Double biefacLoyerNet;


    /**
     * montant des charges immeuble
     */
    private Double biefacChargesImmeuble;


    /**
     * taux des charges immeuble
     */
    private Double biefacTauxCharges;


    /**
     * eau
     */
    private Double biefacEau;


    /**
     * electricite
     */
    private Double biefacElectricite;


    /**
     * parking
     */
    private Double biefacParking;


    /**
     * gardiennage
     */
    private Double biefacGardiennage;


    /**
     * jardinnier
     */
    private Double biefacJardinnier;


    /**
     * groupe electrogene
     */
    private Double biefacGroupeElectro;


    /**
     * divers frais
     */
    private Double biefacDiversFrais;


    /**
     * libelle frais
     */
    private String biefacLibelleFrais;


    /**
     * frais complementaire
     */
    private Double biefacFraisComplement;


    /**
     * net a payer au proprietaire
     */
    private Double biefacNetPayer;


    /**
     * ref du proprietaire
     */
    private String biefacProprietaire;


    /**
     * nom du proprietaire
     */
    private String biefacNomProprietaire;


    /**
     * civilite du proprietaire
     */
    private String biefacCivilProprietaire;


    /**
     * id du proprietaire
     */
    private Long biefacIdProprietaire;


    /**
     * type du proprietaire
     */
    private Integer biefacTypeProprietaire;


    /**
     * taux irpp
     */
    private Double biefacTauxIrpp;


    /**
     * total irpp si proprietaire est assujetti irrp
     */
    private Double biefacTotalIrpp;


    /**
     * taux commisison agence
     */
    private Double biefacTauxCom;


    /**
     * total commission agence
     */
    private Double biefacTotalCom;


    /**
     * tva commission agence
     */
    private Double biefacTvaCom;

    private Long exevteId;

    private Long tieId;

    private Long usrId;

}
