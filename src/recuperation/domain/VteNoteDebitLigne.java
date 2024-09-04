package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "vte_note_debit_ligne")
public class VteNoteDebitLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ndblig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ndbligId;

    /**
     * id de la ligne devis
     */
    @Column(name = "ndblig_id_dvs")
    private Long ndbligIdDvs = 0L;

    /**
     * id de la ligne commande
     */
    @Column(name = "ndblig_id_bcm")
    private Long ndbligIdBcm = 0L;

    /**
     * id de la ligne livraison
     */
    @Column(name = "ndblig_id_blv")
    private Long ndbligIdBlv = 0L;

    /**
     * code produit
     */
    @Column(name = "ndblig_code")
    private String ndbligCode;

    /**
     * famille vente
     */
    @Column(name = "ndblig_famille")
    private String ndbligFamille;

    /**
     * libelle produit
     */
    @Column(name = "ndblig_libelle")
    private String ndbligLibelle;

    /**
     * reference produit
     */
    @Column(name = "ndblig_reference")
    private String ndbligReference;

    /**
     * code taxe
     */
    @Column(name = "ndblig_taxe")
    private String ndbligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "ndblig_taux_taxe")
    private Float ndbligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "ndblig_unite")
    private String ndbligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "ndblig_condition")
    private String ndbligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "ndblig_description")
    private String ndbligDescription;

    /**
     * code depot
     */
    @Column(name = "ndblig_depot")
    private String ndbligDepot;

    /**
     * mode de gestion stock
     */
    @Column(name = "ndblig_stock")
    private Integer ndbligStock = 0;

    /**
     * quantite en stock
     */
    @Column(name = "ndblig_qte_stock")
    private Float ndbligQteStock = 0F;

    /**
     * echelle de la ligne
     */
    @Column(name = "ndblig_echelle")
    private Integer ndbligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "ndblig_qte")
    private Float ndbligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "ndblig_long")
    private Float ndbligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "ndblig_larg")
    private Float ndbligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "ndblig_haut")
    private Float ndbligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "ndblig_diam")
    private Float ndbligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "ndblig_nb")
    private Float ndbligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "ndblig_poidsNet")
    private Float ndbligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "ndblig_poidsBrut")
    private Float ndbligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "ndblig_volume")
    private Float ndbligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "ndblig_qte_util")
    private Float ndbligQteUtil = 0F;

    /**
     * numero de lot
     */
    @Column(name = "ndblig_lot")
    private String ndbligLot;

    /**
     * numero de serie
     */
    @Column(name = "ndblig_num_serie")
    private String ndbligNumSerie;

    /**
     * code devise
     */
    @Column(name = "ndblig_devise")
    private String ndbligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "ndblig_pu")
    private Double ndbligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "ndblig_taux_remise")
    private Float ndbligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "ndblig_rabais")
    private Double ndbligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "ndblig_pu_rem")
    private Double ndbligPuRem = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "ndblig_pu_rem_ttc")
    private Double ndbligPuRemTtc = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "ndblig_pu_ttc")
    private Double ndbligPuTtc = 0D;

    /**
     * prix total ht
     */
    @Column(name = "ndblig_pt")
    private Double ndbligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "ndblig_tva")
    private Double ndbligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "ndblig_tc")
    private Double ndbligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "ndblig_ttc")
    private Double ndbligTtc = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "ndblig_pump")
    private Double ndbligPump = 0D;

    @Column(name = "ndb_id", nullable = false)
    private Long ndbId;

    /**
     * total commission
     */
    @Column(name = "ndblig_commission")
    private Double ndbligCommission = 0D;

    /**
     * ordre des lignes
     */
    @Column(name = "ndblig_ordre")
    private Integer ndbligOrdre = 0;

    /**
     * descriptif complementaire
     */
    @Column(name = "ndblig_complement")
    private String ndbligComplement;

}
