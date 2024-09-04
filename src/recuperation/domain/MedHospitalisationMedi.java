package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_hospitalisation_medi")
public class MedHospitalisationMedi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "hosmed_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hosmedId;

    /**
     * id medecin
     */
    @Column(name = "hosmed_id_medecin")
    private Long hosmedIdMedecin = 0L;

    /**
     * nom medecin
     */
    @Column(name = "hosmed_medecin")
    private String hosmedMedecin;

    /**
     * service
     */
    @Column(name = "hosmed_service")
    private String hosmedService;

    /**
     * code produit
     */
    @Column(name = "hosmed_produit")
    private String hosmedProduit;

    /**
     * libelle produit
     */
    @Column(name = "hosmed_libelle")
    private String hosmedLibelle;

    /**
     * prix unitaire
     */
    @Column(name = "hosmed_pu")
    private Double hosmedPu = 0D;

    /**
     * code de tva
     */
    @Column(name = "hosmed_code_tva")
    private String hosmedCodeTva;

    /**
     * taux de tva
     */
    @Column(name = "hosmed_taux_tva")
    private Float hosmedTauxTva = 0F;

    /**
     * %remise
     */
    @Column(name = "hosmed_remise")
    private Float hosmedRemise = 0F;

    /**
     * prix apres remise
     */
    @Column(name = "hosmed_pu_rem")
    private Double hosmedPuRem = 0D;

    /**
     * code depot de stockage
     */
    @Column(name = "hosmed_depot")
    private String hosmedDepot;

    /**
     * quantite
     */
    @Column(name = "hosmed_qte")
    private Float hosmedQte = 0F;

    /**
     * part ht patient
     */
    @Column(name = "hosmed_patient_ht")
    private Double hosmedPatientHt = 0D;

    /**
     * part taxe patient
     */
    @Column(name = "hosmed_patient_taxe")
    private Double hosmedPatientTaxe = 0D;

    /**
     * part ht societe
     */
    @Column(name = "hosmed_societe_ht")
    private Double hosmedSocieteHt = 0D;

    /**
     * part taxe societe
     */
    @Column(name = "hosmed_societe_taxe")
    private Double hosmedSocieteTaxe = 0D;

    /**
     * part ht assurance
     */
    @Column(name = "hosmed_assurance_ht")
    private Double hosmedAssuranceHt = 0D;

    /**
     * part taxe assurance
     */
    @Column(name = "hosmed_assurance_taxe")
    private Double hosmedAssuranceTaxe = 0D;

    /**
     * part ht comllementaire
     */
    @Column(name = "hosmed_complementaire_ht")
    private Double hosmedComplementaireHt = 0D;

    /**
     * part taxe complementaire
     */
    @Column(name = "hosmed_complementaire_taxe")
    private Double hosmedComplementaireTaxe = 0D;

    /**
     * total ht
     */
    @Column(name = "hosmed_total")
    private Double hosmedTotal = 0D;

    /**
     * total taxe
     */
    @Column(name = "hosmed_taxe")
    private Double hosmedTaxe = 0D;

    /**
     * id sejour
     */
    @Column(name = "hosmed_id_sejour")
    private Long hosmedIdSejour = 0L;

    @Column(name = "hos_id", nullable = false)
    private Long hosId;

    /**
     * famille produit
     */
    @Column(name = "hosmed_famille")
    private String hosmedFamille;

    /**
     * pump
     */
    @Column(name = "hosmed_pump")
    private Double hosmedPump = 0D;

    /**
     * quantite en stock
     */
    @Column(name = "hosmed_stock")
    private Float hosmedStock = 0F;

}
