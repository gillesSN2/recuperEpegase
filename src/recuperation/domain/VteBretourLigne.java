package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "vte_bretour_ligne")
public class VteBretourLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "brtlig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brtligId;

    /**
     * id de la ligne livraison
     */
    @Column(name = "brtlig_id_blv")
    private Long brtligIdBlv = 0L;

    /**
     * code produit
     */
    @Column(name = "brtlig_code")
    private String brtligCode;

    /**
     * famille vente
     */
    @Column(name = "brtlig_famille")
    private String brtligFamille;

    /**
     * libelle produit
     */
    @Column(name = "brtlig_libelle")
    private String brtligLibelle;

    /**
     * reference produit
     */
    @Column(name = "brtlig_reference")
    private String brtligReference;

    /**
     * code taxe
     */
    @Column(name = "brtlig_taxe")
    private String brtligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "brtlig_taux_taxe")
    private Float brtligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "brtlig_unite")
    private String brtligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "brtlig_condition")
    private String brtligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "brtlig_description")
    private String brtligDescription;

    /**
     * code depot
     */
    @Column(name = "brtlig_depot")
    private String brtligDepot;

    /**
     * mode gestion en stock
     */
    @Column(name = "brtlig_stock")
    private Integer brtligStock = 0;

    /**
     * quantite en stock
     */
    @Column(name = "brtlig_qte_stock")
    private Float brtligQteStock = 0F;

    /**
     * echelle de la ligne
     */
    @Column(name = "brtlig_echelle")
    private Integer brtligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "brtlig_qte")
    private Float brtligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "brtlig_long")
    private Float brtligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "brtlig_larg")
    private Float brtligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "brtlig_haut")
    private Float brtligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "brtlig_diam")
    private Float brtligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "brtlig_nb")
    private Float brtligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "brtlig_poidsNet")
    private Float brtligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "brtlig_poidsBrut")
    private Float brtligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "brtlig_volume")
    private Float brtligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "brtlig_qte_util")
    private Float brtligQteUtil = 0F;

    /**
     * numero de lot
     */
    @Column(name = "brtlig_lot")
    private String brtligLot;

    /**
     * numero de serie
     */
    @Column(name = "brtlig_num_serie")
    private String brtligNumSerie;

    /**
     * code devise
     */
    @Column(name = "brtlig_devise")
    private String brtligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "brtlig_pu")
    private Double brtligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "brtlig_taux_remise")
    private Float brtligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "brtlig_rabais")
    private Double brtligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "brtlig_pu_rem")
    private Double brtligPuRem = 0D;

    /**
     * prix unitaire avant remise
     */
    @Column(name = "brtlig_pu_ttc")
    private Double brtligPuTtc = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "brtlig_pu_rem_ttc")
    private Double brtligPuRemTtc = 0D;

    /**
     * prix total ht
     */
    @Column(name = "brtlig_pt")
    private Double brtligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "brtlig_tva")
    private Double brtligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "brtlig_tc")
    private Double brtligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "brtlig_ttc")
    private Double brtligTtc = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "brtlig_pump")
    private Double brtligPump = 0D;

    @Column(name = "brt_id", nullable = false)
    private Long brtId;

    /**
     * ordre des lignes
     */
    @Column(name = "brtlig_ordre")
    private Integer brtligOrdre = 0;

    /**
     * descriptif complementaire
     */
    @Column(name = "brtlig_complement")
    private String brtligComplement;

}
