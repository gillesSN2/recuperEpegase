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
public class AchProcessEnteteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "procesId can not null")
    private Long procesId;


    /**
     * date de creation
     */
    private LocalDateTime procesDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime procesDateModif;


    /**
     * id user createur
     */
    private Long procesUserCreat;


    /**
     * id user de modification
     */
    private Long procesUserModif;


    /**
     * code produit
     */
    private String procesCode;


    /**
     * libelle client
     */
    private String procesLibClient;


    /**
     * libelle technique
     */
    private String procesLibTech;


    /**
     * depot de stockage
     */
    private String procesDepot;


    /**
     * unite
     */
    private String procesUnite;


    /**
     * coefficient
     */
    private Float procesCoef;


    /**
     * site
     */
    private String procesSite;


    /**
     * ligne
     */
    private String procesLigne;


    /**
     * atelier
     */
    private String procesAtelier;


    /**
     * code acitivite commerciale
     */
    private String procesActivite;


    /**
     * total pump
     */
    private Double procesTotPump;


    /**
     * 0=actif 1=inactif
     */
    private Integer procesInactif;

}
