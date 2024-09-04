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
public class PrcFamillesParc2VO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "famprc2Id can not null")
    private Long famprc2Id;


    /**
     * date de creation
     */
    private LocalDateTime famprc2DateCreation;


    /**
     * date de modification
     */
    private LocalDateTime famprc2DateModif;


    /**
     * user de creation
     */
    private Long famprc2UserCreation;


    /**
     * user de modification
     */
    private Long famprc2UserModif;


    /**
     * code famille parc
     */
    private String famprc2Code;


    /**
     * libelle famille parc en FR
     */
    private String famprc2LibelleFr;


    /**
     * libelle famille parc en UK
     */
    private String famprc2LibelleUk;


    /**
     * libelle famille parc en SP
     */
    private String famprc2LibelleSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer famprc2Inactif;

    @NotNull(message = "famprc1Id can not null")
    private Long famprc1Id;

}
