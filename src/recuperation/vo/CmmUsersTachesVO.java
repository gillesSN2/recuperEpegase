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
public class CmmUsersTachesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "usrtacId can not null")
    private Long usrtacId;


    /**
     * date de creation
     */
    private LocalDateTime usrtacDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime usrtacDateModif;


    /**
     * utilisateur de creation
     */
    private Long usrtacUserCreat;


    /**
     * utilisateur de creation
     */
    private Long usrtacUserModif;


    /**
     * code tache
     */
    private String usrtacCode;


    /**
     * libelle tache
     */
    private String usrtacLib;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer usrtacInactif;


    /**
     * prix de revient de la tache
     */
    private Float usrtacValPr;


    /**
     * prix de vente de la tache
     */
    private Float usrtacValPv;

    private Long usrId;

}
