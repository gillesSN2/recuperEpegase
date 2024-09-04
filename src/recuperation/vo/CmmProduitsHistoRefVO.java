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
public class CmmProduitsHistoRefVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "prohrfId can not null")
    private Long prohrfId;


    /**
     * reference founisseur
     */
    private String prohrfReference;


    /**
     * date de debut d utilisation
     */
    private LocalDate prohrfDateDebut;


    /**
     * date de fin d utilisation
     */
    private LocalDate prohrfDateFin;


    /**
     * observations
     */
    private String prohrfObs;

    @NotNull(message = "proId can not null")
    private Long proId;

}
