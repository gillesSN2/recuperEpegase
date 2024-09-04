package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_taxes_achats")
public class AchTaxesAchats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "taxach_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taxachId;

    /**
     * date de creation
     */
    @Column(name = "taxach_date_creation")
    private LocalDateTime taxachDateCreation;

    /**
     * date de modification
     */
    @Column(name = "taxach_date_modif")
    private LocalDateTime taxachDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "taxach_user_creation")
    private Long taxachUserCreation = 0L;

    /**
     * utilisateur de creation
     */
    @Column(name = "taxach_user_modif")
    private Long taxachUserModif = 0L;

    /**
     * code de la taxe
     */
    @Column(name = "tacach_code")
    private String tacachCode;

    /**
     * nom de la taxe en FR
     */
    @Column(name = "taxach_libelle_fr")
    private String taxachLibelleFr;

    /**
     * nom de la taxe en UK
     */
    @Column(name = "taxach_libelle_uk")
    private String taxachLibelleUk;

    /**
     * nom de la taxe en SP
     */
    @Column(name = "taxach_libelle_sp")
    private String taxachLibelleSp;

    /**
     * taux de la taxe
     */
    @Column(name = "taxach_taux")
    private Float taxachTaux = 0F;

    /**
     * numero de compte
     */
    @Column(name = "taxach_compte")
    private String taxachCompte;

    /**
     * 0=tva sur bien 1=tva sur prestation
     */
    @Column(name = "taxach_type")
    private Integer taxachType = 0;

    /**
     * 0=sans timbre sur achat 1=timbre achat paye par fournisseur 2=timbre achat paye par societe
     */
    @Column(name = "taxach_timbre")
    private Integer taxachTimbre = 0;

    /**
     * 0=sans taxe complementaire 1=avec taxe complementaire 2=avec taxe egalisation
     */
    @Column(name = "taxach_tc")
    private Integer taxachTc = 0;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "taxach_inactif")
    private Integer taxachInactif = 0;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

}
