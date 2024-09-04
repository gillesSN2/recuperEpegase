package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmProductionLigneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long ligId;


    /**
     * date de creation
     */
    private LocalDateTime ligDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime ligDateModif;


    /**
     * utilisateur de creation
     */
    private Long ligUserCreat;


    /**
     * utilisateur de modification
     */
    private Long ligUserModif;


    /**
     * code departement
     */
    private String ligCode;


    /**
     * nom departement en FR
     */
    private String ligNomFr;


    /**
     * nom departement en UK
     */
    private String ligNomUk;


    /**
     * nom departement en SP
     */
    private String ligNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer ligInactif;


    /**
     * % de repartition par rapport au site
     */
    private Float ligPourcentage;

    private Long sitId;

}
