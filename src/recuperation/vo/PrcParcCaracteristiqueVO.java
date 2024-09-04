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
public class PrcParcCaracteristiqueVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "prccarId can not null")
    private Long prccarId;


    /**
     * date creation
     */
    private LocalDateTime prccarDateCreat;


    /**
     * date modification
     */
    private LocalDateTime prccarDateModif;


    /**
     * id user de creation
     */
    private Long prccarUserCreat;


    /**
     * id user de modification
     */
    private Long prccarUserModif;


    /**
     * code nature
     */
    private String prccarNature;


    /**
     * libelle nature
     */
    private String prccarLibNature;


    /**
     * 0=caracteristique 1=inventaire
     */
    private Integer prccarType;


    /**
     * 0=actif 1=inactif
     */
    private Integer prccarInactif;


    /**
     * 0=organe mecanique 1=equipement 2=pneumatique 3=autre
     */
    private Integer prccarOrgane;


    /**
     * libelle caracteristique
     */
    private String prccarLibelle;

    private Long prcId;

}
