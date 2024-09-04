package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class AchFactureLigneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fcfligId;


    /**
     * id de la ligne de da
     */
    private Long fcfligIdDa;


    /**
     * id de la ligne de cotation
     */
    private Long fcfligIdCot;


    /**
     * id de la ligne de commande
     */
    private Long fcfligIdCmd;


    /**
     * id de la ligne de reception
     */
    private Long fcfligIdRec;


    /**
     * code produit
     */
    private String fcfligCode;


    /**
     * famille vente
     */
    private String fcfligFamille;


    /**
     * libelle produit
     */
    private String fcfligLibelle;


    /**
     * reference produit
     */
    private String fcfligReference;


    /**
     * code taxe
     */
    private String fcfligTaxe;


    /**
     * taux de taxe
     */
    private Float fcfligTauxTaxe;


    /**
     * unite produit
     */
    private String fcfligUnite;


    /**
     * conditionnement produit
     */
    private String fcfligCondition;


    /**
     * description conditionnement produit
     */
    private String fcfligDescription;


    /**
     * quantite
     */
    private Float fcfligQte;


    /**
     * longueur
     */
    private Float fcfligLong;


    /**
     * largeur
     */
    private Float fcfligLarg;


    /**
     * hauteur
     */
    private Float fcfligHaut;


    /**
     * diametre
     */
    private Float fcfligDiam;


    /**
     * nombre de piece
     */
    private Float fcfligNb;


    /**
     * poids net
     */
    private Float fcfligPoidsnet;


    /**
     * poids brut
     */
    private Float fcfligPoidsbrut;


    /**
     * volume
     */
    private Float fcfligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float fcfligQteUtil;


    /**
     * code depot
     */
    private String fcfligDepot;


    /**
     * quantite en stock du depot
     */
    private Float fcfligQteStock;


    /**
     * echelle de la ligne
     */
    private Integer fcfligEchelle;


    /**
     * code devise
     */
    private String fcfligDevise;


    /**
     * prix unitaire
     */
    private Double fcfligPu;


    /**
     * taux de remise
     */
    private Float fcfligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double fcfligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double fcfligPuRem;


    /**
     * prix total ht
     */
    private Double fcfligPt;


    /**
     * total taxe
     */
    private Double fcfligTva;


    /**
     * total taxe complementaire
     */
    private Double fcfligTc;


    /**
     * total ttc
     */
    private Double fcfligTtc;


    /**
     * prix de revient
     */
    private Double fcfligPr;


    /**
     * prix unitaire moyen pondere
     */
    private Double fcfligPump;

    private Long fcfId;


    /**
     * libelle produit
     */
    private String fcfligLibelleFournisseur;


    /**
     * descriptif complementaire
     */
    private String fcfligComplement;

}
