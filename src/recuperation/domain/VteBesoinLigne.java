package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "vte_besoin_ligne")
public class VteBesoinLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "beslig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long besligId;

    /**
     * code produit
     */
    @Column(name = "beslig_code")
    private String besligCode;

    /**
     * famille vente
     */
    @Column(name = "beslig_famille")
    private String besligFamille;

    /**
     * libelle produit
     */
    @Column(name = "beslig_libelle")
    private String besligLibelle;

    /**
     * reference produit
     */
    @Column(name = "beslig_reference")
    private String besligReference;

    /**
     * code taxe
     */
    @Column(name = "beslig_taxe")
    private String besligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "beslig_taux_taxe")
    private Float besligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "beslig_unite")
    private String besligUnite;

    /**
     * conditionnement produit
     */
    @Column(name = "beslig_condition")
    private String besligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "beslig_description")
    private String besligDescription;

    /**
     * echelle de la ligne
     */
    @Column(name = "beslig_echelle")
    private Integer besligEchelle = 0;

    /**
     * quantite
     */
    @Column(name = "beslig_qte")
    private Float besligQte = 0F;

    /**
     * longueur
     */
    @Column(name = "beslig_long")
    private Float besligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "beslig_larg")
    private Float besligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "beslig_haut")
    private Float besligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "beslig_diam")
    private Float besligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "beslig_nb")
    private Float besligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "beslig_poidsNet")
    private Float besligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "beslig_poidsBrut")
    private Float besligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "beslig_volume")
    private Float besligVolume = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "beslig_qte_util")
    private Float besligQteUtil = 0F;

    /**
     * mode de gestion du stock
     */
    @Column(name = "beslig_stock")
    private Integer besligStock = 0;

    /**
     * code depot
     */
    @Column(name = "beslig_depot")
    private String besligDepot;

    /**
     * code devise
     */
    @Column(name = "beslig_devise")
    private String besligDevise;

    /**
     * prix unitaire HT avant remise
     */
    @Column(name = "beslig_pu")
    private Double besligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "beslig_taux_remise")
    private Float besligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "beslig_rabais")
    private Double besligRabais = 0D;

    /**
     * prix unitaire Ht apres remise
     */
    @Column(name = "beslig_pu_rem")
    private Double besligPuRem = 0D;

    /**
     * prix unitaire Ttc avant remise
     */
    @Column(name = "beslig_pu_ttc")
    private Double besligPuTtc = 0D;

    /**
     * prix unitaire Ttc apres remise
     */
    @Column(name = "beslig_pu_rem_ttc")
    private Double besligPuRemTtc = 0D;

    /**
     * prix total ht
     */
    @Column(name = "beslig_pt")
    private Double besligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "beslig_tva")
    private Double besligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "beslig_tc")
    private Double besligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "beslig_ttc")
    private Double besligTtc = 0D;

    /**
     * prix unitaire moyen pondere unitaire
     */
    @Column(name = "beslig_pump")
    private Double besligPump = 0D;

    @Column(name = "bes_id", nullable = false)
    private Long besId;

}
