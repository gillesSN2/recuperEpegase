package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmUniteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long uniId;


    /**
     * date de creation
     */
    private LocalDateTime uniDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime uniDateModif;


    /**
     * user de creation
     */
    private Long uniUserCreation;


    /**
     * user de modification
     */
    private Long uniUserModif;


    /**
     * libelle unite
     */
    private String uniLibelle;

    private Integer uniEchelle;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer uniInactif;

}
