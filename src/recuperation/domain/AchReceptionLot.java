package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ach_reception_lot")
public class AchReceptionLot implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "reclot_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reclotId;

    /**
     * id ligne de reception
     */
    @Column(name = "reclot_id_ligne")
    private Long reclotIdLigne = 0L;

    /**
     * numero de reception
     */
    @Column(name = "reclot_num")
    private String reclotNum;

    /**
     * date achat
     */
    @Column(name = "reclot_date_achat")
    private LocalDate reclotDateAchat;

    /**
     * valable jusqu au
     */
    @Column(name = "reclot_date_valable")
    private LocalDate reclotDateValable;

    /**
     * quantite du lot
     */
    @Column(name = "reclot_qte")
    private Float reclotQte = 0F;

    /**
     * quantite pour le stock
     */
    @Column(name = "reclot_qte_util")
    private Float reclotQteUtil = 0F;

    /**
     * quantite consommee
     */
    @Column(name = "reclot_qte_conso")
    private Float reclotQteConso = 0F;

    /**
     * quantite consomme pour le stock
     */
    @Column(name = "reclot_qte_util_conso")
    private Float reclotQteUtilConso = 0F;

    /**
     * code produit
     */
    @Column(name = "reclot_code")
    private String reclotCode;

    /**
     * code depot
     */
    @Column(name = "reclot_depot")
    private String reclotDepot;

    /**
     * prix de revient
     */
    @Column(name = "reclot_pr")
    private Double reclotPr = 0D;

    /**
     * longueur
     */
    @Column(name = "reclot_long")
    private Float reclotLong = 0F;

    /**
     * largeur
     */
    @Column(name = "reclot_larg")
    private Float reclotLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "reclot_haut")
    private Float reclotHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "reclot_diam")
    private Float reclotDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "reclot_nb")
    private Float reclotNb = 0F;

    /**
     * poids net
     */
    @Column(name = "reclot_poidsNet")
    private Float reclotPoidsnet = 0F;

    /**
     * poids tare
     */
    @Column(name = "reclot_poidsTare")
    private Float reclotPoidstare = 0F;

    /**
     * poids brut
     */
    @Column(name = "reclot_poidsBrut")
    private Float reclotPoidsbrut = 0F;

    /**
     * numero du lot
     */
    @Column(name = "reclot_numero")
    private String reclotNumero;

}
