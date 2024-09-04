package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "vte_bcommande_ligne")
public class VteBcommandeLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bcmlig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bcmligId;

    /**
     * id de la ligne devis
     */
    @Column(name = "bcmlig_id_dvs")
    private Long bcmligIdDvs = 0L;

    /**
     * code produit
     */
    @Column(name = "bcmlig_code")
    private String bcmligCode;

    /**
     * famille vente
     */
    @Column(name = "bcmlig_famille")
    private String bcmligFamille;

    /**
     * libelle produit
     */
    @Column(name = "bcmlig_libelle")
    private String bcmligLibelle;

    /**
     * reference produit
     */
    @Column(name = "bcmlig_reference")
    private String bcmligReference;

    /**
     * code taxe
     */
    @Column(name = "bcmlig_taxe")
    private String bcmligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "bcmlig_taux_taxe")
    private Float bcmligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "bcmlig_unite")
    private String bcmligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "bcmlig_condition")
    private String bcmligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "bcmlig_description")
    private String bcmligDescription;

    /**
     * echelle de la ligne
     */
    @Column(name = "bcmlig_echelle")
    private Integer bcmligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "bcmlig_qte")
    private Float bcmligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "bcmlig_long")
    private Float bcmligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "bcmlig_larg")
    private Float bcmligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "bcmlig_haut")
    private Float bcmligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "bcmlig_diam")
    private Float bcmligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "bcmlig_nb")
    private Float bcmligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "bcmlig_poidsNet")
    private Float bcmligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "bcmlig_poidsBrut")
    private Float bcmligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "bcmlig_volume")
    private Float bcmligVolume = 0F;

    /**
     * depot utilise
     */
    @Column(name = "bcmlig_depot")
    private String bcmligDepot;

    /**
     * mode gestion stock
     */
    @Column(name = "bcmlig_stock")
    private Integer bcmligStock = 0;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "bcmlig_qte_util")
    private Float bcmligQteUtil = 0F;

    /**
     * quantite en stock
     */
    @Column(name = "bcmlig_qte_stock")
    private Float bcmligQteStock = 0F;

    /**
     * code devise
     */
    @Column(name = "bcmlig_devise")
    private String bcmligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "bcmlig_pu")
    private Double bcmligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "bcmlig_taux_remise")
    private Float bcmligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "bcmlig_rabais")
    private Double bcmligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "bcmlig_pu_rem")
    private Double bcmligPuRem = 0D;

    /**
     * prix unitaire Ttc avant remise
     */
    @Column(name = "bcmlig_pu_ttc")
    private Double bcmligPuTtc = 0D;

    /**
     * prix unitaire Ttc apres remise
     */
    @Column(name = "bcmlig_pu_rem_ttc")
    private Double bcmligPuRemTtc = 0D;

    /**
     * prix total ht
     */
    @Column(name = "bcmlig_pt")
    private Double bcmligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "bcmlig_tva")
    private Double bcmligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "bcmlig_tc")
    private Double bcmligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "bcmlig_ttc")
    private Double bcmligTtc = 0D;

    /**
     * pump
     */
    @Column(name = "bcmlig_pump")
    private Double bcmligPump = 0D;

    @Column(name = "bcm_id", nullable = false)
    private Long bcmId;

    /**
     * ordre des lignes
     */
    @Column(name = "bcmlig_ordre")
    private Integer bcmligOrdre = 0;

    /**
     * descriptif complementaire
     */
    @Column(name = "bcmlig_complement")
    private String bcmligComplement;

    /**
     * quantite livree
     */
    @Column(name = "bcmlig_qte_livree")
    private Float bcmligQteLivree = 0F;

}
