package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
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
public class CptAmortissementsRegVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "amoregId can not null")
    private Long amoregId;


    /**
     * date de creation
     */
    private LocalDateTime amoregDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime amoregDateModif;


    /**
     * utilisateur de creation
     */
    private Long amoregUserCreat;


    /**
     * utilisateur de modification
     */
    private Long amoregUserModif;


    /**
     * date de reglement
     */
    private LocalDate amoregDateReg;


    /**
     * montant payee par le client
     */
    private Double amoregMontant;

    @NotNull(message = "amoId can not null")
    private Long amoId;

}
