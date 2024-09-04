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
public class UtilisateursModulesesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "utilisateurId can not null")
    private Long utilisateurId;

    @NotNull(message = "modulesesCode can not null")
    private String modulesesCode;

}
