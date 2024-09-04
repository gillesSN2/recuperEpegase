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
public class VteContratEnteteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "crtId can not null")
    private Long crtId;


    /**
     * date de creation
     */
    private LocalDateTime crtDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime crtDateModif;


    /**
     * id user createur
     */
    private Long crtIdCreateur;


    /**
     * nom du createur
     */
    private String crtNomCreateur;


    /**
     * id user de modification
     */
    private Long crtIdModif;


    /**
     * nom user de modification
     */
    private String crtNomModif;


    /**
     * date du factue
     */
    private LocalDateTime crtDate;


    /**
     * numero facture
     */
    private String crtNum;


    /**
     * nom equipe
     */
    private String crtNomEquipe;


    /**
     * id equipe
     */
    private Long crtIdEquipe;


    /**
     * nom du commercial
     */
    private String crtNomResponsable;


    /**
     * id du commercial
     */
    private Long crtIdResponsable;


    /**
     * nom du commercial
     */
    private String crtNomCommercial;


    /**
     * id du commercial
     */
    private Long crtIdCommercial;


    /**
     * nom du divers
     */
    private String crtDiversNom;


    /**
     * nom du client
     */
    private String crtNomTiers;


    /**
     * civilite du tiers
     */
    private String crtCivilTiers;


    /**
     * id du contact
     */
    private Long crtIdContact;


    /**
     * nom du contact
     */
    private String crtNomContact;


    /**
     * civilite du contact
     */
    private String crtCivilContact;


    /**
     * serie
     */
    private String crtSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer crtExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer crtExoDouane;


    /**
     * categorie du client
     */
    private String crtCat;


    /**
     * code devise
     */
    private String crtDevise;


    /**
     * objet
     */
    private String crtObject;


    /**
     * observation
     */
    private String crtObservation;


    /**
     * code budget
     */
    private String crtBudget;


    /**
     * taux remise globale
     */
    private Float crtTauxRemise;


    /**
     * total ht
     */
    private Double crtTotHt;


    /**
     * total remise
     */
    private Double crtTotRemise;


    /**
     * total rabais
     */
    private Double crtTotRabais;


    /**
     * ttal tva
     */
    private Double crtTotTva;


    /**
     * taux taxe complementaire
     */
    private Float crtTauxTc;


    /**
     * total taxe complementaire
     */
    private Double crtTotTc;


    /**
     * total ttc
     */
    private Double crtTotTtc;


    /**
     * total timbre
     */
    private Double crtTotTimbre;


    /**
     * nom de la banque + numero de compte
     */
    private String crtBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    private Integer crtTypeReg;


    /**
     * mode de reglement xml
     */
    private String crtModeReg;


    /**
     * nombre de jour
     */
    private Integer crtNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer crtArrondiReg;


    /**
     * condition de reglement
     */
    private String crtConditionReg;


    /**
     * code journal des reglements
     */
    private String crtJournalReg;


    /**
     * code activite
     */
    private String crtActivite;


    /**
     * code site
     */
    private String crtSite;


    /**
     * code departement
     */
    private String crtDepartement;


    /**
     * code service
     */
    private String crtService;


    /**
     * code region
     */
    private String crtRegion;


    /**
     * code secteur
     */
    private String crtSecteur;


    /**
     * code point de vente
     */
    private String crtPdv;


    /**
     * code analytique 2
     */
    private String crtAnal2;


    /**
     * code analytique 4
     */
    private String crtAnal4;


    /**
     * info 1
     */
    private String crtInfo1;


    /**
     * info 2
     */
    private String crtInfo2;


    /**
     * info 3
     */
    private String crtInfo3;


    /**
     * info 4
     */
    private String crtInfo4;


    /**
     * info 5
     */
    private String crtInfo5;


    /**
     * info 6
     */
    private String crtInfo6;


    /**
     * info 7
     */
    private String crtInfo7;


    /**
     * info 8
     */
    private String crtInfo8;


    /**
     * info 9
     */
    private String crtInfo9;


    /**
     * info 10
     */
    private String crtInfo10;


    /**
     * code formule 1
     */
    private String crtFormule1;


    /**
     * code formule 2
     */
    private String crtFormule2;


    /**
     * date impression
     */
    private LocalDate crtDateImp;


    /**
     * nom jasper du modele
     */
    private String crtModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer crtEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer crtGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer crtEtat;


    /**
     * numero de transfert
     */
    private String crtNumTrf;


    /**
     * date de validite
     */
    private LocalDate crtDateValidite;


    /**
     * date de validation
     */
    private LocalDate crtDateValide;


    /**
     * motif exoneration
     */
    private String crtMotifExo;


    /**
     * numero du visa
     */
    private String crtNumVisa;


    /**
     * date du visa
     */
    private LocalDate crtDateVisa;


    /**
     * rangement du visa
     */
    private String crtRangeVisa;


    /**
     * date transfert en compta
     */
    private LocalDate crtDateTransfert;


    /**
     * si facture directe et stock alors 1 sinon 0
     */
    private Integer crtStock;


    /**
     * source du document
     */
    private String crtSource;


    /**
     * date debut
     */
    private LocalDate crtDateDebut;


    /**
     * date fin
     */
    private LocalDate crtDateFin;


    /**
     * 0=contrat vente 1=maintenance ou assistance 2=abonnement saas
     */
    private Integer crtType;


    /**
     * 0=jour 1=semaine 2=mois 3=trimestre 4=semestre 5=annuel
     */
    private Integer crtPeriodicite;


    /**
     * jour de generation
     */
    private Integer crtJour;


    /**
     * text du contrat
     */
    private String crtText;

    @NotNull(message = "exevteId can not null")
    private Long exevteId;

    @NotNull(message = "tieId can not null")
    private Long tieId;

    private Long usrId;

}
