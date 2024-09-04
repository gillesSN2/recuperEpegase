package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmSecteurQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long secId;


    /**
     * dat de creation
     */
    private LocalDateTime secDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime secDateModif;


    /**
     * utilisateur de creation
     */
    private Long secUserCreat;


    /**
     * utilisateur de modification
     */
    private Long secUserModif;


    /**
     * code su secteur
     */
    private String secCode;


    /**
     * nom du secteur en FR
     */
    private String secNomFr;


    /**
     * nom du secteur en UK
     */
    private String secNomUk;


    /**
     * nom du secteur en SP
     */
    private String secNomSp;


    /**
     * 0=actif 1=inactif
     */
    private Integer secInactif;


    /**
     * % de repartition par rapport a la region
     */
    private Float secPourcentage;

    private Long regId;


    /**
     * id responsable
     */
    private Long secIdResponsable;


    /**
     * nom responsable
     */
    private String secNomResponsable;

}
