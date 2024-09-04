package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_cotations_ligne")
public class AchCotationsLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cotlig_id", nullable = false)
    private Long cotligId;

    /**
     * id de la ligne de la da
     */
    @Column(name = "cotlig_id_da")
    private Long cotligIdDa = 0L;

    /**
     * code produit
     */
    @Column(name = "cotlig_code")
    private String cotligCode;

    /**
     * famille vente
     */
    @Column(name = "cotlig_famille")
    private String cotligFamille;

    /**
     * libelle produit
     */
    @Column(name = "cotlig_libelle")
    private String cotligLibelle;

    /**
     * reference produit
     */
    @Column(name = "cotlig_reference")
    private String cotligReference;

    /**
     * code taxe
     */
    @Column(name = "cotlig_taxe")
    private String cotligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "cotlig_taux_taxe")
    private Float cotligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "cotlig_unite")
    private String cotligUnite;

    /**
     * mode de gestion de stock
     */
    @Column(name = "cotlig_stock")
    private Integer cotligStock = 0;

    /**
     * conditionnement produit
     */
    @Column(name = "cotlig_condition")
    private String cotligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "cotlig_description")
    private String cotligDescription;

    /**
     * echelle de la ligne
     */
    @Column(name = "cotlig_echelle")
    private Integer cotligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "cotlig_qte")
    private Float cotligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "cotlig_long")
    private Float cotligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "cotlig_larg")
    private Float cotligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "cotlig_haut")
    private Float cotligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "cotlig_diam")
    private Float cotligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "cotlig_nb")
    private Float cotligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "cotlig_poidsNet")
    private Float cotligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "cotlig_poidsBrut")
    private Float cotligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "cotlig_volume")
    private Float cotligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "cotlig_qte_util")
    private Float cotligQteUtil = 0F;

    /**
     * code devise
     */
    @Column(name = "cotlig_devise")
    private String cotligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "cotlig_pu")
    private Double cotligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "cotlig_taux_remise")
    private Float cotligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "cotlig_rabais")
    private Double cotligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "cotlig_pu_rem")
    private Double cotligPuRem = 0D;

    /**
     * prix total ht
     */
    @Column(name = "cotlig_pt")
    private Double cotligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "cotlig_tva")
    private Double cotligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "cotlig_tc")
    private Double cotligTc = 0D;

    /**
     * prix de revient
     */
    @Column(name = "cotlig_pr")
    private Double cotligPr = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "cotlig_pump")
    private Double cotligPump = 0D;

    /**
     * total ttc
     */
    @Column(name = "cotlig_ttc")
    private Double cotligTtc = 0D;

    @Column(name = "cot_id", nullable = false)
    private Long cotId;

    /**
     * libelle produit
     */
    @Column(name = "cotlig_libelle_fournisseur")
    private String cotligLibelleFournisseur;

    /**
     * descriptif complementaire
     */
    @Column(name = "cotlig_complement")
    private String cotligComplement;

    /**
     * code depot
     */
    @Column(name = "cotlig_depot")
    private String cotligDepot;

}
