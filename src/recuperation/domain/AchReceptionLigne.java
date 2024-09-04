package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_reception_ligne")
public class AchReceptionLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "reclig_id", nullable = false)
    private Long recligId;

    /**
     * id de la ligne de da
     */
    @Column(name = "reclig_id_da")
    private Long recligIdDa = 0L;

    /**
     * id de la ligne de cotation
     */
    @Column(name = "reclig_id_cot")
    private Long recligIdCot = 0L;

    /**
     * id de la ligne de commande
     */
    @Column(name = "reclig_id_cmd")
    private Long recligIdCmd = 0L;

    /**
     * code produit
     */
    @Column(name = "reclig_code")
    private String recligCode;

    /**
     * code famille
     */
    @Column(name = "reclig_famille")
    private String recligFamille;

    /**
     * libelle produit
     */
    @Column(name = "reclig_libelle")
    private String recligLibelle;

    /**
     * reference produit
     */
    @Column(name = "reclig_reference")
    private String recligReference;

    /**
     * code taxe
     */
    @Column(name = "reclig_taxe")
    private String recligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "reclig_taux_taxe")
    private Float recligTauxTaxe = 0F;

    /**
     * unite de stockage
     */
    @Column(name = "reclig_unite")
    private String recligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "reclig_condition")
    private String recligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "reclig_description")
    private String recligDescription;

    /**
     * mode de gestion de stock
     */
    @Column(name = "reclig_stock")
    private Integer recligStock = 0;

    /**
     * echelle de la ligne
     */
    @Column(name = "reclig_echelle")
    private Integer recligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "reclig_qte")
    private Float recligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "reclig_long")
    private Float recligLong = 0F;

    /**
     * largeur ou laize
     */
    @Column(name = "reclig_larg")
    private Float recligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "reclig_haut")
    private Float recligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "reclig_diam")
    private Float recligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "reclig_nb")
    private Float recligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "reclig_poidsNet")
    private Float recligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "reclig_poidsBrut")
    private Float recligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "reclig_volume")
    private Float recligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "reclig_qte_util")
    private Float recligQteUtil = 0F;

    /**
     * code depot
     */
    @Column(name = "reclig_depot")
    private String recligDepot;

    /**
     * code depot de la commande
     */
    @Column(name = "reclig_depot_cmd")
    private String recligDepotCmd;

    /**
     * quantite en stock du depot apres ajout
     */
    @Column(name = "reclig_qte_stock")
    private Float recligQteStock = 0F;

    /**
     * code devise
     */
    @Column(name = "reclig_devise")
    private String recligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "reclig_pu")
    private Double recligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "reclig_taux_remise")
    private Float recligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "reclig_rabais")
    private Double recligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "reclig_pu_rem")
    private Double recligPuRem = 0D;

    /**
     * prix total ht en devise
     */
    @Column(name = "reclig_pt_dev")
    private Double recligPtDev = 0D;

    /**
     * prix total ht
     */
    @Column(name = "reclig_pt")
    private Double recligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "reclig_tva")
    private Double recligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "reclig_tc")
    private Double recligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "reclig_ttc")
    private Double recligTtc = 0D;

    /**
     * prix de revient
     */
    @Column(name = "reclig_pr")
    private Double recligPr = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "reclig_pump")
    private Double recligPump = 0D;

    /**
     * code douane
     */
    @Column(name = "reclig_douane")
    private String recligDouane;

    /**
     * taux douane
     */
    @Column(name = "reclig_taux_douane")
    private Float recligTauxDouane = 0F;

    /**
     * mode saisie 0=laize 1=format
     */
    @Column(name = "reclig_mode")
    private Integer recligMode = 0;

    /**
     * grammage
     */
    @Column(name = "reclig_gr")
    private Float recligGr = 0F;

    /**
     * couleur
     */
    @Column(name = "reclig_couleur")
    private String recligCouleur;

    /**
     * fob
     */
    @Column(name = "reclig_fob")
    private Double recligFob = 0D;

    /**
     * fret
     */
    @Column(name = "reclig_fret")
    private Double recligFret = 0D;

    /**
     * assurance
     */
    @Column(name = "reclig_assurance")
    private Double recligAssurance = 0D;

    /**
     * t1 droit de douane
     */
    @Column(name = "reclig_t1")
    private Double recligT1 = 0D;

    /**
     * t3 rs
     */
    @Column(name = "reclig_t3")
    private Double recligT3 = 0D;

    /**
     * t5 tva
     */
    @Column(name = "reclig_t5")
    private Double recligT5 = 0D;

    /**
     * t10 pcc
     */
    @Column(name = "reclig_t10")
    private Double recligT10 = 0D;

    /**
     * t30
     */
    @Column(name = "reclig_t30")
    private Double recligT30 = 0D;

    /**
     * t31
     */
    @Column(name = "reclig_t31")
    private Double recligT31 = 0D;

    /**
     * total frais
     */
    @Column(name = "reclig_frais")
    private Double recligFrais = 0D;

    /**
     * prix de revient au kilo
     */
    @Column(name = "reclig_pr_kg")
    private Double recligPrKg = 0D;

    /**
     * prix de revient unitaire
     */
    @Column(name = "reclig_pr_u")
    private Double recligPrU = 0D;

    @Column(name = "rec_id", nullable = false)
    private Long recId;

    /**
     * code sommier entree
     */
    @Column(name = "reclig_sommier")
    private String recligSommier;

    /**
     * coefficient prix de revient
     */
    @Column(name = "reclig_coef_pr")
    private Float recligCoefPr = 0F;

    /**
     * frais financier
     */
    @Column(name = "reclig_financier")
    private Double recligFinancier = 0D;

    /**
     * prix de revient ttc
     */
    @Column(name = "reclig_pr_u_ttc")
    private Double recligPrUTtc = 0D;

    /**
     * libelle produit
     */
    @Column(name = "reclig_libelle_fournisseur")
    private String recligLibelleFournisseur;

    /**
     * descriptif complementaire
     */
    @Column(name = "reclig_complement")
    private String recligComplement;

}
