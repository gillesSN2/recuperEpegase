package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

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
public class EduExercicesEducationVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "exeeduId can not null")
    private Long exeeduId;


    /**
     * date de creation de l exercice
     */
    private LocalDate exeeduDateCreat;


    /**
     * date de modification de l exercice
     */
    private LocalDate exeeduDateModif;


    /**
     * date de cloture de l exercice
     */
    private LocalDate exeeduDateCloture;


    /**
     * utilisateur de creation de l exericce
     */
    private Long exeeduUserCreat;


    /**
     * utilisateur qui a fait la cloture
     */
    private Long exeeduUserCloture;


    /**
     * utilisateur de modification de l exercice
     */
    private Long exeeduUserModif;


    /**
     * date de debut de l exercice
     */
    private LocalDate exeeduDateDebut;


    /**
     * date de fin de l exercice
     */
    private LocalDate exeeduDateFin;


    /**
     * 0=exercice en cours 1=exercice cloture
     */
    private Integer exeeduEtat;

}
