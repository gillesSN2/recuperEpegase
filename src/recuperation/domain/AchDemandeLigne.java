package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_demande_ligne")
public class AchDemandeLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "demlig_id", nullable = false)
    private Long demligId;

    /**
     * code produit
     */
    @Column(name = "demlig_code")
    private String demligCode;

    /**
     * famille vente
     */
    @Column(name = "demlig_famille")
    private String demligFamille;

    /**
     * libelle produit
     */
    @Column(name = "demlig_libelle")
    private String demligLibelle;

    /**
     * reference produit
     */
    @Column(name = "demlig_reference")
    private String demligReference;

    /**
     * code taxe
     */
    @Column(name = "demlig_taxe")
    private String demligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "demlig_taux_taxe")
    private Float demligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "demlig_unite")
    private String demligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "demlig_condition")
    private String demligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "demlig_description")
    private String demligDescription;

    /**
     * quantite
     */
    @Column(name = "demlig_qte")
    private Float demligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "demlig_long")
    private Float demligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "demlig_larg")
    private Float demligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "demlig_haut")
    private Float demligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "demlig_diam")
    private Float demligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "demlig_nb")
    private Float demligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "demlig_poidsNet")
    private Float demligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "demlig_poidsBrut")
    private Float demligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "demlig_volume")
    private Float demligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "demlig_qte_util")
    private Float demligQteUtil = 0F;

    /**
     * quantite en stock
     */
    @Column(name = "demlig_qte_stock")
    private Float demligQteStock = 0F;

    /**
     * code devise
     */
    @Column(name = "demlig_devise")
    private String demligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "demlig_pu")
    private Double demligPu = 0D;

    /**
     * prix total ht
     */
    @Column(name = "demlig_pt")
    private Double demligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "demlig_tva")
    private Double demligTva = 0D;

    /**
     * total ttc
     */
    @Column(name = "demlig_ttc")
    private Double demligTtc = 0D;

    /**
     * prix de revient
     */
    @Column(name = "demlig_pr")
    private Double demligPr = 0D;

    /**
     * prix de revient
     */
    @Column(name = "demlig_pump")
    private Double demligPump = 0D;

    /**
     * nom du fournisseur
     */
    @Column(name = "demlig_nom_tiers")
    private String demligNomTiers;

    /**
     * civilite du fournisseur
     */
    @Column(name = "demlig_civil_tiers")
    private String demligCivilTiers;

    /**
     * id du fournisseur
     */
    @Column(name = "demlig_id_tiers")
    private Long demligIdTiers = 0L;

    @Column(name = "dem_id", nullable = false)
    private Long demId;

    /**
     * descriptif complementaire
     */
    @Column(name = "demlig_complement")
    private String demligComplement;

}
