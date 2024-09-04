package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MedLettreMedicalDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long letId;


    /**
     * date de creation
     */
    private LocalDateTime letDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime letDateModif;


    /**
     * user de creation
     */
    private Long letUserCreat;


    /**
     * user de modification
     */
    private Long letUserModif;


    /**
     * code lettre
     */
    private String letLettre;


    /**
     * libelle FR
     */
    private String letLibelleFr;


    /**
     * libelle UK
     */
    private String letLibelleUk;


    /**
     * libelle SP
     */
    private String letLibelleSp;


    /**
     * valeur de la lettre
     */
    private Double letValeur;


    /**
     * 1=inactif 2=supprimer
     */
    private Integer letInactif;

    private Long exemedId;

    private Long exevteId;

}
