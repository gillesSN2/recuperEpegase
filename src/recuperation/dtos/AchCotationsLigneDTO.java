package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class AchCotationsLigneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cotligId;


    /**
     * id de la ligne de la da
     */
    private Long cotligIdDa;


    /**
     * code produit
     */
    private String cotligCode;


    /**
     * famille vente
     */
    private String cotligFamille;


    /**
     * libelle produit
     */
    private String cotligLibelle;


    /**
     * reference produit
     */
    private String cotligReference;


    /**
     * code taxe
     */
    private String cotligTaxe;


    /**
     * taux de taxe
     */
    private Float cotligTauxTaxe;


    /**
     * unite produit
     */
    private String cotligUnite;


    /**
     * mode de gestion de stock
     */
    private Integer cotligStock;


    /**
     * conditionnement produit
     */
    private String cotligCondition;


    /**
     * description conditionnement produit
     */
    private String cotligDescription;


    /**
     * echelle de la ligne
     */
    private Integer cotligEchelle;


    /**
     * quantite
     */
    private Float cotligQte;


    /**
     * longueur
     */
    private Float cotligLong;


    /**
     * largeur
     */
    private Float cotligLarg;


    /**
     * hauteur
     */
    private Float cotligHaut;


    /**
     * diametre
     */
    private Float cotligDiam;


    /**
     * nombre de piece
     */
    private Float cotligNb;


    /**
     * poids net
     */
    private Float cotligPoidsnet;


    /**
     * poids brut
     */
    private Float cotligPoidsbrut;


    /**
     * volume
     */
    private Float cotligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float cotligQteUtil;


    /**
     * code devise
     */
    private String cotligDevise;


    /**
     * prix unitaire
     */
    private Double cotligPu;


    /**
     * taux de remise
     */
    private Float cotligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double cotligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double cotligPuRem;


    /**
     * prix total ht
     */
    private Double cotligPt;


    /**
     * total taxe
     */
    private Double cotligTva;


    /**
     * total taxe complementaire
     */
    private Double cotligTc;


    /**
     * prix de revient
     */
    private Double cotligPr;


    /**
     * prix unitaire moyen pondere
     */
    private Double cotligPump;


    /**
     * total ttc
     */
    private Double cotligTtc;

    private Long cotId;


    /**
     * libelle produit
     */
    private String cotligLibelleFournisseur;


    /**
     * descriptif complementaire
     */
    private String cotligComplement;


    /**
     * code depot
     */
    private String cotligDepot;

}
