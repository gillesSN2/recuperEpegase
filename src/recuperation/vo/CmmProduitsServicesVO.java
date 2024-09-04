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
public class CmmProduitsServicesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "proserId can not null")
    private Long proserId;


    /**
     * code de service
     */
    private String proserCode;


    /**
     * nom du service en FR
     */
    private String proserNomFr;

    @NotNull(message = "proId can not null")
    private Long proId;

    @NotNull(message = "serId can not null")
    private Long serId;

}
