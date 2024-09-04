package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_region")
public class CmmRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "reg_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regId;

    /**
     * date de creation
     */
    @Column(name = "reg_date_creat")
    private LocalDateTime regDateCreat;

    /**
     * date de modification
     */
    @Column(name = "reg_date_modif")
    private LocalDateTime regDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "reg_user_creat")
    private Long regUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "reg_user_modif")
    private Long regUserModif = 0L;

    /**
     * code region
     */
    @Column(name = "reg_code")
    private String regCode;

    /**
     * nom region en FR
     */
    @Column(name = "reg_nom_FR")
    private String regNomFr;

    /**
     * nom region en UK
     */
    @Column(name = "reg_nom_UK")
    private String regNomUk;

    /**
     * nom region en SP
     */
    @Column(name = "reg_nom_SP")
    private String regNomSp;

    /**
     * 1=inactif
     */
    @Column(name = "reg_inactif")
    private Integer regInactif = 0;

    /**
     * id responsable
     */
    @Column(name = "reg_id_responsable")
    private Long regIdResponsable = 0L;

    /**
     * nom responsable
     */
    @Column(name = "reg_nom_responsable")
    private String regNomResponsable;

}
