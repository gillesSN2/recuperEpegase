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
public class CmmProjetRubriqueVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "prorubId can not null")
    private Long prorubId;

    private String prorubCode;

    private String prorubLibelleFr;

    private String prorubLibelleUk;

    private String prorubLibelleSp;

    private Double prorubMontantOrigine;

    private String prorubDevise;

    private Float prorubCoefEuro;

    private Double prorubMontantEuro;

    private Float prorubCoefPays;

    private Double prorubMontantPays;

    private Double prorubTotalOrigine;

    private Double prorubTotalEuro;

    private Double prorubTotalPays;

    private Double prorubSoldeOrigine;

    private Double prorubSoldeEuro;

    private Double prorubSoldePays;

    private Integer prorubType;

    @NotNull(message = "proposId can not null")
    private Long proposId;

}
