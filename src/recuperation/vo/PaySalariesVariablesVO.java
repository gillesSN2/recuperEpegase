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
public class PaySalariesVariablesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "salvarId can not null")
    private Long salvarId;


    /**
     * code rubrique
     */
    private String salvarCode;


    /**
     * periode MM:AAAA ou JJ:MM:AAAA
     */
    private String salvarPeriode;


    /**
     * valeur colonne A
     */
    private Double salvarValeurCola;


    /**
     * valeur colonne B
     */
    private Double salvarValeurColb;


    /**
     * valeur colonne C
     */
    private Double salvarValeurColc;


    /**
     * valeur colonne D
     */
    private Double salvarValeurCold;


    /**
     * valeur colonne E
     */
    private Double salvarValeurCole;

    @NotNull(message = "plpId can not null")
    private Long plpId;

    @NotNull(message = "salId can not null")
    private Long salId;


    /**
     * variable salarie colonne A
     */
    private Boolean salvarVariablea;


    /**
     * variable salarie colonne B
     */
    private Boolean salvarVariableb;


    /**
     * variable salarie colonne C
     */
    private Boolean salvarVariablec;


    /**
     * variable salarie colonne D
     */
    private Boolean salvarVariabled;


    /**
     * variable salarie colonne E
     */
    private Boolean salvarVariablee;


    /**
     * numero contrat
     */
    private String salvarContrat;


    /**
     * feuille de calcul
     */
    private String salvarFeuille;

}
