package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class VteSuiviLivraisonVentesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "suivteId can not null")
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

    @NotNull(message = "exevteId can not null")
    private Long exevteId;

}
