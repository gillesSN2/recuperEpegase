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
public class AchTaxesAchatsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "taxachId can not null")
    private Long taxachId;


    /**
     * date de creation
     */
    private LocalDateTime taxachDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime taxachDateModif;


    /**
     * utilisateur de creation
     */
    private Long taxachUserCreation;


    /**
     * utilisateur de creation
     */
    private Long taxachUserModif;


    /**
     * code de la taxe
     */
    private String tacachCode;


    /**
     * nom de la taxe en FR
     */
    private String taxachLibelleFr;


    /**
     * nom de la taxe en UK
     */
    private String taxachLibelleUk;


    /**
     * nom de la taxe en SP
     */
    private String taxachLibelleSp;


    /**
     * taux de la taxe
     */
    private Float taxachTaux;


    /**
     * numero de compte
     */
    private String taxachCompte;


    /**
     * 0=tva sur bien 1=tva sur prestation
     */
    private Integer taxachType;


    /**
     * 0=sans timbre sur achat 1=timbre achat paye par fournisseur 2=timbre achat paye par societe
     */
    private Integer taxachTimbre;


    /**
     * 0=sans taxe complementaire 1=avec taxe complementaire 2=avec taxe egalisation
     */
    private Integer taxachTc;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer taxachInactif;

    @NotNull(message = "exeachId can not null")
    private Long exeachId;

}
