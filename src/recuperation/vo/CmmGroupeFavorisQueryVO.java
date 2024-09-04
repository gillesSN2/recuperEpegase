package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmGroupeFavorisQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long grpfavId;


    /**
     * 0=repertoire
     */
    private Integer grpfavNature;


    /**
     * nom du repertoire
     */
    private String grpfavRepertoire;


    /**
     * 0=sans acces 1=avec acces
     */
    private Boolean grpfavAcces;


    /**
     * 0=sans ajout 1=avec ajout
     */
    private Boolean grpfavAjout;


    /**
     * 0=sans modif 1=avec modif
     */
    private Boolean grpfavModif;


    /**
     * 0=sans suppression 1=avec suupression
     */
    private Boolean grpfacSupp;

    private Long grpId;

}
