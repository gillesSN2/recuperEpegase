package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class VteFormulesVentesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "forvteId can not null")
    private Long forvteId;


    /**
     * date de creation
     */
    private LocalDateTime forvteDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime forvteDateModif;


    /**
     * user de creation
     */
    private Long forvteUserCreation;


    /**
     * user de modification
     */
    private Long forvteUserModif;


    /**
     * libelle de la formule FR
     */
    private String forvteLibelleFr;


    /**
     * libelle de la formule UK
     */
    private String forvteLibelleUk;


    /**
     * libelle de la formule SP
     */
    private String forvteLibelleSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer forvteInactif;

    @NotNull(message = "exevteId can not null")
    private Long exevteId;

}
