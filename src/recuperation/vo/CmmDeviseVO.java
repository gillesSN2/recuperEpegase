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
public class CmmDeviseVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "devId can not null")
    private Integer devId;


    /**
     * code devise
     */
    private String devCode;


    /**
     * libelle devise
     */
    private String devLibelle;


    /**
     * format devise
     */
    private String devFormat;


    /**
     * taux 1
     */
    private Float devTaux1;


    /**
     * taux 2
     */
    private Float devTaux2;

    private Long strId;

}
