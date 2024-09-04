package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_commande_ligne")
public class AchCommandeLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cmdlig_id", nullable = false)
    private Long cmdligId;

    /**
     * Da associe
     */
    @Column(name = "cmdlig_id_da")
    private Long cmdligIdDa = 0L;

    /**
     * id de la ligne cotation
     */
    @Column(name = "cmdlig_id_cot")
    private Long cmdligIdCot = 0L;

    /**
     * code produit
     */
    @Column(name = "cmdlig_code")
    private String cmdligCode;

    /**
     * famille vente
     */
    @Column(name = "cmdlig_famille")
    private String cmdligFamille;

    /**
     * libelle produit
     */
    @Column(name = "cmdlig_libelle")
    private String cmdligLibelle;

    /**
     * reference produit
     */
    @Column(name = "cmdlig_reference")
    private String cmdligReference;

    /**
     * code taxe
     */
    @Column(name = "cmdlig_taxe")
    private String cmdligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "cmdlig_taux_taxe")
    private Float cmdligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "cmdlig_unite")
    private String cmdligUnite;

    /**
     * mode de gestion de stock
     */
    @Column(name = "cmdlig_stock")
    private Integer cmdligStock = 0;

    /**
     * conditionnement produit
     */
    @Column(name = "cmdlig_condition")
    private String cmdligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "cmdlig_description")
    private String cmdligDescription;

    /**
     * echelle de la ligne
     */
    @Column(name = "cmdlig_echelle")
    private Integer cmdligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "cmdlig_qte")
    private Float cmdligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "cmdlig_long")
    private Float cmdligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "cmdlig_larg")
    private Float cmdligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "cmdlig_haut")
    private Float cmdligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "cmdlig_diam")
    private Float cmdligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "cmdlig_nb")
    private Float cmdligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "cmdlig_poidsNet")
    private Float cmdligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "cmdlig_poidsBrut")
    private Float cmdligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "cmdlig_volume")
    private Float cmdligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "cmdlig_qte_util")
    private Float cmdligQteUtil = 0F;

    /**
     * code depot
     */
    @Column(name = "cmdlig_depot")
    private String cmdligDepot;

    /**
     * quantite en stock
     */
    @Column(name = "cmdlig_qte_stock")
    private Float cmdligQteStock = 0F;

    /**
     * code devise
     */
    @Column(name = "cmdlig_devise")
    private String cmdligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "cmdlig_pu")
    private Double cmdligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "cmdlig_taux_remise")
    private Float cmdligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "cmdlig_rabais")
    private Double cmdligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "cmdlig_pu_rem")
    private Double cmdligPuRem = 0D;

    /**
     * prix total ht en devise
     */
    @Column(name = "cmdlig_pt_dev")
    private Double cmdligPtDev = 0D;

    /**
     * prix total ht
     */
    @Column(name = "cmdlig_pt")
    private Double cmdligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "cmdlig_tva")
    private Double cmdligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "cmdlig_tc")
    private Double cmdligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "cmdlig_ttc")
    private Double cmdligTtc = 0D;

    /**
     * prix de revient
     */
    @Column(name = "cmdlig_pr")
    private Double cmdligPr = 0D;

    /**
     * prix de revient
     */
    @Column(name = "cmdlig_pump")
    private Double cmdligPump = 0D;

    /**
     * code douane
     */
    @Column(name = "cmdlig_douane")
    private String cmdligDouane;

    /**
     * taux douane
     */
    @Column(name = "cmdlig_taux_douane")
    private Float cmdligTauxDouane = 0F;

    /**
     * mode saisie 0=laize 1=format
     */
    @Column(name = "cmdlig_mode")
    private Integer cmdligMode = 0;

    /**
     * grammage
     */
    @Column(name = "cmdlig_gr")
    private Float cmdligGr = 0F;

    /**
     * couleur
     */
    @Column(name = "cmdlig_couleur")
    private String cmdligCouleur;

    /**
     * fob
     */
    @Column(name = "cmdlig_fob")
    private Double cmdligFob = 0D;

    /**
     * fret
     */
    @Column(name = "cmdlig_fret")
    private Double cmdligFret = 0D;

    /**
     * assurance
     */
    @Column(name = "cmdlig_assurance")
    private Double cmdligAssurance = 0D;

    /**
     * t1 droit de douane
     */
    @Column(name = "cmdlig_t1")
    private Double cmdligT1 = 0D;

    /**
     * t3 rs
     */
    @Column(name = "cmdlig_t3")
    private Double cmdligT3 = 0D;

    /**
     * t5 tva
     */
    @Column(name = "cmdlig_t5")
    private Double cmdligT5 = 0D;

    /**
     * t10 pcc
     */
    @Column(name = "cmdlig_t10")
    private Double cmdligT10 = 0D;

    /**
     * t30
     */
    @Column(name = "cmdlig_t30")
    private Double cmdligT30 = 0D;

    /**
     * t31
     */
    @Column(name = "cmdlig_t31")
    private Double cmdligT31 = 0D;

    /**
     * total frais
     */
    @Column(name = "cmdlig_frais")
    private Double cmdligFrais = 0D;

    /**
     * prix de revient au kilo
     */
    @Column(name = "cmdlig_pr_kr")
    private Double cmdligPrKr = 0D;

    /**
     * prix de revient unitaire
     */
    @Column(name = "cmdlig_pr_u")
    private Double cmdligPrU = 0D;

    @Column(name = "cmd_id", nullable = false)
    private Long cmdId;

    /**
     * frais financier
     */
    @Column(name = "cmdlig_financier")
    private Double cmdligFinancier = 0D;

    /**
     * prix de revient unitaire ttc
     */
    @Column(name = "cmdlig_pr_u_ttc")
    private Double cmdligPrUTtc = 0D;

    /**
     * ordre des lignes
     */
    @Column(name = "cmdlig_ordre")
    private Integer cmdligOrdre = 0;

    /**
     * libelle produit
     */
    @Column(name = "cmdlig_libelle_fournisseur")
    private String cmdligLibelleFournisseur;

    /**
     * descriptif complementaire
     */
    @Column(name = "cmdlig_complement")
    private String cmdligComplement;

}
