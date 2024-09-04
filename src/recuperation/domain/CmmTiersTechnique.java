package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_tiers_technique")
public class CmmTiersTechnique implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "tietec_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tietecId;

    /**
     * date de creation
     */
    @Column(name = "tietec_date_creat")
    private LocalDateTime tietecDateCreat;

    /**
     * date de modification
     */
    @Column(name = "tietec_date_modif")
    private LocalDateTime tietecDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "tietec_user_creat")
    private Long tietecUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "tietec_user_modif")
    private Long tietecUserModif = 0L;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "tietec_etat")
    private Integer tietecEtat = 0;

    /**
     * 0=mot de passe 1=configuration 2=autre
     */
    @Column(name = "tietec_type")
    private Integer tietecType = 0;

    /**
     * mot de passe espace client
     */
    @Column(name = "tietec_service")
    private String tietecService;

    /**
     * login
     */
    @Column(name = "tietec_login")
    private String tietecLogin;

    /**
     * mot de passe
     */
    @Column(name = "tietec_ps")
    private String tietecPs;

    /**
     * adresse de connexion
     */
    @Column(name = "tietec_adresse")
    private String tietecAdresse;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

}
