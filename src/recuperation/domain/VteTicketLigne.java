package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "vte_ticket_ligne")
public class VteTicketLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ticlig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticligId;

    /**
     * code produit
     */
    @Column(name = "ticlig_code")
    private String ticligCode;

    /**
     * famille vente
     */
    @Column(name = "ticlig_famille")
    private String ticligFamille;

    /**
     * libelle produit
     */
    @Column(name = "ticlig_libelle")
    private String ticligLibelle;

    /**
     * code activite
     */
    @Column(name = "ticlig_activite")
    private String ticligActivite;

    /**
     * code taxe
     */
    @Column(name = "ticlig_taxe")
    private String ticligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "ticlig_taux_taxe")
    private Float ticligTauxTaxe = 0F;

    /**
     * code depot
     */
    @Column(name = "ticlig_depot")
    private String ticligDepot;

    /**
     * mode de gestion stock
     */
    @Column(name = "ticlig_stock")
    private Integer ticligStock = 0;

    /**
     * quantite
     */
    @Column(name = "ticlig_qte")
    private Float ticligQte = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "ticlig_qte_util")
    private Float ticligQteUtil = 0F;

    /**
     * prix unitaire
     */
    @Column(name = "ticlig_pu")
    private Double ticligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "ticlig_taux_remise")
    private Float ticligTauxRemise = 0F;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "ticlig_pu_rem")
    private Double ticligPuRem = 0D;

    /**
     * prix unitaire TTC avant remise
     */
    @Column(name = "ticlig_pu_ttc")
    private Double ticligPuTtc = 0D;

    /**
     * prix unitaire TTC apres remise
     */
    @Column(name = "ticlig_pu_rem_ttc")
    private Double ticligPuRemTtc = 0D;

    /**
     * prix total ht
     */
    @Column(name = "ticlig_pt")
    private Double ticligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "ticlig_tva")
    private Double ticligTva = 0D;

    /**
     * taux taxe complementaire
     */
    @Column(name = "ticlig_taux_tc")
    private Float ticligTauxTc = 0F;

    /**
     * total taxe complementaire
     */
    @Column(name = "ticlig_tc")
    private Double ticligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "ticlig_ttc")
    private Double ticligTtc = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "ticlig_pump")
    private Double ticligPump = 0D;

    @Column(name = "tic_id", nullable = false)
    private Long ticId;

    /**
     * poids net
     */
    @Column(name = "ticlig_poidsNet")
    private Float ticligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "ticlig_poidsBrut")
    private Float ticligPoidsbrut = 0F;

}
