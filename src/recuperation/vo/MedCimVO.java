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
public class MedCimVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "cimId can not null")
    private Long cimId;


    /**
     * code cmd
     */
    private String cimCodeCmd;


    /**
     * libelle cmd
     */
    private String cimLibCmd;


    /**
     * code cim
     */
    private String cimCode;


    /**
     * libelle cim FR
     */
    private String cimLibelleFr;


    /**
     * libelle cim UK
     */
    private String cimLibelleUk;


    /**
     * libelle cim SP
     */
    private String cimLibelleSp;

}
