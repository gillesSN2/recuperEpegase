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
public class MedProtocoleVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "prtId can not null")
    private Long prtId;


    /**
     * user de creation
     */
    private Long prtUserCreat;


    /**
     * user de modification
     */
    private Long prtUserModif;


    /**
     * dat de ceration
     */
    private LocalDateTime prtDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime prtDateModif;


    /**
     * code du protocole
     */
    private String prtCode;


    /**
     * libelle du protocole
     */
    private String prtLibelle;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer prtInactif;

    @NotNull(message = "exemedId can not null")
    private Long exemedId;

    private Long exevteId;

}
