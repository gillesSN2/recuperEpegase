package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_produits_medicamment")
public class MedProduitsMedicamment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "promdc_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promdcId;

    /**
     * user de creation
     */
    @Column(name = "promdc_user_creation")
    private Long promdcUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "promdc_user_modif")
    private Long promdcUserModif = 0L;

    /**
     * dat de ceration
     */
    @Column(name = "promdc_date_creation")
    private LocalDateTime promdcDateCreation;

    /**
     * date de modification
     */
    @Column(name = "promdc_date_modif")
    private LocalDateTime promdcDateModif;

    /**
     * code cip
     */
    @Column(name = "promdc_code_cip")
    private String promdcCodeCip;

    /**
     * dci du medicamment
     */
    @Column(name = "promdc_code_dci")
    private String promdcCodeDci;

    /**
     * dosage du medicamment
     */
    @Column(name = "promdc_dosage")
    private String promdcDosage;

    /**
     * nom du medicamment
     */
    @Column(name = "promdc_specialite")
    private String promdcSpecialite;

    /**
     * forme galenique du medicamment
     */
    @Column(name = "promdc_forme")
    private String promdcForme;

    /**
     * classe therapeutique du medicamment
     */
    @Column(name = "promdc_classe")
    private String promdcClasse;

    /**
     * prix du medicamment
     */
    @Column(name = "promdc_prix")
    private Double promdcPrix = 0D;

    /**
     * liste du medicamment
     */
    @Column(name = "promdc_liste")
    private String promdcListe;

    /**
     * laboratoire du medicamment
     */
    @Column(name = "promdc_laboratoire")
    private String promdcLaboratoire;

    /**
     * 0=medicamment 1=complement alimentaire 2=plante 3=hydratant cutane 4=homeopathie 5=veterinaire 6=parapharmacie
     */
    @Column(name = "promdc_type")
    private Integer promdcType = 0;

    /**
     * code cophase
     */
    @Column(name = "promdc_code_cophase")
    private String promdcCodeCophase;

}
