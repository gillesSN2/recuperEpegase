package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_users_taches")
public class CmmUsersTaches implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "usrtac_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrtacId;

    /**
     * date de creation
     */
    @Column(name = "usrtac_date_creat")
    private LocalDateTime usrtacDateCreat;

    /**
     * date de modification
     */
    @Column(name = "usrtac_date_modif")
    private LocalDateTime usrtacDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "usrtac_user_creat")
    private Long usrtacUserCreat = 0L;

    /**
     * utilisateur de creation
     */
    @Column(name = "usrtac_user_modif")
    private Long usrtacUserModif = 0L;

    /**
     * code tache
     */
    @Column(name = "usrtac_code")
    private String usrtacCode;

    /**
     * libelle tache
     */
    @Column(name = "usrtac_lib")
    private String usrtacLib;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "usrtac_inactif")
    private Integer usrtacInactif = 0;

    /**
     * prix de revient de la tache
     */
    @Column(name = "usrtac_val_pr")
    private Float usrtacValPr = 0F;

    /**
     * prix de vente de la tache
     */
    @Column(name = "usrtac_val_pv")
    private Float usrtacValPv = 0F;

    @Column(name = "usr_id")
    private Long usrId;

}
