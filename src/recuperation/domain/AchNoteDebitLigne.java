package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_note_debit_ligne")
public class AchNoteDebitLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ndflig_id", nullable = false)
    private Long ndfligId;

    /**
     * code produit
     */
    @Column(name = "ndflig_code")
    private String ndfligCode;

    /**
     * famille vente
     */
    @Column(name = "ndflig_famille")
    private String ndfligFamille;

    /**
     * libelle produit
     */
    @Column(name = "ndflig_libelle")
    private String ndfligLibelle;

    /**
     * reference produit
     */
    @Column(name = "ndflig_reference")
    private String ndfligReference;

    /**
     * code taxe
     */
    @Column(name = "ndflig_taxe")
    private String ndfligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "ndflig_taux_taxe")
    private Float ndfligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "ndflig_unite")
    private String ndfligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "ndflig_condition")
    private String ndfligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "ndflig_description")
    private String ndfligDescription;

    /**
     * echelle de la ligne
     */
    @Column(name = "ndflig_echelle")
    private Integer ndfligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "ndflig_qte")
    private Float ndfligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "ndflig_long")
    private Float ndfligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "ndflig_larg")
    private Float ndfligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "ndflig_haut")
    private Float ndfligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "ndflig_diam")
    private Float ndfligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "ndflig_nb")
    private Float ndfligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "ndflig_poidsNet")
    private Float ndfligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "ndflig_poidsBrut")
    private Float ndfligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "ndflig_volume")
    private Float ndfligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "ndflig_qte_util")
    private Float ndfligQteUtil = 0F;

    /**
     * code devise
     */
    @Column(name = "ndflig_devise")
    private String ndfligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "ndflig_pu")
    private Double ndfligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "ndflig_taux_remise")
    private Float ndfligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "ndflig_rabais")
    private Double ndfligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "ndflig_pu_rem")
    private Double ndfligPuRem = 0D;

    /**
     * prix total ht
     */
    @Column(name = "ndflig_pt")
    private Double ndfligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "ndflig_tva")
    private Double ndfligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "ndflig_tc")
    private Double ndfligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "ndflig_ttc")
    private Double ndfligTtc = 0D;

    /**
     * pump
     */
    @Column(name = "ndflig_pump")
    private Double ndfligPump = 0D;

    @Column(name = "ndf_id", nullable = false)
    private Long ndfId;

    /**
     * libelle produit
     */
    @Column(name = "ndflig_libelle_fournisseur")
    private String ndfligLibelleFournisseur;

    /**
     * descriptif complementaire
     */
    @Column(name = "ndflig_complement")
    private String ndfligComplement;

    /**
     * prix revient
     */
    @Column(name = "ndflig_pr")
    private Double ndfligPr = 0D;

}
