package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_taxes_medical")
public class MedTaxesMedical implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "taxmed_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taxmedId;

    /**
     * date de creation
     */
    @Column(name = "taxmed_date_creation")
    private LocalDateTime taxmedDateCreation;

    /**
     * date de modification
     */
    @Column(name = "taxmed_date_modif")
    private LocalDateTime taxmedDateModif;

    /**
     * user de creation
     */
    @Column(name = "taxmed_user_creation")
    private Long taxmedUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "taxmed_user_modif")
    private Long taxmedUserModif;

    /**
     * code de la taxe
     */
    @Column(name = "taxmed_code")
    private String taxmedCode;

    /**
     * libelle de la taxe FR
     */
    @Column(name = "taxmed_libelle_FR")
    private String taxmedLibelleFr;

    /**
     * libelle de la taxe UK
     */
    @Column(name = "taxmed_libelle_UK")
    private String taxmedLibelleUk;

    /**
     * libelle de la taxe SP
     */
    @Column(name = "taxmed_libelle_SP")
    private String taxmedLibelleSp;

    /**
     * taux de la taxe
     */
    @Column(name = "taxmed_taux")
    private Float taxmedTaux = 0F;

    /**
     * numero de compte
     */
    @Column(name = "taxmed_compte")
    private String taxmedCompte;

    /**
     * 0=tva sur biens 1=tva sur prestations 2=brs sur prestations
     */
    @Column(name = "taxmed_type")
    private Integer taxmedType = 0;

    /**
     * 0=sans timbre 1=timbre paye par le fournisseur 2=timbre non payee par le fournisseur
     */
    @Column(name = "taxmed_timbre")
    private Integer taxmedTimbre = 0;

    /**
     * 0=sans taxe complementaire 1=avec centimes additionnels 2=avec taxe egalisation
     */
    @Column(name = "taxmed_tc")
    private Integer taxmedTc = 0;

    /**
     * 1=inactif 2=supprimer
     */
    @Column(name = "taxmed_inactif")
    private Integer taxmedInactif = 0;

    @Column(name = "exemed_id", nullable = false)
    private Long exemedId;

    @Column(name = "exevte_id")
    private Long exevteId;

}
