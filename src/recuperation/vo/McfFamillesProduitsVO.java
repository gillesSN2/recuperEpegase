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
public class McfFamillesProduitsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "fammcfI can not null")
    private Long fammcfI;

    private LocalDate fammcfDateCreation;

    private LocalDate fammcfDateModif;

    private Long fammcfUserCreation;

    private Long fammcfUserModif;

    private String fammcfCode;

    private String fammcfLibelleFr;

    private String fammcfLibelleUk;

    private String fammcfLibelleSp;

    private String fammcfTaxe;

    private String fammcfCompteLocal;

    private String fammcfCompteZone;

    private String fammcfCompteExterieur;

    private Integer fammcfNature;

    private String fammcfLibNature;

    private Integer fammcfInactif;

    @NotNull(message = "exemcfId can not null")
    private Long exemcfId;

}
