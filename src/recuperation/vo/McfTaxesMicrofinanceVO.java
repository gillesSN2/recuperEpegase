package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

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
public class McfTaxesMicrofinanceVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "taxmcfId can not null")
    private Long taxmcfId;

    private LocalDate taxmcfDateCreation;

    private LocalDate taxmcfDateModif;

    private Long taxmcfUserCreation;

    private Long taxmcfUserModif;

    private String tacmcfCode;

    private String taxmcfLibelleFr;

    private String taxmcfLibelleUk;

    private String taxmcfLibelleSp;

    private Float taxmcfTaux;

    private String taxmcfCompte;

    private Integer taxmcfType;

    private Integer taxmcfTimbre;

    private Integer taxmcfTc;

    private Integer taxmcfInactif;

    @NotNull(message = "exemcfId can not null")
    private Long exemcfId;

}
