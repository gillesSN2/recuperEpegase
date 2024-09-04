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
public class AchAvoirEnteteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "avfId can not null")
    private Long avfId;


    /**
     * date de creation
     */
    private LocalDateTime avfDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime avfDateModif;


    /**
     * id user createur
     */
    private Long avfIdCreateur;


    /**
     * nom du createur
     */
    private String avfNomCreateur;


    /**
     * id user de modification
     */
    private Long avfIdModif;


    /**
     * nom user de modification
     */
    private String avfNomModif;


    /**
     * date du reception
     */
    private LocalDateTime avfDate;


    /**
     * numero reception
     */
    private String avfNum;


    /**
     * nom du commercial
     */
    private String avfNomResponsable;


    /**
     * id du commercial
     */
    private Long avfIdResponsable;


    /**
     * nom du fournisseur
     */
    private String avfNomTiers;


    /**
     * civilite du tiers
     */
    private String avfCivilTiers;


    /**
     * id du contact
     */
    private Long avfIdContact;


    /**
     * nom du contact
     */
    private String avfNomContact;


    /**
     * civilite du contact
     */
    private String avfCivilContact;


    /**
     * serie
     */
    private String avfSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer avfExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer avfExoDouane;


    /**
     * categorie du fournisseur
     */
    private String avfCat;


    /**
     * code devise
     */
    private String avfDevise;


    /**
     * objet
     */
    private String avfObject;


    /**
     * observation
     */
    private String avfObservation;


    /**
     * code budget
     */
    private String avfBudget;


    /**
     * montant disponible sur budget
     */
    private Double avfBudgetDispo;


    /**
     * montant disponible sur treso
     */
    private Double avfBudgetTreso;


    /**
     * budget mensuel dispo
     */
    private Double avfBudgetDispoMois;


    /**
     * budget mensuel treso
     */
    private Double avfBudgetTresoMois;


    /**
     * total ht
     */
    private Double avfTotHt;


    /**
     * total remise
     */
    private Double avfTotRemise;


    /**
     * total rabais
     */
    private Double avfTotRabais;


    /**
     * ttal tva
     */
    private Double avfTotTva;


    /**
     * total taxe complementaire
     */
    private Double avfTotTc;


    /**
     * total ttc
     */
    private Double avfTotTtc;


    /**
     * total reglement
     */
    private Double avfTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer avfSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String avfBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    private Integer avfTypeReg;


    /**
     * mode de reglement xml
     */
    private String avfModeReg;


    /**
     * nombre de jour
     */
    private Integer avfNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer avfArrondiReg;


    /**
     * condition de reglement
     */
    private String avfConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate avfDateEcheReg;


    /**
     * code journal des reglements
     */
    private String avfJournalReg;


    /**
     * code activite
     */
    private String avfActivite;


    /**
     * code site
     */
    private String avfSite;


    /**
     * code departement
     */
    private String avfDepartement;


    /**
     * code service
     */
    private String avfService;


    /**
     * code region
     */
    private String avfRegion;


    /**
     * code secteur
     */
    private String avfSecteur;


    /**
     * code point de vente
     */
    private String avfPdv;


    /**
     * code analytique 2
     */
    private String avfAnal2;


    /**
     * code analytique 4
     */
    private String avfAnal4;


    /**
     * info 1
     */
    private String avfInfo1;


    /**
     * info 2
     */
    private String avfInfo2;


    /**
     * info 3
     */
    private String avfInfo3;


    /**
     * info 4
     */
    private String avfInfo4;


    /**
     * info 5
     */
    private String avfInfo5;


    /**
     * info 6
     */
    private String avfInfo6;


    /**
     * info 7
     */
    private String avfInfo7;


    /**
     * info 8
     */
    private String avfInfo8;


    /**
     * info 9
     */
    private String avfInfo9;


    /**
     * info 10
     */
    private String avfInfo10;


    /**
     * code formule 1
     */
    private String avfFormule1;


    /**
     * code formule 2
     */
    private String avfFormule2;


    /**
     * nom jasper anexe 1
     */
    private String avfAnnexe1;


    /**
     * nom jasper anexe 2
     */
    private String avfAnnexe2;


    /**
     * code contrat
     */
    private String avfContrat;


    /**
     * numero facture fournisseur
     */
    private String avfNumFour;


    /**
     * date impression
     */
    private LocalDate avfDateImp;


    /**
     * nom jasper du modele
     */
    private String avfModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer avfEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer avfGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer avfEtat;


    /**
     * date de validite
     */
    private LocalDate avfDateValidite;


    /**
     * date de relance
     */
    private LocalDate avfDateRelance;


    /**
     * date de validation
     */
    private LocalDate avfDateValide;


    /**
     * date de transformation
     */
    private LocalDate avfDateTransforme;


    /**
     * type de transformation
     */
    private Integer avfTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate avfDateAnnule;


    /**
     * motif annulation
     */
    private String avfMotifAnnule;


    /**
     * date transfert en compta
     */
    private LocalDate avfDateTransfert;

    @NotNull(message = "exeachId can not null")
    private Long exeachId;

    @NotNull(message = "tieId can not null")
    private Long tieId;

    private Long usrId;


    /**
     * 0=normal 99= divers
     */
    private Integer avfDiversTiers;


    /**
     * nom du tiers divers
     */
    private String avfDiversNom;


    /**
     * adresse du tiers divers
     */
    private String avfDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String avfDiversVille;


    /**
     * telephone du tiers divers
     */
    private String avfDiversTel;


    /**
     * mail du tiers divers
     */
    private String avfDiversMail;


    /**
     * numero de transfert
     */
    private String avfNumTrf;

}
