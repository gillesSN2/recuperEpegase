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
public class MedConsultationOrdoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "cslordId can not null")
    private Long cslordId;


    /**
     * code produit
     */
    private String cslordProduit;


    /**
     * libelle produit
     */
    private String cslordLibelle;


    /**
     * posologie
     */
    private String cslordPoso;


    /**
     * observations
     */
    private String cslordObs;

    @NotNull(message = "csgId can not null")
    private Long csgId;


    /**
     * dci
     */
    private String cslordDci;


    /**
     * forme
     */
    private String cslordForme;

}
