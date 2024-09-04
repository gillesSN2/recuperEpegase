package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_bal")
public class CmmBal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bal_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long balId;

    /**
     * date de creation
     */
    @Column(name = "bal_date_creat")
    private LocalDateTime balDateCreat;

    /**
     * date de modification
     */
    @Column(name = "bal_date_modif")
    private LocalDateTime balDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "bal_user_creat")
    private Long balUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "bal_user_modif")
    private Long balUserModif = 0L;

    /**
     * nom du compte
     */
    @Column(name = "bal_nom_compte")
    private String balNomCompte;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "bal_inactif")
    private Integer balInactif = 0;

    /**
     * adresse mail
     */
    @Column(name = "bal_adresse_mail")
    private String balAdresseMail;

    /**
     * mot de passe
     */
    @Column(name = "bal_pw")
    private String balPw;

    /**
     * 0=connexion sans ssl 1=connexion avec ssl
     */
    @Column(name = "bal_ssl")
    private Integer balSsl = 0;

    /**
     * nom du serveur pop
     */
    @Column(name = "bal_pop_serveur")
    private String balPopServeur;

    /**
     * no du port pop
     */
    @Column(name = "bal_pop_port")
    private Integer balPopPort = 0;

    /**
     * 0=automatique 1=AUTHCRAM-MDS 2=AUTHLOGIN 3=text plain 4=aucune
     */
    @Column(name = "bal_pop_authentification")
    private Integer balPopAuthentification = 0;

    /**
     * 0=laisse un exemplaire dans le serveur 1=enleve du serveur
     */
    @Column(name = "bal_pop_exemplaire")
    private Integer balPopExemplaire = 0;

    /**
     * nom du serveur smtp
     */
    @Column(name = "bal_smtp_serveur")
    private String balSmtpServeur;

    /**
     * no port smtp
     */
    @Column(name = "bal_smtp_port")
    private Integer balSmtpPort = 0;

    /**
     * signature
     */
    @Column(name = "bal_signature")
    private String balSignature;

    /**
     * id du user
     */
    @Column(name = "bal_user")
    private Long balUser = 0L;

    /**
     * code du groupe
     */
    @Column(name = "bal_groupe")
    private String balGroupe;

    /**
     * id structure
     */
    @Column(name = "bal_structure")
    private Long balStructure = 0L;

    /**
     * adresse mail pour la reponse
     */
    @Column(name = "bal_adresse_mail_reponse")
    private String balAdresseMailReponse;

    /**
     * nom du serveur iamp
     */
    @Column(name = "bal_iamp_serveur")
    private String balIampServeur;

    /**
     * no du port imap
     */
    @Column(name = "bal_imap_port")
    private Integer balImapPort = 0;

    /**
     * 0=sans authentification 1=avec authentification
     */
    @Column(name = "bal_smtp_authentification")
    private Integer balSmtpAuthentification = 0;

    /**
     * bal par defaut
     */
    @Column(name = "bal_defaut")
    private Boolean balDefaut = Boolean.FALSE;

}
