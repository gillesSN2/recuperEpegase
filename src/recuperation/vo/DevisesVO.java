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
public class DevisesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "code can not null")
    private String code;

    @NotNull(message = "createdBy can not null")
    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    private String format;

    private String libelle;

    private Long structureId;

    @NotNull(message = "taux1 can not null")
    private Float taux1;

    @NotNull(message = "taux2 can not null")
    private Float taux2;

}
