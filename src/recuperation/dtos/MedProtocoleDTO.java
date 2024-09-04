package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MedProtocoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long prtId;


    /**
     * user de creation
     */
    private Long prtUserCreat;


    /**
     * user de modification
     */
    private Long prtUserModif;


    /**
     * dat de ceration
     */
    private LocalDateTime prtDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime prtDateModif;


    /**
     * code du protocole
     */
    private String prtCode;


    /**
     * libelle du protocole
     */
    private String prtLibelle;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer prtInactif;

    private Long exemedId;

    private Long exevteId;

}
