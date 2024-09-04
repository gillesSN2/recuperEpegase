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
public class CmmProduitsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "proId can not null")
    private Long proId;


    /**
     * date de creation
     */
    private LocalDateTime proDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime proDateModif;


    /**
     * id user createur
     */
    private Long proUserCreat;


    /**
     * id user de modification
     */
    private Long proUserModif;


    /**
     * code produit
     */
    private String proCode;


    /**
     * code option
     */
    private String proCodeOption;


    /**
     * libelle client
     */
    private String proLibClient;


    /**
     * libelle technique
     */
    private String proLibTech;


    /**
     * description du produit
     */
    private String proDescrip;


    /**
     * 0=verrouillage de la zone libelle 1=deverrouillage de la zone libelle
     */
    private Integer proImpDesciption;


    /**
     * code barre
     */
    private String proBarre;


    /**
     * code famille achat
     */
    private String proAchCode;


    /**
     * libelle famille achat
     */
    private String proAchLib;


    /**
     * code douane achat
     */
    private String proAchDouane;


    /**
     * code tva achat
     */
    private String proAchTva;


    /**
     * compte achat local
     */
    private String proAchCpteLoc;


    /**
     * compte achat zone
     */
    private String proAchCpteZ;


    /**
     * compte achat hors zone
     */
    private String proAchCpteHz;


    /**
     * compte achat charges
     */
    private String proAchCpteCh;


    /**
     * compte achat stock
     */
    private String proAchCpteSt;


    /**
     * nature famille achat
     */
    private String proAchNat;


    /**
     * code depot par defaut pour les achats
     */
    private String proDepotAch;


    /**
     * code depot par defaut pour la production
     */
    private String proDepotPrd;


    /**
     * code famille de vente
     */
    private String proVteCode;


    /**
     * libelle famille de vente
     */
    private String proVteLib;


    /**
     * code douane de vente
     */
    private String proVteDouane;


    /**
     * code tva de vente
     */
    private String proVteTva;


    /**
     * compte vente en local
     */
    private String proVteCpteLoc;


    /**
     * compte vente dans la zone
     */
    private String proVteCpteZ;


    /**
     * compte vente hors zone
     */
    private String proVteCpteHz;


    /**
     * compte vente produit
     */
    private String proVteCptePr;


    /**
     * compte vente stock
     */
    private String proVteCpteSt;


    /**
     * nature famille de vente
     */
    private String proVteNat;


    /**
     * code depot par defaut pour les ventes
     */
    private String proDepotVte;


    /**
     * 0=sans stock 1=stock simple 2=lifo 3=fifo 4=peremption 5=serialise 6=consigne 7=debours
     */
    private Integer proStock;


    /**
     * conditionnement 1
     */
    private String proCondition1;


    /**
     * conditionnement 2
     */
    private String proCondition2;


    /**
     * conditionnement 3
     */
    private String proCondition3;


    /**
     * conditionnement 4
     */
    private String proCondition4;


    /**
     * conditionnement 5
     */
    private String proCondition5;


    /**
     * code acitivite commerciale
     */
    private String proActivite;


    /**
     * code cle 1 repartition
     */
    private String proCle1;


    /**
     * code cle 2 repartition
     */
    private String proCle2;


    /**
     * code promotion
     */
    private String proPromo;


    /**
     * code lettre de facturation
     */
    private String proLettre;


    /**
     * longueur
     */
    private Float proLongueur;


    /**
     * largeur
     */
    private Float proLargeur;


    /**
     * epaisseur
     */
    private Float proEpaisseur;


    /**
     * volume
     */
    private Float proVolume;


    /**
     * poids brut
     */
    private Float proPoidsBrut;


    /**
     * poids net
     */
    private Float proPoidsNet;


    /**
     * tare
     */
    private Float proPoidsTare;


    /**
     * diametre interne
     */
    private Float proDiamInt;


    /**
     * diametre externe
     */
    private Float proDiamExt;


    /**
     * densite
     */
    private Float proDensite;


    /**
     * pression
     */
    private Float proPression;


    /**
     * etat du produit
     */
    private String proEtat;


    /**
     * nombre d unite ou nombre de lettre
     */
    private Float proNbUnite;


    /**
     * valeur du pump par defaut
     */
    private Double proDefPump;


    /**
     * date valeur du pump par defaut
     */
    private LocalDate proDefDtePump;


    /**
     * code du groupe d inventaire
     */
    private String proGrpInv;


    /**
     * 0=produit simple 1=groupe visible 2=groupe invisible 3=forfait 4=calcul auto.
     */
    private Integer proMode;


    /**
     * marque du produit
     */
    private String proMarque;


    /**
     * couleur du produit
     */
    private String proCouleur;


    /**
     * constructeur du produit
     */
    private String proConstructeur;


    /**
     * code du produit lie
     */
    private String proCodeLie;


    /**
     * quantite produit lie
     */
    private Float proQteLie;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer proInactif;


    /**
     * photos du produits
     */
    private String proPhoto;


    /**
     * fichier pdf
     */
    private String proPdf;


    /**
     * formule
     */
    private String proFormule;


    /**
     * 0=prive 1=public
     */
    private Integer proPublic;


    /**
     * date de publication
     */
    private LocalDateTime proDatePublic;


    /**
     * energie
     */
    private String proEnergie;


    /**
     * nb de porte
     */
    private Integer proNbPorte;


    /**
     * boite de vitesse
     */
    private Integer proBoiteVitesse;


    /**
     * puissance
     */
    private Integer proPuissance;


    /**
     * cylindree
     */
    private Integer proCylindree;


    /**
     * genre
     */
    private String proGenre;


    /**
     * carrosserie
     */
    private String proCarrosserie;


    /**
     * nb place
     */
    private Integer proNbPlace;


    /**
     * puissance din
     */
    private Integer proPuissanceDin;


    /**
     * remise max
     */
    private Integer proRemise;


    /**
     * prc ht
     */
    private Double proPrcHt;


    /**
     * prc exo partiel
     */
    private Double proPrcExop;


    /**
     * prc exo total
     */
    private Double proPrcExot;


    /**
     * prc ht
     */
    private Double proPrgHt;


    /**
     * prc exo partiel
     */
    private Double proPrgExop;


    /**
     * prc exo total
     */
    private Double proPrgExot;


    /**
     * prix achat en devise
     */
    private Double proPa;


    /**
     * fret en devise
     */
    private Double proFret;


    /**
     * assurance locale
     */
    private Double proAssurance;


    /**
     * devise
     */
    private String proDevise;


    /**
     * coefficient devise
     */
    private Float proCoefDevise;


    /**
     * total caf
     */
    private Double proCaf;


    /**
     * quantite en stock
     */
    private Float proQteStock;


    /**
     * quantite en commande fournisseur
     */
    private Float proQteCmdFournisseur;


    /**
     * quantite en commande client
     */
    private Float proQteCmdClient;


    /**
     * compte vente en local non taxable
     */
    private String proVteCpteNTx;


    /**
     * compte achat en cours
     */
    private String proAchCpteEc;


    /**
     * commission unitaire
     */
    private Double proComUnite;


    /**
     * commission en pourcentage sur le ca
     */
    private Float proComPourcentage;


    /**
     * 0=petite photo 1=grande photo
     */
    private Integer proPhotoTaille;

}
