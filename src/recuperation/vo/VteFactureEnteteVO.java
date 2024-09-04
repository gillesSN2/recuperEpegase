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
public class VteFactureEnteteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "facId can not null")
    private Long facId;


    /**
     * date de creation
     */
    private LocalDateTime facDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime facDateModif;


    /**
     * id user createur
     */
    private Long facIdCreateur;


    /**
     * nom du createur
     */
    private String facNomCreateur;


    /**
     * id user de modification
     */
    private Long facIdModif;


    /**
     * nom user de modification
     */
    private String facNomModif;


    /**
     * date du devis
     */
    private LocalDateTime facDate;


    /**
     * numero devis
     */
    private String facNum;


    /**
     * nom du commercial
     */
    private String facNomResponsable;


    /**
     * id du commercial
     */
    private Long facIdResponsable;


    /**
     * nom du client
     */
    private String facNomTiers;


    /**
     * civilite du tiers
     */
    private String facCivilTiers;


    /**
     * id du contact
     */
    private Long facIdContact;


    /**
     * nom du contact
     */
    private String facNomContact;


    /**
     * civilite du contact
     */
    private String facCivilContact;


    /**
     * serie
     */
    private String facSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer facExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer facExoDouane;


    /**
     * categorie du client
     */
    private String facCat;


    /**
     * code devise
     */
    private String facDevise;


    /**
     * objet
     */
    private String facObject;


    /**
     * observation
     */
    private String facObservation;


    /**
     * code budget
     */
    private String facBudget;


    /**
     * total ht
     */
    private Double facTotHt;


    /**
     * total remise
     */
    private Double facTotRemise;


    /**
     * total rabais
     */
    private Double facTotRabais;


    /**
     * ttal tva
     */
    private Double facTotTva;


    /**
     * taux taxe complementaire
     */
    private Float facTauxTc;


    /**
     * total taxe complementaire
     */
    private Double facTotTc;


    /**
     * total ttc
     */
    private Double facTotTtc;


    /**
     * total reglement
     */
    private Double facTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer facSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String facBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    private Integer facTypeReg;


    /**
     * mode de reglement xml
     */
    private String facModeReg;


    /**
     * date echeance reliquat si type reg = 5
     */
    private LocalDate facEcheanceReliquat;


    /**
     * motif du rejet accord du credit
     */
    private String facMotifRejetCredit;


    /**
     * nombre de jour
     */
    private Integer facNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer facArrondiReg;


    /**
     * condition de reglement
     */
    private String facConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate facDateEcheReg;


    /**
     * date dernier reglement
     */
    private LocalDate facDateLastReg;


    /**
     * code journal des reglements
     */
    private String facJournalReg;


    /**
     * code activite
     */
    private String facActivite;


    /**
     * code site
     */
    private String facSite;


    /**
     * code departement
     */
    private String facDepartement;


    /**
     * code service
     */
    private String facService;


    /**
     * code region
     */
    private String facRegion;


    /**
     * code secteur
     */
    private String facSecteur;


    /**
     * code point de vente
     */
    private String facPdv;


    /**
     * code analytique 2
     */
    private String facAnal2;


    /**
     * code analytique 4
     */
    private String facAnal4;


    /**
     * info 1
     */
    private String facInfo1;


    /**
     * info 2
     */
    private String facInfo2;


    /**
     * info 3
     */
    private String facInfo3;


    /**
     * info 4
     */
    private String facInfo4;


    /**
     * info 5
     */
    private String facInfo5;


    /**
     * info 6
     */
    private String facInfo6;


    /**
     * info 7
     */
    private String facInfo7;


    /**
     * info 8
     */
    private String facInfo8;


    /**
     * info 9
     */
    private String facInfo9;


    /**
     * info 10
     */
    private String facInfo10;


    /**
     * code formule 1
     */
    private String facFormule1;


    /**
     * code formule 2
     */
    private String facFormule2;


    /**
     * nom jasper de anexe 1
     */
    private String facAnnexe1;


    /**
     * nom jasper de anexe 2
     */
    private String facAnnexe2;


    /**
     * code contrat
     */
    private String facContrat;


    /**
     * code incoterm
     */
    private String facIncoterm;


    /**
     * lieu de livraison
     */
    private String facLieuLivraison;


    /**
     * date de livraison
     */
    private LocalDate facDateLivraison;


    /**
     * info sur la livraison
     */
    private String facInfoLivraison;


    /**
     * date impression
     */
    private LocalDate facDateImp;


    /**
     * nom jasper du modele
     */
    private String facModeleImp;


    /**
     * nom jasper page de garde
     */
    private String facGarde;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer facEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer facGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer facEtat;


    /**
     * date de validite
     */
    private LocalDate facDateValidite;


    /**
     * date de relance
     */
    private LocalDate facDateRelance;


    /**
     * date de validation
     */
    private LocalDate facDateValide;


    /**
     * date de transformation
     */
    private LocalDate facDateTransforme;


    /**
     * type de transformation
     */
    private Integer facTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate facDateAnnule;


    /**
     * motif annulation
     */
    private String facMotifAnnule;


    /**
     * motif exoneration
     */
    private String facMotifExo;


    /**
     * numero du visa
     */
    private String facNumVisa;


    /**
     * date du visa
     */
    private LocalDate facDateVisa;


    /**
     * rangement du visa
     */
    private String facRangeVisa;


    /**
     * date transfert en compta
     */
    private LocalDate facDateTransfert;


    /**
     * nom du factor
     */
    private String facFactorNom;


    /**
     * id du factor
     */
    private Long facFactorId;


    /**
     * 0=en cours 1=accepter 2=refuser
     */
    private Integer facFactorEtat;


    /**
     * 0=normal 99= divers
     */
    private Integer facDiversTiers;


    /**
     * nom du tiers divers
     */
    private String facDiversNom;


    /**
     * adresse du tiers divers
     */
    private String facDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String facDiversVille;


    /**
     * telephone du tiers divers
     */
    private String facDiversTel;


    /**
     * mail du tiers divers
     */
    private String facDiversMail;

    @NotNull(message = "exevteId can not null")
    private Long exevteId;

    @NotNull(message = "tieId can not null")
    private Long tieId;

    private Long usrId;


    /**
     * nom du commercial
     */
    private String facNomCommercial;


    /**
     * id du commercial
     */
    private Long facIdCommercial;


    /**
     * si facture directe et stock alors 1 sinon 0
     */
    private Integer facStock;


    /**
     * nom equipe
     */
    private String facNomEquipe;


    /**
     * id equipe
     */
    private Long facIdEquipe;


    /**
     * numero de transfert
     */
    private String facNumTrf;


    /**
     * numero dernier bl
     */
    private String facNumBl;


    /**
     * numero avoir
     */
    private String facNumAvoir;


    /**
     * total timbre
     */
    private Double facTotTimbre;


    /**
     * taux remise globale
     */
    private Float facTauxRemise;


    /**
     * source du document
     */
    private String facSource;

}
