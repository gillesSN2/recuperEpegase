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
public class MedPatientProtVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "patprtId can not null")
    private Long patprtId;


    /**
     * date de debut du protocole
     */
    private LocalDate patprtDateDebut;


    /**
     * date de fin du protocole
     */
    private LocalDate patptrDateFin;


    /**
     * code du protocole
     */
    private String patptrCode;


    /**
     * libelle du protocole
     */
    private String patptrLibelle;

    @NotNull(message = "patId can not null")
    private Long patId;

}
