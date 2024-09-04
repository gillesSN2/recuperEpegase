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
public class CmmProductionAtelierVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ateId can not null")
    private Long ateId;


    /**
     * date de creation
     */
    private LocalDateTime ateDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime ateDateModif;


    /**
     * utilisateur de modification
     */
    private Long ateUserCreat;


    /**
     * utilisateur de creation
     */
    private Long ateUserModif;


    /**
     * code de service
     */
    private String ateCode;


    /**
     * nom du service en FR
     */
    private String ateNomFr;


    /**
     * nom du service en UK
     */
    private String ateNomUk;


    /**
     * nom du service en SP
     */
    private String ateNomSp;


    /**
     * 0=actif 1=inactif
     */
    private Integer ateInactif;


    /**
     * % de repartition par rapport au departement
     */
    private Float atePourcentage;

    @NotNull(message = "sitId can not null")
    private Long sitId;

    @NotNull(message = "ligId can not null")
    private Long ligId;

}
