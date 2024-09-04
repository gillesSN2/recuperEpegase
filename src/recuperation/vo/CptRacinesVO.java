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
public class CptRacinesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "racId can not null")
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
