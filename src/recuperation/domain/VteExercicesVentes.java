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
@Table(name = "vte_exercices_ventes")
public class VteExercicesVentes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    /**
     * date de creation
     */
    @Column(name = "exevte_date_creat")
    private LocalDateTime exevteDateCreat;

    /**
     * date de modification
     */
    @Column(name = "exevte_date_modif")
    private LocalDateTime exevteDateModif;

    /**
     * date de cloture
     */
    @Column(name = "exevte_date_cloture")
    private LocalDateTime exevteDateCloture;

    /**
     * user de creation
     */
    @Column(name = "exevte_user_creat")
    private Long exevteUserCreat = 0L;

    /**
     * user de cloture
     */
    @Column(name = "exevte_user_cloture")
    private Long exevteUserCloture = 0L;

    /**
     * user de modification
     */
    @Column(name = "exevte_user_modif")
    private Long exevteUserModif = 0L;

    /**
     * date debut exercice
     */
    @Column(name = "exevte_date_debut")
    private LocalDate exevteDateDebut;

    /**
     * date fin exercice
     */
    @Column(name = "exevte_date_fin")
    private LocalDate exevteDateFin;

    /**
     * etat 0=en cours 1=cloture
     */
    @Column(name = "exevte_etat")
    private Integer exevteEtat = 0;

}
