package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "mcf_taxes_microfinance")
public class McfTaxesMicrofinance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "taxmcf_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taxmcfId;

    @Column(name = "taxmcf_date_creation")
    private LocalDate taxmcfDateCreation;

    @Column(name = "taxmcf_date_modif")
    private LocalDate taxmcfDateModif;

    @Column(name = "taxmcf_user_creation")
    private Long taxmcfUserCreation;

    @Column(name = "taxmcf_user_modif")
    private Long taxmcfUserModif;

    @Column(name = "tacmcf_code")
    private String tacmcfCode;

    @Column(name = "taxmcf_libelle_fr")
    private String taxmcfLibelleFr;

    @Column(name = "taxmcf_libelle_uk")
    private String taxmcfLibelleUk;

    @Column(name = "taxmcf_libelle_sp")
    private String taxmcfLibelleSp;

    @Column(name = "taxmcf_taux")
    private Float taxmcfTaux;

    @Column(name = "taxmcf_compte")
    private String taxmcfCompte;

    @Column(name = "taxmcf_type")
    private Integer taxmcfType;

    @Column(name = "taxmcf_timbre")
    private Integer taxmcfTimbre;

    @Column(name = "taxmcf_tc")
    private Integer taxmcfTc;

    @Column(name = "taxmcf_inactif")
    private Integer taxmcfInactif;

    @Column(name = "exemcf_id", nullable = false)
    private Long exemcfId;

}
