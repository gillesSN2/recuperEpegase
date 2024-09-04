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
public class CmmProduitsMclesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "promclId can not null")
    private Long promclId;


    /**
     * mot cle
     */
    private String promclMot;

    @NotNull(message = "proId can not null")
    private Long proId;

}
