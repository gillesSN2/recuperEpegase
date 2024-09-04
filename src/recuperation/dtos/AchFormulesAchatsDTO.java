package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AchFormulesAchatsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long forachId;


    /**
     * date de creation
     */
    private LocalDateTime forachDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime forachDateModif;


    /**
     * user de creation
     */
    private Long forachUserCreation;


    /**
     * user de modification
     */
    private Long forachUserModif;


    /**
     * libelle FR
     */
    private String forachLibelleFr;


    /**
     * libelle UK
     */
    private String forachLibelleUk;


    /**
     * libelle SP
     */
    private String forachLibelleSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer forachInactif;

    private Long exeachId;

}
