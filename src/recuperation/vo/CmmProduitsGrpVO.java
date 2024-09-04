package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;

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
public class CmmProduitsGrpVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "progrpId can not null")
    private Long progrpId;


    /**
     * code produit constituant
     */
    private String progrpCode;


    /**
     * libelle produit constituant
     */
    private String progrpLibelle;


    /**
     * depot du produit constituant
     */
    private String progrpDepot;


    /**
     * quantite concernee
     */
    private Float progrpQte;


    /**
     * unite
     */
    private String progrpUnite;


    /**
     * pump du produit constrituant
     */
    private Double progrpPump;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer progrpInactif;

    @NotNull(message = "proId can not null")
    private Long proId;

}
