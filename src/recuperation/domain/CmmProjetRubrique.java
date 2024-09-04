package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_projet_rubrique")
public class CmmProjetRubrique implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prorub_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prorubId;

    @Column(name = "prorub_code")
    private String prorubCode;

    @Column(name = "prorub_libelle_FR")
    private String prorubLibelleFr;

    @Column(name = "prorub_libelle_UK")
    private String prorubLibelleUk;

    @Column(name = "prorub_libelle_SP")
    private String prorubLibelleSp;

    @Column(name = "prorub_montant_origine")
    private Double prorubMontantOrigine;

    @Column(name = "prorub_devise")
    private String prorubDevise;

    @Column(name = "prorub_coef_euro")
    private Float prorubCoefEuro;

    @Column(name = "prorub_montant_euro")
    private Double prorubMontantEuro;

    @Column(name = "prorub_coef_pays")
    private Float prorubCoefPays;

    @Column(name = "prorub_montant_pays")
    private Double prorubMontantPays;

    @Column(name = "prorub_total_origine")
    private Double prorubTotalOrigine;

    @Column(name = "prorub_total_euro")
    private Double prorubTotalEuro;

    @Column(name = "prorub_total_pays")
    private Double prorubTotalPays;

    @Column(name = "prorub_solde_origine")
    private Double prorubSoldeOrigine;

    @Column(name = "prorub_solde_euro")
    private Double prorubSoldeEuro;

    @Column(name = "prorub_solde_pays")
    private Double prorubSoldePays;

    @Column(name = "prorub_type")
    private Integer prorubType;

    @Column(name = "propos_id", nullable = false)
    private Long proposId;

}
