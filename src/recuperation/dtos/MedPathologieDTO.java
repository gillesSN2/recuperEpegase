package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MedPathologieDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long phlId;


    /**
     * user de creation
     */
    private Long phlUserCreat;


    /**
     * user de modification
     */
    private Long phlUserModif;


    /**
     * dat de ceration
     */
    private LocalDateTime phlDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime phlDateModif;


    /**
     * code du protocole
     */
    private String phlCode;


    /**
     * libelle du protocole
     */
    private String phlLibelle;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer phlInactif;

    private Long exemedId;

    private Long exevteId;

}
