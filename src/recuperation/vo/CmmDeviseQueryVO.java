package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmDeviseQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer devId;


    /**
     * code devise
     */
    private String devCode;


    /**
     * libelle devise
     */
    private String devLibelle;


    /**
     * format devise
     */
    private String devFormat;


    /**
     * taux 1
     */
    private Float devTaux1;


    /**
     * taux 2
     */
    private Float devTaux2;

    private Long strId;

}
