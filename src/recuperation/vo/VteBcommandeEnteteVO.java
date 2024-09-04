package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class VteBcommandeEnteteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "bcmId can not null")
    private Long bcmId;


    /**
     * date de creation
     */
    private LocalDateTime bcmDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime bcmDateModif;


    /**
     * id user createur
     */
    private Long bcmIdCreateur;


    /**
     * nom du createur
     */
    private String bcmNomCreateur;


    /**
     * id user de modification
     */
    private Long bcmIdModif;


    /**
     * nom user de modification
     */
    private String bcmNomModif;


    /**
     * date du commande
     */
    private LocalDateTime bcmDate;


    /**
     * numero commande
     */
    private String bcmNum;


    /**
     * nom du commercial
     */
    private String bcmNomResponsable;


    /**
     * id du commercial
     */
    private Long bcmIdResponsable;


    /**
     * nom du client
     */
    private String bcmNomTiers;


    /**
     * civilite du tiers
     */
    private String bcmCivilTiers;


    /**
     * id du contact
     */
    private Long bcmIdContact;


    /**
     * nom du contact
     */
    private String bcmNomContact;


    /**
     * civilite du contact
     */
    private String bcmCivilContact;


    /**
     * serie
     */
    private String bcmSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer bcmExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer bcmExoDouane;


    /**
     * categorie du client
     */
    private String bcmCat;


    /**
     * code devise
     */
    private String bcmDevise;


    /**
     * objet
     */
    private String bcmObject;


    /**
     * observation
     */
    private String bcmObservation;


    /**
     * code budget
     */
    private String bcmBudget;


    /**
     * total ht
     */
    private Double bcmTotHt;


    /**
     * total remise
     */
    private Double bcmTotRemise;


    /**
     * total rabais
     */
    private Double bcmTotRabais;


    /**
     * ttal tva
     */
    private Double bcmTotTva;


    /**
     * taux taxe complementaire
     */
    private Float bcmTauxTc;


    /**
     * total taxe complementaire
     */
    private Double bcmTotTc;


    /**
     * total ttc
     */
    private Double bcmTotTtc;


    /**
     * total reglement
     */
    private Double bcmTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer bcmSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String bcmBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement 5=demande credit
     */
    private Integer bcmTypeReg;


    /**
     * mode de reglement xml
     */
    private String bcmModeReg;


    /**
     * date echeance reliquat si type reg = 5
     */
    private LocalDate bcmEcheanceReliquat;


    /**
     * motif du rejet accord du credit
     */
    private String bcmMotifRejetCredit;


    /**
     * nombre de jour
     */
    private Integer bcmNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer bcmArrondiReg;


    /**
     * condition de reglement
     */
    private String bcmConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate bcmDateEcheReg;


    /**
     * code journal des reglements
     */
    private String bcmJournalReg;


    /**
     * code activite
     */
    private String bcmActivite;


    /**
     * code site
     */
    private String bcmSite;


    /**
     * code departement
     */
    private String bcmDepartement;


    /**
     * code service
     */
    private String bcmService;


    /**
     * code region
     */
    private String bcmRegion;


    /**
     * code secteur
     */
    private String bcmSecteur;


    /**
     * code point de vente
     */
    private String bcmPdv;


    /**
     * code analytique 2
     */
    private String bcmAnal2;


    /**
     * code analytique 4
     */
    private String bcmAnal4;


    /**
     * info 1
     */
    private String bcmInfo1;


    /**
     * info 2
     */
    private String bcmInfo2;


    /**
     * info 3
     */
    private String bcmInfo3;


    /**
     * info 4
     */
    private String bcmInfo4;


    /**
     * info 5
     */
    private String bcmInfo5;


    /**
     * info 6
     */
    private String bcmInfo6;


    /**
     * info 7
     */
    private String bcmInfo7;


    /**
     * info 8
     */
    private String bcmInfo8;


    /**
     * info 9
     */
    private String bcmInfo9;


    /**
     * info 10
     */
    private String bcmInfo10;


    /**
     * code formule 1
     */
    private String bcmFormule1;


    /**
     * code formule 2
     */
    private String bcmFormule2;


    /**
     * nom jasper de l annexe 1
     */
    private String bcmAnnexe1;


    /**
     * nom jasper de l annexe 2
     */
    private String bcmAnnexe2;


    /**
     * code contrat
     */
    private String bcmContrat;


    /**
     * code incoterm
     */
    private String bcmIncoterm;


    /**
     * lieu de livraison
     */
    private String bcmLieuLivraison;


    /**
     * date de livraison
     */
    private LocalDate bcmDateLivraison;


    /**
     * info sur la livraison
     */
    private String bcmInfoLivraison;


    /**
     * date impression
     */
    private LocalDateTime bcmDateImp;


    /**
     * nom jasper du modele
     */
    private String bcmModeleImp;


    /**
     * nom jasper page de garde
     */
    private String bcmGarde;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer bcmEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer bcmGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme partiel 5=transforme total
     */
    private Integer bcmEtat;


    /**
     * date de validite
     */
    private LocalDate bcmDateValidite;


    /**
     * date de relance
     */
    private LocalDate bcmDateRelance;


    /**
     * date de validation
     */
    private LocalDateTime bcmDateValide;


    /**
     * date de transformation
     */
    private LocalDateTime bcmDateTransforme;


    /**
     * type de transformation
     */
    private Integer bcmTypeTransforme;


    /**
     * date annulation
     */
    private LocalDateTime bcmDateAnnule;


    /**
     * motif annulation
     */
    private String bcmMotifAnnule;


    /**
     * 0=normal 1=urgent 2=prioritaire
     */
    private Integer bcmNiveau;


    /**
     * nom du preparateur
     */
    private String bcmPreparateur;


    /**
     * conseil pour la preparation
     */
    private String bcmConseil;


    /**
     * nom du factor
     */
    private String bcmFactorNom;


    /**
     * id du factor
     */
    private Long bcmFactorId;


    /**
     * 0=en cours 1=accepter 2=refuser
     */
    private Integer bcmFactorEtat;


    /**
     * 0=initiale 1=en cours production 2=finale
     */
    private Integer bcmPhase;


    /**
     * 0=normal 99= divers
     */
    private Integer bcmDiversTiers;


    /**
     * nom du tiers divers
     */
    private String bcmDiversNom;


    /**
     * adresse du tiers divers
     */
    private String bcmDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String bcmDiversVille;


    /**
     * telephone du tiers divers
     */
    private String bcmDiversTel;


    /**
     * mail du tiers divers
     */
    private String bcmDiversMail;

    @NotNull(message = "exevteId can not null")
    private Long exevteId;

    @NotNull(message = "tieId can not null")
    private Long tieId;

    private Long usrId;


    /**
     * nom du commercial
     */
    private String bcmNomCommercial;


    /**
     * id du commercial
     */
    private Long bcmIdCommercial;


    /**
     * nom equipe
     */
    private String bcmNomEquipe;


    /**
     * id equipe
     */
    private Long bcmIdEquipe;


    /**
     * taux remise globale
     */
    private Float bcmTauxRemise;


    /**
     * source du document
     */
    private String bcmSource;

}
