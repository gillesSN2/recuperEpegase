package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class AchRetourLigneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long brfligId;


    /**
     * id de la ligne de da
     */
    private Long brfligIdDa;


    /**
     * id de la ligne de cotation
     */
    private Long brfligIdCot;


    /**
     * id de la ligne de commande
     */
    private Long brfligIdCmd;


    /**
     * id de la ligne de reception
     */
    private Long brfligIdRec;


    /**
     * code produit
     */
    private String brfligCode;


    /**
     * famille vente
     */
    private String brfligFamille;


    /**
     * libelle produit
     */
    private String brfligLibelle;


    /**
     * reference produit
     */
    private String brfligReference;


    /**
     * code taxe
     */
    private String brfligTaxe;


    /**
     * taux de taxe
     */
    private Float brfligTauxTaxe;


    /**
     * unite produit
     */
    private String brfligUnite;


    /**
     * mode de gestion de stock
     */
    private Integer brfligStock;


    /**
     * conditionnement produit
     */
    private String brfligCondition;


    /**
     * description conditionnement produit
     */
    private String brfligDescription;


    /**
     * echelle de la ligne
     */
    private Integer brfligEchelle;


    /**
     * quantite
     */
    private Float brfligQte;


    /**
     * longueur
     */
    private Float brfligLong;


    /**
     * largeur
     */
    private Float brfligLarg;


    /**
     * hauteur
     */
    private Float brfligHaut;


    /**
     * diametre
     */
    private Float brfligDiam;


    /**
     * nombre de piece
     */
    private Float brfligNb;


    /**
     * poids net
     */
    private Float brfligPoidsnet;


    /**
     * poids brut
     */
    private Float brfligPoidsbrut;


    /**
     * volume
     */
    private Float brfligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float brfligQteUtil;


    /**
     * code depot
     */
    private String brfligDepot;


    /**
     * quantite en stock du depot
     */
    private Float brfligQteStock;


    /**
     * code devise
     */
    private String brfligDevise;


    /**
     * prix unitaire
     */
    private Double brfligPu;


    /**
     * taux de remise
     */
    private Float brfligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double brfligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double brfligPuRem;


    /**
     * prix total ht
     */
    private Double brfligPt;


    /**
     * total taxe
     */
    private Double brfligTva;


    /**
     * total taxe complementaire
     */
    private Double brfligTc;


    /**
     * total ttc
     */
    private Double brfligTtc;


    /**
     * prix de revient
     */
    private Double brfligPr;


    /**
     * prix unitaire moyen pondere
     */
    private Double brfligPump;

    private Long brfId;


    /**
     * libelle produit
     */
    private String brfligLibelleFournisseur;


    /**
     * descriptif complementaire
     */
    private String brfligComplement;

}
