package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_cession_ligne")
public class AchCessionLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ceslig_id", nullable = false)
    private Long cesligId;

    /**
     * code produit
     */
    @Column(name = "ceslig_code")
    private String cesligCode;

    /**
     * code depot origine
     */
    @Column(name = "ceslig_depot_origine")
    private String cesligDepotOrigine;

    /**
     * code depot destination
     */
    @Column(name = "ceslig_depot_destination")
    private String cesligDepotDestination;

    /**
     * famille produit
     */
    @Column(name = "ceslig_famille")
    private String cesligFamille;

    /**
     * libelle produit
     */
    @Column(name = "ceslig_libelle")
    private String cesligLibelle;

    /**
     * reference produit
     */
    @Column(name = "ceslig_reference")
    private String cesligReference;

    /**
     * unite produit
     */
    @Column(name = "ceslig_unite")
    private String cesligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "ceslig_condition")
    private String cesligCondition;

    /**
     * quantite origine
     */
    @Column(name = "ceslig_qte")
    private Float cesligQte = 0F;

    /**
     * casier origine
     */
    @Column(name = "ceslig_casier_origine")
    private String cesligCasierOrigine;

    /**
     * casier destination
     */
    @Column(name = "ceslig_casier_destination")
    private String cesligCasierDestination;

    /**
     * longueur
     */
    @Column(name = "ceslig_long")
    private Float cesligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "ceslig_larg")
    private Float cesligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "ceslig_haut")
    private Float cesligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "ceslig_diam")
    private Float cesligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "ceslig_nb")
    private Float cesligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "ceslig_poidsNet")
    private Float cesligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "ceslig_poidsBrut")
    private Float cesligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "ceslig_volume")
    private Float cesligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "ceslig_qte_util")
    private Float cesligQteUtil = 0F;

    /**
     * mode gestion en stock
     */
    @Column(name = "ceslig_stock")
    private Integer cesligStock = 0;

    /**
     * quantite en stock
     */
    @Column(name = "ceslig_qte_stock")
    private Float cesligQteStock = 0F;

    /**
     * pump
     */
    @Column(name = "ceslig_pump")
    private Double cesligPump = 0D;

    /**
     * total pump
     */
    @Column(name = "ceslig_total")
    private Double cesligTotal = 0D;

    /**
     * obsrvations
     */
    @Column(name = "ceslig_obs")
    private String cesligObs;

    @Column(name = "ces_id", nullable = false)
    private Long cesId;

    /**
     * code sommier sortie
     */
    @Column(name = "ceslig_sommier")
    private String cesligSommier;

    /**
     * description conditionnement produit
     */
    @Column(name = "ceslig_description")
    private String cesligDescription;

}
