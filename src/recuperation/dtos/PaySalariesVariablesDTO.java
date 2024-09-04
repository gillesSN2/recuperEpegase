package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class PaySalariesVariablesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
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

    private Long plpId;

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
