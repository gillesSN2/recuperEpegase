package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_fabrication_ligne_achats")
public class AchFabricationLigneAchats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "fablig_id", nullable = false)
    private Long fabligId;

    /**
     * code produit
     */
    @Column(name = "fablig_code")
    private String fabligCode;

    /**
     * code depot
     */
    @Column(name = "fablig_depot")
    private String fabligDepot;

    /**
     * famille produit
     */
    @Column(name = "fablig_famille")
    private String fabligFamille;

    /**
     * libelle produit
     */
    @Column(name = "fablig_libelle")
    private String fabligLibelle;

    /**
     * reference produit
     */
    @Column(name = "fablig_reference")
    private String fabligReference;

    /**
     * unite produit
     */
    @Column(name = "fablig_unite")
    private String fabligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "fablig_condition")
    private String fabligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "fablig_description")
    private String fabligDescription;

    /**
     * quantite
     */
    @Column(name = "fablig_qte")
    private Float fabligQte = 0F;

    /**
     * quantite
     */
    @Column(name = "fablig_casier")
    private String fabligCasier;

    /**
     * longueur
     */
    @Column(name = "fablig_long")
    private Float fabligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "fablig_larg")
    private Float fabligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "fablig_haut")
    private Float fabligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "fablig_diam")
    private Float fabligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "fablig_nb")
    private Float fabligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "fablig_poidsNet")
    private Float fabligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "fablig_poidsBrut")
    private Float fabligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "fablig_volume")
    private Float fabligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "fablig_qte_util")
    private Float fabligQteUtil = 0F;

    /**
     * mode gestion en stock
     */
    @Column(name = "fablig_stock")
    private Integer fabligStock = 0;

    /**
     * quantite en stock
     */
    @Column(name = "fablig_qte_stock")
    private Float fabligQteStock = 0F;

    /**
     * pump
     */
    @Column(name = "fablig_pump")
    private Double fabligPump = 0D;

    /**
     * total pump
     */
    @Column(name = "fablig_total")
    private Double fabligTotal = 0D;

    /**
     * obsrvations
     */
    @Column(name = "fablig_obs")
    private String fabligObs;

    @Column(name = "fab_id", nullable = false)
    private Long fabId;

}
