package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchFactureEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fcfId;


    /**
     * date de creation
     */
    private LocalDateTime fcfDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime fcfDateModif;


    /**
     * id user createur
     */
    private Long fcfIdCreateur;


    /**
     * nom du createur
     */
    private String fcfNomCreateur;


    /**
     * id user de modification
     */
    private Long fcfIdModif;


    /**
     * nom user de modification
     */
    private String fcfNomModif;


    /**
     * date du reception
     */
    private LocalDateTime fcfDate;


    /**
     * date de livrison
     */
    private LocalDate fcfDateLivraison;


    /**
     * numero reception
     */
    private String fcfNum;


    /**
     * nom du commercial
     */
    private String fcfNomResponsable;


    /**
     * id du commercial
     */
    private Long fcfIdResponsable;


    /**
     * nom du fournisseur
     */
    private String fcfNomTiers;


    /**
     * civilite du tiers
     */
    private String fcfCivilTiers;


    /**
     * id du contact
     */
    private Long fcfIdContact;


    /**
     * nom du contact
     */
    private String fcfNomContact;


    /**
     * civilite du contact
     */
    private String fcfCivilContact;


    /**
     * serie
     */
    private String fcfSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer fcfExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer fcfExoDouane;


    /**
     * categorie du fournisseur
     */
    private String fcfCat;


    /**
     * code devise
     */
    private String fcfDevise;


    /**
     * coefficient devise
     */
    private Float fcfCoefDevise;


    /**
     * objet
     */
    private String fcfObject;


    /**
     * observation
     */
    private String fcfObservation;


    /**
     * code budget
     */
    private String fcfBudget;


    /**
     * montant disponible sur budget
     */
    private Double fcfBudgetDispo;


    /**
     * montant disponible sur treso
     */
    private Double fcfBudgetTreso;


    /**
     * budget mensuel dispo
     */
    private Double fcfBudgetDispoMois;


    /**
     * budget mensuel treso
     */
    private Double fcfBudgetTresoMois;


    /**
     * total ht
     */
    private Double fcfTotHt;


    /**
     * total remise
     */
    private Double fcfTotRemise;


    /**
     * total rabais
     */
    private Double fcfTotRabais;


    /**
     * ttal tva
     */
    private Double fcfTotTva;


    /**
     * total taxe complementaire
     */
    private Double fcfTotTc;


    /**
     * total ttc
     */
    private Double fcfTotTtc;


    /**
     * total reglement
     */
    private Double fcfTotReglement;


    /**
     * total ht local
     */
    private Double fcfTotHtLocal;


    /**
     * total tva local
     */
    private Double fcfTotTvaLocal;


    /**
     * total ttc local
     */
    private Double fcfTotTtcLocal;


    /**
     * total remise local
     */
    private Double fcfTotRemiseLocal;


    /**
     * total rabais local
     */
    private Double fcfTotRabaisLocal;


    /**
     * 0=non solde 1=solde
     */
    private Integer fcfSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String fcfBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    private Integer fcfTypeReg;


    /**
     * mode de reglement xml
     */
    private String fcfModeReg;


    /**
     * nombre de jour
     */
    private Integer fcfNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer fcfArrondiReg;


    /**
     * condition de reglement
     */
    private String fcfConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate fcfDateEcheReg;


    /**
     * code journal des reglements
     */
    private String fcfJournalReg;


    /**
     * code activite
     */
    private String fcfActivite;


    /**
     * code site
     */
    private String fcfSite;


    /**
     * code departement
     */
    private String fcfDepartement;


    /**
     * code service
     */
    private String fcfService;


    /**
     * code region
     */
    private String fcfRegion;


    /**
     * code secteur
     */
    private String fcfSecteur;


    /**
     * code point de vente
     */
    private String fcfPdv;


    /**
     * code analytique 2
     */
    private String fcfAnal2;


    /**
     * code analytique 4
     */
    private String fcfAnal4;


    /**
     * info 1
     */
    private String fcfInfo1;


    /**
     * info 2
     */
    private String fcfInfo2;


    /**
     * info 3
     */
    private String fcfInfo3;


    /**
     * info 4
     */
    private String fcfInfo4;


    /**
     * info 5
     */
    private String fcfInfo5;


    /**
     * info 6
     */
    private String fcfInfo6;


    /**
     * info 7
     */
    private String fcfInfo7;


    /**
     * info 8
     */
    private String fcfInfo8;


    /**
     * info 9
     */
    private String fcfInfo9;


    /**
     * info 10
     */
    private String fcfInfo10;


    /**
     * code formule 1
     */
    private String fcfFormule1;


    /**
     * code formule 2
     */
    private String fcfFormule2;


    /**
     * nom jasper anexe 1
     */
    private String fcfAnnexe1;


    /**
     * nom jasper anexe 2
     */
    private String fcfAnnexe2;


    /**
     * code contrat
     */
    private String fcfContrat;


    /**
     * numero facture fournisseur
     */
    private String fcfNumFour;


    /**
     * date impression
     */
    private LocalDate fcfDateImp;


    /**
     * nom jasper du modele
     */
    private String fcfModeleImp;


    /**
     * 0=sans validation 1=avecc validation
     */
    private Integer fcfEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer fcfGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme 5=transferer en compta
     */
    private Integer fcfEtat;


    /**
     * date de validite
     */
    private LocalDate fcfDateValidite;


    /**
     * date de relance
     */
    private LocalDate fcfDateRelance;


    /**
     * date de validation
     */
    private LocalDate fcfDateValide;


    /**
     * date de transformation
     */
    private LocalDate fcfDateTransforme;


    /**
     * type de transformation
     */
    private Integer fcfTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate fcfDateAnnule;


    /**
     * motif annulation
     */
    private String fcfMotifAnnule;


    /**
     * date transfert en compta
     */
    private LocalDate fcfDateTransfert;


    /**
     * nom du factor
     */
    private String fcfFactorNom;


    /**
     * id du factor
     */
    private Long fcfFactorId;


    /**
     * 0=en cours 1=accepter 2=refuser
     */
    private Integer fcfFactorEtat;


    /**
     * date valorisation
     */
    private LocalDate fcfDateValo;


    /**
     * 0=sans valo 1=valo sur coef 2=valo sur frais
     */
    private Integer fcfTypeValo;


    /**
     * coefficient de valorisation
     */
    private Float fcfCoefValoEtat;


    /**
     * numero de facture de frais
     */
    private String fcfFraisValo;

    private Long exeachId;

    private Long tieId;

    private Long usrId;


    /**
     * 0=normal 99= divers
     */
    private Integer fcfDiversTiers;


    /**
     * nom du tiers divers
     */
    private String fcfDiversNom;


    /**
     * adresse du tiers divers
     */
    private String fcfDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String fcfDiversVille;


    /**
     * telephone du tiers divers
     */
    private String fcfDiversTel;


    /**
     * mail du tiers divers
     */
    private String fcfDiversMail;


    /**
     * numero proforme fournisseur
     */
    private String fcfProformaFour;


    /**
     * numero de transfert
     */
    private String fcfNumTrf;

}
