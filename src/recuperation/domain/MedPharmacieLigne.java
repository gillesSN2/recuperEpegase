package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_pharmacie_ligne")
public class MedPharmacieLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "phalig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phaligId;

    /**
     * code produit
     */
    @Column(name = "phalig_produit")
    private String phaligProduit;

    /**
     * depot
     */
    @Column(name = "phalig_depot")
    private String phaligDepot;

    /**
     * code de la tva
     */
    @Column(name = "phalig_code_tva")
    private String phaligCodeTva = "0";

    /**
     * code lettre
     */
    @Column(name = "phalig_lettre")
    private String phaligLettre;

    /**
     * nombre lettre
     */
    @Column(name = "phalig_nb")
    private Float phaligNb = 0F;

    /**
     * valeur lettre
     */
    @Column(name = "phalig_valeur")
    private Double phaligValeur = 0D;

    /**
     * prix unitaire
     */
    @Column(name = "phalig_pu")
    private Double phaligPu = 0D;

    /**
     * taux de tva
     */
    @Column(name = "phalig_taux_tva")
    private Float phaligTauxTva = 0F;

    /**
     * %remise
     */
    @Column(name = "phalig_remise")
    private Float phaligRemise = 0F;

    /**
     * prix apres remise
     */
    @Column(name = "phalig_pu_rem")
    private Float phaligPuRem = 0F;

    /**
     * quantite
     */
    @Column(name = "phalig_qte")
    private Float phaligQte = 0F;

    /**
     * part ht patient
     */
    @Column(name = "phalig_patient_ht")
    private Double phaligPatientHt = 0D;

    /**
     * part taxe patient
     */
    @Column(name = "phalig_patient_taxe")
    private Double phaligPatientTaxe = 0D;

    /**
     * part ht societe
     */
    @Column(name = "phalig_societe_ht")
    private Double phaligSocieteHt = 0D;

    /**
     * part taxe societe
     */
    @Column(name = "phalig_societe_taxe")
    private Double phaligSocieteTaxe = 0D;

    /**
     * part ht assurance
     */
    @Column(name = "phalig_assurance_ht")
    private Double phaligAssuranceHt = 0D;

    /**
     * part taxe assurance
     */
    @Column(name = "phalig_assurance_taxe")
    private Double phaligAssuranceTaxe = 0D;

    /**
     * part ht comllementaire
     */
    @Column(name = "phalig_complementaire_ht")
    private Double phaligComplementaireHt = 0D;

    /**
     * part taxe complementaire
     */
    @Column(name = "phalig_complementaire_taxe")
    private Double phaligComplementaireTaxe = 0D;

    /**
     * total ht
     */
    @Column(name = "phalig_total")
    private Double phaligTotal = 0D;

    @Column(name = "pha_id", nullable = false)
    private Long phaId;

    /**
     * libelle produit
     */
    @Column(name = "phalig_libelle")
    private String phaligLibelle;

    /**
     * dci
     */
    @Column(name = "phalig_dci")
    private String phaligDci;

    /**
     * famille produit
     */
    @Column(name = "phalig_famille")
    private String phaligFamille;

    /**
     * unite produit
     */
    @Column(name = "phalig_unite")
    private String phaligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "phalig_condition")
    private String phaligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "phalig_description")
    private String phaligDescription;

    /**
     * mode de gestion de stock
     */
    @Column(name = "phalig_stock")
    private Integer phaligStock = 0;

    /**
     * echelle de la ligne
     */
    @Column(name = "phalig_echelle")
    private Integer phaligEchelle = 0;

    /**
     * total taxe
     */
    @Column(name = "phalig_taxe")
    private Double phaligTaxe = 0D;

    /**
     * pump
     */
    @Column(name = "phalig_pump")
    private Double phaligPump = 0D;

}
