package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_users_objectifs")
public class CmmUsersObjectifs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "usrobj_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrobjId;

    /**
     * date de creation
     */
    @Column(name = "usrobj_date_creat")
    private LocalDateTime usrobjDateCreat;

    /**
     * date de modification
     */
    @Column(name = "usrobj_date_modif")
    private LocalDateTime usrobjDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "usrobj_user_creat")
    private Long usrobjUserCreat = 0L;

    /**
     * utilisateur de creation
     */
    @Column(name = "usrobj_user_modif")
    private Long usrobjUserModif = 0L;

    /**
     * 0=devis 1=bc 2=bl 3=br 4=facture 5=ndb 6=avoir 10=rdv
     */
    @Column(name = "usrobj_nature")
    private Integer usrobjNature = 0;

    /**
     * anne objectif
     */
    @Column(name = "usrobj_annee")
    private String usrobjAnnee;

    /**
     * objectif total
     */
    @Column(name = "usrobj_ca_total")
    private Double usrobjCaTotal = 0D;

    /**
     * objectif janvier
     */
    @Column(name = "usrobj_ca_01")
    private Double usrobjCa01 = 0D;

    /**
     * objectif fevrier
     */
    @Column(name = "usrobj_ca_02")
    private Double usrobjCa02 = 0D;

    /**
     * objectif mars
     */
    @Column(name = "usrobj_ca_03")
    private Double usrobjCa03 = 0D;

    /**
     * objectif avril
     */
    @Column(name = "usrobj_ca_04")
    private Double usrobjCa04 = 0D;

    /**
     * objectif mai
     */
    @Column(name = "usrobj_ca_05")
    private Double usrobjCa05 = 0D;

    /**
     * objectif juin
     */
    @Column(name = "usrobj_ca_06")
    private Double usrobjCa06 = 0D;

    /**
     * objectif juillet
     */
    @Column(name = "usrobj_ca_07")
    private Double usrobjCa07 = 0D;

    /**
     * objectif aout
     */
    @Column(name = "usrobj_ca_08")
    private Double usrobjCa08 = 0D;

    /**
     * objectif septembre
     */
    @Column(name = "usrobj_ca_09")
    private Double usrobjCa09 = 0D;

    /**
     * objectif octobre
     */
    @Column(name = "usrobj_ca_10")
    private Double usrobjCa10 = 0D;

    /**
     * objectif novembre
     */
    @Column(name = "usrobj_ca_11")
    private Double usrobjCa11 = 0D;

    /**
     * objectif decembre
     */
    @Column(name = "usrobj_ca_12")
    private Double usrobjCa12 = 0D;

    @Column(name = "usr_id", nullable = false)
    private Long usrId;

}
