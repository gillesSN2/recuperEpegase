package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchCommandeEnteteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cmdId;


    /**
     * date de creation
     */
    private LocalDateTime cmdDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime cmdDateModif;


    /**
     * id user createur
     */
    private Long cmdIdCreateur;


    /**
     * nom du createur
     */
    private String cmdNomCreateur;


    /**
     * id user de modification
     */
    private Long cmdIdModif;


    /**
     * nom user de modification
     */
    private String cmdNomModif;


    /**
     * 0=ferme 1=ouvert
     */
    private Integer cmdMaj;


    /**
     * date du commande
     */
    private LocalDateTime cmdDate;


    /**
     * numero commande
     */
    private String cmdNum;


    /**
     * numero de valorisation
     */
    private String cmdValo;


    /**
     * nom du commercial
     */
    private String cmdNomResponsable;


    /**
     * id du commercial
     */
    private Long cmdIdResponsable;


    /**
     * nom du fournisseur
     */
    private String cmdNomTiers;


    /**
     * civilite du tiers
     */
    private String cmdCivilTiers;


    /**
     * id du contact
     */
    private Long cmdIdContact;


    /**
     * nom du contact
     */
    private String cmdNomContact;


    /**
     * civilite du contact
     */
    private String cmdCivilContact;


    /**
     * serie
     */
    private String cmdSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer cmdExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer cmdExoDouane;


    /**
     * categorie du fournisseur
     */
    private String cmdCat;


    /**
     * code devise
     */
    private String cmdDevise;


    /**
     * objet
     */
    private String cmdObject;


    /**
     * observation
     */
    private String cmdObservation;


    /**
     * code budget
     */
    private String cmdBudget;


    /**
     * total ht
     */
    private Double cmdTotHt;


    /**
     * total remise
     */
    private Double cmdTotRemise;


    /**
     * total rabais
     */
    private Double cmdTotRabais;


    /**
     * ttal tva
     */
    private Double cmdTotTva;


    /**
     * total taxe complementaire
     */
    private Double cmdTotTc;


    /**
     * total ttc
     */
    private Double cmdTotTtc;


    /**
     * total reglement
     */
    private Double cmdTotReglement;


    /**
     * total ht local
     */
    private Double cmdTotHtLocal;


    /**
     * total tva local
     */
    private Double cmdTotTvaLocal;


    /**
     * total ttc local
     */
    private Double cmdTotTtcLocal;


    /**
     * total remise local
     */
    private Double cmdTotRemiseLocal;


    /**
     * total rabais local
     */
    private Double cmdTotRabaisLocal;


    /**
     * total fret si CFR
     */
    private Double cmdTotFret;


    /**
     * total fret si CFR
     */
    private Double cmdTotFretlocal;


    /**
     * budget annuel dispo
     */
    private Double cmdBudgetDispo;


    /**
     * budget annuel treso
     */
    private Double cmdBudgetTreso;


    /**
     * budget mensuel dispo
     */
    private Double cmdBudgetDispoMois;


    /**
     * budget mensuel treso
     */
    private Double cmdBudgetTresoMois;


    /**
     * 0=non solde 1=solde
     */
    private Integer cmdSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String cmdBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    private Integer cmdTypeReg;


    /**
     * mode de reglement xml
     */
    private String cmdModeReg;


    /**
     * nombre de jour
     */
    private Integer cmdNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer cmdArrondiReg;


    /**
     * condition de reglement
     */
    private String cmdConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate cmdDateEcheReg;


    /**
     * code journal des reglements
     */
    private String cmdJournalReg;


    /**
     * code activite
     */
    private String cmdActivite;


    /**
     * code site
     */
    private String cmdSite;


    /**
     * code departement
     */
    private String cmdDepartement;


    /**
     * code service
     */
    private String cmdService;


    /**
     * code region
     */
    private String cmdRegion;


    /**
     * code secteur
     */
    private String cmdSecteur;


    /**
     * code point de vente
     */
    private String cmdPdv;


    /**
     * code analytique 2 (parc)
     */
    private String cmdAnal2;


    /**
     * code analytique 4 (dossier)
     */
    private String cmdAnal4;


    /**
     * info 1
     */
    private String cmdInfo1;


    /**
     * info 2
     */
    private String cmdInfo2;


    /**
     * info 3
     */
    private String cmdInfo3;


    /**
     * info 4
     */
    private String cmdInfo4;


    /**
     * info 5
     */
    private String cmdInfo5;


    /**
     * info 6
     */
    private String cmdInfo6;


    /**
     * info 7
     */
    private String cmdInfo7;


    /**
     * info 8
     */
    private String cmdInfo8;


    /**
     * info 9
     */
    private String cmdInfo9;


    /**
     * info 10
     */
    private String cmdInfo10;


    /**
     * code formule 1
     */
    private String cmdFormule1;


    /**
     * code formule 2
     */
    private String cmdFormule2;


    /**
     * nom jasper annexe 1
     */
    private String cmdAnnexe1;


    /**
     * nom jasper annexe 2
     */
    private String cmdAnnexe2;


    /**
     * code contrat
     */
    private String cmdContrat;


    /**
     * code incoterm
     */
    private String cmdIncoterm;


    /**
     * lieu de livraison
     */
    private String cmdLieuLivraison;


    /**
     * date de livraison
     */
    private LocalDate cmdDateLivraison;


    /**
     * info sur la livraison
     */
    private String cmdInfoLivraison;


    /**
     * date impression
     */
    private LocalDate cmdDateImp;


    /**
     * nom jasper du modele
     */
    private String cmdModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer cmdEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer cmdGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme partiel 5=transforme total
     */
    private Integer cmdEtat;


    /**
     * date de validite
     */
    private LocalDate cmdDateValidite;


    /**
     * date de relance
     */
    private LocalDate cmdDateRelance;


    /**
     * date de validation
     */
    private LocalDate cmdDateValide;


    /**
     * date de transformation
     */
    private LocalDate cmdDateTransforme;


    /**
     * date de facturation
     */
    private LocalDate cmdDateFacture;


    /**
     * type de transformation
     */
    private Integer cmdTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate cmdDateAnnule;


    /**
     * motif annulation
     */
    private String cmdMotifAnnule;


    /**
     * nom du factor
     */
    private String cmdFactorNom;


    /**
     * id du factor
     */
    private Long cmdFactorId;


    /**
     * 0=en cours 1=accepter 2=refuser
     */
    private Integer cmdFactorEtat;


    /**
     * 0=basse 1=normal 2=urgent 3=prioritaire
     */
    private Integer cmdPriorite;


    /**
     * 0=realisation interne 1=realisation externe
     */
    private Integer cmdInOut;


    /**
     * commentaire sur la production
     */
    private String cmdCommentaire;


    /**
     * numero de production
     */
    private String cmdProduction;


    /**
     * preparateur
     */
    private String cmdPreparateur;

    private Long exeachId;

    private Long tieId;

    private Long usrId;


    /**
     * total poids brut
     */
    private Float cmdTotPoidsBrut;


    /**
     * total qte
     */
    private Float cmdTotQte;


    /**
     * 0=normal 99= divers
     */
    private Integer cmdDiversTiers;


    /**
     * nom du tiers divers
     */
    private String cmdDiversNom;


    /**
     * adresse du tiers divers
     */
    private String cmdDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String cmdDiversVille;


    /**
     * telephone du tiers divers
     */
    private String cmdDiversTel;


    /**
     * mail du tiers divers
     */
    private String cmdDiversMail;


    /**
     * numero de proforma fournisseur
     */
    private String cmdNumProforma;


    /**
     * coefficient devise
     */
    private Float cmdCoefDevise;


    /**
     * code tracking
     */
    private String cmdTracking;


    /**
     * date depart usine
     */
    private LocalDate cmdDateDepartUsine;


    /**
     * date arrivee transitaire
     */
    private LocalDate cmdDateArriveeTransit;


    /**
     * date embarquement theorique
     */
    private LocalDate cmdDateEmbarquementTheo;


    /**
     * date embarquement reel
     */
    private LocalDate cmdDateEmbarquementReel;


    /**
     * date arrivee port theorique
     */
    private LocalDate cmdDateArriveePortTheo;


    /**
     * date arrivee port reel
     */
    private LocalDate cmdDateArriveePortReel;


    /**
     * date livraion dans nos entrepots
     */
    private LocalDate cmdDateLivreDepot;


    /**
     * moyen de paiement
     */
    private String cmdMoyenPaiement;


    /**
     * observation sur le paiement
     */
    private String cmdObsPaiement;


    /**
     * date paiement
     */
    private LocalDate cmdDatePaiement;


    /**
     * 0=maritime 1=avion 2=express 3=route
     */
    private Integer cmdMode;


    /**
     * prochaine action
     */
    private String cmdProchaineAction;

}
