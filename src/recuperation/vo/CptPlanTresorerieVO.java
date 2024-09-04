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
public class CptPlanTresorerieVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "treId can not null")
    private Long treId;


    /**
     * date de creation
     */
    private LocalDateTime treDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime treDateModif;


    /**
     * utilisateur de creation
     */
    private Long plbUserCreat;


    /**
     * utilisateur de modification
     */
    private Long plbUserModif;


    /**
     * Annee du budget
     */
    private String treAnnee;


    /**
     * code du budget
     */
    private String treCode;


    /**
     * libelle du budget en FR
     */
    private String treLibelleFr;


    /**
     * libelle du budget en UK
     */
    private String treLibelleUk;


    /**
     * libelle du budget en SP
     */
    private String treLibelleSp;


    /**
     * code projet
     */
    private String treProjet;


    /**
     * ordre des elements
     */
    private Integer treOrdre;


    /**
     * 0=encaissement 1=decaissement
     */
    private Integer treType;


    /**
     * 0=actif 1=inactif
     */
    private Integer treInactif;

    @NotNull(message = "execptId can not null")
    private Long execptId;


    /**
     * liste des users autorises
     */
    private String treIdUsers;


    /**
     * compte
     */
    private String treCompte;


    /**
     * libelle du compte
     */
    private String treLibelleCompte;

}
