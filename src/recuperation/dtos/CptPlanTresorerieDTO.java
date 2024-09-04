package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CptPlanTresorerieDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long treId;


    /**
     * date de creation
     */
    private LocalDateTime treDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime treDateModif;


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
    private String treAnnee;


    /**
     * code du budget
     */
    private String treCode;


    /**
     * libelle du budget en FR
     */
    private String treLibelleFr;


    /**
     * libelle du budget en UK
     */
    private String treLibelleUk;


    /**
     * libelle du budget en SP
     */
    private String treLibelleSp;


    /**
     * code projet
     */
    private String treProjet;


    /**
     * ordre des elements
     */
    private Integer treOrdre;


    /**
     * 0=encaissement 1=decaissement
     */
    private Integer treType;


    /**
     * 0=actif 1=inactif
     */
    private Integer treInactif;

    private Long execptId;


    /**
     * liste des users autorises
     */
    private String treIdUsers;


    /**
     * compte
     */
    private String treCompte;


    /**
     * libelle du compte
     */
    private String treLibelleCompte;

}
