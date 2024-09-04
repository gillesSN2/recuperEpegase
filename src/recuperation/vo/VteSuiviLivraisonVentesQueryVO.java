package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class VteSuiviLivraisonVentesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long suivteId;


    /**
     * date de creation
     */
    private LocalDateTime suivteDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime suivteDateModif;


    /**
     * user de creation
     */
    private Long suivteUserCreation;


    /**
     * user de modification
     */
    private Long suivteUserModif;


    /**
     * code du suivi de livraison
     */
    private String suivteCode;


    /**
     * libelle du suivi de livraison FR
     */
    private String suivteLibelleFr;


    /**
     * libelle du suivi de livraison UK
     */
    private String suivteLibelleUk;


    /**
     * libelle du suivi de livraisison SP
     */
    private String suivteLibelleSp;


    /**
     * 0=inactif 1=actif
     */
    private Boolean suivteAerien;


    /**
     * 0=inactif 1=actif
     */
    private Boolean suivteMaritime;


    /**
     * 0=inactif 1=actif
     */
    private Boolean suivteExpress;


    /**
     * 0=inactif 1=actif
     */
    private Boolean suivteRoute;


    /**
     * 0=inactif 1=actif
     */
    private Boolean suivteAutreTransit;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer suivteInactif;

    private Long exevteId;

}
