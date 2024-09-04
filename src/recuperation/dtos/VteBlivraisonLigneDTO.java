package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class VteBlivraisonLigneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long blvligId;


    /**
     * id de la ligne devis
     */
    private Long blvligIdDvs;


    /**
     * id de la ligne commande
     */
    private Long blvligIdBcm;


    /**
     * code produit
     */
    private String blvligCode;


    /**
     * famille vente
     */
    private String blvligFamille;


    /**
     * libelle produit
     */
    private String blvligLibelle;


    /**
     * reference produit
     */
    private String blvligReference;


    /**
     * code taxe
     */
    private String blvligTaxe;


    /**
     * taux de taxe
     */
    private Float blvligTauxTaxe;


    /**
     * unite produit
     */
    private String blvligUnite;


    /**
     * conditionnement produit
     */
    private String blvligCondition;


    /**
     * description conditionnement produit
     */
    private String blvligDescription;


    /**
     * code depot
     */
    private String blvligDepot;


    /**
     * code depot de la commande
     */
    private String blvligDepotCmd;


    /**
     * quantite validee pour maj stock
     */
    private Float blvligQteStock;


    /**
     * mode de gestion de stock
     */
    private Integer blvligStock;


    /**
     * echelle de la ligne
     */
    private Integer blvligEchelle;


    /**
     * quantite
     */
    private Float blvligQte;


    /**
     * longueur
     */
    private Float blvligLong;


    /**
     * largeur
     */
    private Float blvligLarg;


    /**
     * hauteur
     */
    private Float blvligHaut;


    /**
     * diametre
     */
    private Float blvligDiam;


    /**
     * nombre de piece
     */
    private Float blvligNb;


    /**
     * poids net
     */
    private Float blvligPoidsnet;


    /**
     * poids brut
     */
    private Float blvligPoidsbrut;


    /**
     * volume
     */
    private Float blvligVolume;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float blvligQteUtil;


    /**
     * quantite utilisee (valable pour le stock apres validation)
     */
    private Float blvligQteUtilStock;


    /**
     * numero de lot
     */
    private String blvligLot;


    /**
     * numero de serie
     */
    private String blvligNumSerie;


    /**
     * code devise
     */
    private String blvligDevise;


    /**
     * prix unitaire
     */
    private Double blvligPu;


    /**
     * taux de remise
     */
    private Float blvligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double blvligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double blvligPuRem;


    /**
     * prix unitaire Ttc avant remise
     */
    private Double blvligPuTtc;


    /**
     * prix unitaire Ttc apres remise
     */
    private Double blvligPuRemTtc;


    /**
     * prix total ht
     */
    private Double blvligPt;


    /**
     * total taxe
     */
    private Double blvligTva;


    /**
     * total taxe complementaire
     */
    private Double blvligTc;


    /**
     * total ttc
     */
    private Double blvligTtc;


    /**
     * prix unitaire moyen pondere
     */
    private Double blvligPump;

    private Long blvId;


    /**
     * generique
     */
    private Integer blvligGenerique;


    /**
     * ordre des lignes
     */
    private Integer blvligOrdre;


    /**
     * descriptif complementaire
     */
    private String blvligComplement;

}
