package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_projet_bailleur")
public class CmmProjetBailleur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "probai_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long probaiId;

    @Column(name = "probai_nom_bailleur")
    private String probaiNomBailleur;

    @Column(name = "probai_montant_origine")
    private Double probaiMontantOrigine;

    @Column(name = "probai_devise")
    private String probaiDevise;

    @Column(name = "probai_coef_euro")
    private Float probaiCoefEuro;

    @Column(name = "parbai_montant_euro")
    private Double parbaiMontantEuro;

    @Column(name = "probai_coef_pays")
    private Float probaiCoefPays;

    @Column(name = "probai_montant_pays")
    private Double probaiMontantPays;

    @Column(name = "probai_repart")
    private Float probaiRepart;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

    @Column(name = "str_id", nullable = false)
    private Long strId;

}
