package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;

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
public class VteAvoirLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "avrligId can not null")
    private Long avrligId;


    /**
     * id de la ligne facture
     */
    private Long avrligIdFac;


    /**
     * id de la ligne note de debit
     */
    private Long avrligIdNdb;


    /**
     * code produit
     */
    private String avrligCode;


    /**
     * famille vente
     */
    private String avrligFamille;


    /**
     * libelle produit
     */
    private String avrligLibelle;


    /**
     * reference produit
     */
    private String avrligReference;


    /**
     * code taxe
     */
    private String avrligTaxe;


    /**
     * taux de taxe
     */
    private Float avrligTauxTaxe;


    /**
     * unite produit
     */
    private String avrligUnite;


    /**
     * conditionnement produit
     */
    private String avrligCondition;


    /**
     * description conditionnement produit
     */
    private String avrligDescription;


    /**
     * code depot
     */
    private String avrligDepot;


    /**
     * mode gestion en stock
     */
    private Integer avrligStock;


    /**
     * quantite en stock
     */
    private Float avrligQteStock;


    /**
     * echelle de la ligne
     */
    private Integer avrligEchelle;


    /**
     * quantite
     */
    private Float avrligQte;


    /**
     * longueur
     */
    private Float avrligLong;


    /**
     * largeur
     */
    private Float avrligLarg;


    /**
     * hauteur
     */
    private Float avrligHaut;


    /**
     * diametre
     */
    private Float avrligDiam;


    /**
     * nombre de piece
     */
    private Float avrligNb;


    /**
     * poids net
     */
    private Float avrligPoidsnet;


    /**
     * poids brut
     */
    private Float avrligPoidsbrut;


    /**
     * volume
     */
    private Float avrligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float avrligQteUtil;


    /**
     * numero de lot
     */
    private String avrligLot;


    /**
     * numero de serie
     */
    private String avrligNumSerie;


    /**
     * code devise
     */
    private String avrligDevise;


    /**
     * prix unitaire
     */
    private Double avrligPu;


    /**
     * taux de remise
     */
    private Float avrligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double avrligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double avrligPuRem;


    /**
     * prix unitaire avant remise
     */
    private Double avrligPuTtc;


    /**
     * prix unitaire apres remise
     */
    private Double avrligPuRemTtc;


    /**
     * prix total ht
     */
    private Double avrligPt;


    /**
     * total taxe
     */
    private Double avrligTva;


    /**
     * total taxe complementaire
     */
    private Double avrligTc;


    /**
     * total ttc
     */
    private Double avrligTtc;


    /**
     * prix unitaire moyen pondere
     */
    private Double avrligPump;

    @NotNull(message = "avrId can not null")
    private Long avrId;


    /**
     * total commission
     */
    private Double avrligCommission;


    /**
     * ordre des lignes
     */
    private Integer avrligOrdre;


    /**
     * descriptif complementaire
     */
    private String avrligComplement;

}
