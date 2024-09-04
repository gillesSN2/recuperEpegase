package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class AchProcessLigneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long procesligId;


    /**
     * 1=intrant 2=sous produits 3=dechets 4=taches
     */
    private Integer procesligType;


    /**
     * code produit
     */
    private String procesligCode;


    /**
     * libelle client
     */
    private String procesligLibClient;


    /**
     * libelle technique
     */
    private String procesligLibTech;


    /**
     * depot de stockage
     */
    private String procesligDepot;


    /**
     * unite
     */
    private String procesligUnite;


    /**
     * quantite
     */
    private Float procesligQte;


    /**
     * cout horaire agent
     */
    private Double procesligPrht;


    /**
     * prix vente horaire agent
     */
    private Double procesligPvht;


    /**
     * nombre de jour
     */
    private Integer procesligJj;


    /**
     * nombre heures
     */
    private Integer procesligHh;


    /**
     * nombre de minutes
     */
    private Integer procesligMm;


    /**
     * nombre de seconde
     */
    private Integer procesligSs;


    /**
     * flase = utilisee true = interchangeable
     */
    private Boolean procesligInterChange;


    /**
     * type de metier concerne
     */
    private String procesligMetier;


    /**
     * type de materiel concerne
     */
    private String procesligMateriel;

    private Long procesId;

}
