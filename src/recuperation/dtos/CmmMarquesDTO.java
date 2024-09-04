package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmMarquesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long marId;


    /**
     * date de creation
     */
    private LocalDateTime marDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime marDateModif;


    /**
     * user de creation
     */
    private Long marUserCreation;


    /**
     * user de modification
     */
    private Long marUserModif;


    /**
     * libelle FR
     */
    private String marLibelleFr;


    /**
     * libelle UK
     */
    private String marLibelleUk;


    /**
     * libelle SP
     */
    private String marLibelleSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer marInactif;


    /**
     * photos du produits
     */
    private String marPhoto;


    /**
     * fichier pdf
     */
    private String marPdf;

}
