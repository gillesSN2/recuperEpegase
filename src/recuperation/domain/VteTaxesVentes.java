package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_taxes_ventes")
public class VteTaxesVentes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "taxvte_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taxvteId;

    /**
     * date de creation
     */
    @Column(name = "taxvte_date_creation")
    private LocalDateTime taxvteDateCreation;

    /**
     * date de modification
     */
    @Column(name = "taxvte_date_modif")
    private LocalDateTime taxvteDateModif;

    /**
     * user de creation
     */
    @Column(name = "taxvte_user_creation")
    private Long taxvteUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "taxvte_user_modif")
    private Long taxvteUserModif = 0L;

    /**
     * code de la taxe
     */
    @Column(name = "taxvte_code")
    private String taxvteCode;

    /**
     * libelle de la taxe FR
     */
    @Column(name = "taxvte_libelle_FR")
    private String taxvteLibelleFr;

    /**
     * libelle de la taxe UK
     */
    @Column(name = "taxvte_libelle_UK")
    private String taxvteLibelleUk;

    /**
     * libelle de la taxe SP
     */
    @Column(name = "taxvte_libelle_SP")
    private String taxvteLibelleSp;

    /**
     * taux de la taxe
     */
    @Column(name = "taxvte_taux")
    private Float taxvteTaux = 0F;

    /**
     * numero de compte
     */
    @Column(name = "taxvte_compte")
    private String taxvteCompte;

    /**
     * 0=tva sur biens 1=tva sur prestations 2=brs sur prestations
     */
    @Column(name = "taxvte_type")
    private Integer taxvteType = 0;

    /**
     * 0=sans timbre 1=timbre paye par le client 2=timbre non paye par le client
     */
    @Column(name = "taxvte_timbre")
    private Integer taxvteTimbre = 0;

    /**
     * 0=sans taxe complementaire 1=avec centimes additionnels 2=avec taxe egalisation
     */
    @Column(name = "taxvte_tc")
    private Integer taxvteTc = 0;

    /**
     * 1=inactif 2=supprimer
     */
    @Column(name = "taxvte_inactif")
    private Integer taxvteInactif = 0;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

}
