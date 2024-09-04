package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_bon_sortie_ligne")
public class AchBonSortieLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "boulig_id", nullable = false)
    private Long bouligId;

    /**
     * code produit
     */
    @Column(name = "boulig_code")
    private String bouligCode;

    /**
     * code depot
     */
    @Column(name = "boulig_depot")
    private String bouligDepot;

    /**
     * famille produit
     */
    @Column(name = "boulig_famille")
    private String bouligFamille;

    /**
     * libelle produit
     */
    @Column(name = "boulig_libelle")
    private String bouligLibelle;

    /**
     * reference produit
     */
    @Column(name = "boulig_reference")
    private String bouligReference;

    /**
     * unite produit
     */
    @Column(name = "boulig_unite")
    private String bouligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "boulig_condition")
    private String bouligCondition;

    /**
     * quantite
     */
    @Column(name = "boulig_qte")
    private Float bouligQte = 0F;

    /**
     * quantite
     */
    @Column(name = "boulig_casier")
    private String bouligCasier;

    /**
     * longueur
     */
    @Column(name = "boulig_long")
    private Float bouligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "boulig_larg")
    private Float bouligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "boulig_haut")
    private Float bouligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "boulig_diam")
    private Float bouligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "boulig_nb")
    private Float bouligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "boulig_poidsNet")
    private Float bouligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "boulig_poidsBrut")
    private Float bouligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "boulig_volume")
    private Float bouligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "boulig_qte_util")
    private Float bouligQteUtil = 0F;

    /**
     * mode gestion en stock
     */
    @Column(name = "boulig_stock")
    private Integer bouligStock = 0;

    /**
     * quantite en stock
     */
    @Column(name = "boulig_qte_stock")
    private Float bouligQteStock = 0F;

    /**
     * pump
     */
    @Column(name = "boulig_pump")
    private Double bouligPump = 0D;

    /**
     * total pump
     */
    @Column(name = "boulig_total")
    private Double bouligTotal = 0D;

    /**
     * obsrvations
     */
    @Column(name = "boulig_obs")
    private String bouligObs;

    @Column(name = "bou_id", nullable = false)
    private Long bouId;

    /**
     * description conditionnement produit
     */
    @Column(name = "boulig_description")
    private String bouligDescription;

}
