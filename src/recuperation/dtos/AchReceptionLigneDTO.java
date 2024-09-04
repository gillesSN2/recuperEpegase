package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class AchReceptionLigneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long recligId;


    /**
     * id de la ligne de da
     */
    private Long recligIdDa;


    /**
     * id de la ligne de cotation
     */
    private Long recligIdCot;


    /**
     * id de la ligne de commande
     */
    private Long recligIdCmd;


    /**
     * code produit
     */
    private String recligCode;


    /**
     * code famille
     */
    private String recligFamille;


    /**
     * libelle produit
     */
    private String recligLibelle;


    /**
     * reference produit
     */
    private String recligReference;


    /**
     * code taxe
     */
    private String recligTaxe;


    /**
     * taux de taxe
     */
    private Float recligTauxTaxe;


    /**
     * unite de stockage
     */
    private String recligUnite;


    /**
     * conditionnement produit
     */
    private String recligCondition;


    /**
     * description conditionnement produit
     */
    private String recligDescription;


    /**
     * mode de gestion de stock
     */
    private Integer recligStock;


    /**
     * echelle de la ligne
     */
    private Integer recligEchelle;


    /**
     * quantite
     */
    private Float recligQte;


    /**
     * longueur
     */
    private Float recligLong;


    /**
     * largeur ou laize
     */
    private Float recligLarg;


    /**
     * hauteur
     */
    private Float recligHaut;


    /**
     * diametre
     */
    private Float recligDiam;


    /**
     * nombre de piece
     */
    private Float recligNb;


    /**
     * poids net
     */
    private Float recligPoidsnet;


    /**
     * poids brut
     */
    private Float recligPoidsbrut;


    /**
     * volume
     */
    private Float recligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float recligQteUtil;


    /**
     * code depot
     */
    private String recligDepot;


    /**
     * code depot de la commande
     */
    private String recligDepotCmd;


    /**
     * quantite en stock du depot apres ajout
     */
    private Float recligQteStock;


    /**
     * code devise
     */
    private String recligDevise;


    /**
     * prix unitaire
     */
    private Double recligPu;


    /**
     * taux de remise
     */
    private Float recligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double recligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double recligPuRem;


    /**
     * prix total ht en devise
     */
    private Double recligPtDev;


    /**
     * prix total ht
     */
    private Double recligPt;


    /**
     * total taxe
     */
    private Double recligTva;


    /**
     * total taxe complementaire
     */
    private Double recligTc;


    /**
     * total ttc
     */
    private Double recligTtc;


    /**
     * prix de revient
     */
    private Double recligPr;


    /**
     * prix unitaire moyen pondere
     */
    private Double recligPump;


    /**
     * code douane
     */
    private String recligDouane;


    /**
     * taux douane
     */
    private Float recligTauxDouane;


    /**
     * mode saisie 0=laize 1=format
     */
    private Integer recligMode;


    /**
     * grammage
     */
    private Float recligGr;


    /**
     * couleur
     */
    private String recligCouleur;


    /**
     * fob
     */
    private Double recligFob;


    /**
     * fret
     */
    private Double recligFret;


    /**
     * assurance
     */
    private Double recligAssurance;


    /**
     * t1 droit de douane
     */
    private Double recligT1;


    /**
     * t3 rs
     */
    private Double recligT3;


    /**
     * t5 tva
     */
    private Double recligT5;


    /**
     * t10 pcc
     */
    private Double recligT10;


    /**
     * t30
     */
    private Double recligT30;


    /**
     * t31
     */
    private Double recligT31;


    /**
     * total frais
     */
    private Double recligFrais;


    /**
     * prix de revient au kilo
     */
    private Double recligPrKg;


    /**
     * prix de revient unitaire
     */
    private Double recligPrU;

    private Long recId;


    /**
     * code sommier entree
     */
    private String recligSommier;


    /**
     * coefficient prix de revient
     */
    private Float recligCoefPr;


    /**
     * frais financier
     */
    private Double recligFinancier;


    /**
     * prix de revient ttc
     */
    private Double recligPrUTtc;


    /**
     * libelle produit
     */
    private String recligLibelleFournisseur;


    /**
     * descriptif complementaire
     */
    private String recligComplement;

}
