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
public class CmmDepartementVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "depId can not null")
    private Long depId;


    /**
     * date de creation
     */
    private LocalDateTime depDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime depDateModif;


    /**
     * utilisateur de creation
     */
    private Long depUserCreat;


    /**
     * utilisateur de modification
     */
    private Long depUserModif;


    /**
     * code departement
     */
    private String depCode;


    /**
     * nom departement en FR
     */
    private String depNomFr;


    /**
     * nom departement en UK
     */
    private String depNomUk;


    /**
     * nom departement en SP
     */
    private String depNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer depInactif;


    /**
     * % de repartition par rapport au site
     */
    private Float depPourcentage;

    @NotNull(message = "sitId can not null")
    private Long sitId;


    /**
     * id responsable
     */
    private Long depIdResponsable;


    /**
     * nom responsable
     */
    private String depNomResponsable;

}
