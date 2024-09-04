package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cpt_plan_tresorerie")
public class CptPlanTresorerie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "tre_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long treId;

    /**
     * date de creation
     */
    @Column(name = "tre_date_creat")
    private LocalDateTime treDateCreat;

    /**
     * date de modification
     */
    @Column(name = "tre_date_modif")
    private LocalDateTime treDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "plb_user_creat")
    private Long plbUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "plb_user_modif")
    private Long plbUserModif = 0L;

    /**
     * Annee du budget
     */
    @Column(name = "tre_annee")
    private String treAnnee;

    /**
     * code du budget
     */
    @Column(name = "tre_code")
    private String treCode;

    /**
     * libelle du budget en FR
     */
    @Column(name = "tre_libelle_FR")
    private String treLibelleFr;

    /**
     * libelle du budget en UK
     */
    @Column(name = "tre_libelle_UK")
    private String treLibelleUk;

    /**
     * libelle du budget en SP
     */
    @Column(name = "tre_libelle_SP")
    private String treLibelleSp;

    /**
     * code projet
     */
    @Column(name = "tre_projet")
    private String treProjet;

    /**
     * ordre des elements
     */
    @Column(name = "tre_ordre")
    private Integer treOrdre = 0;

    /**
     * 0=encaissement 1=decaissement
     */
    @Column(name = "tre_type")
    private Integer treType = 0;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "tre_inactif")
    private Integer treInactif = 0;

    @Column(name = "execpt_id", nullable = false)
    private Long execptId;

    /**
     * liste des users autorises
     */
    @Column(name = "tre_id_users")
    private String treIdUsers;

    /**
     * compte
     */
    @Column(name = "tre_compte")
    private String treCompte;

    /**
     * libelle du compte
     */
    @Column(name = "tre_libelle_compte")
    private String treLibelleCompte;

}
