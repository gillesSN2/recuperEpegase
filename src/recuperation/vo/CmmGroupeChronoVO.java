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
public class CmmGroupeChronoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "grpchrId can not null")
    private Long grpchrId;


    /**
     * date de creation
     */
    private LocalDateTime grpchrDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime grpchrDateModif;


    /**
     * utilisateur de creation
     */
    private Long grpchrUserCreat;


    /**
     * utilisateur de creation
     */
    private Long grpchrUserModif;


    /**
     * code serie
     */
    private String grpchrSerie;


    /**
     * libelle serie
     */
    private String grpchrLib;


    /**
     * code nature
     */
    private Integer grpchrNature;


    /**
     * 0=valide a l impression 1=valide a l enregistrement 2=sur bouton
     */
    private Integer grpchrValidation;


    /**
     * 0=devalidation interdite 1=devalidation autorisee
     */
    private Integer grpchrDevalidation;


    /**
     * 0=dupplication interdite 1=dupplication autorisee
     */
    private Integer grpchrDupplication;


    /**
     * mise ÃƒÂ  jour autorisee 1=mise ÃƒÂ  jour interdite
     */
    private Integer grpchrUpdate;


    /**
     * 0=public 1=prive
     */
    private Integer grpchrPrive;

    @NotNull(message = "grpId can not null")
    private Long grpId;

}
