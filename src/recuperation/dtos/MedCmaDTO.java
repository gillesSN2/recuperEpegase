package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class MedCmaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cmaId;


    /**
     * code cma
     */
    private String cmaCode;


    /**
     * libelle cma FR
     */
    private String cmaLibelleFr;


    /**
     * libelle cma UK
     */
    private String cmaLibelleUk;


    /**
     * libelle cma UK
     */
    private String cmaLibelleSp;


    /**
     * cma
     */
    private Integer cmaCma;


    /**
     * cmas
     */
    private Integer cmaCmas;


    /**
     * cmasnt
     */
    private Integer cmaCmasnt;

}
