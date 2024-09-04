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
@Table(name = "cai_exercices_caisse")
public class CaiExercicesCaisse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "execai_id", nullable = false)
    private Long execaiId;

    /**
     * date de creation
     */
    @Column(name = "execai_date_creat")
    private LocalDateTime execaiDateCreat;

    /**
     * date de modification
     */
    @Column(name = "execai_date_modif")
    private LocalDateTime execaiDateModif;

    /**
     * date de cloture
     */
    @Column(name = "execai_date_cloture")
    private LocalDateTime execaiDateCloture;

    /**
     * user de creation
     */
    @Column(name = "execai_user_creat")
    private Long execaiUserCreat = 0L;

    /**
     * user de cloture
     */
    @Column(name = "execai_user_cloture")
    private Long execaiUserCloture = 0L;

    /**
     * user de modification
     */
    @Column(name = "execai_user_modif")
    private Long execaiUserModif = 0L;

    /**
     * date debut exercice
     */
    @Column(name = "execai_date_debut")
    private LocalDate execaiDateDebut;

    /**
     * date fin exercice
     */
    @Column(name = "execai_date_fin")
    private LocalDate execaiDateFin;

    /**
     * etat 0=en cours 1=cloture
     */
    @Column(name = "execai_etat")
    private Integer execaiEtat = 0;

}
