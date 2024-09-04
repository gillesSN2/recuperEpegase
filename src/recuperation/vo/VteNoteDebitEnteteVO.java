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
public class VteNoteDebitEnteteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ndbId can not null")
    private Long ndbId;


    /**
     * date de creation
     */
    private LocalDateTime ndbDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime ndbDateModif;


    /**
     * id user createur
     */
    private Long ndbIdCreateur;


    /**
     * nom du createur
     */
    private String ndbNomCreateur;


    /**
     * id user de modification
     */
    private Long ndbIdModif;


    /**
     * nom user de modification
     */
    private String ndbNomModif;


    /**
     * date du devis
     */
    private LocalDateTime ndbDate;


    /**
     * numero devis
     */
    private String ndbNum;


    /**
     * nom du commercial
     */
    private String ndbNomResponsable;


    /**
     * id du commercial
     */
    private Long ndbIdResponsable;


    /**
     * nom du client
     */
    private String ndbNomTiers;


    /**
     * civilite du tiers
     */
    private String ndbCivilTiers;


    /**
     * id du contact
     */
    private Long ndbIdContact;


    /**
     * nom du contact
     */
    private String ndbNomContact;


    /**
     * civilite du contact
     */
    private String ndbCivilContact;


    /**
     * serie
     */
    private String ndbSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer ndbExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer ndbExoDouane;


    /**
     * categorie du client
     */
    private String ndbCat;


    /**
     * code devise
     */
    private String ndbDevise;


    /**
     * objet
     */
    private String ndbObject;


    /**
     * observation
     */
    private String ndbObservation;


    /**
     * code budget
     */
    private String ndbBudget;


    /**
     * total ht
     */
    private Double ndbTotHt;


    /**
     * total remise
     */
    private Double ndbTotRemise;


    /**
     * total rabais
     */
    private Double ndbTotRabais;


    /**
     * ttal tva
     */
    private Double ndbTotTva;


    /**
     * taux taxe complementaire
     */
    private Float ndbTauxTc;


    /**
     * total taxe complementaire
     */
    private Double ndbTotTc;


    /**
     * total ttc
     */
    private Double ndbTotTtc;


    /**
     * total reglement
     */
    private Double ndbTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer ndbSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String ndbBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    private Integer ndbTypeReg;


    /**
     * mode de reglement xml
     */
    private String ndbModeReg;


    /**
     * date echeance reliquat si type reg = 5
     */
    private LocalDate ndbEcheanceReliquat;


    /**
     * motif du rejet accord du credit
     */
    private String ndbMotifRejetCredit;


    /**
     * nombre de jour
     */
    private Integer ndbNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer ndbArrondiReg;


    /**
     * condition de reglement
     */
    private String ndbConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate ndbDateEcheReg;


    /**
     * code journal des reglements
     */
    private String ndbJournalReg;


    /**
     * code activite
     */
    private String ndbActivite;


    /**
     * code site
     */
    private String ndbSite;


    /**
     * code departement
     */
    private String ndbDepartement;


    /**
     * code service
     */
    private String ndbService;


    /**
     * code region
     */
    private String ndbRegion;


    /**
     * code secteur
     */
    private String ndbSecteur;


    /**
     * code point de vente
     */
    private String ndbPdv;


    /**
     * code analytique 2
     */
    private String ndbAnal2;


    /**
     * code analytique 4
     */
    private String ndbAnal4;


    /**
     * info 1
     */
    private String ndbInfo1;


    /**
     * info 2
     */
    private String ndbInfo2;


    /**
     * info 3
     */
    private String ndbInfo3;


    /**
     * info 4
     */
    private String ndbInfo4;


    /**
     * info 5
     */
    private String ndbInfo5;


    /**
     * info 6
     */
    private String ndbInfo6;


    /**
     * info 7
     */
    private String ndbInfo7;


    /**
     * info 8
     */
    private String ndbInfo8;


    /**
     * info 9
     */
    private String ndbInfo9;


    /**
     * info 10
     */
    private String ndbInfo10;


    /**
     * code formule 1
     */
    private String ndbFormule1;


    /**
     * code formule 2
     */
    private String ndbFormule2;


    /**
     * nom jasper de anexe 1
     */
    private String ndbAnnexe1;


    /**
     * nom jasper de anexe 2
     */
    private String ndbAnnexe2;


    /**
     * code contrat
     */
    private String ndbContrat;


    /**
     * code incoterm
     */
    private String ndbIncoterm;


    /**
     * lieu de livraison
     */
    private String ndbLieuLivraison;


    /**
     * date de livraison
     */
    private LocalDate ndbDateLivraison;


    /**
     * info sur la livraison
     */
    private String ndbInfoLivraison;


    /**
     * date impression
     */
    private LocalDate ndbDateImp;


    /**
     * nom jasper du modele
     */
    private String ndbModeleImp;


    /**
     * nom jasper page de garde
     */
    private String ndbGarde;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer ndbEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer ndbGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer ndbEtat;


    /**
     * date de validite
     */
    private LocalDate ndbDateValidite;


    /**
     * date de relance
     */
    private LocalDate ndbDateRelance;


    /**
     * date de validation
     */
    private LocalDate ndbDateValide;


    /**
     * date de transformation
     */
    private LocalDate ndbDateTransforme;


    /**
     * type de transformation
     */
    private Integer ndbTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate ndbDateAnnule;


    /**
     * motif annulation
     */
    private String ndbMotifAnnule;


    /**
     * 0=non exo 1=exoneree
     */
    private Integer ndbExo;


    /**
     * motif exoneration
     */
    private String ndbMotifExo;


    /**
     * numero du visa
     */
    private String ndbNumVisa;


    /**
     * date du visa
     */
    private LocalDate ndbDateVisa;


    /**
     * rangement du visa
     */
    private String ndbRangeVisa;


    /**
     * date transfert en compta
     */
    private LocalDate ndbDateTransfert;


    /**
     * nom du factor
     */
    private String ndbFactorNom;


    /**
     * id du factor
     */
    private Long ndbFactorId;


    /**
     * 0=en cours 1=accepter 2=refuser
     */
    private Integer ndbFactorEtat;


    /**
     * 0=normal 99= divers
     */
    private Integer ndbDiversTiers;


    /**
     * nom du tiers divers
     */
    private String ndbDiversNom;


    /**
     * adresse du tiers divers
     */
    private String ndbDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String ndbDiversVille;


    /**
     * telephone du tiers divers
     */
    private String ndbDiversTel;


    /**
     * mail du tiers divers
     */
    private String ndbDiversMail;

    @NotNull(message = "exevteId can not null")
    private Long exevteId;

    @NotNull(message = "tieId can not null")
    private Long tieId;

    private Long usrId;


    /**
     * nom du commercial
     */
    private String ndbNomCommercial;


    /**
     * id du commercial
     */
    private Long ndbIdCommercial;


    /**
     * date dernier reglement
     */
    private LocalDate ndbDateLastReg;


    /**
     * nom equipe
     */
    private String ndbNomEquipe;


    /**
     * id equipe
     */
    private Long ndbIdEquipe;


    /**
     * numero de transfert
     */
    private String ndbNumTrf;


    /**
     * taux remise globale
     */
    private Float ndbTauxRemise;


    /**
     * source du document
     */
    private String ndbSource;

}
