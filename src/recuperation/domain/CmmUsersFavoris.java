package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_users_favoris")
public class CmmUsersFavoris implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "usrfav_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrfavId;

    /**
     * date de creation
     */
    @Column(name = "usrfav_date_creat")
    private LocalDateTime usrfavDateCreat;

    /**
     * date de modification
     */
    @Column(name = "usrfav_date_modif")
    private LocalDateTime usrfavDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "usrfav_user_creat")
    private Long usrfavUserCreat = 0L;

    /**
     * utilisateur de creation
     */
    @Column(name = "usrfav_user_modif")
    private Long usrfavUserModif = 0L;

    /**
     * nom
     */
    @Column(name = "usrfav_nom")
    private String usrfavNom;

    /**
     * adresse url
     */
    @Column(name = "usrfav_url")
    private String usrfavUrl;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "usrfav_inactif")
    private Integer usrfavInactif = 0;

    /**
     * 0=flux rss 1=site favori 2=dossier cabinet autorise 3=modele impression
     */
    @Column(name = "usrfav_nature")
    private Integer usrfavNature = 0;

    /**
     * login acces
     */
    @Column(name = "usrfav_login")
    private String usrfavLogin;

    /**
     * mot de pass
     */
    @Column(name = "usrfav_pw")
    private String usrfavPw;

    /**
     * id de la strucutre pegase autorisee
     */
    @Column(name = "usrfav_structure_peg")
    private Long usrfavStructurePeg = 0L;

    /**
     * id du user autorise
     */
    @Column(name = "usrfav_id_user")
    private Long usrfavIdUser = 0L;

    /**
     * civilite
     */
    @Column(name = "usrfav_civilite_user")
    private String usrfavCiviliteUser;

    /**
     * nom utilisateur
     */
    @Column(name = "usrfav_nom_user")
    private String usrfavNomUser;

    /**
     * prenom user
     */
    @Column(name = "usrfav_prenom_user")
    private String usrfavPrenomUser;

    /**
     * fonction user
     */
    @Column(name = "usrfav_fonction_user")
    private String usrfavFonctionUser;

    @Column(name = "usr_id", nullable = false)
    private Long usrId;

    /**
     * mail du compte
     */
    @Column(name = "usrfav_mail")
    private String usrfavMail;

}
