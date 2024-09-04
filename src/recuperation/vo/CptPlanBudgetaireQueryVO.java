package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CptPlanBudgetaireQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long plbId;


    /**
     * date de creation
     */
    private LocalDateTime plbDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime plbDateModif;


    /**
     * utilisateur de creation
     */
    private Long plbUserCreat;


    /**
     * utilisateur de modification
     */
    private Long plbUserModif;


    /**
     * Annee du budget
     */
    private String plbAnnee;


    /**
     * 1=vente 2=achat 3=production 4=frais generaux 5=investissement 6=tva 7=frais personnel
     */
    private String plbNature;


    /**
     * code du budget
     */
    private String plbCode;


    /**
     * libelle du budget en FR
     */
    private String plbLibelleFr;


    /**
     * libelle du budget en UK
     */
    private String plbLibelleUk;


    /**
     * libelle du budget en SP
     */
    private String plbLibelleSp;


    /**
     * activite
     */
    private String plbActivite;


    /**
     * odre des elements
     */
    private Integer plbOrdre;


    /**
     * 0=budget bloquant 1=budget non bloquant
     */
    private Integer plbBloque;


    /**
     * 0=actif 1=inactif
     */
    private Integer plbInactif;

    private Long execptId;

}
