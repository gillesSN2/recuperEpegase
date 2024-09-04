package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_inventaire_ligne")
public class AchInventaireLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "invlig_id", nullable = false)
    private Long invligId;

    /**
     * code produit
     */
    @Column(name = "invlig_code")
    private String invligCode;

    /**
     * code depot
     */
    @Column(name = "invlig_depot")
    private String invligDepot;

    /**
     * famille produit
     */
    @Column(name = "invlig_famille")
    private String invligFamille;

    /**
     * libelle produit
     */
    @Column(name = "invlig_libelle")
    private String invligLibelle;

    /**
     * reference produit
     */
    @Column(name = "invlig_reference")
    private String invligReference;

    /**
     * unite produit
     */
    @Column(name = "invlig_unite")
    private String invligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "invlig_condition")
    private String invligCondition;

    /**
     * quantite
     */
    @Column(name = "invlig_qte")
    private Float invligQte = 0F;

    /**
     * quantite
     */
    @Column(name = "invlig_casier")
    private String invligCasier;

    /**
     * longueur
     */
    @Column(name = "invlig_long")
    private Float invligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "invlig_larg")
    private Float invligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "invlig_haut")
    private Float invligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "invlig_diam")
    private Float invligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "invlig_nb")
    private Float invligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "invlig_poidsNet")
    private Float invligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "invlig_poidsBrut")
    private Float invligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "invlig_volume")
    private Float invligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "invlig_qte_util")
    private Float invligQteUtil = 0F;

    /**
     * mode gestion en stock
     */
    @Column(name = "invlig_stock")
    private Integer invligStock = 0;

    /**
     * quantite en stock
     */
    @Column(name = "invlig_qte_stock")
    private Float invligQteStock = 0F;

    /**
     * pump
     */
    @Column(name = "invlig_pump")
    private Double invligPump = 0D;

    /**
     * total pump
     */
    @Column(name = "invlig_total")
    private Double invligTotal = 0D;

    /**
     * obsrvations
     */
    @Column(name = "invlig_obs")
    private String invligObs;

    /**
     * false si pas bon true si bon
     */
    @Column(name = "invlig_valide")
    private Boolean invligValide = Boolean.FALSE;

    @Column(name = "inv_id", nullable = false)
    private Long invId;

    /**
     * description conditionnement produit
     */
    @Column(name = "invlig_description")
    private String invligDescription;

}
