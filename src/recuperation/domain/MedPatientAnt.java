package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "med_patient_ant")
public class MedPatientAnt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "patant_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patantId;

    /**
     * date de creation
     */
    @Column(name = "patant_date_creat")
    private LocalDate patantDateCreat;

    /**
     * date de modification
     */
    @Column(name = "patant_date_modif")
    private LocalDate patantDateModif;

    /**
     * user de creation
     */
    @Column(name = "patant_user_creat")
    private Long patantUserCreat = 0L;

    /**
     * user de modification
     */
    @Column(name = "patant_user_modif")
    private Long patantUserModif = 0L;

    /**
     * nom du medecin qui note
     */
    @Column(name = "patant_medecin")
    private String patantMedecin;

    /**
     * date de l antecedent
     */
    @Column(name = "patant_date")
    private LocalDate patantDate;

    /**
     * code famille antecedent
     */
    @Column(name = "patant_code")
    private String patantCode;

    /**
     * famille antecedent
     */
    @Column(name = "patant_famille")
    private String patantFamille;

    /**
     * etat antecedent
     */
    @Column(name = "patant_etat")
    private String patantEtat;

    /**
     * observation antecedent
     */
    @Column(name = "patant_observation")
    private String patantObservation;

    /**
     * numero consultation general
     */
    @Column(name = "patant_num_consult_gene")
    private String patantNumConsultGene;

    /**
     * numero consultation specialisee
     */
    @Column(name = "patant_num_consult_Spe")
    private String patantNumConsultSpe;

    @Column(name = "pat_id", nullable = false)
    private Long patId;

}
