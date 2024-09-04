package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class AchDemandeLigneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long demligId;


    /**
     * code produit
     */
    private String demligCode;


    /**
     * famille vente
     */
    private String demligFamille;


    /**
     * libelle produit
     */
    private String demligLibelle;


    /**
     * reference produit
     */
    private String demligReference;


    /**
     * code taxe
     */
    private String demligTaxe;


    /**
     * taux de taxe
     */
    private Float demligTauxTaxe;


    /**
     * unite produit
     */
    private String demligUnite;


    /**
     * conditionnement produit
     */
    private String demligCondition;


    /**
     * description conditionnement produit
     */
    private String demligDescription;


    /**
     * quantite
     */
    private Float demligQte;


    /**
     * longueur
     */
    private Float demligLong;


    /**
     * largeur
     */
    private Float demligLarg;


    /**
     * hauteur
     */
    private Float demligHaut;


    /**
     * diametre
     */
    private Float demligDiam;


    /**
     * nombre de piece
     */
    private Float demligNb;


    /**
     * poids net
     */
    private Float demligPoidsnet;


    /**
     * poids brut
     */
    private Float demligPoidsbrut;


    /**
     * volume
     */
    private Float demligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float demligQteUtil;


    /**
     * quantite en stock
     */
    private Float demligQteStock;


    /**
     * code devise
     */
    private String demligDevise;


    /**
     * prix unitaire
     */
    private Double demligPu;


    /**
     * prix total ht
     */
    private Double demligPt;


    /**
     * total taxe
     */
    private Double demligTva;


    /**
     * total ttc
     */
    private Double demligTtc;


    /**
     * prix de revient
     */
    private Double demligPr;


    /**
     * prix de revient
     */
    private Double demligPump;


    /**
     * nom du fournisseur
     */
    private String demligNomTiers;


    /**
     * civilite du fournisseur
     */
    private String demligCivilTiers;


    /**
     * id du fournisseur
     */
    private Long demligIdTiers;

    private Long demId;


    /**
     * descriptif complementaire
     */
    private String demligComplement;

}
