package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

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
public class ImmBienTravauxLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "bietraligId can not null")
    private Long bietraligId;


    /**
     * id du tiers fournisseur
     */
    private Long bietraligIdTiers;


    /**
     * civilite du fournisseur
     */
    private String bietraligCivilTiers;


    /**
     * type du fournisseur
     */
    private Integer bietraligTypeTiers;


    /**
     * nom ou raison social du fournisseur
     */
    private String bietraligNomTiers;


    /**
     * numero de facture fournisseur
     */
    private String bietraligNumFacture;


    /**
     * date de facture fournisseur
     */
    private LocalDate bietraligDateFacture;


    /**
     * objet de la facture
     */
    private String bietraligObjetFacture;


    /**
     * total ht facture
     */
    private Double bietraligHt;


    /**
     * total tva
     */
    private Double bietraligTva;


    /**
     * total ttc
     */
    private Double bietraligTtc;


    /**
     * scan de la facture
     */
    private String bietraligScanFacture;

    @NotNull(message = "bietraentId can not null")
    private Long bietraentId;

}
