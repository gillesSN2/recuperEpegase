package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmMetiersDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long metId;


    /**
     * date de creation
     */
    private LocalDateTime metDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime metDateModif;


    /**
     * utilisateur de creation
     */
    private Long metUserCreat;


    /**
     * utilisateur de modification
     */
    private Long metUserModif;


    /**
     * nom activite en FR
     */
    private String metNomFr;


    /**
     * nom activite en UK
     */
    private String metNomUk;


    /**
     * nom activite en SP
     */
    private String metNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer metInactif;


    /**
     * 0=personne physique 1=personne morale
     */
    private Integer metType;

}
