package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cmm_projet")
public class CmmProjet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pro_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proId;

    @Column(name = "pro_user_creat")
    private Long proUserCreat;

    @Column(name = "pro_date_creat")
    private LocalDate proDateCreat;

    @Column(name = "pro_user_modif")
    private Long proUserModif;

    @Column(name = "pro_date_modif")
    private LocalDate proDateModif;

    @Column(name = "pro_code")
    private String proCode;

    @Column(name = "pro_nom_FR")
    private String proNomFr;

    @Column(name = "pro_nom_UK")
    private String proNomUk;

    @Column(name = "pro_nom_SP")
    private String proNomSp;

    @Column(name = "pro_description")
    private String proDescription;

    @Column(name = "pro_initiateur")
    private String proInitiateur;

    @Column(name = "pro_date_debut")
    private LocalDate proDateDebut;

    @Column(name = "pro_date_fin")
    private LocalDate proDateFin;

    @Column(name = "pro_montant_euro")
    private Double proMontantEuro;

    @Column(name = "pro_coef_pays")
    private Float proCoefPays;

    @Column(name = "pro_montant_pays")
    private Double proMontantPays;

    @Column(name = "pro_contexte")
    private String proContexte;

    @Column(name = "pro_objectif")
    private String proObjectif;

    @Column(name = "pro_inactif")
    private Integer proInactif;

    /**
     * id responsable
     */
    @Column(name = "pro_id_responsable")
    private Long proIdResponsable;

    /**
     * nom responsable
     */
    @Column(name = "pro_nom_responsable")
    private String proNomResponsable;

    /**
     * source
     */
    @Column(name = "pro_source")
    private String proSource;

    /**
     * duree du projet
     */
    @Column(name = "pro_duree")
    private Integer proDuree = 0;

    /**
     * valeur en devise
     */
    @Column(name = "pro_montant_devise")
    private Double proMontantDevise = 0D;

    /**
     * devise
     */
    @Column(name = "pro_devise")
    private String proDevise;

    /**
     * coef en euro
     */
    @Column(name = "pro_coef_euro")
    private Float proCoefEuro = 0F;

    /**
     * nombre de tranche
     */
    @Column(name = "pro_nb_tranche")
    private Integer proNbTranche = 0;

    /**
     * annee debut
     */
    @Column(name = "pro_annee")
    private String proAnnee;

    /**
     * date echeance
     */
    @Column(name = "pro_date_echeance")
    private String proDateEcheance;

    /**
     * montant echeance
     */
    @Column(name = "pro_montant_echeance")
    private String proMontantEcheance;

    /**
     * observation echeance
     */
    @Column(name = "pro_obs_echeance")
    private String proObsEcheance;

    /**
     * liste des utilisateurs autorises
     */
    @Column(name = "pro_id_users")
    private String proIdUsers;

    /**
     * date echeance debut
     */
    @Column(name = "pro_date_echeance_deb")
    private String proDateEcheanceDeb;

    /**
     * date echeance fin
     */
    @Column(name = "pro_date_echeance_fin")
    private String proDateEcheanceFin;

    /**
     * date debut de la convention
     */
    @Column(name = "pro_date_debut_convention")
    private LocalDate proDateDebutConvention;

    /**
     * date fin de la convention
     */
    @Column(name = "pro_date_fin_convention")
    private LocalDate proDateFinConvention;

}
