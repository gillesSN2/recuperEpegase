package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_laboratoire_ligne")
public class MedLaboratoireLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "lablig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labligId;

    /**
     * code produit
     */
    @Column(name = "lablig_produit")
    private String labligProduit = "0";

    /**
     * libelle produit
     */
    @Column(name = "lablig_libelle")
    private String labligLibelle = "0";

    /**
     * code lettre
     */
    @Column(name = "lablig_lettre")
    private String labligLettre = "0";

    /**
     * nombre de lettre
     */
    @Column(name = "lablig_nb")
    private Float labligNb = 0F;

    /**
     * valeur de la lettre
     */
    @Column(name = "lablig_valeur")
    private Double labligValeur = 0D;

    /**
     * prix unitaire
     */
    @Column(name = "lablig_pu")
    private Double labligPu = 0D;

    /**
     * code de la tva
     */
    @Column(name = "lablig_code_tva")
    private String labligCodeTva = "0";

    /**
     * taux de la tva
     */
    @Column(name = "lablig_taux_tva")
    private Float labligTauxTva = 0F;

    /**
     * %remise
     */
    @Column(name = "lablig_remise")
    private Float labligRemise = 0F;

    /**
     * prix apres remise
     */
    @Column(name = "lablig_pu_rem")
    private Double labligPuRem = 0D;

    /**
     * quantite
     */
    @Column(name = "lablig_qte")
    private Float labligQte = 0F;

    /**
     * part ht patient
     */
    @Column(name = "lablig_patient_ht")
    private Double labligPatientHt = 0D;

    /**
     * part taxe patient
     */
    @Column(name = "lablig_patient_taxe")
    private Double labligPatientTaxe = 0D;

    /**
     * part ht societe
     */
    @Column(name = "lablig_societe_ht")
    private Double labligSocieteHt = 0D;

    /**
     * part taxe societe
     */
    @Column(name = "lablig_societe_taxe")
    private Double labligSocieteTaxe = 0D;

    /**
     * part ht assurance
     */
    @Column(name = "lablig_assurance_ht")
    private Double labligAssuranceHt = 0D;

    /**
     * part taxe assurance
     */
    @Column(name = "lablig_assurance_taxe")
    private Double labligAssuranceTaxe = 0D;

    /**
     * part ht complementaire
     */
    @Column(name = "lablig_complementaire_ht")
    private Double labligComplementaireHt = 0D;

    /**
     * part taxe complementaire
     */
    @Column(name = "lablig_complementaire_taxe")
    private Double labligComplementaireTaxe = 0D;

    /**
     * total ht
     */
    @Column(name = "lablig_total")
    private Double labligTotal = 0D;

    /**
     * nom prescripteur
     */
    @Column(name = "lablig_prescipteur")
    private String labligPrescipteur = "0";

    @Column(name = "lab_id", nullable = false)
    private Long labId;

    /**
     * famille produit
     */
    @Column(name = "lablig_famille")
    private String labligFamille;

    /**
     * coefficient
     */
    @Column(name = "lablig_coef")
    private Float labligCoef = 0F;

    /**
     * total taxe
     */
    @Column(name = "lablig_taxe")
    private Double labligTaxe = 0D;

    /**
     * etat examen 0=en cours 1=effectue 2=gele 3=annule 4=cloture
     */
    @Column(name = "lablig_etat")
    private Integer labligEtat = 0;

    /**
     * identification appareil analyse
     */
    @Column(name = "lablig_appareil")
    private String labligAppareil;

    /**
     * date de realisation
     */
    @Column(name = "lablig_date_realisee")
    private LocalDateTime labligDateRealisee;

}
