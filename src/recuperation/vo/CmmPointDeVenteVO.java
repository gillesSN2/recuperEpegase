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
public class CmmPointDeVenteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "pdvId can not null")
    private Long pdvId;


    /**
     * date de creation
     */
    private LocalDateTime pdvDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime pdvDateModif;


    /**
     * utilisateur de modification
     */
    private Long pdvUserCreat;


    /**
     * utilisateur de creation
     */
    private Long pdvUserModif;


    /**
     * code de pdv
     */
    private String pdvCode;


    /**
     * nom du pdv en FR
     */
    private String pdvNomFr;


    /**
     * nom du pdv en UK
     */
    private String pdvNomUk;


    /**
     * nom du pdv en SP
     */
    private String pdvNomSp;


    /**
     * 0=actif 1=inactif
     */
    private Integer pdvInactif;


    /**
     * % de repartition par rapport au secteur
     */
    private Float pdvPourcentage;

    @NotNull(message = "regId can not null")
    private Long regId;

    @NotNull(message = "secId can not null")
    private Long secId;


    /**
     * id responsable
     */
    private Long pdvIdResponsable;


    /**
     * nom responsable
     */
    private String pdvNomResponsable;

}
