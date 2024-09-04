package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class VteBcommandeLigneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long bcmligId;


    /**
     * id de la ligne devis
     */
    private Long bcmligIdDvs;


    /**
     * code produit
     */
    private String bcmligCode;


    /**
     * famille vente
     */
    private String bcmligFamille;


    /**
     * libelle produit
     */
    private String bcmligLibelle;


    /**
     * reference produit
     */
    private String bcmligReference;


    /**
     * code taxe
     */
    private String bcmligTaxe;


    /**
     * taux de taxe
     */
    private Float bcmligTauxTaxe;


    /**
     * unite produit
     */
    private String bcmligUnite;


    /**
     * conditionnement produit
     */
    private String bcmligCondition;


    /**
     * description conditionnement produit
     */
    private String bcmligDescription;


    /**
     * echelle de la ligne
     */
    private Integer bcmligEchelle;


    /**
     * quantite
     */
    private Float bcmligQte;


    /**
     * longueur
     */
    private Float bcmligLong;


    /**
     * largeur
     */
    private Float bcmligLarg;


    /**
     * hauteur
     */
    private Float bcmligHaut;


    /**
     * diametre
     */
    private Float bcmligDiam;


    /**
     * nombre de piece
     */
    private Float bcmligNb;


    /**
     * poids net
     */
    private Float bcmligPoidsnet;


    /**
     * poids brut
     */
    private Float bcmligPoidsbrut;


    /**
     * volume
     */
    private Float bcmligVolume;


    /**
     * depot utilise
     */
    private String bcmligDepot;


    /**
     * mode gestion stock
     */
    private Integer bcmligStock;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float bcmligQteUtil;


    /**
     * quantite en stock
     */
    private Float bcmligQteStock;


    /**
     * code devise
     */
    private String bcmligDevise;


    /**
     * prix unitaire
     */
    private Double bcmligPu;


    /**
     * taux de remise
     */
    private Float bcmligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double bcmligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double bcmligPuRem;


    /**
     * prix unitaire Ttc avant remise
     */
    private Double bcmligPuTtc;


    /**
     * prix unitaire Ttc apres remise
     */
    private Double bcmligPuRemTtc;


    /**
     * prix total ht
     */
    private Double bcmligPt;


    /**
     * total taxe
     */
    private Double bcmligTva;


    /**
     * total taxe complementaire
     */
    private Double bcmligTc;


    /**
     * total ttc
     */
    private Double bcmligTtc;


    /**
     * pump
     */
    private Double bcmligPump;

    private Long bcmId;


    /**
     * ordre des lignes
     */
    private Integer bcmligOrdre;


    /**
     * descriptif complementaire
     */
    private String bcmligComplement;


    /**
     * quantite livree
     */
    private Float bcmligQteLivree;

}
