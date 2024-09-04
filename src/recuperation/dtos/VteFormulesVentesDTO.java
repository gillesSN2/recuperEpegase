package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class VteFormulesVentesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long forvteId;


    /**
     * date de creation
     */
    private LocalDateTime forvteDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime forvteDateModif;


    /**
     * user de creation
     */
    private Long forvteUserCreation;


    /**
     * user de modification
     */
    private Long forvteUserModif;


    /**
     * libelle de la formule FR
     */
    private String forvteLibelleFr;


    /**
     * libelle de la formule UK
     */
    private String forvteLibelleUk;


    /**
     * libelle de la formule SP
     */
    private String forvteLibelleSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer forvteInactif;

    private Long exevteId;

}
