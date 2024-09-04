package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmDepartementDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long depId;


    /**
     * date de creation
     */
    private LocalDateTime depDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime depDateModif;


    /**
     * utilisateur de creation
     */
    private Long depUserCreat;


    /**
     * utilisateur de modification
     */
    private Long depUserModif;


    /**
     * code departement
     */
    private String depCode;


    /**
     * nom departement en FR
     */
    private String depNomFr;


    /**
     * nom departement en UK
     */
    private String depNomUk;


    /**
     * nom departement en SP
     */
    private String depNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer depInactif;


    /**
     * % de repartition par rapport au site
     */
    private Float depPourcentage;

    private Long sitId;


    /**
     * id responsable
     */
    private Long depIdResponsable;


    /**
     * nom responsable
     */
    private String depNomResponsable;

}
