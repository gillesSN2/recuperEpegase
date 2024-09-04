package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "vte_devis_ligne")
public class VteDevisLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dvslig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dvsligId;

    /**
     * code produit
     */
    @Column(name = "dvslig_code")
    private String dvsligCode;

    /**
     * famille vente
     */
    @Column(name = "dvslig_famille")
    private String dvsligFamille;

    /**
     * libelle produit
     */
    @Column(name = "dvslig_libelle")
    private String dvsligLibelle;

    /**
     * reference produit
     */
    @Column(name = "dvslig_reference")
    private String dvsligReference;

    /**
     * code taxe
     */
    @Column(name = "dvslig_taxe")
    private String dvsligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "dvslig_taux_taxe")
    private Float dvsligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "dvslig_unite")
    private String dvsligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "dvslig_condition")
    private String dvsligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "dvslig_description")
    private String dvsligDescription;

    /**
     * echelle de la ligne
     */
    @Column(name = "dvslig_echelle")
    private Integer dvsligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "dvslig_qte")
    private Float dvsligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "dvslig_long")
    private Float dvsligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "dvslig_larg")
    private Float dvsligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "dvslig_haut")
    private Float dvsligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "dvslig_diam")
    private Float dvsligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "dvslig_nb")
    private Float dvsligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "dvslig_poidsNet")
    private Float dvsligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "dvslig_poidsBrut")
    private Float dvsligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "dvslig_volume")
    private Float dvsligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "dvslig_qte_util")
    private Float dvsligQteUtil = 0F;

    /**
     * mode de gestion du stock
     */
    @Column(name = "dvslig_stock")
    private Integer dvsligStock = 0;

    /**
     * code depot
     */
    @Column(name = "dvslig_depot")
    private String dvsligDepot;

    /**
     * code devise
     */
    @Column(name = "dvslig_devise")
    private String dvsligDevise;

    /**
     * prix unitaire HT avant remise
     */
    @Column(name = "dvslig_pu")
    private Double dvsligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "dvslig_taux_remise")
    private Float dvsligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "dvslig_rabais")
    private Double dvsligRabais = 0D;

    /**
     * prix unitaire Ht apres remise
     */
    @Column(name = "dvslig_pu_rem")
    private Double dvsligPuRem = 0D;

    /**
     * prix unitaire Ttc avant remise
     */
    @Column(name = "dvslig_pu_ttc")
    private Double dvsligPuTtc = 0D;

    /**
     * prix unitaire Ttc apres remise
     */
    @Column(name = "dvslig_pu_rem_ttc")
    private Double dvsligPuRemTtc = 0D;

    /**
     * prix total ht
     */
    @Column(name = "dvslig_pt")
    private Double dvsligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "dvslig_tva")
    private Double dvsligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "dvslig_tc")
    private Double dvsligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "dvslig_ttc")
    private Double dvsligTtc = 0D;

    /**
     * prix unitaire moyen pondere unitaire
     */
    @Column(name = "dvslig_pump")
    private Double dvsligPump = 0D;

    @Column(name = "dvs_id", nullable = false)
    private Long dvsId;

    /**
     * ordre des lignes
     */
    @Column(name = "dvslig_ordre")
    private Integer dvsligOrdre = 0;

    /**
     * descriptif complementaire
     */
    @Column(name = "dvslig_complement")
    private String dvsligComplement;

}
