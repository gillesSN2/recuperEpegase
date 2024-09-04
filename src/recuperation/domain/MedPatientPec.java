package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "med_patient_pec")
public class MedPatientPec implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "patpec_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patpecId;

    /**
     * assurance, societe ou complementaire
     */
    @Column(name = "patpec_num_type")
    private String patpecNumType;

    /**
     * numero de contrat de l assurance
     */
    @Column(name = "patpec_num_contrat")
    private String patpecNumContrat;

    /**
     * dat de debut de prise en charge
     */
    @Column(name = "patpec_date_debut")
    private LocalDate patpecDateDebut;

    /**
     * dat de fin de prise en charge
     */
    @Column(name = "patpec_date_fin")
    private LocalDate patpecDateFin;

    /**
     * montant du planfond pour l hebergement
     */
    @Column(name = "patpec_hebergement_plaf")
    private Double patpecHebergementPlaf = 0D;

    /**
     * % remboursement hebergement
     */
    @Column(name = "patpec_hebergement_rep")
    private Float patpecHebergementRep = 0F;

    /**
     * % remboursement des soins
     */
    @Column(name = "patpec_soins")
    private Float patpecSoins = 0F;

    /**
     * % remboursement des actes et examens
     */
    @Column(name = "patpec_examenss")
    private Float patpecExamenss = 0F;

    /**
     * % remboursement des autres prestations
     */
    @Column(name = "patpec_prestations")
    private Float patpecPrestations = 0F;

    /**
     * % remboursement soins dentaires
     */
    @Column(name = "patpec_dentaire")
    private Float patpecDentaire = 0F;

    /**
     * % remboursement soins occulaires
     */
    @Column(name = "patpec_occulaire")
    private Float patpecOcculaire = 0F;

    /**
     * % remboursement medicaments
     */
    @Column(name = "patpec_medicament")
    private Float patpecMedicament = 0F;

    /**
     * % remboursement de l hotelerie
     */
    @Column(name = "patpac_hotelerie")
    private Float patpacHotelerie = 0F;

    /**
     * montant remboursement forfaitaire
     */
    @Column(name = "patpec_forfait")
    private Float patpecForfait = 0F;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "patpec_inactif")
    private Integer patpecInactif = 0;

    /**
     * numero de securite sociale
     */
    @Column(name = "patpec_num_cnss")
    private String patpecNumCnss;

    /**
     * numero de couverture
     */
    @Column(name = "patpec_num_couvert")
    private String patpecNumCouvert;

    /**
     * matricvule agent de couverture
     */
    @Column(name = "patpec_agent_Refact")
    private String patpecAgentRefact;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "pat_id", nullable = false)
    private Long patId;

}
