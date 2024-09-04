package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmServiceQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long serId;


    /**
     * date de creation
     */
    private LocalDateTime serDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime serDateModif;


    /**
     * utilisateur de modification
     */
    private Long serUserCreat;


    /**
     * utilisateur de creation
     */
    private Long serUserModif;


    /**
     * code de service
     */
    private String serCode;


    /**
     * nom du service en FR
     */
    private String serNomFr;


    /**
     * nom du service en UK
     */
    private String serNomUk;


    /**
     * nom du service en SP
     */
    private String serNomSp;


    /**
     * 0=actif 1=inactif
     */
    private Integer serInactif;


    /**
     * % de repartition par rapport au departement
     */
    private Float serPourcentage;

    private Long sitId;

    private Long depId;


    /**
     * id responsable
     */
    private Long serIdResponsable;


    /**
     * nom responsable
     */
    private String serNomResponsable;

}
