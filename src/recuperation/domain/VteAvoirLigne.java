package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "vte_avoir_ligne")
public class VteAvoirLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "avrlig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avrligId;

    /**
     * id de la ligne facture
     */
    @Column(name = "avrlig_id_fac")
    private Long avrligIdFac = 0L;

    /**
     * id de la ligne note de debit
     */
    @Column(name = "avrlig_id_ndb")
    private Long avrligIdNdb = 0L;

    /**
     * code produit
     */
    @Column(name = "avrlig_code")
    private String avrligCode;

    /**
     * famille vente
     */
    @Column(name = "avrlig_famille")
    private String avrligFamille;

    /**
     * libelle produit
     */
    @Column(name = "avrlig_libelle")
    private String avrligLibelle;

    /**
     * reference produit
     */
    @Column(name = "avrlig_reference")
    private String avrligReference;

    /**
     * code taxe
     */
    @Column(name = "avrlig_taxe")
    private String avrligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "avrlig_taux_taxe")
    private Float avrligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "avrlig_unite")
    private String avrligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "avrlig_condition")
    private String avrligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "avrlig_description")
    private String avrligDescription;

    /**
     * code depot
     */
    @Column(name = "avrlig_depot")
    private String avrligDepot;

    /**
     * mode gestion en stock
     */
    @Column(name = "avrlig_stock")
    private Integer avrligStock = 0;

    /**
     * quantite en stock
     */
    @Column(name = "avrlig_qte_stock")
    private Float avrligQteStock = 0F;

    /**
     * echelle de la ligne
     */
    @Column(name = "avrlig_echelle")
    private Integer avrligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "avrlig_qte")
    private Float avrligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "avrlig_long")
    private Float avrligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "avrlig_larg")
    private Float avrligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "avrlig_haut")
    private Float avrligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "avrlig_diam")
    private Float avrligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "avrlig_nb")
    private Float avrligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "avrlig_poidsNet")
    private Float avrligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "avrlig_poidsBrut")
    private Float avrligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "avrlig_volume")
    private Float avrligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "avrlig_qte_util")
    private Float avrligQteUtil = 0F;

    /**
     * numero de lot
     */
    @Column(name = "avrlig_lot")
    private String avrligLot;

    /**
     * numero de serie
     */
    @Column(name = "avrlig_num_serie")
    private String avrligNumSerie;

    /**
     * code devise
     */
    @Column(name = "avrlig_devise")
    private String avrligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "avrlig_pu")
    private Double avrligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "avrlig_taux_remise")
    private Float avrligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "avrlig_rabais")
    private Double avrligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "avrlig_pu_rem")
    private Double avrligPuRem = 0D;

    /**
     * prix unitaire avant remise
     */
    @Column(name = "avrlig_pu_ttc")
    private Double avrligPuTtc = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "avrlig_pu_rem_ttc")
    private Double avrligPuRemTtc = 0D;

    /**
     * prix total ht
     */
    @Column(name = "avrlig_pt")
    private Double avrligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "avrlig_tva")
    private Double avrligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "avrlig_tc")
    private Double avrligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "avrlig_ttc")
    private Double avrligTtc = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "avrlig_pump")
    private Double avrligPump = 0D;

    @Column(name = "avr_id", nullable = false)
    private Long avrId;

    /**
     * total commission
     */
    @Column(name = "avrlig_commission")
    private Double avrligCommission = 0D;

    /**
     * ordre des lignes
     */
    @Column(name = "avrlig_ordre")
    private Integer avrligOrdre = 0;

    /**
     * descriptif complementaire
     */
    @Column(name = "avrlig_complement")
    private String avrligComplement;

}
