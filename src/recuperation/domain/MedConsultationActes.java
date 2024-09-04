package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_consultation_actes")
public class MedConsultationActes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cslact_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cslactId;

    /**
     * code produit
     */
    @Column(name = "cslact_produit")
    private String cslactProduit;

    /**
     * libelle produit
     */
    @Column(name = "cslact_libelle")
    private String cslactLibelle;

    /**
     * code lettre
     */
    @Column(name = "cslact_lettre")
    private String cslactLettre;

    /**
     * nombre lettre
     */
    @Column(name = "cslact_nb")
    private Float cslactNb = 0F;

    /**
     * valeur lettre
     */
    @Column(name = "cslact_valeur")
    private Double cslactValeur = 0D;

    /**
     * prix unitaire
     */
    @Column(name = "cslact_pu")
    private Double cslactPu = 0D;

    /**
     * code de tva
     */
    @Column(name = "cslact_code_tva")
    private String cslactCodeTva;

    /**
     * taux de tva
     */
    @Column(name = "cslact_taux_tva")
    private Float cslactTauxTva = 0F;

    /**
     * %remise
     */
    @Column(name = "cslact_remise")
    private Float cslactRemise = 0F;

    /**
     * prix apres remise
     */
    @Column(name = "cslact_pu_rem")
    private Double cslactPuRem = 0D;

    /**
     * quantite
     */
    @Column(name = "cslact_qte")
    private Float cslactQte = 0F;

    /**
     * part ht patient
     */
    @Column(name = "cslact_patient_ht")
    private Double cslactPatientHt = 0D;

    /**
     * part taxe patient
     */
    @Column(name = "cslact_patient_taxe")
    private Double cslactPatientTaxe = 0D;

    /**
     * part ht societe
     */
    @Column(name = "cslact_societe_ht")
    private Double cslactSocieteHt = 0D;

    /**
     * part taxe societe
     */
    @Column(name = "cslact_societe_taxe")
    private Double cslactSocieteTaxe = 0D;

    /**
     * part ht assurance
     */
    @Column(name = "cslact_assurance_ht")
    private Double cslactAssuranceHt = 0D;

    /**
     * part taxe assurance
     */
    @Column(name = "cslact_assurance_taxe")
    private Double cslactAssuranceTaxe = 0D;

    /**
     * part ht comllementaire
     */
    @Column(name = "cslact_complementaire_ht")
    private Double cslactComplementaireHt = 0D;

    /**
     * part taxe complementaire
     */
    @Column(name = "cslact_complementaire_taxe")
    private Double cslactComplementaireTaxe = 0D;

    /**
     * total ht
     */
    @Column(name = "cslact_total")
    private Double cslactTotal = 0D;

    @Column(name = "csg_id", nullable = false)
    private Long csgId;

    /**
     * coefficient
     */
    @Column(name = "cslact_coef")
    private Float cslactCoef = 0F;

    /**
     * total taxe
     */
    @Column(name = "cslact_taxe")
    private Double cslactTaxe = 0D;

}
