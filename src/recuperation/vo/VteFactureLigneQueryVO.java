package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class VteFactureLigneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long facligId;


    /**
     * id de la ligne devis
     */
    private Long facligIdDvs;


    /**
     * id de la ligne commande
     */
    private Long facligIdBcm;


    /**
     * id de la ligne livraison
     */
    private Long facligIdBlv;


    /**
     * code produit
     */
    private String facligCode;


    /**
     * famille vente
     */
    private String facligFamille;


    /**
     * libelle produit
     */
    private String facligLibelle;


    /**
     * reference produit
     */
    private String facligReference;


    /**
     * code taxe
     */
    private String facligTaxe;


    /**
     * taux de taxe
     */
    private Float facligTauxTaxe;


    /**
     * unite produit
     */
    private String facligUnite;


    /**
     * conditionnement produit
     */
    private String facligCondition;


    /**
     * description conditionnement produit
     */
    private String facligDescription;


    /**
     * code depot
     */
    private String facligDepot;


    /**
     * mode de gestion stock
     */
    private Integer facligStock;


    /**
     * quantite en stock
     */
    private Float facligQteStock;


    /**
     * echelle de la ligne
     */
    private Integer facligEchelle;


    /**
     * quantite
     */
    private Float facligQte;


    /**
     * longueur
     */
    private Float facligLong;


    /**
     * largeur
     */
    private Float facligLarg;


    /**
     * hauteur
     */
    private Float facligHaut;


    /**
     * diametre
     */
    private Float facligDiam;


    /**
     * nombre de piece
     */
    private Float facligNb;


    /**
     * poids net
     */
    private Float facligPoidsnet;


    /**
     * poids brut
     */
    private Float facligPoidsbrut;


    /**
     * volume
     */
    private Float facligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float facligQteUtil;


    /**
     * numero de lot
     */
    private String facligLot;


    /**
     * numero de serie
     */
    private String facligNumSerie;


    /**
     * code devise
     */
    private String facligDevise;


    /**
     * prix unitaire
     */
    private Double facligPu;


    /**
     * taux de remise
     */
    private Float facligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double facligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double facligPuRem;


    /**
     * prix unitaire TTC avant remise
     */
    private Double facligPuTtc;


    /**
     * prix unitaire TTC apres remise
     */
    private Double facligPuRemTtc;


    /**
     * prix total ht
     */
    private Double facligPt;


    /**
     * total taxe
     */
    private Double facligTva;


    /**
     * total taxe complementaire
     */
    private Double facligTc;


    /**
     * total ttc
     */
    private Double facligTtc;


    /**
     * prix unitaire moyen pondere
     */
    private Double facligPump;

    private Long facId;


    /**
     * si facture directe et stock alors 1 sinon 0
     */
    private Integer facligEntStock;


    /**
     * total commission
     */
    private Double facligCommission;


    /**
     * ordre des lignes
     */
    private Integer facligOrdre;


    /**
     * descriptif complementaire
     */
    private String facligComplement;

}
