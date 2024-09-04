package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_production_ligne")
public class CmmProductionLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "lig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ligId;

    /**
     * date de creation
     */
    @Column(name = "lig_date_creat")
    private LocalDateTime ligDateCreat;

    /**
     * date de modification
     */
    @Column(name = "lig_date_modif")
    private LocalDateTime ligDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "lig_user_creat")
    private Long ligUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "lig_user_modif")
    private Long ligUserModif = 0L;

    /**
     * code departement
     */
    @Column(name = "lig_code")
    private String ligCode;

    /**
     * nom departement en FR
     */
    @Column(name = "lig_nom_FR")
    private String ligNomFr;

    /**
     * nom departement en UK
     */
    @Column(name = "lig_nom_UK")
    private String ligNomUk;

    /**
     * nom departement en SP
     */
    @Column(name = "lig_nom_SP")
    private String ligNomSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "lig_inactif")
    private Integer ligInactif = 0;

    /**
     * % de repartition par rapport au site
     */
    @Column(name = "lig_pourcentage")
    private Float ligPourcentage = 0F;

    @Column(name = "sit_id", nullable = false)
    private Long sitId;

}
