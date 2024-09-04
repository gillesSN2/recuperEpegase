package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_avoir_ligne")
public class AchAvoirLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "avflig_id", nullable = false)
    private Long avfligId;

    /**
     * id de la ligne de note de debit
     */
    @Column(name = "avflig_id_Ndf")
    private Long avfligIdNdf = 0L;

    /**
     * id de la ligne de facture
     */
    @Column(name = "avflig_id_fcf")
    private Long avfligIdFcf = 0L;

    /**
     * code produit
     */
    @Column(name = "avflig_code")
    private String avfligCode;

    /**
     * famille vente
     */
    @Column(name = "avflig_famille")
    private String avfligFamille;

    /**
     * libelle produit
     */
    @Column(name = "avflig_libelle")
    private String avfligLibelle;

    /**
     * reference produit
     */
    @Column(name = "avflig_reference")
    private String avfligReference;

    /**
     * code taxe
     */
    @Column(name = "avflig_taxe")
    private String avfligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "avflig_taux_taxe")
    private Float avfligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "avflig_unite")
    private String avfligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "avflig_condition")
    private String avfligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "avflig_description")
    private String avfligDescription;

    /**
     * echelle de la ligne
     */
    @Column(name = "avflig_echelle")
    private Integer avfligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "avflig_qte")
    private Float avfligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "avflig_long")
    private Float avfligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "avflig_larg")
    private Float avfligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "avflig_haut")
    private Float avfligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "avflig_diam")
    private Float avfligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "avflig_nb")
    private Float avfligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "avflig_poidsNet")
    private Float avfligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "avflig_poidsBrut")
    private Float avfligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "avflig_volume")
    private Float avfligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "avflig_qte_util")
    private Float avfligQteUtil = 0F;

    /**
     * code devise
     */
    @Column(name = "avflig_devise")
    private String avfligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "avflig_pu")
    private Double avfligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "avflig_taux_remise")
    private Float avfligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "avflig_rabais")
    private Double avfligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "avflig_pu_rem")
    private Double avfligPuRem = 0D;

    /**
     * prix total ht
     */
    @Column(name = "avflig_pt")
    private Double avfligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "avflig_tva")
    private Double avfligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "avflig_tc")
    private Double avfligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "avflig_ttc")
    private Double avfligTtc = 0D;

    /**
     * prix de revient
     */
    @Column(name = "avflig_pr")
    private Double avfligPr = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "avflig_pump")
    private Double avfligPump = 0D;

    @Column(name = "avf_id", nullable = false)
    private Long avfId;

    /**
     * libelle produit
     */
    @Column(name = "avflig_libelle_fournisseur")
    private String avfligLibelleFournisseur;

    /**
     * descriptif complementaire
     */
    @Column(name = "avflig_complement")
    private String avfligComplement;

}
