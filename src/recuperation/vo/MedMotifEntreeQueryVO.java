package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MedMotifEntreeQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long mteId;


    /**
     * user de creation
     */
    private Long mteUserCreat;


    /**
     * user de modification
     */
    private Long mteUserModif;


    /**
     * dat de ceration
     */
    private LocalDateTime mteDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime mteDateModif;


    /**
     * code du protocole
     */
    private String mteCode;


    /**
     * libelle du protocole
     */
    private String mteLibelle;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer mteInactif;


    /**
     * 0=non 1=actif dans les consult gene
     */
    private Integer mteConGene;


    /**
     * 0=non 1=actif dans les consult spe
     */
    private Integer mteConSpe;


    /**
     * 0=non 1=actif dans les labo
     */
    private Integer mteLab;


    /**
     * 0=non 1=actif dans les pharmacies
     */
    private Integer mtePha;


    /**
     * 0=non 1=actif dans les consult gene
     */
    private Integer mteHosp;

    private Long exemedId;

    private Long exevteId;

}
