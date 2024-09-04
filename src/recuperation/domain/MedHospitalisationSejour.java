package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "med_hospitalisation_sejour")
public class MedHospitalisationSejour implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "hossej_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hossejId;

    /**
     * id medecin
     */
    @Column(name = "hossej_id_medecin")
    private Long hossejIdMedecin = 0L;

    /**
     * nom medecin
     */
    @Column(name = "hossej_medecin")
    private String hossejMedecin;

    /**
     * service
     */
    @Column(name = "hossej_service")
    private String hossejService;

    /**
     * code lit
     */
    @Column(name = "hossej_lit")
    private String hossejLit;

    /**
     * libelle produit
     */
    @Column(name = "hossej_libelle")
    private String hossejLibelle;

    /**
     * date entree
     */
    @Column(name = "hossej_date_entree")
    private LocalDate hossejDateEntree;

    /**
     * date sortie
     */
    @Column(name = "hossej_date_sortie")
    private LocalDate hossejDateSortie;

    /**
     * nombre de jour
     */
    @Column(name = "hossej_nb_jour")
    private Integer hossejNbJour = 0;

    /**
     * motid entree fichier xml
     */
    @Column(name = "hossej_motif_entree")
    private String hossejMotifEntree;

    /**
     * provenance
     */
    @Column(name = "hossej_provenance")
    private String hossejProvenance;

    /**
     * motid sortie fichier xml
     */
    @Column(name = "hossej_motif_sortie")
    private String hossejMotifSortie;

    /**
     * destination
     */
    @Column(name = "hossej_destination")
    private String hossejDestination;

    /**
     * prix unitaire
     */
    @Column(name = "hossej_pu")
    private Double hossejPu = 0D;

    /**
     * code de tva
     */
    @Column(name = "hossej_code_tva")
    private String hossejCodeTva;

    /**
     * taux de tva
     */
    @Column(name = "hossej_taux_tva")
    private Float hossejTauxTva = 0F;

    /**
     * %remise
     */
    @Column(name = "hossej_remise")
    private Float hossejRemise = 0F;

    /**
     * prix apres remise
     */
    @Column(name = "hossej_pu_rem")
    private Double hossejPuRem = 0D;

    /**
     * quantite
     */
    @Column(name = "hossej_qte")
    private Float hossejQte = 0F;

    /**
     * part ht patient
     */
    @Column(name = "hossej_patient_ht")
    private Double hossejPatientHt = 0D;

    /**
     * part taxe patient
     */
    @Column(name = "hossej_patient_taxe")
    private Double hossejPatientTaxe = 0D;

    /**
     * part ht societe
     */
    @Column(name = "hossej_societe_ht")
    private Double hossejSocieteHt = 0D;

    /**
     * part taxe societe
     */
    @Column(name = "hossej_societe_taxe")
    private Double hossejSocieteTaxe = 0D;

    /**
     * part ht assurance
     */
    @Column(name = "hossej_assurance_ht")
    private Double hossejAssuranceHt = 0D;

    /**
     * part taxe assurance
     */
    @Column(name = "hossej_assurance_taxe")
    private Double hossejAssuranceTaxe = 0D;

    /**
     * part ht comllementaire
     */
    @Column(name = "hossej_complementaire_ht")
    private Double hossejComplementaireHt = 0D;

    /**
     * part taxe complementaire
     */
    @Column(name = "hossej_complementaire_taxe")
    private Double hossejComplementaireTaxe = 0D;

    /**
     * total ht
     */
    @Column(name = "hossej_total")
    private Double hossejTotal = 0D;

    /**
     * total taxe
     */
    @Column(name = "hossej_taxe")
    private Double hossejTaxe = 0D;

    /**
     * code diagnostic principal
     */
    @Column(name = "hossej_code_diag1")
    private String hossejCodeDiag1;

    /**
     * code diagnostic relie
     */
    @Column(name = "hossej_code_diag2")
    private String hossejCodeDiag2;

    /**
     * code diagnostic associe 1
     */
    @Column(name = "hossej_code_diag11")
    private String hossejCodeDiag11;

    /**
     * code diagnostic associe 2
     */
    @Column(name = "hossej_code_diag12")
    private String hossejCodeDiag12;

    /**
     * code diagnostic associe 3
     */
    @Column(name = "hossej_code_diag13")
    private String hossejCodeDiag13;

    /**
     * code diagnostic associe 4
     */
    @Column(name = "hossej_code_diag14")
    private String hossejCodeDiag14;

    /**
     * code diagnostic associe 5
     */
    @Column(name = "hossej_code_diag15")
    private String hossejCodeDiag15;

    /**
     * poids entree pour les nourissons en gramme
     */
    @Column(name = "hossej_poids_entree")
    private Integer hossejPoidsEntree = 0;

    /**
     * indice de gravite isg
     */
    @Column(name = "hossej_indice_igs")
    private Integer hossejIndiceIgs = 0;

    /**
     * nombre de seances
     */
    @Column(name = "hossej_nb_seances")
    private Integer hossejNbSeances = 0;

    /**
     * true si hospit30 jours avant
     */
    @Column(name = "hossej_hospit_avant")
    private Boolean hossejHospitAvant = Boolean.FALSE;

    /**
     * true si duree moins de 48 heures
     */
    @Column(name = "hossej_hospit_48")
    private Boolean hossejHospit48 = Boolean.FALSE;

    /**
     * evolution
     */
    @Column(name = "hossej_evolution")
    private String hossejEvolution;

    /**
     * observation
     */
    @Column(name = "hossej_observation")
    private String hossejObservation;

    @Column(name = "hos_id", nullable = false)
    private Long hosId;

}
