package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_site")
public class CmmSite implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "sit_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sitId;

    /**
     * date de creation
     */
    @Column(name = "sit_date_creat")
    private LocalDateTime sitDateCreat;

    /**
     * date de modification
     */
    @Column(name = "sit_date_modif")
    private LocalDateTime sitDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "sit_user_creat")
    private Long sitUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "sit_user_modif")
    private Long sitUserModif = 0L;

    /**
     * code du site
     */
    @Column(name = "sit_code")
    private String sitCode;

    /**
     * nom du site en FR
     */
    @Column(name = "sit_nom_FR")
    private String sitNomFr;

    /**
     * nom du site en UK
     */
    @Column(name = "sit_nom_UK")
    private String sitNomUk;

    /**
     * nom du site en SP
     */
    @Column(name = "sit_nom_SP")
    private String sitNomSp;

    /**
     * 1=inactif
     */
    @Column(name = "sit_inactif")
    private Integer sitInactif = 0;

    /**
     * id responsable
     */
    @Column(name = "sit_id_responsable")
    private Long sitIdResponsable = 0L;

    /**
     * nom responsable
     */
    @Column(name = "sit_nom_responsable")
    private String sitNomResponsable;

}
