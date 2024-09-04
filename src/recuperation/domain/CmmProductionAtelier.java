package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_production_atelier")
public class CmmProductionAtelier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ate_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ateId;

    /**
     * date de creation
     */
    @Column(name = "ate_date_creat")
    private LocalDateTime ateDateCreat;

    /**
     * date de modification
     */
    @Column(name = "ate_date_modif")
    private LocalDateTime ateDateModif;

    /**
     * utilisateur de modification
     */
    @Column(name = "ate_user_creat")
    private Long ateUserCreat = 0L;

    /**
     * utilisateur de creation
     */
    @Column(name = "ate_user_modif")
    private Long ateUserModif = 0L;

    /**
     * code de service
     */
    @Column(name = "ate_code")
    private String ateCode;

    /**
     * nom du service en FR
     */
    @Column(name = "ate_nom_FR")
    private String ateNomFr;

    /**
     * nom du service en UK
     */
    @Column(name = "ate_nom_UK")
    private String ateNomUk;

    /**
     * nom du service en SP
     */
    @Column(name = "ate_nom_SP")
    private String ateNomSp;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "ate_inactif")
    private Integer ateInactif = 0;

    /**
     * % de repartition par rapport au departement
     */
    @Column(name = "ate_pourcentage")
    private Float atePourcentage = 0F;

    @Column(name = "sit_id", nullable = false)
    private Long sitId;

    @Column(name = "lig_id", nullable = false)
    private Long ligId;

}
