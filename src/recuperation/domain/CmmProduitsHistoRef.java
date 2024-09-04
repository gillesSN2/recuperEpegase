package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cmm_produits_histo_ref")
public class CmmProduitsHistoRef implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prohrf_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prohrfId;

    /**
     * reference founisseur
     */
    @Column(name = "prohrf_reference")
    private String prohrfReference;

    /**
     * date de debut d utilisation
     */
    @Column(name = "prohrf_date_debut")
    private LocalDate prohrfDateDebut;

    /**
     * date de fin d utilisation
     */
    @Column(name = "prohrf_date_fin")
    private LocalDate prohrfDateFin;

    /**
     * observations
     */
    @Column(name = "prohrf_obs")
    private String prohrfObs;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

}
