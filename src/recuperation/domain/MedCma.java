package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_cma")
public class MedCma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cma_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cmaId;

    /**
     * code cma
     */
    @Column(name = "cma_code")
    private String cmaCode;

    /**
     * libelle cma FR
     */
    @Column(name = "cma_libelle_FR")
    private String cmaLibelleFr;

    /**
     * libelle cma UK
     */
    @Column(name = "cma_libelle_UK")
    private String cmaLibelleUk;

    /**
     * libelle cma UK
     */
    @Column(name = "cma_libelle_SP")
    private String cmaLibelleSp;

    /**
     * cma
     */
    @Column(name = "cma_cma")
    private Integer cmaCma = 0;

    /**
     * cmas
     */
    @Column(name = "cma_cmas")
    private Integer cmaCmas = 0;

    /**
     * cmasnt
     */
    @Column(name = "cma_cmasnt")
    private Integer cmaCmasnt = 0;

}
