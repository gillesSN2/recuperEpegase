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
public class PrcFamillesParc1VO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "famprc1Id can not null")
    private Long famprc1Id;


    /**
     * date de creation
     */
    private LocalDateTime famprc1DateCreation;


    /**
     * date de modification
     */
    private LocalDateTime famprc1DateModif;


    /**
     * user de creation
     */
    private Long famprc1UserCreation;


    /**
     * user de modification
     */
    private Long famprc1UserModif;


    /**
     * suivant code xml
     */
    private Integer famprc1Nature;


    /**
     * libelle nature
     */
    private String famprc1LibNature;


    /**
     * code famille parc
     */
    private String famprc1Code;


    /**
     * libelle famille parc en FR
     */
    private String famprc1LibelleFr;


    /**
     * libelle famille parc en UK
     */
    private String famprc1LibelleUk;


    /**
     * libelle famille parc en SP
     */
    private String famprc1LibelleSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer famprc1Inactif;

}
