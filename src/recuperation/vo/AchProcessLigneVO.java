package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class AchProcessLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "procesligId can not null")
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

    @NotNull(message = "procesId can not null")
    private Long procesId;

}
