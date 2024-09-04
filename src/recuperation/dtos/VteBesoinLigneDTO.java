package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class VteBesoinLigneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long besligId;


    /**
     * code produit
     */
    private String besligCode;


    /**
     * famille vente
     */
    private String besligFamille;


    /**
     * libelle produit
     */
    private String besligLibelle;


    /**
     * reference produit
     */
    private String besligReference;


    /**
     * code taxe
     */
    private String besligTaxe;


    /**
     * taux de taxe
     */
    private Float besligTauxTaxe;


    /**
     * unite produit
     */
    private String besligUnite;


    /**
     * conditionnement produit
     */
    private String besligCondition;


    /**
     * description conditionnement produit
     */
    private String besligDescription;


    /**
     * echelle de la ligne
     */
    private Integer besligEchelle;


    /**
     * quantite
     */
    private Float besligQte;


    /**
     * longueur
     */
    private Float besligLong;


    /**
     * largeur
     */
    private Float besligLarg;


    /**
     * hauteur
     */
    private Float besligHaut;


    /**
     * diametre
     */
    private Float besligDiam;


    /**
     * nombre de piece
     */
    private Float besligNb;


    /**
     * poids net
     */
    private Float besligPoidsnet;


    /**
     * poids brut
     */
    private Float besligPoidsbrut;


    /**
     * volume
     */
    private Float besligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float besligQteUtil;


    /**
     * mode de gestion du stock
     */
    private Integer besligStock;


    /**
     * code depot
     */
    private String besligDepot;


    /**
     * code devise
     */
    private String besligDevise;


    /**
     * prix unitaire HT avant remise
     */
    private Double besligPu;


    /**
     * taux de remise
     */
    private Float besligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double besligRabais;


    /**
     * prix unitaire Ht apres remise
     */
    private Double besligPuRem;


    /**
     * prix unitaire Ttc avant remise
     */
    private Double besligPuTtc;


    /**
     * prix unitaire Ttc apres remise
     */
    private Double besligPuRemTtc;


    /**
     * prix total ht
     */
    private Double besligPt;


    /**
     * total taxe
     */
    private Double besligTva;


    /**
     * total taxe complementaire
     */
    private Double besligTc;


    /**
     * total ttc
     */
    private Double besligTtc;


    /**
     * prix unitaire moyen pondere unitaire
     */
    private Double besligPump;

    private Long besId;

}
