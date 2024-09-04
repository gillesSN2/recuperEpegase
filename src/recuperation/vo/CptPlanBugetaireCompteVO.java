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
public class CptPlanBugetaireCompteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "plbcptId can not null")
    private Long plbcptId;


    /**
     * code budgetaire
     */
    private String plbcptCode;


    /**
     * 1=vente 2=achat 3=production 4=frais generaux 5=investissement 6=tva 7=frais personnel
     */
    private String plbcptNature;


    /**
     * 0=plan comptable 1=produit
     */
    private Integer plbcptType;


    /**
     * numero de compte
     */
    private String plbcptCompte;


    /**
     * libelle compte
     */
    private String plbcptLibelleFr;


    /**
     * libelle compte
     */
    private String plbcptLibelleUk;


    /**
     * libelle compte
     */
    private String plbcptLibelleSp;

    @NotNull(message = "plbId can not null")
    private Long plbId;

}
