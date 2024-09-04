package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class CmmSiteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "sitId can not null")
    private Long sitId;


    /**
     * date de creation
     */
    private LocalDateTime sitDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime sitDateModif;


    /**
     * utilisateur de creation
     */
    private Long sitUserCreat;


    /**
     * utilisateur de modification
     */
    private Long sitUserModif;


    /**
     * code du site
     */
    private String sitCode;


    /**
     * nom du site en FR
     */
    private String sitNomFr;


    /**
     * nom du site en UK
     */
    private String sitNomUk;


    /**
     * nom du site en SP
     */
    private String sitNomSp;


    /**
     * 1=inactif
     */
    private Integer sitInactif;


    /**
     * id responsable
     */
    private Long sitIdResponsable;


    /**
     * nom responsable
     */
    private String sitNomResponsable;

}
