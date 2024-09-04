package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class MedCimDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cimId;


    /**
     * code cmd
     */
    private String cimCodeCmd;


    /**
     * libelle cmd
     */
    private String cimLibCmd;


    /**
     * code cim
     */
    private String cimCode;


    /**
     * libelle cim FR
     */
    private String cimLibelleFr;


    /**
     * libelle cim UK
     */
    private String cimLibelleUk;


    /**
     * libelle cim SP
     */
    private String cimLibelleSp;

}
