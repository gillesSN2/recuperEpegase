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
public class MedNgapVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ngaId can not null")
    private Long ngaId;


    /**
     * code famille
     */
    private String ngaFamCode;


    /**
     * libelle FR
     */
    private String ngaFamLibelleFr;


    /**
     * libelle UK
     */
    private String ngaFamLibelleUk;


    /**
     * libelle SP
     */
    private String ngaFamLibelleSp;


    /**
     * code cms
     */
    private String ngaDetCode;


    /**
     * libelle FR
     */
    private String ngaDetLibelleFr;


    /**
     * libelle UK
     */
    private String ngaDetLibelleUk;


    /**
     * libelle SP
     */
    private String ngaDetLibelleSp;


    /**
     * 0=pricipal 1=secondaire
     */
    private Integer ngaDetType;

}
