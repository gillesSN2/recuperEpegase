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
public class CmmUsersFavorisVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "usrfavId can not null")
    private Long usrfavId;


    /**
     * date de creation
     */
    private LocalDateTime usrfavDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime usrfavDateModif;


    /**
     * utilisateur de creation
     */
    private Long usrfavUserCreat;


    /**
     * utilisateur de creation
     */
    private Long usrfavUserModif;


    /**
     * nom
     */
    private String usrfavNom;


    /**
     * adresse url
     */
    private String usrfavUrl;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer usrfavInactif;


    /**
     * 0=flux rss 1=site favori 2=dossier cabinet autorise 3=modele impression
     */
    private Integer usrfavNature;


    /**
     * login acces
     */
    private String usrfavLogin;


    /**
     * mot de pass
     */
    private String usrfavPw;


    /**
     * id de la strucutre pegase autorisee
     */
    private Long usrfavStructurePeg;


    /**
     * id du user autorise
     */
    private Long usrfavIdUser;


    /**
     * civilite
     */
    private String usrfavCiviliteUser;


    /**
     * nom utilisateur
     */
    private String usrfavNomUser;


    /**
     * prenom user
     */
    private String usrfavPrenomUser;


    /**
     * fonction user
     */
    private String usrfavFonctionUser;

    @NotNull(message = "usrId can not null")
    private Long usrId;


    /**
     * mail du compte
     */
    private String usrfavMail;

}
