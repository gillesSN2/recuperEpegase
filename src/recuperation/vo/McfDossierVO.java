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
public class McfDossierVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "dosId can not null")
    private Long dosId;

    private LocalDate dosDateDemande;

    private LocalDate dosDateReception;

    private LocalDate dosDateAcceptation;

    private LocalDate dosDateRefus;

    private String dosMotifRefus;

    private Integer dosType;

    private LocalDate dosDateCloture;

    private String dosMotifCloture;

    @NotNull(message = "tieId can not null")
    private Long tieId;

}
