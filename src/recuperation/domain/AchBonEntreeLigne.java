package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_bon_entree_ligne")
public class AchBonEntreeLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "binlig_id", nullable = false)
    private Long binligId;

    /**
     * code produit
     */
    @Column(name = "binlig_code")
    private String binligCode;

    /**
     * code depot
     */
    @Column(name = "binlig_depot")
    private String binligDepot;

    /**
     * famille produit
     */
    @Column(name = "binlig_famille")
    private String binligFamille;

    /**
     * libelle produit
     */
    @Column(name = "binlig_libelle")
    private String binligLibelle;

    /**
     * reference produit
     */
    @Column(name = "binlig_reference")
    private String binligReference;

    /**
     * unite produit
     */
    @Column(name = "binlig_unite")
    private String binligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "binlig_condition")
    private String binligCondition;

    /**
     * quantite
     */
    @Column(name = "binlig_qte")
    private Float binligQte = 0F;

    /**
     * quantite
     */
    @Column(name = "binlig_casier")
    private String binligCasier;

    /**
     * longueur
     */
    @Column(name = "binlig_long")
    private Float binligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "binlig_larg")
    private Float binligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "binlig_haut")
    private Float binligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "binlig_diam")
    private Float binligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "binlig_nb")
    private Float binligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "binlig_poidsNet")
    private Float binligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "binlig_poidsBrut")
    private Float binligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "binlig_volume")
    private Float binligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "binlig_qte_util")
    private Float binligQteUtil = 0F;

    /**
     * mode gestion en stock
     */
    @Column(name = "binlig_stock")
    private Integer binligStock = 0;

    /**
     * quantite en stock
     */
    @Column(name = "binlig_qte_stock")
    private Float binligQteStock = 0F;

    /**
     * pump
     */
    @Column(name = "binlig_pump")
    private Double binligPump = 0D;

    /**
     * total pump
     */
    @Column(name = "binlig_total")
    private Double binligTotal = 0D;

    /**
     * obsrvations
     */
    @Column(name = "binlig_obs")
    private String binligObs;

    @Column(name = "bin_id", nullable = false)
    private Long binId;

    /**
     * description conditionnement produit
     */
    @Column(name = "binlig_description")
    private String binligDescription;

}
