package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
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
public class AchSommierEnteteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "somId can not null")
    private Long somId;


    /**
     * date de creation
     */
    private LocalDateTime somDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime somDateModif;


    /**
     * id user createur
     */
    private Long somIdCreateur;


    /**
     * nom du createur
     */
    private String somNomCreateur;


    /**
     * id user de modification
     */
    private Long somIdModif;


    /**
     * nom user de modification
     */
    private String somNomModif;


    /**
     * date sommier
     */
    private LocalDateTime somDate;


    /**
     * date expiration du sommier
     */
    private LocalDateTime somDateExpiration;


    /**
     * date prorogation du sommier
     */
    private LocalDateTime somDateProrogation;


    /**
     * numero sommier
     */
    private String somNum;


    /**
     * type 0=entree, 1=sortie
     */
    private Integer somType;


    /**
     * nom du commercial
     */
    private String somNomResponsable;


    /**
     * id du commercial
     */
    private Long somIdResponsable;


    /**
     * numero dossier transit
     */
    private String somDossierTransit;


    /**
     * numero reception
     */
    private String somReception;


    /**
     * numero cession
     */
    private String somCession;


    /**
     * date impression
     */
    private LocalDate somDateImp;


    /**
     * modele impression
     */
    private String somModeleImp;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer somEtat;


    /**
     * regime de sortie
     */
    private String somRegime;


    /**
     * nom du tiers
     */
    private String somNomTiers;

    @NotNull(message = "exeachId can not null")
    private Long exeachId;

    private Long usrId;

}
