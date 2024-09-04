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
public class CmmSecteurVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "secId can not null")
    private Long secId;


    /**
     * dat de creation
     */
    private LocalDateTime secDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime secDateModif;


    /**
     * utilisateur de creation
     */
    private Long secUserCreat;


    /**
     * utilisateur de modification
     */
    private Long secUserModif;


    /**
     * code su secteur
     */
    private String secCode;


    /**
     * nom du secteur en FR
     */
    private String secNomFr;


    /**
     * nom du secteur en UK
     */
    private String secNomUk;


    /**
     * nom du secteur en SP
     */
    private String secNomSp;


    /**
     * 0=actif 1=inactif
     */
    private Integer secInactif;


    /**
     * % de repartition par rapport a la region
     */
    private Float secPourcentage;

    @NotNull(message = "regId can not null")
    private Long regId;


    /**
     * id responsable
     */
    private Long secIdResponsable;


    /**
     * nom responsable
     */
    private String secNomResponsable;

}
