package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class AchCommandeLigneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long cmdligId;


    /**
     * Da associe
     */
    private Long cmdligIdDa;


    /**
     * id de la ligne cotation
     */
    private Long cmdligIdCot;


    /**
     * code produit
     */
    private String cmdligCode;


    /**
     * famille vente
     */
    private String cmdligFamille;


    /**
     * libelle produit
     */
    private String cmdligLibelle;


    /**
     * reference produit
     */
    private String cmdligReference;


    /**
     * code taxe
     */
    private String cmdligTaxe;


    /**
     * taux de taxe
     */
    private Float cmdligTauxTaxe;


    /**
     * unite produit
     */
    private String cmdligUnite;


    /**
     * mode de gestion de stock
     */
    private Integer cmdligStock;


    /**
     * conditionnement produit
     */
    private String cmdligCondition;


    /**
     * description conditionnement produit
     */
    private String cmdligDescription;


    /**
     * echelle de la ligne
     */
    private Integer cmdligEchelle;


    /**
     * quantite
     */
    private Float cmdligQte;


    /**
     * longueur
     */
    private Float cmdligLong;


    /**
     * largeur
     */
    private Float cmdligLarg;


    /**
     * hauteur
     */
    private Float cmdligHaut;


    /**
     * diametre
     */
    private Float cmdligDiam;


    /**
     * nombre de piece
     */
    private Float cmdligNb;


    /**
     * poids net
     */
    private Float cmdligPoidsnet;


    /**
     * poids brut
     */
    private Float cmdligPoidsbrut;


    /**
     * volume
     */
    private Float cmdligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float cmdligQteUtil;


    /**
     * code depot
     */
    private String cmdligDepot;


    /**
     * quantite en stock
     */
    private Float cmdligQteStock;


    /**
     * code devise
     */
    private String cmdligDevise;


    /**
     * prix unitaire
     */
    private Double cmdligPu;


    /**
     * taux de remise
     */
    private Float cmdligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double cmdligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double cmdligPuRem;


    /**
     * prix total ht en devise
     */
    private Double cmdligPtDev;


    /**
     * prix total ht
     */
    private Double cmdligPt;


    /**
     * total taxe
     */
    private Double cmdligTva;


    /**
     * total taxe complementaire
     */
    private Double cmdligTc;


    /**
     * total ttc
     */
    private Double cmdligTtc;


    /**
     * prix de revient
     */
    private Double cmdligPr;


    /**
     * prix de revient
     */
    private Double cmdligPump;


    /**
     * code douane
     */
    private String cmdligDouane;


    /**
     * taux douane
     */
    private Float cmdligTauxDouane;


    /**
     * mode saisie 0=laize 1=format
     */
    private Integer cmdligMode;


    /**
     * grammage
     */
    private Float cmdligGr;


    /**
     * couleur
     */
    private String cmdligCouleur;


    /**
     * fob
     */
    private Double cmdligFob;


    /**
     * fret
     */
    private Double cmdligFret;


    /**
     * assurance
     */
    private Double cmdligAssurance;


    /**
     * t1 droit de douane
     */
    private Double cmdligT1;


    /**
     * t3 rs
     */
    private Double cmdligT3;


    /**
     * t5 tva
     */
    private Double cmdligT5;


    /**
     * t10 pcc
     */
    private Double cmdligT10;


    /**
     * t30
     */
    private Double cmdligT30;


    /**
     * t31
     */
    private Double cmdligT31;


    /**
     * total frais
     */
    private Double cmdligFrais;


    /**
     * prix de revient au kilo
     */
    private Double cmdligPrKr;


    /**
     * prix de revient unitaire
     */
    private Double cmdligPrU;

    private Long cmdId;


    /**
     * frais financier
     */
    private Double cmdligFinancier;


    /**
     * prix de revient unitaire ttc
     */
    private Double cmdligPrUTtc;


    /**
     * ordre des lignes
     */
    private Integer cmdligOrdre;


    /**
     * libelle produit
     */
    private String cmdligLibelleFournisseur;


    /**
     * descriptif complementaire
     */
    private String cmdligComplement;

}
