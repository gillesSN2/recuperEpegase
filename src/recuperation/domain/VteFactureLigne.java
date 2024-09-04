package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "vte_facture_ligne")
public class VteFactureLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "faclig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facligId;

    /**
     * id de la ligne devis
     */
    @Column(name = "faclig_id_dvs")
    private Long facligIdDvs = 0L;

    /**
     * id de la ligne commande
     */
    @Column(name = "faclig_id_bcm")
    private Long facligIdBcm = 0L;

    /**
     * id de la ligne livraison
     */
    @Column(name = "faclig_id_blv")
    private Long facligIdBlv = 0L;

    /**
     * code produit
     */
    @Column(name = "faclig_code")
    private String facligCode;

    /**
     * famille vente
     */
    @Column(name = "faclig_famille")
    private String facligFamille;

    /**
     * libelle produit
     */
    @Column(name = "faclig_libelle")
    private String facligLibelle;

    /**
     * reference produit
     */
    @Column(name = "faclig_reference")
    private String facligReference;

    /**
     * code taxe
     */
    @Column(name = "faclig_taxe")
    private String facligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "faclig_taux_taxe")
    private Float facligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "faclig_unite")
    private String facligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "faclig_condition")
    private String facligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "faclig_description")
    private String facligDescription;

    /**
     * code depot
     */
    @Column(name = "faclig_depot")
    private String facligDepot;

    /**
     * mode de gestion stock
     */
    @Column(name = "faclig_stock")
    private Integer facligStock = 0;

    /**
     * quantite en stock
     */
    @Column(name = "faclig_qte_stock")
    private Float facligQteStock = 0F;

    /**
     * echelle de la ligne
     */
    @Column(name = "faclig_echelle")
    private Integer facligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "faclig_qte")
    private Float facligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "faclig_long")
    private Float facligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "faclig_larg")
    private Float facligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "faclig_haut")
    private Float facligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "faclig_diam")
    private Float facligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "faclig_nb")
    private Float facligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "faclig_poidsNet")
    private Float facligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "faclig_poidsBrut")
    private Float facligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "faclig_volume")
    private Float facligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "faclig_qte_util")
    private Float facligQteUtil = 0F;

    /**
     * numero de lot
     */
    @Column(name = "faclig_lot")
    private String facligLot;

    /**
     * numero de serie
     */
    @Column(name = "faclig_num_serie")
    private String facligNumSerie;

    /**
     * code devise
     */
    @Column(name = "faclig_devise")
    private String facligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "faclig_pu")
    private Double facligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "faclig_taux_remise")
    private Float facligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "faclig_rabais")
    private Double facligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "faclig_pu_rem")
    private Double facligPuRem = 0D;

    /**
     * prix unitaire TTC avant remise
     */
    @Column(name = "faclig_pu_ttc")
    private Double facligPuTtc = 0D;

    /**
     * prix unitaire TTC apres remise
     */
    @Column(name = "faclig_pu_rem_ttc")
    private Double facligPuRemTtc = 0D;

    /**
     * prix total ht
     */
    @Column(name = "faclig_pt")
    private Double facligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "faclig_tva")
    private Double facligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "faclig_tc")
    private Double facligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "faclig_ttc")
    private Double facligTtc = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "faclig_pump")
    private Double facligPump = 0D;

    @Column(name = "fac_id", nullable = false)
    private Long facId;

    /**
     * si facture directe et stock alors 1 sinon 0
     */
    @Column(name = "faclig_ent_stock")
    private Integer facligEntStock = 0;

    /**
     * total commission
     */
    @Column(name = "faclig_commission")
    private Double facligCommission = 0D;

    /**
     * ordre des lignes
     */
    @Column(name = "faclig_ordre")
    private Integer facligOrdre = 0;

    /**
     * descriptif complementaire
     */
    @Column(name = "faclig_complement")
    private String facligComplement;

}
