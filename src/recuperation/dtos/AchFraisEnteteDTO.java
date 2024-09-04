package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchFraisEnteteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long fsfId;


    /**
     * date de creation
     */
    private LocalDateTime fsfDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime fsfDateModif;


    /**
     * id user createur
     */
    private Long fsfIdCreateur;


    /**
     * nom du createur
     */
    private String fsfNomCreateur;


    /**
     * id user de modification
     */
    private Long fsfIdModif;


    /**
     * nom user de modification
     */
    private String fsfNomModif;


    /**
     * date du reception
     */
    private LocalDateTime fsfDate;


    /**
     * numero frais
     */
    private String fsfNum;


    /**
     * numero valorisation
     */
    private String fsfValo;


    /**
     * 0=non utilise 1=utilise sur achat 2=utilise sur reexpedition
     */
    private Integer fsfTypeValo;


    /**
     * nom du commercial
     */
    private String fsfNomResponsable;


    /**
     * id du commercial
     */
    private Long fsfIdResponsable;


    /**
     * nom du fournisseur
     */
    private String fsfNomTiers;


    /**
     * civilite du tiers
     */
    private String fsfCivilTiers;


    /**
     * id du contact
     */
    private Long fsfIdContact;


    /**
     * nom du contact
     */
    private String fsfNomContact;


    /**
     * civilite du contact
     */
    private String fsfCivilContact;


    /**
     * serie
     */
    private String fsfSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer fsfExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer fsfExoDouane;


    /**
     * categorie du fournisseur
     */
    private String fsfCat;


    /**
     * code devise
     */
    private String fsfDevise;


    /**
     * coef devise
     */
    private Float fsfCoefDevise;


    /**
     * objet
     */
    private String fsfObject;


    /**
     * observation
     */
    private String fsfObservation;


    /**
     * code budget
     */
    private String fsfBudget;


    /**
     * montant disponible sur budget
     */
    private Double fsfBudgetDispo;


    /**
     * montant disponible sur treso
     */
    private Double fsfBudgetTreso;


    /**
     * budget mensuel dispo
     */
    private Double fsfBudgetDispoMois;


    /**
     * budget mensuel treso
     */
    private Double fsfBudgetTresoMois;


    /**
     * total ht
     */
    private Double fsfTotHt;


    /**
     * total remise
     */
    private Double fsfTotRemise;


    /**
     * total rabais
     */
    private Double fsfTotRabais;


    /**
     * ttal tva
     */
    private Double fsfTotTva;


    /**
     * total taxe complementaire
     */
    private Double fsfTotTc;


    /**
     * total ttc
     */
    private Double fsfTotTtc;


    /**
     * total reglement
     */
    private Double fsfTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer fsfSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String fsfBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    private Integer fsfTypeReg;


    /**
     * mode de reglement xml
     */
    private String fsfModeReg;


    /**
     * nombre de jour
     */
    private Integer fsfNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer fsfArrondiReg;


    /**
     * condition de reglement
     */
    private String fsfConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate fsfDateEcheReg;


    /**
     * code journal des reglements
     */
    private String fsfJournalReg;


    /**
     * code activite
     */
    private String fsfActivite;


    /**
     * code site
     */
    private String fsfSite;


    /**
     * code departement
     */
    private String fsfDepartement;


    /**
     * code service
     */
    private String fsfService;


    /**
     * code region
     */
    private String fsfRegion;


    /**
     * code secteur
     */
    private String fsfSecteur;


    /**
     * code point de vente
     */
    private String fsfPdv;


    /**
     * code analytique 2
     */
    private String fsfAnal2;


    /**
     * code analytique 4
     */
    private String fsfAnal4;


    /**
     * info 1
     */
    private String fsfInfo1;


    /**
     * info 2
     */
    private String fsfInfo2;


    /**
     * info 3
     */
    private String fsfInfo3;


    /**
     * info 4
     */
    private String fsfInfo4;


    /**
     * info 5
     */
    private String fsfInfo5;


    /**
     * info 6
     */
    private String fsfInfo6;


    /**
     * info 7
     */
    private String fsfInfo7;


    /**
     * info 8
     */
    private String fsfInfo8;


    /**
     * info 9
     */
    private String fsfInfo9;


    /**
     * info 10
     */
    private String fsfInfo10;


    /**
     * code formule 1
     */
    private String fsfFormule1;


    /**
     * code formule 2
     */
    private String fsfFormule2;


    /**
     * nom jasper anexe 1
     */
    private String fsfAnnexe1;


    /**
     * nom jasper anexe 2
     */
    private String fsfAnnexe2;


    /**
     * code contrat
     */
    private String fsfContrat;


    /**
     * numero facture fournisseur
     */
    private String fsfNumFour;


    /**
     * date impression
     */
    private LocalDate fsfDateImp;


    /**
     * nom jasper du modele
     */
    private String fsfModeleImp;


    /**
     * 0=sans validation 1=avecc validation
     */
    private Integer fsfEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer fsfGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer fsfEtat;


    /**
     * date de validite
     */
    private LocalDate fsfDateValidite;


    /**
     * date de relance
     */
    private LocalDate fsfDateRelance;


    /**
     * date de validation
     */
    private LocalDate fsfDateValide;


    /**
     * date de transformation
     */
    private LocalDate fsfDateTransforme;


    /**
     * type de transformation
     */
    private Integer fsfTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate fsfDateAnnule;


    /**
     * motif annulation
     */
    private String fsfMotifAnnule;


    /**
     * nom du factor
     */
    private String fsfFactorNom;


    /**
     * id du factor
     */
    private Long fsfFactorId;


    /**
     * 0=en cours 1=accepter 2=refuser
     */
    private Integer fsfFactorEtat;


    /**
     * date transfert en compta
     */
    private LocalDate fsfDateTransfert;

    private Long exeachId;

    private Long tieId;

    private Long usrId;


    /**
     * 0=normal 99= divers
     */
    private Integer fsfDiversTiers;


    /**
     * nom du tiers divers
     */
    private String fsfDiversNom;


    /**
     * adresse du tiers divers
     */
    private String fsfDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String fsfDiversVille;


    /**
     * telephone du tiers divers
     */
    private String fsfDiversTel;


    /**
     * mail du tiers divers
     */
    private String fsfDiversMail;


    /**
     * numero commande ou reception
     */
    private String fsfNumDoc;


    /**
     * numero de transfert
     */
    private String fsfNumTrf;


    /**
     * total tva douane
     */
    private Double fsfTotTvaDouane;

}
