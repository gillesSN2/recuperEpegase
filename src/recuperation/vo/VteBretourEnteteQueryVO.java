package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VteBretourEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long brtId;


    /**
     * date de creation
     */
    private LocalDateTime brtDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime brtDateModif;


    /**
     * id user createur
     */
    private Long brtIdCreateur;


    /**
     * nom du createur
     */
    private String brtNomCreateur;


    /**
     * id user de modification
     */
    private Long brtIdModif;


    /**
     * nom user de modification
     */
    private String brtNomModif;


    /**
     * date du bon
     */
    private LocalDateTime brtDate;


    /**
     * numero devis
     */
    private String brtNum;


    /**
     * nom du commercial
     */
    private String brtNomResponsable;


    /**
     * id du commercial
     */
    private Long brtIdResponsable;


    /**
     * nom du client
     */
    private String brtNomTiers;


    /**
     * civilite du tiers
     */
    private String brtCivilTiers;


    /**
     * id du contact
     */
    private Long brtIdContact;


    /**
     * nom du contact
     */
    private String brtNomContact;


    /**
     * civilite du contact
     */
    private String brtCivilContact;


    /**
     * serie
     */
    private String brtSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer brtExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer brtExoDouane;


    /**
     * categorie du client
     */
    private String brtCat;


    /**
     * code devise
     */
    private String brtDevise;


    /**
     * objet
     */
    private String brtObject;


    /**
     * observation
     */
    private String brtObservation;


    /**
     * code budget
     */
    private String brtBudget;


    /**
     * total ht
     */
    private Double brtTotHt;


    /**
     * total remise
     */
    private Double brtTotRemise;


    /**
     * total rabais
     */
    private Double brtTotRabais;


    /**
     * ttal tva
     */
    private Double brtTotTva;


    /**
     * taux taxe complementaire
     */
    private Float brtTauxTc;


    /**
     * total taxe complementaire
     */
    private Double brtTotTc;


    /**
     * total ttc
     */
    private Double brtTotTtc;


    /**
     * total reglement
     */
    private Double brtTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer brtSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String brtBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    private Integer brtTypeReg;


    /**
     * mode de reglement xml
     */
    private String brtModeReg;


    /**
     * nombre de jour
     */
    private Integer brtNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer brtArrondiReg;


    /**
     * condition de reglement
     */
    private String brtConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate brtDateEcheReg;


    /**
     * code journal des reglements
     */
    private String brtJournalReg;


    /**
     * code activite
     */
    private String brtActivite;


    /**
     * code site
     */
    private String brtSite;


    /**
     * code departement
     */
    private String brtDepartement;


    /**
     * code service
     */
    private String brtService;


    /**
     * code region
     */
    private String brtRegion;


    /**
     * code secteur
     */
    private String brtSecteur;


    /**
     * code point de vente
     */
    private String brtPdv;


    /**
     * code analytique 2
     */
    private String brtAnal2;


    /**
     * code analytique 4
     */
    private String brtAnal4;


    /**
     * info 1
     */
    private String brtInfo1;


    /**
     * info 2
     */
    private String brtInfo2;


    /**
     * info 3
     */
    private String brtInfo3;


    /**
     * info 4
     */
    private String brtInfo4;


    /**
     * info 5
     */
    private String brtInfo5;


    /**
     * info 6
     */
    private String brtInfo6;


    /**
     * info 7
     */
    private String brtInfo7;


    /**
     * info 8
     */
    private String brtInfo8;


    /**
     * info 9
     */
    private String brtInfo9;


    /**
     * info 10
     */
    private String brtInfo10;


    /**
     * code formule 1
     */
    private String brtFormule1;


    /**
     * code formule 2
     */
    private String brtFormule2;


    /**
     * nom jasper de anexe 1
     */
    private String brtAnnexe1;


    /**
     * nom jasper de anexe 2
     */
    private String brtAnnexe2;


    /**
     * code contrat
     */
    private String brtContrat;


    /**
     * code incoterm
     */
    private String brtIncoterm;


    /**
     * lieu de livraison
     */
    private String brtLieuLivraison;


    /**
     * date de livraison
     */
    private LocalDate brtDateLivraison;


    /**
     * info sur la livraison
     */
    private String brtInfoLivraison;


    /**
     * date impression
     */
    private LocalDate brtDateImp;


    /**
     * nom jasper du modele
     */
    private String brtModeleImp;


    /**
     * nom jasper page de garde
     */
    private String brtGarde;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer brtEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer brtGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer brtEtat;


    /**
     * date de validite
     */
    private LocalDate brtDateValidite;


    /**
     * date de relance
     */
    private LocalDate brtDateRelance;


    /**
     * date de validation
     */
    private LocalDate brtDateValide;


    /**
     * date de transformation
     */
    private LocalDate brtDateTransforme;


    /**
     * type de transformation
     */
    private Integer brtTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate brtDateAnnule;


    /**
     * motif annulation
     */
    private String brtMotifAnnule;


    /**
     * nom du factor
     */
    private String brtFactorNom;


    /**
     * id du factor
     */
    private Long brtFactorId;


    /**
     * 0=en cours 1=accepter 2=refuser
     */
    private Integer brtFactorEtat;


    /**
     * 0=normal 99= divers
     */
    private Integer brtDiversTiers;


    /**
     * nom du tiers divers
     */
    private String brtDiversNom;


    /**
     * adresse du tiers divers
     */
    private String brtDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String brtDiversVille;


    /**
     * telephone du tiers divers
     */
    private String brtDiversTel;


    /**
     * mail du tiers divers
     */
    private String brtDiversMail;

    private Long exevteId;

    private Long tieId;

    private Long usrId;


    /**
     * nom du commercial
     */
    private String brtNomCommercial;


    /**
     * id du commercial
     */
    private Long brtIdCommercial;


    /**
     * nom equipe
     */
    private String brtNomEquipe;


    /**
     * id equipe
     */
    private Long brtIdEquipe;


    /**
     * numero avoir
     */
    private String brtNumAvoir;


    /**
     * taux remise globale
     */
    private Float brtTauxRemise;


    /**
     * source du document
     */
    private String brtSource;

}
