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
public class PrcMotifEntreeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "mtpId can not null")
    private Long mtpId;


    /**
     * user de creation
     */
    private Long mtpUserCreat;


    /**
     * user de modification
     */
    private Long mtpUserModif;


    /**
     * date de creation
     */
    private LocalDateTime mtpDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime mtpDateModif;


    /**
     * code du motif
     */
    private String mtpCode;


    /**
     * libelle du motif
     */
    private String mtpLibelle;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer mtpInactif;


    /**
     * code famille
     */
    private String mtpFamille;


    /**
     * type de motif
     */
    private String mtpType;

}
