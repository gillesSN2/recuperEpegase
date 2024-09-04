package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class MedNgapQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long ngaId;


    /**
     * code famille
     */
    private String ngaFamCode;


    /**
     * libelle FR
     */
    private String ngaFamLibelleFr;


    /**
     * libelle UK
     */
    private String ngaFamLibelleUk;


    /**
     * libelle SP
     */
    private String ngaFamLibelleSp;


    /**
     * code cms
     */
    private String ngaDetCode;


    /**
     * libelle FR
     */
    private String ngaDetLibelleFr;


    /**
     * libelle UK
     */
    private String ngaDetLibelleUk;


    /**
     * libelle SP
     */
    private String ngaDetLibelleSp;


    /**
     * 0=pricipal 1=secondaire
     */
    private Integer ngaDetType;

}
