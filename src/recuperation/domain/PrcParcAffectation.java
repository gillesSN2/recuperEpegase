package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prc_parc_affectation")
public class PrcParcAffectation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prcaff_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prcaffId;

    /**
     * date creation
     */
    @Column(name = "prcaff_date_creat")
    private LocalDateTime prcaffDateCreat;

    /**
     * date modification
     */
    @Column(name = "prcaff_date_modif")
    private LocalDateTime prcaffDateModif;

    /**
     * id user de creation
     */
    @Column(name = "prcaff_user_creat")
    private Long prcaffUserCreat = 0L;

    /**
     * id user de modification
     */
    @Column(name = "prcaff_user_modif")
    private Long prcaffUserModif = 0L;

    /**
     * 0=affectation 1=imputation 2=proprietaire
     */
    @Column(name = "prcaff_type")
    private Integer prcaffType;

    /**
     * matricule du salarie
     */
    @Column(name = "prcaff_mat_Salarie")
    private String prcaffMatSalarie;

    /**
     * nom du salarie
     */
    @Column(name = "prcaff_nom_salarie")
    private String prcaffNomSalarie;

    /**
     * prenom du salarie
     */
    @Column(name = "prcaff_prenom_salarie")
    private String prcaffPrenomSalarie;

    /**
     * code service
     */
    @Column(name = "prcaff_service")
    private String prcaffService;

    /**
     * libelle service
     */
    @Column(name = "prcaff_lib_service")
    private String prcaffLibService;

    /**
     * id du tiers
     */
    @Column(name = "prcaff_id_tiers")
    private Long prcaffIdTiers = 0L;

    /**
     * nom du tiers
     */
    @Column(name = "prcaff_nom_tiers")
    private String prcaffNomTiers;

    /**
     * contact du tiers
     */
    @Column(name = "prcaff_contact_tiers")
    private String prcaffContactTiers;

    /**
     * telephone du tiers
     */
    @Column(name = "prcaff_tel_tiers")
    private String prcaffTelTiers;

    /**
     * ville du tiers
     */
    @Column(name = "prcaff_ville_tiers")
    private String prcaffVilleTiers;

    /**
     * adresse du tiers
     */
    @Column(name = "prcaff_adresse_tiers")
    private String prcaffAdresseTiers;

    /**
     * date debut
     */
    @Column(name = "prcaff_date_debut")
    private LocalDate prcaffDateDebut;

    /**
     * date fin
     */
    @Column(name = "prcaff_date_fin")
    private LocalDate prcaffDateFin;

    @Column(name = "prc_id")
    private Long prcId;

}
