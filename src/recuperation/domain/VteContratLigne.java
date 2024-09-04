package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "vte_contrat_ligne")
public class VteContratLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "crtlig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crtligId;

    /**
     * ordre des lignes
     */
    @Column(name = "crtlig_ordre")
    private Integer crtligOrdre = 0;

    /**
     * code produit
     */
    @Column(name = "crtlig_code")
    private String crtligCode;

    /**
     * famille vente
     */
    @Column(name = "crtlig_famille")
    private String crtligFamille;

    /**
     * libelle produit
     */
    @Column(name = "crtlig_libelle")
    private String crtligLibelle;

    /**
     * descriptif complementaire
     */
    @Column(name = "crtlig_complement")
    private String crtligComplement;

    /**
     * reference produit
     */
    @Column(name = "crtlig_reference")
    private String crtligReference;

    /**
     * code taxe
     */
    @Column(name = "crtlig_taxe")
    private String crtligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "crtlig_taux_taxe")
    private Float crtligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "crtlig_unite")
    private String crtligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "crtlig_condition")
    private String crtligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "crtlig_description")
    private String crtligDescription;

    /**
     * code depot
     */
    @Column(name = "crtlig_depot")
    private String crtligDepot;

    /**
     * mode de gestion stock
     */
    @Column(name = "crtlig_stock")
    private Integer crtligStock = 0;

    /**
     * quantite en stock
     */
    @Column(name = "crtlig_qte_stock")
    private Float crtligQteStock = 0F;

    /**
     * echelle de la ligne
     */
    @Column(name = "crtlig_echelle")
    private Integer crtligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "crtlig_qte")
    private Float crtligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "crtlig_long")
    private Float crtligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "crtlig_larg")
    private Float crtligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "crtlig_haut")
    private Float crtligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "crtlig_diam")
    private Float crtligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "crtlig_nb")
    private Float crtligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "crtlig_poidsNet")
    private Float crtligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "crtlig_poidsBrut")
    private Float crtligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "crtlig_volume")
    private Float crtligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "crtlig_qte_util")
    private Float crtligQteUtil = 0F;

    /**
     * numero de lot
     */
    @Column(name = "crtlig_lot")
    private String crtligLot;

    /**
     * numero de serie
     */
    @Column(name = "crtlig_num_serie")
    private String crtligNumSerie;

    /**
     * code devise
     */
    @Column(name = "crtlig_devise")
    private String crtligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "crtlig_pu")
    private Double crtligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "crtlig_taux_remise")
    private Float crtligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "crtlig_rabais")
    private Double crtligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "crtlig_pu_rem")
    private Double crtligPuRem = 0D;

    /**
     * prix unitaire TTC avant remise
     */
    @Column(name = "crtlig_pu_ttc")
    private Double crtligPuTtc = 0D;

    /**
     * prix unitaire TTC apres remise
     */
    @Column(name = "crtlig_pu_rem_ttc")
    private Double crtligPuRemTtc = 0D;

    /**
     * prix total ht
     */
    @Column(name = "crtlig_pt")
    private Double crtligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "crtlig_tva")
    private Double crtligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "crtlig_tc")
    private Double crtligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "crtlig_ttc")
    private Double crtligTtc = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "crtlig_pump")
    private Double crtligPump = 0D;

    /**
     * si facture directe et stock alors 1 sinon 0
     */
    @Column(name = "crtlig_ent_stock")
    private Integer crtligEntStock = 0;

    /**
     * total commission
     */
    @Column(name = "crtlig_commission")
    private Double crtligCommission = 0D;

    @Column(name = "crt_id", nullable = false)
    private Long crtId;

}
