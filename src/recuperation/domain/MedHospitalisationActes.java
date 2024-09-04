package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_hospitalisation_actes")
public class MedHospitalisationActes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "hosact_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hosactId;

    /**
     * id medecin
     */
    @Column(name = "hosact_id_medecin")
    private Long hosactIdMedecin = 0L;

    /**
     * nom medecin
     */
    @Column(name = "hosact_medecin")
    private String hosactMedecin;

    /**
     * service
     */
    @Column(name = "hosact_service")
    private String hosactService;

    /**
     * code produit
     */
    @Column(name = "hosact_produit")
    private String hosactProduit;

    /**
     * libelle produit
     */
    @Column(name = "hosact_libelle")
    private String hosactLibelle;

    /**
     * code lettre
     */
    @Column(name = "hosact_lettre")
    private String hosactLettre;

    /**
     * nombre lettre
     */
    @Column(name = "hosact_nb")
    private Float hosactNb = 0F;

    /**
     * valeur lettre
     */
    @Column(name = "hosact_valeur")
    private Double hosactValeur = 0D;

    /**
     * coefficient
     */
    @Column(name = "hosact_coef")
    private Float hosactCoef = 0F;

    /**
     * prix unitaire
     */
    @Column(name = "hosact_pu")
    private Double hosactPu = 0D;

    /**
     * code de tva
     */
    @Column(name = "hosact_code_tva")
    private String hosactCodeTva;

    /**
     * taux de tva
     */
    @Column(name = "hosact_taux_tva")
    private Float hosactTauxTva = 0F;

    /**
     * %remise
     */
    @Column(name = "hosact_remise")
    private Float hosactRemise = 0F;

    /**
     * prix apres remise
     */
    @Column(name = "hosact_pu_rem")
    private Double hosactPuRem = 0D;

    /**
     * quantite
     */
    @Column(name = "hosact_qte")
    private Float hosactQte = 0F;

    /**
     * part ht patient
     */
    @Column(name = "hosact_patient_ht")
    private Double hosactPatientHt = 0D;

    /**
     * part taxe patient
     */
    @Column(name = "hosact_patient_taxe")
    private Double hosactPatientTaxe = 0D;

    /**
     * part ht societe
     */
    @Column(name = "hosact_societe_ht")
    private Double hosactSocieteHt = 0D;

    /**
     * part taxe societe
     */
    @Column(name = "hosact_societe_taxe")
    private Double hosactSocieteTaxe = 0D;

    /**
     * part ht assurance
     */
    @Column(name = "hosact_assurance_ht")
    private Double hosactAssuranceHt = 0D;

    /**
     * part taxe assurance
     */
    @Column(name = "hosact_assurance_taxe")
    private Double hosactAssuranceTaxe = 0D;

    /**
     * part ht comllementaire
     */
    @Column(name = "hosact_complementaire_ht")
    private Double hosactComplementaireHt = 0D;

    /**
     * part taxe complementaire
     */
    @Column(name = "hosact_complementaire_taxe")
    private Double hosactComplementaireTaxe = 0D;

    /**
     * total ht
     */
    @Column(name = "hosact_total")
    private Double hosactTotal = 0D;

    /**
     * total taxe
     */
    @Column(name = "hosact_taxe")
    private Double hosactTaxe = 0D;

    /**
     * id sejour
     */
    @Column(name = "hosact_id_sejour")
    private Long hosactIdSejour = 0L;

    @Column(name = "hos_id", nullable = false)
    private Long hosId;

}
