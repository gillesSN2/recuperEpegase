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
public class CmmMetiersVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "metId can not null")
    private Long metId;


    /**
     * date de creation
     */
    private LocalDateTime metDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime metDateModif;


    /**
     * utilisateur de creation
     */
    private Long metUserCreat;


    /**
     * utilisateur de modification
     */
    private Long metUserModif;


    /**
     * nom activite en FR
     */
    private String metNomFr;


    /**
     * nom activite en UK
     */
    private String metNomUk;


    /**
     * nom activite en SP
     */
    private String metNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer metInactif;


    /**
     * 0=personne physique 1=personne morale
     */
    private Integer metType;

}
