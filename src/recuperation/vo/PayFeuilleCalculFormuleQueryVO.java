package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class PayFeuilleCalculFormuleQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long feurubforId;


    /**
     * code rubrique
     */
    private String feurubforCode;


    /**
     * colonne A,B,C,D ou E
     */
    private String feurubforColonne;


    /**
     * formule
     */
    private String feurubforFormule;

    private Long feurubId;

    private Long feuId;

}
