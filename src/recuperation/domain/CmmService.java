package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_service")
public class CmmService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ser_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serId;

    /**
     * date de creation
     */
    @Column(name = "ser_date_creat")
    private LocalDateTime serDateCreat;

    /**
     * date de modification
     */
    @Column(name = "ser_date_modif")
    private LocalDateTime serDateModif;

    /**
     * utilisateur de modification
     */
    @Column(name = "ser_user_creat")
    private Long serUserCreat = 0L;

    /**
     * utilisateur de creation
     */
    @Column(name = "ser_user_modif")
    private Long serUserModif = 0L;

    /**
     * code de service
     */
    @Column(name = "ser_code")
    private String serCode;

    /**
     * nom du service en FR
     */
    @Column(name = "ser_nom_FR")
    private String serNomFr;

    /**
     * nom du service en UK
     */
    @Column(name = "ser_nom_UK")
    private String serNomUk;

    /**
     * nom du service en SP
     */
    @Column(name = "ser_nom_SP")
    private String serNomSp;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "ser_inactif")
    private Integer serInactif = 0;

    /**
     * % de repartition par rapport au departement
     */
    @Column(name = "ser_pourcentage")
    private Float serPourcentage = 0F;

    @Column(name = "sit_id", nullable = false)
    private Long sitId;

    @Column(name = "dep_id", nullable = false)
    private Long depId;

    /**
     * id responsable
     */
    @Column(name = "ser_id_responsable")
    private Long serIdResponsable = 0L;

    /**
     * nom responsable
     */
    @Column(name = "ser_nom_responsable")
    private String serNomResponsable;

}
