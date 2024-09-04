package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_groupe_chrono")
public class CmmGroupeChrono implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "grpchr_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grpchrId;

    /**
     * date de creation
     */
    @Column(name = "grpchr_date_creat")
    private LocalDateTime grpchrDateCreat;

    /**
     * date de modification
     */
    @Column(name = "grpchr_date_modif")
    private LocalDateTime grpchrDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "grpchr_user_creat")
    private Long grpchrUserCreat = 0L;

    /**
     * utilisateur de creation
     */
    @Column(name = "grpchr_user_modif")
    private Long grpchrUserModif = 0L;

    /**
     * code serie
     */
    @Column(name = "grpchr_serie")
    private String grpchrSerie;

    /**
     * libelle serie
     */
    @Column(name = "grpchr_lib")
    private String grpchrLib;

    /**
     * code nature
     */
    @Column(name = "grpchr_nature")
    private Integer grpchrNature = 0;

    /**
     * 0=valide a l impression 1=valide a l enregistrement 2=sur bouton
     */
    @Column(name = "grpchr_validation")
    private Integer grpchrValidation = 0;

    /**
     * 0=devalidation interdite 1=devalidation autorisee
     */
    @Column(name = "grpchr_devalidation")
    private Integer grpchrDevalidation = 0;

    /**
     * 0=dupplication interdite 1=dupplication autorisee
     */
    @Column(name = "grpchr_dupplication")
    private Integer grpchrDupplication = 0;

    /**
     * mise ÃƒÂ  jour autorisee 1=mise ÃƒÂ  jour interdite
     */
    @Column(name = "grpchr_update")
    private Integer grpchrUpdate = 0;

    /**
     * 0=public 1=prive
     */
    @Column(name = "grpchr_prive")
    private Integer grpchrPrive = 0;

    @Column(name = "grp_id", nullable = false)
    private Long grpId;

}
