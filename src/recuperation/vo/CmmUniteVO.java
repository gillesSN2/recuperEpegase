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
public class CmmUniteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "uniId can not null")
    private Long uniId;


    /**
     * date de creation
     */
    private LocalDateTime uniDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime uniDateModif;


    /**
     * user de creation
     */
    private Long uniUserCreation;


    /**
     * user de modification
     */
    private Long uniUserModif;


    /**
     * libelle unite
     */
    private String uniLibelle;

    private Integer uniEchelle;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer uniInactif;

}
