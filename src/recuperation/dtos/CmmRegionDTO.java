package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmRegionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long regId;


    /**
     * date de creation
     */
    private LocalDateTime regDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime regDateModif;


    /**
     * utilisateur de creation
     */
    private Long regUserCreat;


    /**
     * utilisateur de modification
     */
    private Long regUserModif;


    /**
     * code region
     */
    private String regCode;


    /**
     * nom region en FR
     */
    private String regNomFr;


    /**
     * nom region en UK
     */
    private String regNomUk;


    /**
     * nom region en SP
     */
    private String regNomSp;


    /**
     * 1=inactif
     */
    private Integer regInactif;


    /**
     * id responsable
     */
    private Long regIdResponsable;


    /**
     * nom responsable
     */
    private String regNomResponsable;

}
