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
public class CmmResponsableVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "rpbId can not null")
    private Long rpbId;


    /**
     * date de creation
     */
    private LocalDateTime rpbDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime rpbDateModif;


    /**
     * utilisateur de creation
     */
    private Long rpbUserCreat;


    /**
     * utilisateur de modification
     */
    private Long rpbUserModif;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer rpbEtat;


    /**
     * id du responsable
     */
    private Long rpbUserId;


    /**
     * nom responsable
     */
    private String rpbNom;


    /**
     * prenom
     */
    private String rpbPrenom;


    /**
     * fonction
     */
    private String rpbCategorie;


    /**
     * civilite (suivant fichier xml)
     */
    private String rpbCivilite;


    /**
     * date de debut
     */
    private LocalDateTime rpbDateDebut;


    /**
     * date de fin
     */
    private LocalDateTime rpbDateFin;


    /**
     * 1= defaut
     */
    private Integer rpbDefaut;

    @NotNull(message = "tieId can not null")
    private Long tieId;

}
