package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmCouleurQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long couId;


    /**
     * date de creation
     */
    private LocalDateTime mcouDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime couDateModif;


    /**
     * user de creation
     */
    private Long couUserCreation;


    /**
     * user de modification
     */
    private Long couUserModif;


    /**
     * libelle FR
     */
    private String couLibelleFr;


    /**
     * libelle UK
     */
    private String couLibelleUk;


    /**
     * libelle SP
     */
    private String couLibelleSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer couInactif;

}
