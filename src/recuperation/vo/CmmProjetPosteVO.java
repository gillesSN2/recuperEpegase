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
public class CmmProjetPosteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "proposId can not null")
    private Long proposId;

    private String proposCode;

    private String proposLibelleFr;

    private String proposLibelleUk;

    private String proposLibelleSp;

    @NotNull(message = "proId can not null")
    private Long proId;

}
