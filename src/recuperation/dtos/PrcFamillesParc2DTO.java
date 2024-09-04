package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PrcFamillesParc2DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long famprc2Id;


    /**
     * date de creation
     */
    private LocalDateTime famprc2DateCreation;


    /**
     * date de modification
     */
    private LocalDateTime famprc2DateModif;


    /**
     * user de creation
     */
    private Long famprc2UserCreation;


    /**
     * user de modification
     */
    private Long famprc2UserModif;


    /**
     * code famille parc
     */
    private String famprc2Code;


    /**
     * libelle famille parc en FR
     */
    private String famprc2LibelleFr;


    /**
     * libelle famille parc en UK
     */
    private String famprc2LibelleUk;


    /**
     * libelle famille parc en SP
     */
    private String famprc2LibelleSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer famprc2Inactif;

    private Long famprc1Id;

}
