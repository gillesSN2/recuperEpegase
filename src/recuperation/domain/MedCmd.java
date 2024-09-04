package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_cmd")
public class MedCmd implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cmd_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cmdId;

    /**
     * code famille
     */
    @Column(name = "cmd_fam_code")
    private String cmdFamCode;

    /**
     * libelle FR
     */
    @Column(name = "cmd_fam_libelle_FR")
    private String cmdFamLibelleFr;

    /**
     * libelle UK
     */
    @Column(name = "cmd_fam_libelle_UK")
    private String cmdFamLibelleUk;

    /**
     * libelle SP
     */
    @Column(name = "cmd_fam_libelle_SP")
    private String cmdFamLibelleSp;

    /**
     * code cms
     */
    @Column(name = "cmd_det_code")
    private String cmdDetCode;

    /**
     * libelle FR
     */
    @Column(name = "cmd_det_libelle_FR")
    private String cmdDetLibelleFr;

    /**
     * libelle UK
     */
    @Column(name = "cmd_det_libelle_UK")
    private String cmdDetLibelleUk;

    /**
     * libelle SP
     */
    @Column(name = "cmd_det_libelle_SP")
    private String cmdDetLibelleSp;

    /**
     * 0=pricipal 1=secondaire
     */
    @Column(name = "cmd_det_type")
    private Integer cmdDetType = 0;

}
