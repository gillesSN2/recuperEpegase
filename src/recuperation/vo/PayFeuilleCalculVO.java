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
public class PayFeuilleCalculVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "feuId can not null")
    private Long feuId;


    /**
     * date de creation
     */
    private LocalDateTime feuDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime feuDateModif;


    /**
     * utilisateur de creation
     */
    private Long feuUserCreat;


    /**
     * utilisateur de modification
     */
    private Long feuUserModif;


    /**
     * voir nature salarie xml
     */
    private String feuNature;


    /**
     * code feuille
     */
    private String feuCode;


    /**
     * libelle feuille en FR
     */
    private String feuLibelleFr;


    /**
     * libelle feuille en UK
     */
    private String feuLibelleUk;


    /**
     * libelle feuille en SP
     */
    private String feuLibelleSp;


    /**
     * modele
     */
    private String feuModele;


    /**
     * code journal
     */
    private String feuJournal;


    /**
     * compte od
     */
    private String feuCompte;


    /**
     * 0=calendrier si non nb jour de decalage
     */
    private Integer feuDecale;


    /**
     * 0=actif 1=inactif
     */
    private Integer feuInactif;

    @NotNull(message = "exepayId can not null")
    private Long exepayId;

}
