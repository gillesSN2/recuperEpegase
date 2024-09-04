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
public class AchExercicesAchatsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "exeachId can not null")
    private Long exeachId;


    /**
     * date de creation
     */
    private LocalDateTime exeachDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime exeachDateModif;


    /**
     * date de cloture
     */
    private LocalDateTime exeachDateCloture;


    /**
     * user de creation
     */
    private Long exeachUserCreat;


    /**
     * user de cloture
     */
    private Long exeachUserCloture;


    /**
     * user de modification
     */
    private Long exeachUserModif;


    /**
     * date debut exercice
     */
    private LocalDate exeachDateDebut;


    /**
     * date fin exercice
     */
    private LocalDate exeachDateFin;


    /**
     * etat 0=en cours 1=cloture
     */
    private Integer exeachEtat;

}
