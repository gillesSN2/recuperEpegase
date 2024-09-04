package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmBalDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long balId;


    /**
     * date de creation
     */
    private LocalDateTime balDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime balDateModif;


    /**
     * utilisateur de creation
     */
    private Long balUserCreat;


    /**
     * utilisateur de modification
     */
    private Long balUserModif;


    /**
     * nom du compte
     */
    private String balNomCompte;


    /**
     * 0=actif 1=inactif
     */
    private Integer balInactif;


    /**
     * adresse mail
     */
    private String balAdresseMail;


    /**
     * mot de passe
     */
    private String balPw;


    /**
     * 0=connexion sans ssl 1=connexion avec ssl
     */
    private Integer balSsl;


    /**
     * nom du serveur pop
     */
    private String balPopServeur;


    /**
     * no du port pop
     */
    private Integer balPopPort;


    /**
     * 0=automatique 1=AUTHCRAM-MDS 2=AUTHLOGIN 3=text plain 4=aucune
     */
    private Integer balPopAuthentification;


    /**
     * 0=laisse un exemplaire dans le serveur 1=enleve du serveur
     */
    private Integer balPopExemplaire;


    /**
     * nom du serveur smtp
     */
    private String balSmtpServeur;


    /**
     * no port smtp
     */
    private Integer balSmtpPort;


    /**
     * signature
     */
    private String balSignature;


    /**
     * id du user
     */
    private Long balUser;


    /**
     * code du groupe
     */
    private String balGroupe;


    /**
     * id structure
     */
    private Long balStructure;


    /**
     * adresse mail pour la reponse
     */
    private String balAdresseMailReponse;


    /**
     * nom du serveur iamp
     */
    private String balIampServeur;


    /**
     * no du port imap
     */
    private Integer balImapPort;


    /**
     * 0=sans authentification 1=avec authentification
     */
    private Integer balSmtpAuthentification;


    /**
     * bal par defaut
     */
    private Boolean balDefaut;

}
