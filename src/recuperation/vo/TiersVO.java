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
public class TiersVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "tieid can not null")
    private Long tieid;

    @NotNull(message = "createdBy can not null")
    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    @NotNull(message = "id can not null")
    private Long id;

    private String tietecAdresse;

    private Integer tietecEtat;

    private String tietecLogin;

    private String tietecPs;

    private String tietecService;

    private Integer tietecType;

    @NotNull(message = "tieId can not null")
    private Long tieId;

}
