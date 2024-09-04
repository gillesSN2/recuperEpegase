package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "med_exercices_medical")
public class MedExercicesMedical implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "exemed_id", nullable = false)
    private Long exemedId;

    /**
     * date de creation de l exercice
     */
    @Column(name = "exemed_date_creat")
    private LocalDate exemedDateCreat;

    /**
     * date de modification de l exercice
     */
    @Column(name = "exemed_date_modif")
    private LocalDate exemedDateModif;

    /**
     * date de cloture de l exercice
     */
    @Column(name = "exemed_date_cloture")
    private LocalDate exemedDateCloture;

    /**
     * utilisateur de creation de l exericce
     */
    @Column(name = "exemed_user_creat")
    private Long exemedUserCreat = 0L;

    /**
     * utilisateur qui a fait la cloture
     */
    @Column(name = "exemed_user_cloture")
    private Long exemedUserCloture = 0L;

    /**
     * utilisateur de modification de l exercice
     */
    @Column(name = "exemed_user_modif")
    private Long exemedUserModif = 0L;

    /**
     * date de debut de l exercice
     */
    @Column(name = "exemed_date_debut")
    private LocalDate exemedDateDebut;

    /**
     * date de fin de l exercice
     */
    @Column(name = "exemed_date_fin")
    private LocalDate exemedDateFin;

    /**
     * 0=exercice en cours 1=exercice cloture
     */
    @Column(name = "exemed_etat")
    private Integer exemedEtat = 0;

}
