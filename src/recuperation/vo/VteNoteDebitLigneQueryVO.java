package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class VteNoteDebitLigneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long ndbligId;


    /**
     * id de la ligne devis
     */
    private Long ndbligIdDvs;


    /**
     * id de la ligne commande
     */
    private Long ndbligIdBcm;


    /**
     * id de la ligne livraison
     */
    private Long ndbligIdBlv;


    /**
     * code produit
     */
    private String ndbligCode;


    /**
     * famille vente
     */
    private String ndbligFamille;


    /**
     * libelle produit
     */
    private String ndbligLibelle;


    /**
     * reference produit
     */
    private String ndbligReference;


    /**
     * code taxe
     */
    private String ndbligTaxe;


    /**
     * taux de taxe
     */
    private Float ndbligTauxTaxe;


    /**
     * unite produit
     */
    private String ndbligUnite;


    /**
     * conditionnement produit
     */
    private String ndbligCondition;


    /**
     * description conditionnement produit
     */
    private String ndbligDescription;


    /**
     * code depot
     */
    private String ndbligDepot;


    /**
     * mode de gestion stock
     */
    private Integer ndbligStock;


    /**
     * quantite en stock
     */
    private Float ndbligQteStock;


    /**
     * echelle de la ligne
     */
    private Integer ndbligEchelle;


    /**
     * quantite
     */
    private Float ndbligQte;


    /**
     * longueur
     */
    private Float ndbligLong;


    /**
     * largeur
     */
    private Float ndbligLarg;


    /**
     * hauteur
     */
    private Float ndbligHaut;


    /**
     * diametre
     */
    private Float ndbligDiam;


    /**
     * nombre de piece
     */
    private Float ndbligNb;


    /**
     * poids net
     */
    private Float ndbligPoidsnet;


    /**
     * poids brut
     */
    private Float ndbligPoidsbrut;


    /**
     * volume
     */
    private Float ndbligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float ndbligQteUtil;


    /**
     * numero de lot
     */
    private String ndbligLot;


    /**
     * numero de serie
     */
    private String ndbligNumSerie;


    /**
     * code devise
     */
    private String ndbligDevise;


    /**
     * prix unitaire
     */
    private Double ndbligPu;


    /**
     * taux de remise
     */
    private Float ndbligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double ndbligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double ndbligPuRem;


    /**
     * prix unitaire apres remise
     */
    private Double ndbligPuRemTtc;


    /**
     * prix unitaire apres remise
     */
    private Double ndbligPuTtc;


    /**
     * prix total ht
     */
    private Double ndbligPt;


    /**
     * total taxe
     */
    private Double ndbligTva;


    /**
     * total taxe complementaire
     */
    private Double ndbligTc;


    /**
     * total ttc
     */
    private Double ndbligTtc;


    /**
     * prix unitaire moyen pondere
     */
    private Double ndbligPump;

    private Long ndbId;


    /**
     * total commission
     */
    private Double ndbligCommission;


    /**
     * ordre des lignes
     */
    private Integer ndbligOrdre;


    /**
     * descriptif complementaire
     */
    private String ndbligComplement;

}
