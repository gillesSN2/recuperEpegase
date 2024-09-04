package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prc_exercices_parc")
public class PrcExercicesParc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "exeprc_id", nullable = false)
    private Long exeprcId;

    /**
     * date de creation
     */
    @Column(name = "exeprc_date_creat")
    private LocalDateTime exeprcDateCreat;

    /**
     * date de modification
     */
    @Column(name = "exeprc_date_modif")
    private LocalDateTime exeprcDateModif;

    /**
     * date de cloture
     */
    @Column(name = "exeprc_date_cloture")
    private LocalDateTime exeprcDateCloture;

    /**
     * user de creation
     */
    @Column(name = "exeprc_user_creat")
    private Long exeprcUserCreat = 0L;

    /**
     * user de cloture
     */
    @Column(name = "exeprc_user_cloture")
    private Long exeprcUserCloture = 0L;

    /**
     * user de modification
     */
    @Column(name = "exeprc_user_modif")
    private Long exeprcUserModif = 0L;

    /**
     * date debut exercice
     */
    @Column(name = "exeprc_date_debut")
    private LocalDate exeprcDateDebut;

    /**
     * date fin exercice
     */
    @Column(name = "exeprc_date_fin")
    private LocalDate exeprcDateFin;

    /**
     * etat 0=en cours 1=cloture
     */
    @Column(name = "exeprc_etat")
    private Integer exeprcEtat = 0;

}
