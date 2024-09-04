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
public class VteCampagneParticipantVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "camparId can not null")
    private Long camparId;


    /**
     * date de creation
     */
    private LocalDateTime camparDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime camparDateModif;


    /**
     * id user createur
     */
    private Long camparIdCreateur;


    /**
     * nom du createur
     */
    private String camparNomCreateur;


    /**
     * id user de modification
     */
    private Long camparIdModif;


    /**
     * nom user de modification
     */
    private String camparNomModif;


    /**
     * date evenement
     */
    private LocalDateTime camparDate;


    /**
     * commentaire du contact
     */
    private String camparCommentaire;


    /**
     * action a faire
     */
    private String camparAction;


    /**
     * cadeau au contact
     */
    private String camparCadeau;


    /**
     * nom tiers
     */
    private String camparNomTiers;


    /**
     * id du tiers
     */
    private Long camparIdTiers;

    @NotNull(message = "camId can not null")
    private Long camId;

    @NotNull(message = "conId can not null")
    private Long conId;

}
