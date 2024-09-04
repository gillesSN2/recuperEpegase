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
public class MedCmdVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "cmdId can not null")
    private Long cmdId;


    /**
     * code famille
     */
    private String cmdFamCode;


    /**
     * libelle FR
     */
    private String cmdFamLibelleFr;


    /**
     * libelle UK
     */
    private String cmdFamLibelleUk;


    /**
     * libelle SP
     */
    private String cmdFamLibelleSp;


    /**
     * code cms
     */
    private String cmdDetCode;


    /**
     * libelle FR
     */
    private String cmdDetLibelleFr;


    /**
     * libelle UK
     */
    private String cmdDetLibelleUk;


    /**
     * libelle SP
     */
    private String cmdDetLibelleSp;


    /**
     * 0=pricipal 1=secondaire
     */
    private Integer cmdDetType;

}
