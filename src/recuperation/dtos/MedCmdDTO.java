package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class MedCmdDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cmdId;


    /**
     * code famille
     */
    private String cmdFamCode;


    /**
     * libelle FR
     */
    private String cmdFamLibelleFr;


    /**
     * libelle UK
     */
    private String cmdFamLibelleUk;


    /**
     * libelle SP
     */
    private String cmdFamLibelleSp;


    /**
     * code cms
     */
    private String cmdDetCode;


    /**
     * libelle FR
     */
    private String cmdDetLibelleFr;


    /**
     * libelle UK
     */
    private String cmdDetLibelleUk;


    /**
     * libelle SP
     */
    private String cmdDetLibelleSp;


    /**
     * 0=pricipal 1=secondaire
     */
    private Integer cmdDetType;

}
