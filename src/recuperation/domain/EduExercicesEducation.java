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
@Table(name = "edu_exercices_education")
public class EduExercicesEducation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "exeedu_id", nullable = false)
    private Long exeeduId;

    /**
     * date de creation de l exercice
     */
    @Column(name = "exeedu_date_creat")
    private LocalDate exeeduDateCreat;

    /**
     * date de modification de l exercice
     */
    @Column(name = "exeedu_date_modif")
    private LocalDate exeeduDateModif;

    /**
     * date de cloture de l exercice
     */
    @Column(name = "exeedu_date_cloture")
    private LocalDate exeeduDateCloture;

    /**
     * utilisateur de creation de l exericce
     */
    @Column(name = "exeedu_user_creat")
    private Long exeeduUserCreat = 0L;

    /**
     * utilisateur qui a fait la cloture
     */
    @Column(name = "exeedu_user_cloture")
    private Long exeeduUserCloture = 0L;

    /**
     * utilisateur de modification de l exercice
     */
    @Column(name = "exeedu_user_modif")
    private Long exeeduUserModif = 0L;

    /**
     * date de debut de l exercice
     */
    @Column(name = "exeedu_date_debut")
    private LocalDate exeeduDateDebut;

    /**
     * date de fin de l exercice
     */
    @Column(name = "exeedu_date_fin")
    private LocalDate exeeduDateFin;

    /**
     * 0=exercice en cours 1=exercice cloture
     */
    @Column(name = "exeedu_etat")
    private Integer exeeduEtat = 0;

}
