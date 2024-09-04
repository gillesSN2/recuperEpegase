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
public class CmmTiersTechniqueVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "tietecId can not null")
    private Long tietecId;


    /**
     * date de creation
     */
    private LocalDateTime tietecDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime tietecDateModif;


    /**
     * utilisateur de creation
     */
    private Long tietecUserCreat;


    /**
     * utilisateur de modification
     */
    private Long tietecUserModif;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer tietecEtat;


    /**
     * 0=mot de passe 1=configuration 2=autre
     */
    private Integer tietecType;


    /**
     * mot de passe espace client
     */
    private String tietecService;


    /**
     * login
     */
    private String tietecLogin;


    /**
     * mot de passe
     */
    private String tietecPs;


    /**
     * adresse de connexion
     */
    private String tietecAdresse;

    @NotNull(message = "tieId can not null")
    private Long tieId;

}
