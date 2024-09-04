package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_hospitalisation_labo")
public class MedHospitalisationLabo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "hoslab_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hoslabId;

    /**
     * id medecin
     */
    @Column(name = "hoslab_id_medecin")
    private Long hoslabIdMedecin = 0L;

    /**
     * nom medecin
     */
    @Column(name = "hoslab_medecin")
    private String hoslabMedecin;

    /**
     * service
     */
    @Column(name = "hoslab_service")
    private String hoslabService;

    /**
     * code produit
     */
    @Column(name = "hoslab_produit")
    private String hoslabProduit;

    /**
     * libelle produit
     */
    @Column(name = "hoslab_libelle")
    private String hoslabLibelle;

    /**
     * code lettre
     */
    @Column(name = "hoslab_lettre")
    private String hoslabLettre;

    /**
     * nombre lettre
     */
    @Column(name = "hoslab_nb")
    private Float hoslabNb = 0F;

    /**
     * valeur lettre
     */
    @Column(name = "hoslab_valeur")
    private Double hoslabValeur = 0D;

    /**
     * coefficient
     */
    @Column(name = "hoslab_coef")
    private Float hoslabCoef = 0F;

    /**
     * prix unitaire
     */
    @Column(name = "hoslab_pu")
    private Double hoslabPu = 0D;

    /**
     * code de tva
     */
    @Column(name = "hoslab_code_tva")
    private String hoslabCodeTva;

    /**
     * taux de tva
     */
    @Column(name = "hoslab_taux_tva")
    private Float hoslabTauxTva = 0F;

    /**
     * %remise
     */
    @Column(name = "hoslab_remise")
    private Float hoslabRemise = 0F;

    /**
     * prix apres remise
     */
    @Column(name = "hoslab_pu_rem")
    private Double hoslabPuRem = 0D;

    /**
     * quantite
     */
    @Column(name = "hoslab_qte")
    private Float hoslabQte = 0F;

    /**
     * part ht patient
     */
    @Column(name = "hoslab_patient_ht")
    private Double hoslabPatientHt = 0D;

    /**
     * part taxe patient
     */
    @Column(name = "hoslab_patient_taxe")
    private Double hoslabPatientTaxe = 0D;

    /**
     * part ht societe
     */
    @Column(name = "hoslab_societe_ht")
    private Double hoslabSocieteHt = 0D;

    /**
     * part taxe societe
     */
    @Column(name = "hoslab_societe_taxe")
    private Double hoslabSocieteTaxe = 0D;

    /**
     * part ht assurance
     */
    @Column(name = "hoslab_assurance_ht")
    private Double hoslabAssuranceHt = 0D;

    /**
     * part taxe assurance
     */
    @Column(name = "hoslab_assurance_taxe")
    private Double hoslabAssuranceTaxe = 0D;

    /**
     * part ht comllementaire
     */
    @Column(name = "hoslab_complementaire_ht")
    private Double hoslabComplementaireHt = 0D;

    /**
     * part taxe complementaire
     */
    @Column(name = "hoslab_complementaire_taxe")
    private Double hoslabComplementaireTaxe = 0D;

    /**
     * total ht
     */
    @Column(name = "hoslab_total")
    private Double hoslabTotal = 0D;

    /**
     * total taxe
     */
    @Column(name = "hoslab_taxe")
    private Double hoslabTaxe = 0D;

    /**
     * id sejour
     */
    @Column(name = "hoslab_id_sejour")
    private Long hoslabIdSejour = 0L;

    @Column(name = "hos_id", nullable = false)
    private Long hosId;

}
