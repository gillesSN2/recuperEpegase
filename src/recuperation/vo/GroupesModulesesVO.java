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
public class GroupesModulesesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "groupesId can not null")
    private Long groupesId;

    @NotNull(message = "modulesesCode can not null")
    private String modulesesCode;

}
