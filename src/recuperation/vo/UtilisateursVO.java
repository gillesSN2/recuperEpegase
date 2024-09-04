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
public class UtilisateursVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "createdBy can not null")
    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    @NotNull(message = "activated can not null")
    private Boolean activated;

    private String activationKey;

    private String civilite;

    private String email;

    private String fonction;

    private String imageUrl;

    private String langKey;

    @NotNull(message = "login can not null")
    private String login;

    private String nom;

    @NotNull(message = "passwordHash can not null")
    private String passwordHash;

    private String prenom;

    private LocalDateTime resetDate;

    private String resetKey;

    private Long structureId;

    private Long groupesId;

}
