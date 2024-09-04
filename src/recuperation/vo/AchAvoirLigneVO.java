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
public class AchAvoirLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "avfligId can not null")
    private Long avfligId;


    /**
     * id de la ligne de note de debit
     */
    private Long avfligIdNdf;


    /**
     * id de la ligne de facture
     */
    private Long avfligIdFcf;


    /**
     * code produit
     */
    private String avfligCode;


    /**
     * famille vente
     */
    private String avfligFamille;


    /**
     * libelle produit
     */
    private String avfligLibelle;


    /**
     * reference produit
     */
    private String avfligReference;


    /**
     * code taxe
     */
    private String avfligTaxe;


    /**
     * taux de taxe
     */
    private Float avfligTauxTaxe;


    /**
     * unite produit
     */
    private String avfligUnite;


    /**
     * conditionnement produit
     */
    private String avfligCondition;


    /**
     * description conditionnement produit
     */
    private String avfligDescription;


    /**
     * echelle de la ligne
     */
    private Integer avfligEchelle;


    /**
     * quantite
     */
    private Float avfligQte;


    /**
     * longueur
     */
    private Float avfligLong;


    /**
     * largeur
     */
    private Float avfligLarg;


    /**
     * hauteur
     */
    private Float avfligHaut;


    /**
     * diametre
     */
    private Float avfligDiam;


    /**
     * nombre de piece
     */
    private Float avfligNb;


    /**
     * poids net
     */
    private Float avfligPoidsnet;


    /**
     * poids brut
     */
    private Float avfligPoidsbrut;


    /**
     * volume
     */
    private Float avfligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float avfligQteUtil;


    /**
     * code devise
     */
    private String avfligDevise;


    /**
     * prix unitaire
     */
    private Double avfligPu;


    /**
     * taux de remise
     */
    private Float avfligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double avfligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double avfligPuRem;


    /**
     * prix total ht
     */
    private Double avfligPt;


    /**
     * total taxe
     */
    private Double avfligTva;


    /**
     * total taxe complementaire
     */
    private Double avfligTc;


    /**
     * total ttc
     */
    private Double avfligTtc;


    /**
     * prix de revient
     */
    private Double avfligPr;


    /**
     * prix unitaire moyen pondere
     */
    private Double avfligPump;

    @NotNull(message = "avfId can not null")
    private Long avfId;


    /**
     * libelle produit
     */
    private String avfligLibelleFournisseur;


    /**
     * descriptif complementaire
     */
    private String avfligComplement;

}
