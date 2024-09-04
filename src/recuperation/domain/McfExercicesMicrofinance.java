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
@Table(name = "mcf_exercices_microfinance")
public class McfExercicesMicrofinance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "exemcf_id", nullable = false)
    private Long exemcfId;

    /**
     * date de creation
     */
    @Column(name = "exemcf_date_creat")
    private LocalDateTime exemcfDateCreat;

    /**
     * date de modification
     */
    @Column(name = "exemcf_date_modif")
    private LocalDateTime exemcfDateModif;

    /**
     * date de cloture
     */
    @Column(name = "exemcf_date_cloture")
    private LocalDateTime exemcfDateCloture;

    /**
     * user de creation
     */
    @Column(name = "exemcf_user_creat")
    private Long exemcfUserCreat = 0L;

    /**
     * user de cloture
     */
    @Column(name = "exemcf_user_cloture")
    private Long exemcfUserCloture = 0L;

    /**
     * user de modification
     */
    @Column(name = "exemcf_user_modif")
    private Long exemcfUserModif = 0L;

    /**
     * date debut exercice
     */
    @Column(name = "exemcf_date_debut")
    private LocalDate exemcfDateDebut;

    /**
     * date fin exercice
     */
    @Column(name = "exemcf_date_fin")
    private LocalDate exemcfDateFin;

    /**
     * etat 0=en cours 1=cloture
     */
    @Column(name = "exemcf_etat")
    private Integer exemcfEtat = 0;

}
