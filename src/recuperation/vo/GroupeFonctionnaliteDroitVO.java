package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;

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
public class GroupeFonctionnaliteDroitVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "codeFonctionnalite can not null")
    private String codeFonctionnalite;

    @NotNull(message = "idGroupe can not null")
    private Long idGroupe;

    private Boolean creation;

    private Boolean edition;

    private Boolean impression;

    private Boolean lecture;

    private Long structureId;

    private Boolean suppression;

    private Boolean transfertComptabilite;

}
