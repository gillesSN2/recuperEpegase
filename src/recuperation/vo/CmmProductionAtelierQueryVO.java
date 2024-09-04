package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmProductionAtelierQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long ateId;


    /**
     * date de creation
     */
    private LocalDateTime ateDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime ateDateModif;


    /**
     * utilisateur de modification
     */
    private Long ateUserCreat;


    /**
     * utilisateur de creation
     */
    private Long ateUserModif;


    /**
     * code de service
     */
    private String ateCode;


    /**
     * nom du service en FR
     */
    private String ateNomFr;


    /**
     * nom du service en UK
     */
    private String ateNomUk;


    /**
     * nom du service en SP
     */
    private String ateNomSp;


    /**
     * 0=actif 1=inactif
     */
    private Integer ateInactif;


    /**
     * % de repartition par rapport au departement
     */
    private Float atePourcentage;

    private Long sitId;

    private Long ligId;

}
