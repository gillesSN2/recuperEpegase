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
public class VteBretourLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "brtligId can not null")
    private Long brtligId;


    /**
     * id de la ligne livraison
     */
    private Long brtligIdBlv;


    /**
     * code produit
     */
    private String brtligCode;


    /**
     * famille vente
     */
    private String brtligFamille;


    /**
     * libelle produit
     */
    private String brtligLibelle;


    /**
     * reference produit
     */
    private String brtligReference;


    /**
     * code taxe
     */
    private String brtligTaxe;


    /**
     * taux de taxe
     */
    private Float brtligTauxTaxe;


    /**
     * unite produit
     */
    private String brtligUnite;


    /**
     * conditionnement produit
     */
    private String brtligCondition;


    /**
     * description conditionnement produit
     */
    private String brtligDescription;


    /**
     * code depot
     */
    private String brtligDepot;


    /**
     * mode gestion en stock
     */
    private Integer brtligStock;


    /**
     * quantite en stock
     */
    private Float brtligQteStock;


    /**
     * echelle de la ligne
     */
    private Integer brtligEchelle;


    /**
     * quantite
     */
    private Float brtligQte;


    /**
     * longueur
     */
    private Float brtligLong;


    /**
     * largeur
     */
    private Float brtligLarg;


    /**
     * hauteur
     */
    private Float brtligHaut;


    /**
     * diametre
     */
    private Float brtligDiam;


    /**
     * nombre de piece
     */
    private Float brtligNb;


    /**
     * poids net
     */
    private Float brtligPoidsnet;


    /**
     * poids brut
     */
    private Float brtligPoidsbrut;


    /**
     * volume
     */
    private Float brtligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float brtligQteUtil;


    /**
     * numero de lot
     */
    private String brtligLot;


    /**
     * numero de serie
     */
    private String brtligNumSerie;


    /**
     * code devise
     */
    private String brtligDevise;


    /**
     * prix unitaire
     */
    private Double brtligPu;


    /**
     * taux de remise
     */
    private Float brtligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double brtligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double brtligPuRem;


    /**
     * prix unitaire avant remise
     */
    private Double brtligPuTtc;


    /**
     * prix unitaire apres remise
     */
    private Double brtligPuRemTtc;


    /**
     * prix total ht
     */
    private Double brtligPt;


    /**
     * total taxe
     */
    private Double brtligTva;


    /**
     * total taxe complementaire
     */
    private Double brtligTc;


    /**
     * total ttc
     */
    private Double brtligTtc;


    /**
     * prix unitaire moyen pondere
     */
    private Double brtligPump;

    @NotNull(message = "brtId can not null")
    private Long brtId;


    /**
     * ordre des lignes
     */
    private Integer brtligOrdre;


    /**
     * descriptif complementaire
     */
    private String brtligComplement;

}
