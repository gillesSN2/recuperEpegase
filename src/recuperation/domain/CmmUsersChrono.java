package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_users_chrono")
public class CmmUsersChrono implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "usrchr_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrchrId;

    /**
     * date de creation
     */
    @Column(name = "usrchr_date_creat")
    private LocalDateTime usrchrDateCreat;

    /**
     * date de modification
     */
    @Column(name = "usrchr_date_modif")
    private LocalDateTime usrchrDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "usrchr_user_creat")
    private Long usrchrUserCreat = 0L;

    /**
     * utilisateur de creation
     */
    @Column(name = "usrchr_user_modif")
    private Long usrchrUserModif = 0L;

    /**
     * code serie
     */
    @Column(name = "usrchr_serie")
    private String usrchrSerie;

    /**
     * libelle serie
     */
    @Column(name = "usrchr_lib")
    private String usrchrLib;

    /**
     * code nature
     */
    @Column(name = "usrchr_nature")
    private Integer usrchrNature = 0;

    /**
     * 0=valide a l impression 1=valide a l enregistrement 2=sur bouton
     */
    @Column(name = "usrchr_validation")
    private Integer usrchrValidation = 0;

    /**
     * 0=devalidation interdite 1=devalidation autorisee
     */
    @Column(name = "usrchr_devalidation")
    private Integer usrchrDevalidation = 0;

    /**
     * 0=dupplication interdite 1=dupplication autorisee
     */
    @Column(name = "usrchr_dupplication")
    private Integer usrchrDupplication = 0;

    /**
     * mise ÃƒÂ  jour autorisee 1=mise ÃƒÂ  jour interdite
     */
    @Column(name = "usrchr_update")
    private Integer usrchrUpdate = 0;

    /**
     * 0=public 1=prive
     */
    @Column(name = "usrchr_prive")
    private Integer usrchrPrive = 0;

    @Column(name = "usr_id", nullable = false)
    private Long usrId;

    /**
     * montant plafond de l operation
     */
    @Column(name = "usrchr_planfond")
    private String usrchrPlanfond;

    /**
     * 0=autorisee sans habilitation 1=autorisee avec habilitation 2=interdiction
     */
    @Column(name = "usrchr_mode")
    private String usrchrMode;

}
