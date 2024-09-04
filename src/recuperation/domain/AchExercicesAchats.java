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
@Table(name = "ach_exercices_achats")
public class AchExercicesAchats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    /**
     * date de creation
     */
    @Column(name = "exeach_date_creat")
    private LocalDateTime exeachDateCreat;

    /**
     * date de modification
     */
    @Column(name = "exeach_date_modif")
    private LocalDateTime exeachDateModif;

    /**
     * date de cloture
     */
    @Column(name = "exeach_date_cloture")
    private LocalDateTime exeachDateCloture;

    /**
     * user de creation
     */
    @Column(name = "exeach_user_creat")
    private Long exeachUserCreat = 0L;

    /**
     * user de cloture
     */
    @Column(name = "exeach_user_cloture")
    private Long exeachUserCloture = 0L;

    /**
     * user de modification
     */
    @Column(name = "exeach_user_modif")
    private Long exeachUserModif = 0L;

    /**
     * date debut exercice
     */
    @Column(name = "exeach_date_debut")
    private LocalDate exeachDateDebut;

    /**
     * date fin exercice
     */
    @Column(name = "exeach_date_fin")
    private LocalDate exeachDateFin;

    /**
     * etat 0=en cours 1=cloture
     */
    @Column(name = "exeach_etat")
    private Integer exeachEtat = 0;

}
