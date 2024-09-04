package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmTiersTechniqueDTO implements Serializable {
    private static final long serialVersionUID = 1L;
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

    private Long tieId;

}
