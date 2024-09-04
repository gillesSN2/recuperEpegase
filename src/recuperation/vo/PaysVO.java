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
public class PaysVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "code can not null")
    private String code;

    @NotNull(message = "createdBy can not null")
    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    private String devise;

    private String drapeau;

    private String fiscalite;

    @NotNull(message = "gestion can not null")
    private Integer gestion;

    private String indicatif;

    private String iso;

    private String langue;

    private String nationnalite;

    private String nom;

    private String zone;

}
