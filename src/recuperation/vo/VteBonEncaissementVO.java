package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
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
public class VteBonEncaissementVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "bonId can not null")
    private Long bonId;


    /**
     * date de creation
     */
    private LocalDateTime bontDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime bontDateModif;


    /**
     * utilisateur de creation
     */
    private Long bonUserCreat;


    /**
     * utilisateur de modification
     */
    private Long bonUserModif;


    /**
     * nature du document origine 21=devis 22=commande 23=livraison 25=facture 26=avoir 27=note debit
     */
    private Integer bonNatRef;


    /**
     * numero du document origine
     */
    private String bonRef;


    /**
     * id du document origine
     */
    private Long bonIdRef;


    /**
     * code de la caisse executrice
     */
    private String bonCodeCaisse;


    /**
     * libelle de la caisse executrice
     */
    private String bonLibCaisse;


    /**
     * code banque du bon
     */
    private String bonCodeBanq;


    /**
     * libelle banque du bon
     */
    private String bonLibBanq;


    /**
     * numero du bon
     */
    private String bonNum;


    /**
     * date du bon
     */
    private LocalDateTime bonDate;


    /**
     * nom du responsable
     */
    private String bonNomResponsable;


    /**
     * observation
     */
    private String bonObservation;


    /**
     * nom du tiers
     */
    private String bonNomTiers;


    /**
     * id du tiers
     */
    private Long bonIdTiers;


    /**
     * 0=client 1=fournisseur 2=agent 3=plan comptable 4=patient 5=eleve
     */
    private Integer bonTypeTiers;


    /**
     * id tiers
     */
    private Long bonIdContact;


    /**
     * nom du contact ou destinataire
     */
    private String bonNomContact;


    /**
     * serie
     */
    private String bonSerie;


    /**
     * libelle
     */
    private String bonLibelle;


    /**
     * objet
     */
    private String bonObject;


    /**
     * devise
     */
    private String bonDevise;


    /**
     * total ttc
     */
    private Double bonTotTtc;


    /**
     * montant a payer
     */
    private Double bonAPayer;


    /**
     * date echeance reglement
     */
    private LocalDateTime bonDateEcheReg;


    /**
     * date de valeur
     */
    private LocalDateTime bonDateValeur;


    /**
     * type de reglement 0=espece 1=cheque 2=virement 3=traite 4=carte bancaire 5=transfert argent 6=epaiement 7=credoc 8=factor 9=compense
     */
    private Integer bonTypeReg;


    /**
     * activite
     */
    private String bonActivite;


    /**
     * site
     */
    private String bonSite;


    /**
     * departement
     */
    private String bonDepartement;


    /**
     * service
     */
    private String bonService;


    /**
     * region
     */
    private String bonRegion;


    /**
     * secteur
     */
    private String bonSecteur;


    /**
     * Pdv
     */
    private String bonPdv;


    /**
     * budget
     */
    private String bonBudget;


    /**
     * 0=a payer 1=regle
     */
    private Integer bonEtat;


    /**
     * date de relance
     */
    private LocalDateTime bonDateRelance;


    /**
     * 0=actif 1=inactif
     */
    private Integer bonActif;


    /**
     * montant encaisse
     */
    private Double bonEncaisse;


    /**
     * montant rendu
     */
    private Double bonRendu;


    /**
     * false=rendu au client true=garde dans le compte client
     */
    private Boolean bonGarde;


    /**
     * banque du tireur
     */
    private String bonBanqueTireur;


    /**
     * numero cheque ou bordereau
     */
    private String bonNumChqBdx;


    /**
     * modele impression recu
     */
    private String bonModeleImp;


    /**
     * numero du document chargement
     */
    private String bonChg;


    /**
     * id du document chargement
     */
    private Long bonIdChg;


    /**
     * numero des factures a payer
     */
    private String bonFacture;


    /**
     * nom des clients
     */
    private String bonClient;


    /**
     * montant a payer
     */
    private String bonMontant;


    /**
     * code budget
     */
    private String bonCodeBudgetTreso;


    /**
     * code poste
     */
    private String bonCodePosteTreso;


    /**
     * id du responsable origine
     */
    private Long bonIdResponsable;


    /**
     * id du commercial origine
     */
    private Long bonIdCommercial;


    /**
     * nom du commercial origine
     */
    private String bonNomCommercial;


    /**
     * id equipe origine
     */
    private Long bonIdEquipe;


    /**
     * nom equipe origine
     */
    private String bonNomEquipe;

}
