package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_produits_pharmacie")
public class CmmProduitsPharmacie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "propha_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prophaId;

    /**
     * forme therapeutique
     */
    @Column(name = "propha_therapeutique")
    private String prophaTherapeutique;

    /**
     * forme gelenique
     */
    @Column(name = "propha_galenique")
    private String prophaGalenique;

    /**
     * formule chimique ou dci
     */
    @Column(name = "propha_formule")
    private String prophaFormule;

    /**
     * position
     */
    @Column(name = "propha_position")
    private String prophaPosition;

    /**
     * tableau
     */
    @Column(name = "propha_tableau")
    private String prophaTableau;

    /**
     * shp
     */
    @Column(name = "propha_shp")
    private String prophaShp;

    /**
     * specialite mere
     */
    @Column(name = "propha_specialite")
    private String prophaSpecialite;

    /**
     * dosage
     */
    @Column(name = "propha_dosage")
    private String prophaDosage;

    /**
     * nom unite
     */
    @Column(name = "propha_unite")
    private String prophaUnite;

    /**
     * nb unites de prise
     */
    @Column(name = "propha_prise")
    private String prophaPrise;

    /**
     * marche
     */
    @Column(name = "propha_marche")
    private String prophaMarche;

    /**
     * origine
     */
    @Column(name = "propha_origine")
    private String prophaOrigine;

    /**
     * posologie
     */
    @Column(name = "propha_posologie")
    private String prophaPosologie;

    /**
     * observation
     */
    @Column(name = "propha_observations")
    private String prophaObservations;

    /**
     * laboratoire
     */
    @Column(name = "propha_laboratoire")
    private String prophaLaboratoire;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

}
