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
public class PrcExercicesParcVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "exeprcId can not null")
    private Long exeprcId;


    /**
     * date de creation
     */
    private LocalDateTime exeprcDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime exeprcDateModif;


    /**
     * date de cloture
     */
    private LocalDateTime exeprcDateCloture;


    /**
     * user de creation
     */
    private Long exeprcUserCreat;


    /**
     * user de cloture
     */
    private Long exeprcUserCloture;


    /**
     * user de modification
     */
    private Long exeprcUserModif;


    /**
     * date debut exercice
     */
    private LocalDate exeprcDateDebut;


    /**
     * date fin exercice
     */
    private LocalDate exeprcDateFin;


    /**
     * etat 0=en cours 1=cloture
     */
    private Integer exeprcEtat;

}
