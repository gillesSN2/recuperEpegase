package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class VteTicketLigneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long ticligId;


    /**
     * code produit
     */
    private String ticligCode;


    /**
     * famille vente
     */
    private String ticligFamille;


    /**
     * libelle produit
     */
    private String ticligLibelle;


    /**
     * code activite
     */
    private String ticligActivite;


    /**
     * code taxe
     */
    private String ticligTaxe;


    /**
     * taux de taxe
     */
    private Float ticligTauxTaxe;


    /**
     * code depot
     */
    private String ticligDepot;


    /**
     * mode de gestion stock
     */
    private Integer ticligStock;


    /**
     * quantite
     */
    private Float ticligQte;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float ticligQteUtil;


    /**
     * prix unitaire
     */
    private Double ticligPu;


    /**
     * taux de remise
     */
    private Float ticligTauxRemise;


    /**
     * prix unitaire apres remise
     */
    private Double ticligPuRem;


    /**
     * prix unitaire TTC avant remise
     */
    private Double ticligPuTtc;


    /**
     * prix unitaire TTC apres remise
     */
    private Double ticligPuRemTtc;


    /**
     * prix total ht
     */
    private Double ticligPt;


    /**
     * total taxe
     */
    private Double ticligTva;


    /**
     * taux taxe complementaire
     */
    private Float ticligTauxTc;


    /**
     * total taxe complementaire
     */
    private Double ticligTc;


    /**
     * total ttc
     */
    private Double ticligTtc;


    /**
     * prix unitaire moyen pondere
     */
    private Double ticligPump;

    private Long ticId;


    /**
     * poids net
     */
    private Float ticligPoidsnet;


    /**
     * poids brut
     */
    private Float ticligPoidsbrut;

}
