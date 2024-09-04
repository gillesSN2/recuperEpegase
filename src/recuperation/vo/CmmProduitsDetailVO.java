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
public class CmmProduitsDetailVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "prodetId can not null")
    private Long prodetId;


    /**
     * ordre des reponses
     */
    private Integer prodetOrdre;


    /**
     * nom item en FR
     */
    private String prodetLibelle;


    /**
     * 0=titre 1=numerique 2=date 3=image 4=texte 5=reponse unique 6=reponse unique + action 7=reponse multiple
     */
    private Integer prodetType;


    /**
     * unite usuelle
     */
    private String prodetUnite;


    /**
     * coefficient de convertion
     */
    private Float prodetCoef;


    /**
     * unite convertie
     */
    private String prodetUniteConv;


    /**
     * norme statique
     */
    private String prodetNorme;

    @NotNull(message = "prolabId can not null")
    private Long prolabId;

    @NotNull(message = "proId can not null")
    private Long proId;


    /**
     * code produit
     */
    private String prodetCode;

}
