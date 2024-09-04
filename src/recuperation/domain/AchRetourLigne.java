package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_retour_ligne")
public class AchRetourLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "brflig_id", nullable = false)
    private Long brfligId;

    /**
     * id de la ligne de da
     */
    @Column(name = "brflig_id_da")
    private Long brfligIdDa = 0L;

    /**
     * id de la ligne de cotation
     */
    @Column(name = "brflig_id_cot")
    private Long brfligIdCot = 0L;

    /**
     * id de la ligne de commande
     */
    @Column(name = "brflig_id_cmd")
    private Long brfligIdCmd = 0L;

    /**
     * id de la ligne de reception
     */
    @Column(name = "brflig_id_rec")
    private Long brfligIdRec = 0L;

    /**
     * code produit
     */
    @Column(name = "brflig_code")
    private String brfligCode;

    /**
     * famille vente
     */
    @Column(name = "brflig_famille")
    private String brfligFamille;

    /**
     * libelle produit
     */
    @Column(name = "brflig_libelle")
    private String brfligLibelle;

    /**
     * reference produit
     */
    @Column(name = "brflig_reference")
    private String brfligReference;

    /**
     * code taxe
     */
    @Column(name = "brflig_taxe")
    private String brfligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "brflig_taux_taxe")
    private Float brfligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "brflig_unite")
    private String brfligUnite;

    /**
     * mode de gestion de stock
     */
    @Column(name = "brflig_stock")
    private Integer brfligStock = 0;

    /**
     * conditionnement produit
     */
    @Column(name = "brflig_condition")
    private String brfligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "brflig_description")
    private String brfligDescription;

    /**
     * echelle de la ligne
     */
    @Column(name = "brflig_echelle")
    private Integer brfligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "brflig_qte")
    private Float brfligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "brflig_long")
    private Float brfligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "brflig_larg")
    private Float brfligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "brflig_haut")
    private Float brfligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "brflig_diam")
    private Float brfligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "brflig_nb")
    private Float brfligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "brflig_poidsNet")
    private Float brfligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "brflig_poidsBrut")
    private Float brfligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "brflig_volume")
    private Float brfligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "brflig_qte_util")
    private Float brfligQteUtil = 0F;

    /**
     * code depot
     */
    @Column(name = "brflig_depot")
    private String brfligDepot;

    /**
     * quantite en stock du depot
     */
    @Column(name = "brflig_qte_stock")
    private Float brfligQteStock = 0F;

    /**
     * code devise
     */
    @Column(name = "brflig_devise")
    private String brfligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "brflig_pu")
    private Double brfligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "brflig_taux_remise")
    private Float brfligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "brflig_rabais")
    private Double brfligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "brflig_pu_rem")
    private Double brfligPuRem = 0D;

    /**
     * prix total ht
     */
    @Column(name = "brflig_pt")
    private Double brfligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "brflig_tva")
    private Double brfligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "brflig_tc")
    private Double brfligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "brflig_ttc")
    private Double brfligTtc = 0D;

    /**
     * prix de revient
     */
    @Column(name = "brflig_pr")
    private Double brfligPr = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "brflig_pump")
    private Double brfligPump = 0D;

    @Column(name = "brf_id", nullable = false)
    private Long brfId;

    /**
     * libelle produit
     */
    @Column(name = "brflig_libelle_fournisseur")
    private String brfligLibelleFournisseur;

    /**
     * descriptif complementaire
     */
    @Column(name = "brflig_complement")
    private String brfligComplement;

}
