package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_consultation_ordo")
public class MedConsultationOrdo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cslord_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cslordId;

    /**
     * code produit
     */
    @Column(name = "cslord_produit")
    private String cslordProduit;

    /**
     * libelle produit
     */
    @Column(name = "cslord_libelle")
    private String cslordLibelle;

    /**
     * posologie
     */
    @Column(name = "cslord_poso")
    private String cslordPoso;

    /**
     * observations
     */
    @Column(name = "cslord_obs")
    private String cslordObs;

    @Column(name = "csg_id", nullable = false)
    private Long csgId;

    /**
     * dci
     */
    @Column(name = "cslord_dci")
    private String cslordDci;

    /**
     * forme
     */
    @Column(name = "cslord_forme")
    private String cslordForme;

}
