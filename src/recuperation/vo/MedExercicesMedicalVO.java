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
public class MedExercicesMedicalVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "exemedId can not null")
    private Long exemedId;


    /**
     * date de creation de l exercice
     */
    private LocalDate exemedDateCreat;


    /**
     * date de modification de l exercice
     */
    private LocalDate exemedDateModif;


    /**
     * date de cloture de l exercice
     */
    private LocalDate exemedDateCloture;


    /**
     * utilisateur de creation de l exericce
     */
    private Long exemedUserCreat;


    /**
     * utilisateur qui a fait la cloture
     */
    private Long exemedUserCloture;


    /**
     * utilisateur de modification de l exercice
     */
    private Long exemedUserModif;


    /**
     * date de debut de l exercice
     */
    private LocalDate exemedDateDebut;


    /**
     * date de fin de l exercice
     */
    private LocalDate exemedDateFin;


    /**
     * 0=exercice en cours 1=exercice cloture
     */
    private Integer exemedEtat;

}
