package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "vte_blivraison_ligne")
public class VteBlivraisonLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "blvlig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blvligId;

    /**
     * id de la ligne devis
     */
    @Column(name = "blvlig_id_dvs")
    private Long blvligIdDvs = 0L;

    /**
     * id de la ligne commande
     */
    @Column(name = "blvlig_id_bcm")
    private Long blvligIdBcm = 0L;

    /**
     * code produit
     */
    @Column(name = "blvlig_code")
    private String blvligCode;

    /**
     * famille vente
     */
    @Column(name = "blvlig_famille")
    private String blvligFamille;

    /**
     * libelle produit
     */
    @Column(name = "blvlig_libelle")
    private String blvligLibelle;

    /**
     * reference produit
     */
    @Column(name = "blvlig_reference")
    private String blvligReference;

    /**
     * code taxe
     */
    @Column(name = "blvlig_taxe")
    private String blvligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "blvlig_taux_taxe")
    private Float blvligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "blvlig_unite")
    private String blvligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "blvlig_condition")
    private String blvligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "blvlig_description")
    private String blvligDescription;

    /**
     * code depot
     */
    @Column(name = "blvlig_depot")
    private String blvligDepot;

    /**
     * code depot de la commande
     */
    @Column(name = "blvlig_depot_cmd")
    private String blvligDepotCmd;

    /**
     * quantite validee pour maj stock
     */
    @Column(name = "blvlig_qte_stock")
    private Float blvligQteStock = 0F;

    /**
     * mode de gestion de stock
     */
    @Column(name = "blvlig_stock")
    private Integer blvligStock = 0;

    /**
     * echelle de la ligne
     */
    @Column(name = "blvlig_echelle")
    private Integer blvligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "blvlig_qte")
    private Float blvligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "blvlig_long")
    private Float blvligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "blvlig_larg")
    private Float blvligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "blvlig_haut")
    private Float blvligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "blvlig_diam")
    private Float blvligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "blvlig_nb")
    private Float blvligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "blvlig_poidsNet")
    private Float blvligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "blvlig_poidsBrut")
    private Float blvligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "blvlig_volume")
    private Float blvligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "blvlig_qte_util")
    private Float blvligQteUtil = 0F;

    /**
     * quantite utilisee (valable pour le stock apres validation)
     */
    @Column(name = "blvlig_qte_util_stock")
    private Float blvligQteUtilStock = 0F;

    /**
     * numero de lot
     */
    @Column(name = "blvlig_lot")
    private String blvligLot;

    /**
     * numero de serie
     */
    @Column(name = "blvlig_num_serie")
    private String blvligNumSerie;

    /**
     * code devise
     */
    @Column(name = "blvlig_devise")
    private String blvligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "blvlig_pu")
    private Double blvligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "blvlig_taux_remise")
    private Float blvligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "blvlig_rabais")
    private Double blvligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "blvlig_pu_rem")
    private Double blvligPuRem = 0D;

    /**
     * prix unitaire Ttc avant remise
     */
    @Column(name = "blvlig_pu_ttc")
    private Double blvligPuTtc = 0D;

    /**
     * prix unitaire Ttc apres remise
     */
    @Column(name = "blvlig_pu_rem_ttc")
    private Double blvligPuRemTtc = 0D;

    /**
     * prix total ht
     */
    @Column(name = "blvlig_pt")
    private Double blvligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "blvlig_tva")
    private Double blvligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "blvlig_tc")
    private Double blvligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "blvlig_ttc")
    private Double blvligTtc = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "blvlig_pump")
    private Double blvligPump = 0D;

    @Column(name = "blv_id", nullable = false)
    private Long blvId;

    /**
     * generique
     */
    @Column(name = "blvlig_generique")
    private Integer blvligGenerique = 0;

    /**
     * ordre des lignes
     */
    @Column(name = "blvlig_ordre")
    private Integer blvligOrdre = 0;

    /**
     * descriptif complementaire
     */
    @Column(name = "blvlig_complement")
    private String blvligComplement;

}
