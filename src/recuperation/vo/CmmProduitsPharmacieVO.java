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
public class CmmProduitsPharmacieVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "prophaId can not null")
    private Long prophaId;


    /**
     * forme therapeutique
     */
    private String prophaTherapeutique;


    /**
     * forme gelenique
     */
    private String prophaGalenique;


    /**
     * formule chimique ou dci
     */
    private String prophaFormule;


    /**
     * position
     */
    private String prophaPosition;


    /**
     * tableau
     */
    private String prophaTableau;


    /**
     * shp
     */
    private String prophaShp;


    /**
     * specialite mere
     */
    private String prophaSpecialite;


    /**
     * dosage
     */
    private String prophaDosage;


    /**
     * nom unite
     */
    private String prophaUnite;


    /**
     * nb unites de prise
     */
    private String prophaPrise;


    /**
     * marche
     */
    private String prophaMarche;


    /**
     * origine
     */
    private String prophaOrigine;


    /**
     * posologie
     */
    private String prophaPosologie;


    /**
     * observation
     */
    private String prophaObservations;


    /**
     * laboratoire
     */
    private String prophaLaboratoire;

    @NotNull(message = "proId can not null")
    private Long proId;

}
