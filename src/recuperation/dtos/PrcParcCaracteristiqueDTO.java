package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PrcParcCaracteristiqueDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long prccarId;


    /**
     * date creation
     */
    private LocalDateTime prccarDateCreat;


    /**
     * date modification
     */
    private LocalDateTime prccarDateModif;


    /**
     * id user de creation
     */
    private Long prccarUserCreat;


    /**
     * id user de modification
     */
    private Long prccarUserModif;


    /**
     * code nature
     */
    private String prccarNature;


    /**
     * libelle nature
     */
    private String prccarLibNature;


    /**
     * 0=caracteristique 1=inventaire
     */
    private Integer prccarType;


    /**
     * 0=actif 1=inactif
     */
    private Integer prccarInactif;


    /**
     * 0=organe mecanique 1=equipement 2=pneumatique 3=autre
     */
    private Integer prccarOrgane;


    /**
     * libelle caracteristique
     */
    private String prccarLibelle;

    private Long prcId;

}
