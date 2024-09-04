package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchReceptionEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long recId;


    /**
     * date de creation
     */
    private LocalDateTime recDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime recDateModif;


    /**
     * id user createur
     */
    private Long recIdCreateur;


    /**
     * nom du createur
     */
    private String recNomCreateur;


    /**
     * id user de modification
     */
    private Long recIdModif;


    /**
     * nom user de modification
     */
    private String recNomModif;


    /**
     * 0=fermer 1=ouvert
     */
    private Integer recMaj;


    /**
     * date du reception
     */
    private LocalDateTime recDate;


    /**
     * numero reception
     */
    private String recNum;


    /**
     * nom du commercial
     */
    private String recNomResponsable;


    /**
     * id du commercial
     */
    private Long recIdResponsable;


    /**
     * nom du fournisseur
     */
    private String recNomTiers;


    /**
     * civilite du tiers
     */
    private String recCivilTiers;


    /**
     * id du contact
     */
    private Long recIdContact;


    /**
     * nom du contact
     */
    private String recNomContact;


    /**
     * civilite du contact
     */
    private String recCivilContact;


    /**
     * serie
     */
    private String recSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer recExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer drecExoDouane;


    /**
     * categorie du fournisseur
     */
    private String recCat;


    /**
     * code devise
     */
    private String recDevise;


    /**
     * coefficient devise
     */
    private Float recCoefDevise;


    /**
     * objet
     */
    private String recObject;


    /**
     * observation
     */
    private String recObservation;


    /**
     * code budget
     */
    private String recBudget;


    /**
     * montant disponible sur budget
     */
    private Double recBudgetDispo;


    /**
     * montant disponible sur treso
     */
    private Double recBudgetTreso;


    /**
     * budget mensuel dispo
     */
    private Double recBudgetDispoMois;


    /**
     * budget mensuel treso
     */
    private Double recBudgetTresoMois;


    /**
     * total ht
     */
    private Double recTotHt;


    /**
     * total remise
     */
    private Double recTotRemise;


    /**
     * total rabais
     */
    private Double recTotRabais;


    /**
     * ttal tva
     */
    private Double recTotTva;


    /**
     * total taxe complementaire
     */
    private Double recTotTc;


    /**
     * total ttc
     */
    private Double recTotTtc;


    /**
     * total poids brut
     */
    private Float recTotPoidsBrut;


    /**
     * total reglement
     */
    private Double recTotReglement;


    /**
     * total ht local
     */
    private Double recTotHtLocal;


    /**
     * total tva local
     */
    private Double recTotTvaLocal;


    /**
     * total ttc local
     */
    private Double recTotTtcLocal;


    /**
     * total remise local
     */
    private Double recTotRemiseLocal;


    /**
     * total rabais local
     */
    private Double recTotRabaisLocal;


    /**
     * total fret si CFR ou CIF
     */
    private Double recTotFret;


    /**
     * total fret si CFR ou CIF
     */
    private Double recTotFretlocal;


    /**
     * total fret si CIF
     */
    private Double recTotAssurance;


    /**
     * total fret si CIF
     */
    private Double recTotAssurancelocal;


    /**
     * 0=non solde 1=solde
     */
    private Integer recSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String recBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    private Integer recTypeReg;


    /**
     * mode de reglement xml
     */
    private String recModeReg;


    /**
     * nombre de jour
     */
    private Integer recNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer recArrondiReg;


    /**
     * condition de reglement
     */
    private String recConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate recDateEcheReg;


    /**
     * code journal des reglements
     */
    private String recJournalReg;


    /**
     * code activite
     */
    private String recActivite;


    /**
     * code site
     */
    private String recSite;


    /**
     * code departement
     */
    private String recDepartement;


    /**
     * code service
     */
    private String recService;


    /**
     * code region
     */
    private String recRegion;


    /**
     * code secteur
     */
    private String recSecteur;


    /**
     * code point de vente
     */
    private String recPdv;


    /**
     * code analytique 2 (parc)
     */
    private String recAnal2;


    /**
     * code analytique 4 (dossier)
     */
    private String recAnal4;


    /**
     * info 1
     */
    private String recInfo1;


    /**
     * info 2
     */
    private String recInfo2;


    /**
     * info 3
     */
    private String recInfo3;


    /**
     * info 4
     */
    private String recInfo4;


    /**
     * info 5
     */
    private String recInfo5;


    /**
     * info 6
     */
    private String recInfo6;


    /**
     * info 7
     */
    private String recInfo7;


    /**
     * info 8
     */
    private String recInfo8;


    /**
     * info 9
     */
    private String recInfo9;


    /**
     * info 10
     */
    private String recInfo10;


    /**
     * code formule 1
     */
    private String recFormule1;


    /**
     * code formule 2
     */
    private String recFormule2;


    /**
     * nom jasper anexe 1
     */
    private String recAnnexe1;


    /**
     * nom jasper anexe 2
     */
    private String recAnnexe2;


    /**
     * code contrat
     */
    private String recContrat;


    /**
     * code incoterm
     */
    private String recIncoterm;


    /**
     * lieu de livraison
     */
    private String recLieuLivraison;


    /**
     * date de livraison
     */
    private LocalDate recDateLivraison;


    /**
     * info sur la livraison
     */
    private String recInfoLivraison;


    /**
     * date impression
     */
    private LocalDate recDateImp;


    /**
     * nom jasper du modele
     */
    private String recModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer recEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer recGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme partiel 5=transforme total
     */
    private Integer recEtat;


    /**
     * numero valorisation
     */
    private String recValo;


    /**
     * 0=sur coef 1=sur frais
     */
    private Integer recValorisation;


    /**
     * coefficient de valorisation
     */
    private Float recCoefValo;


    /**
     * date de validite
     */
    private LocalDate recDateValidite;


    /**
     * date de relance
     */
    private LocalDate recDateRelance;


    /**
     * date de validation
     */
    private LocalDate recDateValide;


    /**
     * date de facturation
     */
    private LocalDate recDateFacture;


    /**
     * numero facture fournisseur
     */
    private String recNumFacture;


    /**
     * date de transformation
     */
    private LocalDate recDateTransforme;


    /**
     * type de transformation
     */
    private Integer recTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate recDateAnnule;


    /**
     * motif annulation
     */
    private String recMotifAnnule;


    /**
     * nom du factor
     */
    private String recFactorNom;


    /**
     * id du factor
     */
    private Long recFactorId;


    /**
     * 0=en cours 1=accepter 2=refuser
     */
    private Integer recFactorEtat;


    /**
     * commentaire sur la production
     */
    private String recCommentaire;


    /**
     * numero de production
     */
    private String recProduction;


    /**
     * nom du livreur
     */
    private String recLivreurNom;

    private Long exeachId;

    private Long tieId;

    private Long usrId;


    /**
     * total qte
     */
    private Float recTotQte;


    /**
     * 0=normal 99= divers
     */
    private Integer recDiversTiers;


    /**
     * nom du tiers divers
     */
    private String recDiversNom;


    /**
     * adresse du tiers divers
     */
    private String recDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String recDiversVille;


    /**
     * telephone du tiers divers
     */
    private String recDiversTel;


    /**
     * mail du tiers divers
     */
    private String recDiversMail;

}
