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
public class FamilleClientVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "createdBy can not null")
    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    @NotNull(message = "active can not null")
    private Boolean active;

    private String code;

    private String description;

    @NotNull(message = "exonarationDouane can not null")
    private Boolean exonarationDouane;

    @NotNull(message = "exonarationTaxe can not null")
    private Boolean exonarationTaxe;

    private String libelle;

}
