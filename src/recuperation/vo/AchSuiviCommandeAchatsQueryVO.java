package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AchSuiviCommandeAchatsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long suiachId;


    /**
     * date de creation
     */
    private LocalDateTime suiachDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime suiachDateModif;


    /**
     * utilisateur de creation
     */
    private Long suiachUserCreation;


    /**
     * utilisateur de modification
     */
    private Long suiachUserModif;


    /**
     * code suivi
     */
    private String suiachCode;


    /**
     * nom du suivi en FR
     */
    private String suiachLibelleFr;


    /**
     * nom du suivi en UK
     */
    private String suiachLibelleUk;


    /**
     * nom du suivi en SP
     */
    private String suiachLibelleSp;


    /**
     * 0=inactif 1=actif
     */
    private Boolean suiachAerien;


    /**
     * 0=inactif 1=actif
     */
    private Boolean suiachMaritime;


    /**
     * 0=inactif 1=actif
     */
    private Boolean suiachExpress;


    /**
     * 0=inactif 1=actif
     */
    private Boolean suiachRoute;


    /**
     * 0=inactif 1=actif
     */
    private Boolean suiachAutreTransit;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer suiachInactif;

    private Long exeachId;

}
