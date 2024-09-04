package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_produits_acte")
public class CmmProduitsActe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "proact_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proactId;

    /**
     * hierarchie
     */
    @Column(name = "proact_hierarchie")
    private String proactHierarchie;

    /**
     * rang
     */
    @Column(name = "proact_rang")
    private String proactRang;

    /**
     * position
     */
    @Column(name = "proact_position")
    private String proactPosition;

    /**
     * y
     */
    @Column(name = "proact_y")
    private String proactY;

    /**
     * icr
     */
    @Column(name = "proactIcr")
    private String proactIcr;

    /**
     * para
     */
    @Column(name = "proact_para")
    private String proactPara;

    /**
     * A
     */
    @Column(name = "proact_a")
    private String proactA;

    /**
     * B
     */
    @Column(name = "proact_b")
    private String proactB;

    /**
     * CC
     */
    @Column(name = "proact_cc")
    private String proactCc;

    /**
     * score
     */
    @Column(name = "proact_scrore")
    private String proactScrore;

    /**
     * observation
     */
    @Column(name = "proact_observations")
    private String proactObservations;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

}
