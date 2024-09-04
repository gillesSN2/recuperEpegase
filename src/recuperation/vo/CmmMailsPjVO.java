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
public class CmmMailsPjVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "maipjId can not null")
    private Long maipjId;


    /**
     * chemin acces a la pj
     */
    private String malpjAcces;

    @NotNull(message = "maiId can not null")
    private Long maiId;

}
