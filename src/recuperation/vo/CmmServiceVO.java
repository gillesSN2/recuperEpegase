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
public class CmmServiceVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "serId can not null")
    private Long serId;


    /**
     * date de creation
     */
    private LocalDateTime serDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime serDateModif;


    /**
     * utilisateur de modification
     */
    private Long serUserCreat;


    /**
     * utilisateur de creation
     */
    private Long serUserModif;


    /**
     * code de service
     */
    private String serCode;


    /**
     * nom du service en FR
     */
    private String serNomFr;


    /**
     * nom du service en UK
     */
    private String serNomUk;


    /**
     * nom du service en SP
     */
    private String serNomSp;


    /**
     * 0=actif 1=inactif
     */
    private Integer serInactif;


    /**
     * % de repartition par rapport au departement
     */
    private Float serPourcentage;

    @NotNull(message = "sitId can not null")
    private Long sitId;

    @NotNull(message = "depId can not null")
    private Long depId;


    /**
     * id responsable
     */
    private Long serIdResponsable;


    /**
     * nom responsable
     */
    private String serNomResponsable;

}
