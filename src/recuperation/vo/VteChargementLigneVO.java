package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

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
public class VteChargementLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "chaligId can not null")
    private Long chaligId;


    /**
     * code produit
     */
    private String chaligCode;


    /**
     * famille vente
     */
    private String chaligFamille;


    /**
     * libelle produit
     */
    private String chaligLibelle;


    /**
     * reference produit
     */
    private String chaligReference;


    /**
     * code taxe
     */
    private String chaligTaxe;


    /**
     * taux de taxe
     */
    private Float chaligTauxTaxe;


    /**
     * unite produit
     */
    private String chaligUnite;


    /**
     * casier rangement
     */
    private String chaligCasier;


    /**
     * depot chargement
     */
    private String chaligDepotCharg;


    /**
     * quantite de chargement
     */
    private Float chaligQteCharg;


    /**
     * prix de revient
     */
    private Double chaligPr;


    /**
     * prix unitaire moyen pondere
     */
    private Double chaligPump;


    /**
     * quantite don
     */
    private Float chaligQteDon;


    /**
     * quantite avoir
     */
    private Float chaligQteAvoir;


    /**
     * depot non conforme
     */
    private String chaligDepotNconforme;


    /**
     * quantite non conforme
     */
    private Float chaligQteNconforme;


    /**
     * depot perce, casse
     */
    private String chaligDepotPerce;


    /**
     * quantite percee, cassee
     */
    private Float chaligQtePercee;


    /**
     * depot perime
     */
    private String chaligDepotPerime;


    /**
     * quantite perimee
     */
    private Float chaligQtePerime;


    /**
     * depot manquant
     */
    private String chaligDepotManquant;


    /**
     * quantite manquant usine
     */
    private Float chaligQteManquant;


    /**
     * depot ecart
     */
    private String chaligDepotEcart;


    /**
     * quantite ecart commerciaux
     */
    private Float chaligQteEcart;

    @NotNull(message = "chamobId can not null")
    private Long chamobId;


    /**
     * id de la ligne du besoin
     */
    private Long chaligIdBes;


    /**
     * id de la ligne de la commande
     */
    private Long chaligIdBcm;


    /**
     * numero ordre
     */
    private Integer chaligOrdre;


    /**
     * generique
     */
    private Integer chaligGenerique;


    /**
     * conditionnement produit
     */
    private String chaligCondition;


    /**
     * description conditionnement produit
     */
    private String chaligDescription;


    /**
     * mode gestion stock
     */
    private Integer chaligStock;


    /**
     * quantite demandee
     */
    private Float chaligQteDem;


    /**
     * prix unitaire
     */
    private Double chaligPu;


    /**
     * taux de remise
     */
    private Float chaligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double chaligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double chaligPuRem;


    /**
     * prix unitaire Ttc avant remise
     */
    private Double chaligPuTtc;


    /**
     * prix unitaire Ttc apres remise
     */
    private Double chaligPuRemTtc;


    /**
     * prix total ht
     */
    private Double chaligPt;


    /**
     * total taxe
     */
    private Double chaligTva;


    /**
     * total taxe complementaire
     */
    private Double chaligTc;


    /**
     * total ttc
     */
    private Double chaligTtc;


    /**
     * echelle de la ligne
     */
    private Integer chaligEchelle;


    /**
     * quantite facture
     */
    private Float chaligQteFacture;


    /**
     * quantite percee, cassee
     */
    private Float chaligQteDefectueux;


    /**
     * quantite reprise
     */
    private Float chaligQteReprise;


    /**
     * quantite retour
     */
    private Float chaligQteRetour;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float chaligQteUtil;


    /**
     * longueur
     */
    private Float chaligLong;


    /**
     * largeur
     */
    private Float chaligLarg;


    /**
     * hauteur
     */
    private Float chaligHaut;


    /**
     * diametre
     */
    private Float chaligDiam;


    /**
     * nombre de piece
     */
    private Float chaligNb;


    /**
     * poids net
     */
    private Float chaligPoidsnet;


    /**
     * poids brut
     */
    private Float chaligPoidsbrut;


    /**
     * volume
     */
    private Float chaligVolume;


    /**
     * date chargement ou rechargement
     */
    private LocalDate chaligDateChargement;


    /**
     * 0=chargement 1=rechargement
     */
    private Integer chaligRechargement;


    /**
     * quantite ramenee par le commercial
     */
    private Float chaligQteRamene;


    /**
     * nmbre de rechargement
     */
    private Integer chaligNombreRechargement;

}
