package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_secteur")
public class CmmSecteur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "sec_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long secId;

    /**
     * dat de creation
     */
    @Column(name = "sec_date_creat")
    private LocalDateTime secDateCreat;

    /**
     * date de modification
     */
    @Column(name = "sec_date_modif")
    private LocalDateTime secDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "sec_user_creat")
    private Long secUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "sec_user_modif")
    private Long secUserModif = 0L;

    /**
     * code su secteur
     */
    @Column(name = "sec_code")
    private String secCode;

    /**
     * nom du secteur en FR
     */
    @Column(name = "sec_nom_FR")
    private String secNomFr;

    /**
     * nom du secteur en UK
     */
    @Column(name = "sec_nom_UK")
    private String secNomUk;

    /**
     * nom du secteur en SP
     */
    @Column(name = "sec_nom_SP")
    private String secNomSp;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "sec_inactif")
    private Integer secInactif = 0;

    /**
     * % de repartition par rapport a la region
     */
    @Column(name = "sec_pourcentage")
    private Float secPourcentage = 0F;

    @Column(name = "reg_id", nullable = false)
    private Long regId;

    /**
     * id responsable
     */
    @Column(name = "sec_id_responsable")
    private Long secIdResponsable = 0L;

    /**
     * nom responsable
     */
    @Column(name = "sec_nom_responsable")
    private String secNomResponsable;

}
