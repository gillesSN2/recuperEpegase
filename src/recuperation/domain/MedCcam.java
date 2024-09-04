package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_ccam")
public class MedCcam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ccam_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ccamId;

    /**
     * code famille
     */
    @Column(name = "ccam_fam_code")
    private String ccamFamCode;

    @Column(name = "ccam_fam_lib_FR")
    private String ccamFamLibFr;

    @Column(name = "ccam_fam_lib_UK")
    private String ccamFamLibUk;

    @Column(name = "ccam_fam_lib_SP")
    private String ccamFamLibSp;

    /**
     * code sous famille
     */
    @Column(name = "ccam_sfam_code")
    private String ccamSfamCode;

    @Column(name = "ccam_sfam_lib_FR")
    private String ccamSfamLibFr;

    @Column(name = "ccam_sfam_lib_UK")
    private String ccamSfamLibUk;

    @Column(name = "ccam_sfam_lib_SP")
    private String ccamSfamLibSp;

    /**
     * code sous sous famille
     */
    @Column(name = "ccam_ssfam_code")
    private String ccamSsfamCode;

    @Column(name = "ccam_ssfam_lib_FR")
    private String ccamSsfamLibFr;

    @Column(name = "ccam_ssfam_lib_UK")
    private String ccamSsfamLibUk;

    @Column(name = "ccam_ssfam_lib_SP")
    private String ccamSsfamLibSp;

    /**
     * code sous sous sous famille
     */
    @Column(name = "ccam_sssfam_code")
    private String ccamSssfamCode;

    @Column(name = "ccam_sssfam_lib_FR")
    private String ccamSssfamLibFr;

    @Column(name = "ccam_sssfam_lib_UK")
    private String ccamSssfamLibUk;

    @Column(name = "ccam_sssfam_lib_SP")
    private String ccamSssfamLibSp;

    /**
     * code ccam
     */
    @Column(name = "ccam_det_code")
    private String ccamDetCode;

    @Column(name = "ccam_det_lib_FR")
    private String ccamDetLibFr;

    @Column(name = "ccam_det_lib_UK")
    private String ccamDetLibUk;

    @Column(name = "ccam_det_lib_SP")
    private String ccamDetLibSp;

    /**
     * code activite
     */
    @Column(name = "ccam_det_activite")
    private String ccamDetActivite;

    @Column(name = "ccam_det_phase")
    private String ccamDetPhase;

    /**
     * prix en euro
     */
    @Column(name = "ccam_det_pu_euro")
    private Float ccamDetPuEuro = 0F;

    /**
     * prix local
     */
    @Column(name = "ccam_det_pu_local")
    private Float ccamDetPuLocal = 0F;

    @Column(name = "ccam_det_rmb_sc")
    private String ccamDetRmbSc;

    @Column(name = "ccam_det_acc_pre")
    private String ccamDetAccPre;

    @Column(name = "ccam_det_exo_tm")
    private String ccamDetExoTm;

    @Column(name = "ccam_det_grp")
    private String ccamDetGrp;

}
