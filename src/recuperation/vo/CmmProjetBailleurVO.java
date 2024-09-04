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
public class CmmProjetBailleurVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "probaiId can not null")
    private Long probaiId;

    private String probaiNomBailleur;

    private Double probaiMontantOrigine;

    private String probaiDevise;

    private Float probaiCoefEuro;

    private Double parbaiMontantEuro;

    private Float probaiCoefPays;

    private Double probaiMontantPays;

    private Float probaiRepart;

    @NotNull(message = "proId can not null")
    private Long proId;

    @NotNull(message = "strId can not null")
    private Long strId;

}
