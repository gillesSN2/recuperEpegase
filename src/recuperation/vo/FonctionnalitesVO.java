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
public class FonctionnalitesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "code can not null")
    private String code;

    @NotNull(message = "createdBy can not null")
    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    private String active;

    private String description;

    private String icon;

    private String libelle;

    @NotNull(message = "ordre can not null")
    private Integer ordre;

    private Long structureId;

    private String url;

    private String modulesCode;

}
