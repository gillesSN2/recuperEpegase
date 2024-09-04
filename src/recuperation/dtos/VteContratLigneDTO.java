package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class VteContratLigneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long crtligId;


    /**
     * ordre des lignes
     */
    private Integer crtligOrdre;


    /**
     * code produit
     */
    private String crtligCode;


    /**
     * famille vente
     */
    private String crtligFamille;


    /**
     * libelle produit
     */
    private String crtligLibelle;


    /**
     * descriptif complementaire
     */
    private String crtligComplement;


    /**
     * reference produit
     */
    private String crtligReference;


    /**
     * code taxe
     */
    private String crtligTaxe;


    /**
     * taux de taxe
     */
    private Float crtligTauxTaxe;


    /**
     * unite produit
     */
    private String crtligUnite;


    /**
     * conditionnement produit
     */
    private String crtligCondition;


    /**
     * description conditionnement produit
     */
    private String crtligDescription;


    /**
     * code depot
     */
    private String crtligDepot;


    /**
     * mode de gestion stock
     */
    private Integer crtligStock;


    /**
     * quantite en stock
     */
    private Float crtligQteStock;


    /**
     * echelle de la ligne
     */
    private Integer crtligEchelle;


    /**
     * quantite
     */
    private Float crtligQte;


    /**
     * longueur
     */
    private Float crtligLong;


    /**
     * largeur
     */
    private Float crtligLarg;


    /**
     * hauteur
     */
    private Float crtligHaut;


    /**
     * diametre
     */
    private Float crtligDiam;


    /**
     * nombre de piece
     */
    private Float crtligNb;


    /**
     * poids net
     */
    private Float crtligPoidsnet;


    /**
     * poids brut
     */
    private Float crtligPoidsbrut;


    /**
     * volume
     */
    private Float crtligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float crtligQteUtil;


    /**
     * numero de lot
     */
    private String crtligLot;


    /**
     * numero de serie
     */
    private String crtligNumSerie;


    /**
     * code devise
     */
    private String crtligDevise;


    /**
     * prix unitaire
     */
    private Double crtligPu;


    /**
     * taux de remise
     */
    private Float crtligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double crtligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double crtligPuRem;


    /**
     * prix unitaire TTC avant remise
     */
    private Double crtligPuTtc;


    /**
     * prix unitaire TTC apres remise
     */
    private Double crtligPuRemTtc;


    /**
     * prix total ht
     */
    private Double crtligPt;


    /**
     * total taxe
     */
    private Double crtligTva;


    /**
     * total taxe complementaire
     */
    private Double crtligTc;


    /**
     * total ttc
     */
    private Double crtligTtc;


    /**
     * prix unitaire moyen pondere
     */
    private Double crtligPump;


    /**
     * si facture directe et stock alors 1 sinon 0
     */
    private Integer crtligEntStock;


    /**
     * total commission
     */
    private Double crtligCommission;

    private Long crtId;

}
