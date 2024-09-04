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
public class MedPathologieVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "phlId can not null")
    private Long phlId;


    /**
     * user de creation
     */
    private Long phlUserCreat;


    /**
     * user de modification
     */
    private Long phlUserModif;


    /**
     * dat de ceration
     */
    private LocalDateTime phlDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime phlDateModif;


    /**
     * code du protocole
     */
    private String phlCode;


    /**
     * libelle du protocole
     */
    private String phlLibelle;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer phlInactif;

    @NotNull(message = "exemedId can not null")
    private Long exemedId;

    private Long exevteId;

}
