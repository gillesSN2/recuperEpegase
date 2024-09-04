package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class AchBonEntreeLigneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long binligId;


    /**
     * code produit
     */
    private String binligCode;


    /**
     * code depot
     */
    private String binligDepot;


    /**
     * famille produit
     */
    private String binligFamille;


    /**
     * libelle produit
     */
    private String binligLibelle;


    /**
     * reference produit
     */
    private String binligReference;


    /**
     * unite produit
     */
    private String binligUnite;


    /**
     * conditionnement produit
     */
    private String binligCondition;


    /**
     * quantite
     */
    private Float binligQte;


    /**
     * quantite
     */
    private String binligCasier;


    /**
     * longueur
     */
    private Float binligLong;


    /**
     * largeur
     */
    private Float binligLarg;


    /**
     * hauteur
     */
    private Float binligHaut;


    /**
     * diametre
     */
    private Float binligDiam;


    /**
     * nombre de piece
     */
    private Float binligNb;


    /**
     * poids net
     */
    private Float binligPoidsnet;


    /**
     * poids brut
     */
    private Float binligPoidsbrut;


    /**
     * volume
     */
    private Float binligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float binligQteUtil;


    /**
     * mode gestion en stock
     */
    private Integer binligStock;


    /**
     * quantite en stock
     */
    private Float binligQteStock;


    /**
     * pump
     */
    private Double binligPump;


    /**
     * total pump
     */
    private Double binligTotal;


    /**
     * obsrvations
     */
    private String binligObs;

    private Long binId;


    /**
     * description conditionnement produit
     */
    private String binligDescription;

}
