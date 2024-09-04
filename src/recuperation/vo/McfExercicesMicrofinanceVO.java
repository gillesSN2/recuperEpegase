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
public class McfExercicesMicrofinanceVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "exemcfId can not null")
    private Long exemcfId;


    /**
     * date de creation
     */
    private LocalDateTime exemcfDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime exemcfDateModif;


    /**
     * date de cloture
     */
    private LocalDateTime exemcfDateCloture;


    /**
     * user de creation
     */
    private Long exemcfUserCreat;


    /**
     * user de cloture
     */
    private Long exemcfUserCloture;


    /**
     * user de modification
     */
    private Long exemcfUserModif;


    /**
     * date debut exercice
     */
    private LocalDate exemcfDateDebut;


    /**
     * date fin exercice
     */
    private LocalDate exemcfDateFin;


    /**
     * etat 0=en cours 1=cloture
     */
    private Integer exemcfEtat;

}
