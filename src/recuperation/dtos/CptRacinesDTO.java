package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CptRacinesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long racId;


    /**
     * code racine
     */
    private String racCode;


    /**
     * libelle FR
     */
    private String racLibelleFr;


    /**
     * libelle UK
     */
    private String racLibelleUk;


    /**
     * libelle SP
     */
    private String racLibelleSp;


    /**
     * nature racine
     */
    private String racNature;


    /**
     * code racine
     */
    private String racCodenature;


    /**
     * taux de taxe
     */
    private Float racTauxTaxe;


    /**
     * 0=pas dernier niveau 1=dernier niveau
     */
    private String racUtil;

}
