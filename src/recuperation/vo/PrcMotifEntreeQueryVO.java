package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PrcMotifEntreeQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long mtpId;


    /**
     * user de creation
     */
    private Long mtpUserCreat;


    /**
     * user de modification
     */
    private Long mtpUserModif;


    /**
     * date de creation
     */
    private LocalDateTime mtpDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime mtpDateModif;


    /**
     * code du motif
     */
    private String mtpCode;


    /**
     * libelle du motif
     */
    private String mtpLibelle;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer mtpInactif;


    /**
     * code famille
     */
    private String mtpFamille;


    /**
     * type de motif
     */
    private String mtpType;

}
