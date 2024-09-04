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
public class MedConsultationLaboVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "csllabId can not null")
    private Long csllabId;


    /**
     * code produit
     */
    private String csllabProduit;


    /**
     * libelle produit
     */
    private String csllabLibelle;


    /**
     * observations
     */
    private String csllabObs;

    @NotNull(message = "csgId can not null")
    private Long csgId;

}
