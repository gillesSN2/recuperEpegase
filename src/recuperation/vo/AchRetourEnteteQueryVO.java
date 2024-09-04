package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchRetourEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long brfId;


    /**
     * date de creation
     */
    private LocalDateTime brfDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime brfDateModif;


    /**
     * id user createur
     */
    private Long brfIdCreateur;


    /**
     * nom du createur
     */
    private String brfNomCreateur;


    /**
     * id user de modification
     */
    private Long brfIdModif;


    /**
     * nom user de modification
     */
    private String brfNomModif;


    /**
     * date du bon de retour fournisseur
     */
    private LocalDateTime brfDate;


    /**
     * numero bon de retour
     */
    private String brfNum;


    /**
     * numero valorisation
     */
    private String brfValo;


    /**
     * nom du commercial
     */
    private String brfNomResponsable;


    /**
     * id du commercial
     */
    private Long brfIdResponsable;


    /**
     * nom du fournisseur
     */
    private String brfNomTiers;


    /**
     * civilite du tiers
     */
    private String brfCivilTiers;


    /**
     * id du contact
     */
    private Long brfIdContact;


    /**
     * nom du contact
     */
    private String brfNomContact;


    /**
     * civilite du contact
     */
    private String brfCivilContact;


    /**
     * serie
     */
    private String brfSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer brfExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer brfExoDouane;


    /**
     * categorie du fournisseur
     */
    private String brfCat;


    /**
     * code devise
     */
    private String brfDevise;


    /**
     * objet
     */
    private String brfObject;


    /**
     * observation
     */
    private String brfObservation;


    /**
     * code budget
     */
    private String brfBudget;


    /**
     * montant disponible sur budget
     */
    private Double brfBudgetDispo;


    /**
     * montant disponible sur treso
     */
    private Double brfBudgetTreso;


    /**
     * budget mensuel dispo
     */
    private Double brfBudgetDispoMois;


    /**
     * budget mensuel treso
     */
    private Double brfBudgetTresoMois;


    /**
     * total ht
     */
    private Double brfTotHt;


    /**
     * total remise
     */
    private Double brfTotRemise;


    /**
     * total rabais
     */
    private Double brfTotRabais;


    /**
     * ttal tva
     */
    private Double brfTotTva;


    /**
     * total taxe complementaire
     */
    private Double brfTotTc;


    /**
     * total ttc
     */
    private Double brfTotTtc;


    /**
     * total reglement
     */
    private Double brfTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer brfSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String brfBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    private Integer brfTypeReg;


    /**
     * mode de reglement xml
     */
    private String brfModeReg;


    /**
     * nombre de jour
     */
    private Integer brfNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer brfArrondiReg;


    /**
     * condition de reglement
     */
    private String brfConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate brfDateEcheReg;


    /**
     * code journal des reglements
     */
    private String brfJournalReg;


    /**
     * code activite
     */
    private String brfActivite;


    /**
     * code site
     */
    private String brfSite;


    /**
     * code departement
     */
    private String brfDepartement;


    /**
     * code service
     */
    private String brfService;


    /**
     * code region
     */
    private String brfRegion;


    /**
     * code secteur
     */
    private String brfSecteur;


    /**
     * code point de vente
     */
    private String brfPdv;


    /**
     * code analytique 2
     */
    private String brfAnal2;


    /**
     * code analytique 4
     */
    private String brfAnal4;


    /**
     * info 1
     */
    private String brfInfo1;


    /**
     * info 2
     */
    private String brfInfo2;


    /**
     * info 3
     */
    private String brfInfo3;


    /**
     * info 4
     */
    private String brfInfo4;


    /**
     * info 5
     */
    private String brfInfo5;


    /**
     * info 6
     */
    private String brfInfo6;


    /**
     * info 7
     */
    private String brfInfo7;


    /**
     * info 8
     */
    private String brfInfo8;


    /**
     * info 9
     */
    private String brfInfo9;


    /**
     * info 10
     */
    private String brfInfo10;


    /**
     * code formule 1
     */
    private String brfFormule1;


    /**
     * code formule 2
     */
    private String brfFormule2;


    /**
     * nom jasper anexe 1
     */
    private String brfAnnexe1;


    /**
     * nom jasper anexe 2
     */
    private String brfAnnexe2;


    /**
     * code contrat
     */
    private String brfContrat;


    /**
     * code incoterm
     */
    private String brfIncoterm;


    /**
     * lieu de livraison
     */
    private String brfLieuLivraison;


    /**
     * date de livraison
     */
    private LocalDate brfDateLivraison;


    /**
     * info sur la livraison
     */
    private String brfInfoLivraison;


    /**
     * date impression
     */
    private LocalDate brfDateImp;


    /**
     * nom jasper du modele
     */
    private String brfModeleImp;


    /**
     * 0=sans validation 1=avecc validation
     */
    private Integer brfEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer brfGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer brfEtat;


    /**
     * date de validite
     */
    private LocalDate brfDateValidite;


    /**
     * date de relance
     */
    private LocalDate brfDateRelance;


    /**
     * date de validation
     */
    private LocalDate brfDateValide;


    /**
     * date de transformation
     */
    private LocalDate brfDateTransforme;


    /**
     * type de transformation
     */
    private Integer brfTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate brfDateAnnule;


    /**
     * motif annulation
     */
    private String brfMotifAnnule;


    /**
     * nom du factor
     */
    private String brfFactorNom;


    /**
     * id du factor
     */
    private Long brfFactorId;


    /**
     * 0=en cours 1=accepter 2=refuser
     */
    private Integer brfFactorEtat;


    /**
     * commentaire sur la production
     */
    private String brfCommentaire;


    /**
     * numero de production
     */
    private String brfProduction;


    /**
     * nom du livreur
     */
    private String brfLivreurNom;

    private Long exeachId;

    private Long tieId;

    private Long usrId;


    /**
     * 0=normal 99= divers
     */
    private Integer brfDiversTiers;


    /**
     * nom du tiers divers
     */
    private String brfDiversNom;


    /**
     * adresse du tiers divers
     */
    private String brfDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String brfDiversVille;


    /**
     * telephone du tiers divers
     */
    private String brfDiversTel;


    /**
     * mail du tiers divers
     */
    private String brfDiversMail;

}
