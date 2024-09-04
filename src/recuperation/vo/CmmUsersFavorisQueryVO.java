package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmUsersFavorisQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

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

    private Long usrId;


    /**
     * mail du compte
     */
    private String usrfavMail;

}
