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
public class PayFeuilleCalculFormuleVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "feurubforId can not null")
    private Long feurubforId;


    /**
     * code rubrique
     */
    private String feurubforCode;


    /**
     * colonne A,B,C,D ou E
     */
    private String feurubforColonne;


    /**
     * formule
     */
    private String feurubforFormule;

    @NotNull(message = "feurubId can not null")
    private Long feurubId;

    private Long feuId;

}
