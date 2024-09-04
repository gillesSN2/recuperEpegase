package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_departement")
public class CmmDepartement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dep_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depId;

    /**
     * date de creation
     */
    @Column(name = "dep_date_creat")
    private LocalDateTime depDateCreat;

    /**
     * date de modification
     */
    @Column(name = "dep_date_modif")
    private LocalDateTime depDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "dep_user_creat")
    private Long depUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "dep_user_modif")
    private Long depUserModif = 0L;

    /**
     * code departement
     */
    @Column(name = "dep_code")
    private String depCode;

    /**
     * nom departement en FR
     */
    @Column(name = "dep_nom_FR")
    private String depNomFr;

    /**
     * nom departement en UK
     */
    @Column(name = "dep_nom_UK")
    private String depNomUk;

    /**
     * nom departement en SP
     */
    @Column(name = "dep_nom_SP")
    private String depNomSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "dep_inactif")
    private Integer depInactif = 0;

    /**
     * % de repartition par rapport au site
     */
    @Column(name = "dep_pourcentage")
    private Float depPourcentage = 0F;

    @Column(name = "sit_id", nullable = false)
    private Long sitId;

    /**
     * id responsable
     */
    @Column(name = "dep_id_responsable")
    private Long depIdResponsable = 0L;

    /**
     * nom responsable
     */
    @Column(name = "dep_nom_responsable")
    private String depNomResponsable;

}
