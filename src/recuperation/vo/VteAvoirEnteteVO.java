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
public class VteAvoirEnteteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "avrId can not null")
    private Long avrId;


    /**
     * date de creation
     */
    private LocalDateTime avrDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime avrDateModif;


    /**
     * id user createur
     */
    private Long avrIdCreateur;


    /**
     * nom du createur
     */
    private String avrNomCreateur;


    /**
     * id user de modification
     */
    private Long avrIdModif;


    /**
     * nom user de modification
     */
    private String avrNomModif;


    /**
     * date du devis
     */
    private LocalDateTime avrDate;


    /**
     * numero devis
     */
    private String avrNum;


    /**
     * nom du commercial
     */
    private String avrNomResponsable;


    /**
     * id du commercial
     */
    private Long avrIdResponsable;


    /**
     * nom du client
     */
    private String avrNomTiers;


    /**
     * civilite du tiers
     */
    private String avrCivilTiers;


    /**
     * id du contact
     */
    private Long avrIdContact;


    /**
     * nom du contact
     */
    private String avrNomContact;


    /**
     * civilite du contact
     */
    private String avrCivilContact;


    /**
     * serie
     */
    private String avrSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer avrExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer avrExoDouane;


    /**
     * categorie du client
     */
    private String avrCat;


    /**
     * code devise
     */
    private String avrDevise;


    /**
     * objet
     */
    private String avrObject;


    /**
     * observation
     */
    private String avrObservation;


    /**
     * code budget
     */
    private String avrBudget;


    /**
     * total ht
     */
    private Double avrTotHt;


    /**
     * total remise
     */
    private Double avrTotRemise;


    /**
     * total rabais
     */
    private Double avrTotRabais;


    /**
     * ttal tva
     */
    private Double avrTotTva;


    /**
     * taux taxe complementaire
     */
    private Float avrTauxTc;


    /**
     * total taxe complementaire
     */
    private Double avrTotTc;


    /**
     * total ttc
     */
    private Double avrTotTtc;


    /**
     * total reglement
     */
    private Double avrTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer avrSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String avrBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    private Integer avrTypeReg;


    /**
     * mode de reglement xml
     */
    private String avrModeReg;


    /**
     * nombre de jour
     */
    private Integer avrNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer avrArrondiReg;


    /**
     * condition de reglement
     */
    private String avrConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate avrDateEcheReg;


    /**
     * code journal des reglements
     */
    private String avrJournalReg;


    /**
     * code activite
     */
    private String avrActivite;


    /**
     * code site
     */
    private String avrSite;


    /**
     * code departement
     */
    private String avrDepartement;


    /**
     * code service
     */
    private String avrService;


    /**
     * code region
     */
    private String avrRegion;


    /**
     * code secteur
     */
    private String avrSecteur;


    /**
     * code point de vente
     */
    private String avrPdv;


    /**
     * code analytique 2
     */
    private String avrAnal2;


    /**
     * code analytique 4
     */
    private String avrAnal4;


    /**
     * info 1
     */
    private String avrInfo1;


    /**
     * info 2
     */
    private String avrInfo2;


    /**
     * info 3
     */
    private String avrInfo3;


    /**
     * info 4
     */
    private String avrInfo4;


    /**
     * info 5
     */
    private String avrInfo5;


    /**
     * info 6
     */
    private String avrInfo6;


    /**
     * info 7
     */
    private String avrInfo7;


    /**
     * info 8
     */
    private String avrInfo8;


    /**
     * info 9
     */
    private String avrInfo9;


    /**
     * info 10
     */
    private String avrInfo10;


    /**
     * code formule 1
     */
    private String avrFormule1;


    /**
     * code formule 2
     */
    private String avrFormule2;


    /**
     * nom jasper de anexe 1
     */
    private String avrAnnexe1;


    /**
     * nom jasper de anexe 2
     */
    private String avrAnnexe2;


    /**
     * code contrat
     */
    private String avrContrat;


    /**
     * code incoterm
     */
    private String avrIncoterm;


    /**
     * lieu de livraison
     */
    private String avrLieuLivraison;


    /**
     * date de livraison
     */
    private LocalDate avrDateLivraison;


    /**
     * info sur la livraison
     */
    private String avrInfoLivraison;


    /**
     * date impression
     */
    private LocalDate avrDateImp;


    /**
     * nom jasper du modele
     */
    private String avrModeleImp;


    /**
     * nom jasper page de garde
     */
    private String avrGarde;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer avrEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer avrGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer avrEtat;


    /**
     * date de validite
     */
    private LocalDate avrDateValidite;


    /**
     * date de relance
     */
    private LocalDate avrDateRelance;


    /**
     * date de validation
     */
    private LocalDate avrDateValide;


    /**
     * date de transformation
     */
    private LocalDate avrDateTransforme;


    /**
     * type de transformation
     */
    private Integer avrTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate avrDateAnnule;


    /**
     * motif annulation
     */
    private String avrMotifAnnule;


    /**
     * 0=non exo 1=exoneree
     */
    private Integer avrExo;


    /**
     * motif exoneration
     */
    private String avrMotifExo;


    /**
     * numero du visa
     */
    private String avrNumVisa;


    /**
     * date du visa
     */
    private LocalDate avrDateVisa;


    /**
     * rangement du visa
     */
    private String avrRangeVisa;


    /**
     * date transfert en compta
     */
    private LocalDate avrDateTransfert;


    /**
     * nom du factor
     */
    private String avrFactorNom;


    /**
     * id du factor
     */
    private Long avrFactorId;


    /**
     * 0=en cours 1=accepter 2=refuser
     */
    private Integer avrFactorEtat;


    /**
     * 0=normal 99= divers
     */
    private Integer avrDiversTiers;


    /**
     * nom du tiers divers
     */
    private String avrDiversNom;


    /**
     * adresse du tiers divers
     */
    private String avrDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String avrDiversVille;


    /**
     * telephone du tiers divers
     */
    private String avrDiversTel;


    /**
     * mail du tiers divers
     */
    private String avrDiversMail;

    @NotNull(message = "exevteId can not null")
    private Long exevteId;

    @NotNull(message = "tieId can not null")
    private Long tieId;

    private Long usrId;


    /**
     * nom du commercial
     */
    private String avrNomCommercial;


    /**
     * id du commercial
     */
    private Long avrIdCommercial;


    /**
     * date dernier reglement
     */
    private LocalDate avrDateLastReg;


    /**
     * nom equipe
     */
    private String avrNomEquipe;


    /**
     * id equipe
     */
    private Long avrIdEquipe;


    /**
     * numero de transfert
     */
    private String avrNumTrf;


    /**
     * numero bon de retour
     */
    private String avrNumRetour;


    /**
     * numero facture
     */
    private String avrNumFacture;


    /**
     * numero bc
     */
    private String avrNumBc;


    /**
     * taux remise globale
     */
    private Float avrTauxRemise;


    /**
     * source du document
     */
    private String avrSource;

}
