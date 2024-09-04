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
public class UserFonctionnaliteDroitVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Boolean creation;

    private Boolean edition;

    private Boolean impression;

    private Boolean lecture;

    private Long structureId;

    private Boolean suppression;

    private Boolean transfertComptabilite;

    @NotNull(message = "fonctionnaliteCode can not null")
    private String fonctionnaliteCode;

    @NotNull(message = "utilisateurId can not null")
    private Long utilisateurId;

}
