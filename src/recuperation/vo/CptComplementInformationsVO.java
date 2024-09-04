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
public class CptComplementInformationsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "cplmenId can not null")
    private Long cplmenId;


    /**
     * type 0=activites 1=dirigeants 2=actionnaires 3=mca 4=filiales
     */
    private Integer cplmenType;


    /**
     * nom
     */
    private String cplmenNom;


    /**
     * prenom
     */
    private String cplmenPrenom;


    /**
     * nationnamlite
     */
    private String cplmenNation;


    /**
     * qualite
     */
    private String cplmenQualite;


    /**
     * identification fiscale
     */
    private String cplmenFiscal;


    /**
     * designation
     */
    private String cplmenDesignation;


    /**
     * adresse
     */
    private String cplmenAdresse;


    /**
     * code
     */
    private String cplmenCode;


    /**
     * libelle
     */
    private String cplmenLibelle;


    /**
     * total
     */
    private Double cplmenTotal;


    /**
     * % de repartition
     */
    private Float cplmenPourcentage;

    @NotNull(message = "execptId can not null")
    private Long execptId;

}
