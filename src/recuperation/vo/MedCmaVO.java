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
public class MedCmaVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "cmaId can not null")
    private Long cmaId;


    /**
     * code cma
     */
    private String cmaCode;


    /**
     * libelle cma FR
     */
    private String cmaLibelleFr;


    /**
     * libelle cma UK
     */
    private String cmaLibelleUk;


    /**
     * libelle cma UK
     */
    private String cmaLibelleSp;


    /**
     * cma
     */
    private Integer cmaCma;


    /**
     * cmas
     */
    private Integer cmaCmas;


    /**
     * cmasnt
     */
    private Integer cmaCmasnt;

}
