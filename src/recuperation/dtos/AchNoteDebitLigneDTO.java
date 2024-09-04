package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class AchNoteDebitLigneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long ndfligId;


    /**
     * code produit
     */
    private String ndfligCode;


    /**
     * famille vente
     */
    private String ndfligFamille;


    /**
     * libelle produit
     */
    private String ndfligLibelle;


    /**
     * reference produit
     */
    private String ndfligReference;


    /**
     * code taxe
     */
    private String ndfligTaxe;


    /**
     * taux de taxe
     */
    private Float ndfligTauxTaxe;


    /**
     * unite produit
     */
    private String ndfligUnite;


    /**
     * conditionnement produit
     */
    private String ndfligCondition;


    /**
     * description conditionnement produit
     */
    private String ndfligDescription;


    /**
     * echelle de la ligne
     */
    private Integer ndfligEchelle;


    /**
     * quantite
     */
    private Float ndfligQte;


    /**
     * longueur
     */
    private Float ndfligLong;


    /**
     * largeur
     */
    private Float ndfligLarg;


    /**
     * hauteur
     */
    private Float ndfligHaut;


    /**
     * diametre
     */
    private Float ndfligDiam;


    /**
     * nombre de piece
     */
    private Float ndfligNb;


    /**
     * poids net
     */
    private Float ndfligPoidsnet;


    /**
     * poids brut
     */
    private Float ndfligPoidsbrut;


    /**
     * volume
     */
    private Float ndfligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float ndfligQteUtil;


    /**
     * code devise
     */
    private String ndfligDevise;


    /**
     * prix unitaire
     */
    private Double ndfligPu;


    /**
     * taux de remise
     */
    private Float ndfligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double ndfligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double ndfligPuRem;


    /**
     * prix total ht
     */
    private Double ndfligPt;


    /**
     * total taxe
     */
    private Double ndfligTva;


    /**
     * total taxe complementaire
     */
    private Double ndfligTc;


    /**
     * total ttc
     */
    private Double ndfligTtc;


    /**
     * pump
     */
    private Double ndfligPump;

    private Long ndfId;


    /**
     * libelle produit
     */
    private String ndfligLibelleFournisseur;


    /**
     * descriptif complementaire
     */
    private String ndfligComplement;


    /**
     * prix revient
     */
    private Double ndfligPr;

}
