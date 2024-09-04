package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class PayFeuilleCalculRubriqueQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long feurubId;


    /**
     * rubrique active
     */
    private Boolean feurubActif;


    /**
     * code rubrique
     */
    private String feurubCode;


    /**
     * colonne A active
     */
    private Boolean feurubCola;


    /**
     * colonne B active
     */
    private Boolean feurubColb;


    /**
     * colonne C active
     */
    private Boolean feurubColc;


    /**
     * colonne D active
     */
    private Boolean feurubCold;


    /**
     * colonne E active
     */
    private Boolean feurubCole;


    /**
     * colonne A raz
     */
    private Boolean feurubColaRaz;


    /**
     * colonne B raz
     */
    private Boolean feurubColbRaz;


    /**
     * colonne C raz
     */
    private Boolean feurubColcRaz;


    /**
     * colonne D raz
     */
    private Boolean feurubColdRaz;


    /**
     * colonne E raz
     */
    private Boolean feurubColeRaz;


    /**
     * compte
     */
    private String feurubCompte;

    private Long feuId;

    private Long plpId;


    /**
     * variable salarie colonne A
     */
    private Boolean feurubVariablea;


    /**
     * variable salarie colonne B
     */
    private Boolean feurubVariableb;


    /**
     * variable salarie colonne C
     */
    private Boolean feurubVariablec;


    /**
     * variable salarie colonne D
     */
    private Boolean feurubVariabled;


    /**
     * variable salarie colonne E
     */
    private Boolean feurubVariablee;

}
