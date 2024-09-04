package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;

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
public class MedPatientContactVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "patconId can not null")
    private Long patconId;


    /**
     * civilite
     */
    private String patconCivilite;


    /**
     * qualite du contact
     */
    private String patconQualite;


    /**
     * nom du contact
     */
    private String patconNom;


    /**
     * prenom du contact
     */
    private String patconPrenom;


    /**
     * adresse du contact
     */
    private String patconAdresse;


    /**
     * telephone du bureau du contact
     */
    private String patconTelBur;


    /**
     * telephone du domicile du contact
     */
    private String patconTelDom;


    /**
     * cellulaire du contact
     */
    private String patconCel;


    /**
     * mail du contact
     */
    private String patconMail;


    /**
     * observations
     */
    private String patconObs;

    @NotNull(message = "patId can not null")
    private Long patId;

}
