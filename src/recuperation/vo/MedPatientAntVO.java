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
public class MedPatientAntVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "patantId can not null")
    private Long patantId;


    /**
     * date de creation
     */
    private LocalDate patantDateCreat;


    /**
     * date de modification
     */
    private LocalDate patantDateModif;


    /**
     * user de creation
     */
    private Long patantUserCreat;


    /**
     * user de modification
     */
    private Long patantUserModif;


    /**
     * nom du medecin qui note
     */
    private String patantMedecin;


    /**
     * date de l antecedent
     */
    private LocalDate patantDate;


    /**
     * code famille antecedent
     */
    private String patantCode;


    /**
     * famille antecedent
     */
    private String patantFamille;


    /**
     * etat antecedent
     */
    private String patantEtat;


    /**
     * observation antecedent
     */
    private String patantObservation;


    /**
     * numero consultation general
     */
    private String patantNumConsultGene;


    /**
     * numero consultation specialisee
     */
    private String patantNumConsultSpe;

    @NotNull(message = "patId can not null")
    private Long patId;

}
