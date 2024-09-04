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
public class MedConventionMedicalVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "cvnId can not null")
    private Long cvnId;


    /**
     * date de creation
     */
    private LocalDateTime cvnDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime cvnDateModif;


    /**
     * user de creation
     */
    private Long cvnUserCreat;


    /**
     * user de modification
     */
    private Long cvnUserModif;


    /**
     * type (lettre, produit...)
     */
    private String cvnType;


    /**
     * code lettre
     */
    private String cvnLettre;


    /**
     * libelle
     */
    private String cvnLibelle;


    /**
     * valeur de la lettre
     */
    private Double cvnValeur;

    @NotNull(message = "exemedId can not null")
    private Long exemedId;

    @NotNull(message = "tieId can not null")
    private Long tieId;

    private Long exevteId;

}
