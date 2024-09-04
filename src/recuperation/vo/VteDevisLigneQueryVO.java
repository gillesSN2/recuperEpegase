package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class VteDevisLigneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long dvsligId;


    /**
     * code produit
     */
    private String dvsligCode;


    /**
     * famille vente
     */
    private String dvsligFamille;


    /**
     * libelle produit
     */
    private String dvsligLibelle;


    /**
     * reference produit
     */
    private String dvsligReference;


    /**
     * code taxe
     */
    private String dvsligTaxe;


    /**
     * taux de taxe
     */
    private Float dvsligTauxTaxe;


    /**
     * unite produit
     */
    private String dvsligUnite;


    /**
     * conditionnement produit
     */
    private String dvsligCondition;


    /**
     * description conditionnement produit
     */
    private String dvsligDescription;


    /**
     * echelle de la ligne
     */
    private Integer dvsligEchelle;


    /**
     * quantite
     */
    private Float dvsligQte;


    /**
     * longueur
     */
    private Float dvsligLong;


    /**
     * largeur
     */
    private Float dvsligLarg;


    /**
     * hauteur
     */
    private Float dvsligHaut;


    /**
     * diametre
     */
    private Float dvsligDiam;


    /**
     * nombre de piece
     */
    private Float dvsligNb;


    /**
     * poids net
     */
    private Float dvsligPoidsnet;


    /**
     * poids brut
     */
    private Float dvsligPoidsbrut;


    /**
     * volume
     */
    private Float dvsligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float dvsligQteUtil;


    /**
     * mode de gestion du stock
     */
    private Integer dvsligStock;


    /**
     * code depot
     */
    private String dvsligDepot;


    /**
     * code devise
     */
    private String dvsligDevise;


    /**
     * prix unitaire HT avant remise
     */
    private Double dvsligPu;


    /**
     * taux de remise
     */
    private Float dvsligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double dvsligRabais;


    /**
     * prix unitaire Ht apres remise
     */
    private Double dvsligPuRem;


    /**
     * prix unitaire Ttc avant remise
     */
    private Double dvsligPuTtc;


    /**
     * prix unitaire Ttc apres remise
     */
    private Double dvsligPuRemTtc;


    /**
     * prix total ht
     */
    private Double dvsligPt;


    /**
     * total taxe
     */
    private Double dvsligTva;


    /**
     * total taxe complementaire
     */
    private Double dvsligTc;


    /**
     * total ttc
     */
    private Double dvsligTtc;


    /**
     * prix unitaire moyen pondere unitaire
     */
    private Double dvsligPump;

    private Long dvsId;


    /**
     * ordre des lignes
     */
    private Integer dvsligOrdre;


    /**
     * descriptif complementaire
     */
    private String dvsligComplement;

}
