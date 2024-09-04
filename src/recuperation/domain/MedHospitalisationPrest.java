package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_hospitalisation_prest")
public class MedHospitalisationPrest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "hosprt_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hosprtId;

    /**
     * id medecin
     */
    @Column(name = "hosprt_id_medecin")
    private Long hosprtIdMedecin = 0L;

    /**
     * nom medecin
     */
    @Column(name = "hosprt_medecin")
    private String hosprtMedecin;

    /**
     * service
     */
    @Column(name = "hosprt_service")
    private String hosprtService;

    /**
     * code produit
     */
    @Column(name = "hosprt_produit")
    private String hosprtProduit;

    /**
     * libelle produit
     */
    @Column(name = "hosprt_libelle")
    private String hosprtLibelle;

    /**
     * code lettre
     */
    @Column(name = "hosprt_lettre")
    private String hosprtLettre;

    /**
     * nombre lettre
     */
    @Column(name = "hosprt_nb")
    private Float hosprtNb = 0F;

    /**
     * valeur lettre
     */
    @Column(name = "hosprt_valeur")
    private Double hosprtValeur = 0D;

    /**
     * coefficient
     */
    @Column(name = "hosprt_coef")
    private Float hosprtCoef = 0F;

    /**
     * prix unitaire
     */
    @Column(name = "hosprt_pu")
    private Double hosprtPu = 0D;

    /**
     * code de tva
     */
    @Column(name = "hosprt_code_tva")
    private String hosprtCodeTva;

    /**
     * taux de tva
     */
    @Column(name = "hosprt_taux_tva")
    private Float hosprtTauxTva = 0F;

    /**
     * %remise
     */
    @Column(name = "hosprt_remise")
    private Float hosprtRemise = 0F;

    /**
     * prix apres remise
     */
    @Column(name = "hosprt_pu_rem")
    private Double hosprtPuRem = 0D;

    /**
     * quantite
     */
    @Column(name = "hosprt_qte")
    private Float hosprtQte = 0F;

    /**
     * part ht patient
     */
    @Column(name = "hosprt_patient_ht")
    private Double hosprtPatientHt = 0D;

    /**
     * part taxe patient
     */
    @Column(name = "hosprt_patient_taxe")
    private Double hosprtPatientTaxe = 0D;

    /**
     * part ht societe
     */
    @Column(name = "hosprt_societe_ht")
    private Double hosprtSocieteHt = 0D;

    /**
     * part taxe societe
     */
    @Column(name = "hosprt_societe_taxe")
    private Double hosprtSocieteTaxe = 0D;

    /**
     * part ht assurance
     */
    @Column(name = "hosprt_assurance_ht")
    private Double hosprtAssuranceHt = 0D;

    /**
     * part taxe assurance
     */
    @Column(name = "hosprt_assurance_taxe")
    private Double hosprtAssuranceTaxe = 0D;

    /**
     * part ht comllementaire
     */
    @Column(name = "hosprt_complementaire_ht")
    private Double hosprtComplementaireHt = 0D;

    /**
     * part taxe complementaire
     */
    @Column(name = "hosprt_complementaire_taxe")
    private Double hosprtComplementaireTaxe = 0D;

    /**
     * total ht
     */
    @Column(name = "hosprt_total")
    private Double hosprtTotal = 0D;

    /**
     * total taxe
     */
    @Column(name = "hosprt_taxe")
    private Double hosprtTaxe = 0D;

    /**
     * id sejour
     */
    @Column(name = "hosprt_id_sejour")
    private Long hosprtIdSejour = 0L;

    @Column(name = "hos_id", nullable = false)
    private Long hosId;

}
