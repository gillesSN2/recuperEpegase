package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_consultation_labo")
public class MedConsultationLabo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "csllab_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long csllabId;

    /**
     * code produit
     */
    @Column(name = "csllab_produit")
    private String csllabProduit;

    /**
     * libelle produit
     */
    @Column(name = "csllab_libelle")
    private String csllabLibelle;

    /**
     * observations
     */
    @Column(name = "csllab_obs")
    private String csllabObs;

    @Column(name = "csg_id", nullable = false)
    private Long csgId;

}
