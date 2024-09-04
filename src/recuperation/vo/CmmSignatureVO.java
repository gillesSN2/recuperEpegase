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
public class CmmSignatureVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "sgrId can not null")
    private Long sgrId;


    /**
     * 10=da 11=cotation 12=commande 13=reception 14=retour 15=facture 16=avoir 17=note debit 18=frais 19=collecte 20=besoin 21=devis 22=BC 23=BL 24=retour 25=facture 26=avoir 27=note debit 28=chargement
     */
    private Integer sgrNature;


    /**
     * 0=mono signature 1=multi signature
     */
    private Integer sgrMode;


    /**
     * numero du document
     */
    private String sgrNum;


    /**
     * numero du document
     */
    private Long sgrIdDoc;


    /**
     * 1=obligatoire
     */
    private Integer sgrObligatoire1;


    /**
     * 1=obligatoire
     */
    private Integer sgrObligatoire2;


    /**
     * 1=obligatoire
     */
    private Integer sgrObligatoire3;


    /**
     * 1=obligatoire
     */
    private Integer sgrObligatoire4;


    /**
     * 1=obligatoire
     */
    private Integer sgrObligatoire5;


    /**
     * 1=obligatoire
     */
    private Integer sgrObligatoire6;


    /**
     * 1=non obligatoire
     */
    private Integer sgrNonObligatoire1;


    /**
     * 1=non obligatoire
     */
    private Integer sgrNonObligatoire2;


    /**
     * 1=non obligatoire
     */
    private Integer sgrNonObligatoire3;


    /**
     * 1=non obligatoire
     */
    private Integer sgrNonObligatoire4;


    /**
     * 1=non obligatoire
     */
    private Integer sgrNonObligatoire5;


    /**
     * 1=non obligatoire
     */
    private Integer sgrNonObligatoire6;


    /**
     * 1=valider
     */
    private Integer sgrValider1;


    /**
     * 1=valider
     */
    private Integer sgrValider2;


    /**
     * 1=valider
     */
    private Integer sgrValider3;


    /**
     * 1=valider
     */
    private Integer sgrValider4;


    /**
     * 1=valider
     */
    private Integer sgrValider5;


    /**
     * 1=valider
     */
    private Integer sgrValider6;


    /**
     * 1=geler
     */
    private Integer sgrGeler1;


    /**
     * 1=geler
     */
    private Integer sgrGeler2;


    /**
     * 1=geler
     */
    private Integer sgrGeler3;


    /**
     * 1=geler
     */
    private Integer sgrGeler4;


    /**
     * 1=geler
     */
    private Integer sgrGeler5;


    /**
     * 1=geler
     */
    private Integer sgrGeler6;


    /**
     * 1=rejeter
     */
    private Integer sgrRejeter1;


    /**
     * 1=rejeter
     */
    private Integer sgrRejeter2;


    /**
     * 1=rejeter
     */
    private Integer sgrRejeter3;


    /**
     * 1=rejeter
     */
    private Integer sgrRejeter4;


    /**
     * 1=rejeter
     */
    private Integer sgrRejeter5;


    /**
     * 1=rejeter
     */
    private Integer sgrRejeter6;


    /**
     * 1=encours
     */
    private Integer sgrEncours1;


    /**
     * 1=encours
     */
    private Integer sgrEncours2;


    /**
     * 1=encours
     */
    private Integer sgrEncours3;


    /**
     * 1=encours
     */
    private Integer sgrEncours4;


    /**
     * 1=encours
     */
    private Integer sgrEncours5;


    /**
     * 1=encours
     */
    private Integer sgrEncours6;


    /**
     * 1=corriger
     */
    private Integer sgrCorriger1;


    /**
     * 1=corriger
     */
    private Integer sgrCorriger2;


    /**
     * 1=corriger
     */
    private Integer sgrCorriger3;


    /**
     * 1=corriger
     */
    private Integer sgrCorriger4;


    /**
     * 1=corriger
     */
    private Integer sgrCorriger5;


    /**
     * 1=corriger
     */
    private Integer sgrCorriger6;


    /**
     * 1=users
     */
    private Integer sgrUsers1;


    /**
     * 1=users
     */
    private Integer sgrUsers2;


    /**
     * 1=users
     */
    private Integer sgrUsers3;


    /**
     * 1=users
     */
    private Integer sgrUsers4;


    /**
     * 1=users
     */
    private Integer sgrUsers5;


    /**
     * 1=users
     */
    private Integer sgrUsers6;


    /**
     * 1=remplace
     */
    private Integer sgrRemplace1;


    /**
     * 1=remplace
     */
    private Integer sgrRemplace2;


    /**
     * 1=remplace
     */
    private Integer sgrRemplace3;


    /**
     * 1=remplace
     */
    private Integer sgrRemplace4;


    /**
     * 1=remplace
     */
    private Integer sgrRemplace5;


    /**
     * 1=remplace
     */
    private Integer sgrRemplace6;

    @NotNull(message = "phrId can not null")
    private Long phrId;

}
