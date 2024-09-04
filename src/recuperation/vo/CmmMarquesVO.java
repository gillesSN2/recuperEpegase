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
public class CmmMarquesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "marId can not null")
    private Long marId;


    /**
     * date de creation
     */
    private LocalDateTime marDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime marDateModif;


    /**
     * user de creation
     */
    private Long marUserCreation;


    /**
     * user de modification
     */
    private Long marUserModif;


    /**
     * libelle FR
     */
    private String marLibelleFr;


    /**
     * libelle UK
     */
    private String marLibelleUk;


    /**
     * libelle SP
     */
    private String marLibelleSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer marInactif;


    /**
     * photos du produits
     */
    private String marPhoto;


    /**
     * fichier pdf
     */
    private String marPdf;

}
