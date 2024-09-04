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
public class CmmProductionLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ligId can not null")
    private Long ligId;


    /**
     * date de creation
     */
    private LocalDateTime ligDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime ligDateModif;


    /**
     * utilisateur de creation
     */
    private Long ligUserCreat;


    /**
     * utilisateur de modification
     */
    private Long ligUserModif;


    /**
     * code departement
     */
    private String ligCode;


    /**
     * nom departement en FR
     */
    private String ligNomFr;


    /**
     * nom departement en UK
     */
    private String ligNomUk;


    /**
     * nom departement en SP
     */
    private String ligNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer ligInactif;


    /**
     * % de repartition par rapport au site
     */
    private Float ligPourcentage;

    @NotNull(message = "sitId can not null")
    private Long sitId;

}
