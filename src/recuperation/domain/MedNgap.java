package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_ngap")
public class MedNgap implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "nga_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ngaId;

    /**
     * code famille
     */
    @Column(name = "nga_fam_code")
    private String ngaFamCode;

    /**
     * libelle FR
     */
    @Column(name = "nga_fam_libelle_FR")
    private String ngaFamLibelleFr;

    /**
     * libelle UK
     */
    @Column(name = "nga_fam_libelle_UK")
    private String ngaFamLibelleUk;

    /**
     * libelle SP
     */
    @Column(name = "nga_fam_libelle_SP")
    private String ngaFamLibelleSp;

    /**
     * code cms
     */
    @Column(name = "nga_det_code")
    private String ngaDetCode;

    /**
     * libelle FR
     */
    @Column(name = "nga_det_libelle_FR")
    private String ngaDetLibelleFr;

    /**
     * libelle UK
     */
    @Column(name = "nga_det_libelle_UK")
    private String ngaDetLibelleUk;

    /**
     * libelle SP
     */
    @Column(name = "nga_det_libelle_SP")
    private String ngaDetLibelleSp;

    /**
     * 0=pricipal 1=secondaire
     */
    @Column(name = "nga_det_type")
    private Integer ngaDetType = 0;

}
