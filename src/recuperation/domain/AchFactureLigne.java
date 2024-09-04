package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_facture_ligne")
public class AchFactureLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "fcflig_id", nullable = false)
    private Long fcfligId;

    /**
     * id de la ligne de da
     */
    @Column(name = "fcflig_id_da")
    private Long fcfligIdDa = 0L;

    /**
     * id de la ligne de cotation
     */
    @Column(name = "fcflig_id_cot")
    private Long fcfligIdCot = 0L;

    /**
     * id de la ligne de commande
     */
    @Column(name = "fcflig_id_cmd")
    private Long fcfligIdCmd = 0L;

    /**
     * id de la ligne de reception
     */
    @Column(name = "fcflig_id_rec")
    private Long fcfligIdRec = 0L;

    /**
     * code produit
     */
    @Column(name = "fcflig_code")
    private String fcfligCode;

    /**
     * famille vente
     */
    @Column(name = "fcflig_famille")
    private String fcfligFamille;

    /**
     * libelle produit
     */
    @Column(name = "fcflig_libelle")
    private String fcfligLibelle;

    /**
     * reference produit
     */
    @Column(name = "fcflig_reference")
    private String fcfligReference;

    /**
     * code taxe
     */
    @Column(name = "fcflig_taxe")
    private String fcfligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "fcflig_taux_taxe")
    private Float fcfligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "fcflig_unite")
    private String fcfligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "fcflig_condition")
    private String fcfligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "fcflig_description")
    private String fcfligDescription;

    /**
     * quantite
     */
    @Column(name = "fcflig_qte")
    private Float fcfligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "fcflig_long")
    private Float fcfligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "fcflig_larg")
    private Float fcfligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "fcflig_haut")
    private Float fcfligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "fcflig_diam")
    private Float fcfligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "fcflig_nb")
    private Float fcfligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "fcflig_poidsNet")
    private Float fcfligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "fcflig_poidsBrut")
    private Float fcfligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "fcflig_volume")
    private Float fcfligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "fcflig_qte_util")
    private Float fcfligQteUtil = 0F;

    /**
     * code depot
     */
    @Column(name = "fcflig_depot")
    private String fcfligDepot;

    /**
     * quantite en stock du depot
     */
    @Column(name = "fcflig_qte_stock")
    private Float fcfligQteStock = 0F;

    /**
     * echelle de la ligne
     */
    @Column(name = "fcflig_echelle")
    private Integer fcfligEchelle = 0;

    /**
     * code devise
     */
    @Column(name = "fcflig_devise")
    private String fcfligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "fcflig_pu")
    private Double fcfligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "fcflig_taux_remise")
    private Float fcfligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "fcflig_rabais")
    private Double fcfligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "fcflig_pu_rem")
    private Double fcfligPuRem = 0D;

    /**
     * prix total ht
     */
    @Column(name = "fcflig_pt")
    private Double fcfligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "fcflig_tva")
    private Double fcfligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "fcflig_tc")
    private Double fcfligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "fcflig_ttc")
    private Double fcfligTtc = 0D;

    /**
     * prix de revient
     */
    @Column(name = "fcflig_pr")
    private Double fcfligPr = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "fcflig_pump")
    private Double fcfligPump = 0D;

    @Column(name = "fcf_id", nullable = false)
    private Long fcfId;

    /**
     * libelle produit
     */
    @Column(name = "fcflig_libelle_fournisseur")
    private String fcfligLibelleFournisseur;

    /**
     * descriptif complementaire
     */
    @Column(name = "fcflig_complement")
    private String fcfligComplement;

}
