package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cai_caisses_inventaire")
public class CaiCaissesInventaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "caiinv_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caiinvId;

    /**
     * date creation
     */
    @Column(name = "caiinv_date_creation")
    private LocalDateTime caiinvDateCreation;

    /**
     * user utilisation creation
     */
    @Column(name = "caiinv_user_id_creation")
    private Long caiinvUserIdCreation = 0L;

    /**
     * date modification
     */
    @Column(name = "caiinv_date_modif")
    private LocalDateTime caiinvDateModif;

    /**
     * user utilisation modification
     */
    @Column(name = "caiinv_user_id_modif")
    private Long caiinvUserIdModif = 0L;

    /**
     * code caisse
     */
    @Column(name = "caiinv_code_caisse")
    private String caiinvCodeCaisse;

    /**
     * libelle caisse
     */
    @Column(name = "caiinv_lib_caisse")
    private String caiinvLibCaisse;

    /**
     * serie
     */
    @Column(name = "caiinv_serie")
    private String caiinvSerie;

    /**
     * periode MMAAAA
     */
    @Column(name = "caiinv_periode")
    private String caiinvPeriode;

    /**
     * date du jour
     */
    @Column(name = "caiinv_date")
    private LocalDate caiinvDate;

    /**
     * numero inventaire
     */
    @Column(name = "caiinv_num")
    private String caiinvNum;

    /**
     * date du controle
     */
    @Column(name = "caiinv_date_ctrl")
    private LocalDate caiinvDateCtrl;

    /**
     * id caisse jour controle
     */
    @Column(name = "caiinv_caisse_id_ctrl")
    private Long caiinvCaisseIdCtrl = 0L;

    /**
     * user utilisation caisse
     */
    @Column(name = "caiinv_user_id_caisse")
    private Long caiinvUserIdCaisse = 0L;

    /**
     * user utilisation caisse
     */
    @Column(name = "caiinv_user_nom_caisse")
    private Long caiinvUserNomCaisse = 0L;

    /**
     * 0=en cours 1=cloture
     */
    @Column(name = "caiinv_etat")
    private Integer caiinvEtat = 0;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_espece")
    private Double caiinvSoldeEspece = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_cheque")
    private Double caiinvSoldeCheque = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_virement")
    private Double caiinvSoldeVirement = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_traite")
    private Double caiinvSoldeTraite = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_tpe")
    private Double caiinvSoldeTpe = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_epaiement")
    private Double caiinvSoldeEpaiement = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_transfert")
    private Double caiinvSoldeTransfert = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_credoc")
    private Double caiinvSoldeCredoc = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_factor")
    private Double caiinvSoldeFactor = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_compense")
    private Double caiinvSoldeCompense = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_terme")
    private Double caiinvSoldeTerme = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_bon_caisse")
    private Double caiinvSoldeBonCaisse = 0D;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b1")
    private Integer caiinvB1 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b2")
    private Integer caiinvB2 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b3")
    private Integer caiinvB3 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b4")
    private Integer caiinvB4 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b5")
    private Integer caiinvB5 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b6")
    private Integer caiinvB6 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b7")
    private Integer caiinvB7 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b8")
    private Integer caiinvB8 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b9")
    private Integer caiinvB9 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b10")
    private Integer caiinvB10 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p1")
    private Integer caiinvP1 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p2")
    private Integer caiinvP2 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p3")
    private Integer caiinvP3 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p4")
    private Integer caiinvP4 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p5")
    private Integer caiinvP5 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p6")
    private Integer caiinvP6 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p7")
    private Integer caiinvP7 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p8")
    private Integer caiinvP8 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p9")
    private Integer caiinvP9 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p10")
    private Integer caiinvP10 = 0;

    /**
     * total des bons
     */
    @Column(name = "caiinv_bon")
    private Double caiinvBon = 0D;

    /**
     * total des espece
     */
    @Column(name = "caiinv_espece")
    private Double caiinvEspece = 0D;

    /**
     * total des timbres
     */
    @Column(name = "caiinv_timbre")
    private Double caiinvTimbre = 0D;

    /**
     * total des hors especes
     */
    @Column(name = "caiinv_autre")
    private Double caiinvAutre = 0D;

    /**
     * total devise 1
     */
    @Column(name = "caiinv_devise1")
    private Double caiinvDevise1 = 0D;

    /**
     * total devise 2
     */
    @Column(name = "caiinv_devise2")
    private Double caiinvDevise2 = 0D;

    /**
     * total devise 3
     */
    @Column(name = "caiinv_devise3")
    private Double caiinvDevise3 = 0D;

    /**
     * total devise 4
     */
    @Column(name = "caiinv_devise4")
    private Double caiinvDevise4 = 0D;

    /**
     * total devise 5
     */
    @Column(name = "caiinv_devise5")
    private Double caiinvDevise5 = 0D;

    /**
     * ecart
     */
    @Column(name = "caiinv_ecart")
    private Double caiinvEcart = 0D;

    /**
     * observation sur inventaire
     */
    @Column(name = "caiinv_observation")
    private String caiinvObservation;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_espece_reel")
    private Double caiinvSoldeEspeceReel = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_cheque_reel")
    private Double caiinvSoldeChequeReel = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_virement_reel")
    private Double caiinvSoldeVirementReel = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_traite_reel")
    private Double caiinvSoldeTraiteReel = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_tpe_reel")
    private Double caiinvSoldeTpeReel = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_epaiement_reel")
    private Double caiinvSoldeEpaiementReel = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_transfert_reel")
    private Double caiinvSoldeTransfertReel = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_credoc_reel")
    private Double caiinvSoldeCredocReel = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_factor_reel")
    private Double caiinvSoldeFactorReel = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_compense_reel")
    private Double caiinvSoldeCompenseReel = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_terme_reel")
    private Double caiinvSoldeTermeReel = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_bon_caisse_reel")
    private Double caiinvSoldeBonCaisseReel = 0D;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b1_reel")
    private Integer caiinvB1Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b2_reel")
    private Integer caiinvB2Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b3_reel")
    private Integer caiinvB3Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b4_reel")
    private Integer caiinvB4Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b5_reel")
    private Integer caiinvB5Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b6_reel")
    private Integer caiinvB6Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b7_reel")
    private Integer caiinvB7Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b8_reel")
    private Integer caiinvB8Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b9_reel")
    private Integer caiinvB9Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b10_reel")
    private Integer caiinvB10Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p1_reel")
    private Integer caiinvP1Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p2_reel")
    private Integer caiinvP2Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p3_reel")
    private Integer caiinvP3Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p4_reel")
    private Integer caiinvP4Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p5_reel")
    private Integer caiinvP5Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p6_reel")
    private Integer caiinvP6Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p7_reel")
    private Integer caiinvP7Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p8_reel")
    private Integer caiinvP8Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p9_reel")
    private Integer caiinvP9Reel = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p10_reel")
    private Integer caiinvP10Reel = 0;

    /**
     * total des bons
     */
    @Column(name = "caiinv_bon_reel")
    private Double caiinvBonReel = 0D;

    /**
     * total des espece
     */
    @Column(name = "caiinv_espece_reel")
    private Double caiinvEspeceReel = 0D;

    /**
     * total des timbres
     */
    @Column(name = "caiinv_timbre_reel")
    private Double caiinvTimbreReel = 0D;

    /**
     * total des hors especes
     */
    @Column(name = "caiinv_autre_reel")
    private Double caiinvAutreReel = 0D;

    /**
     * total devise 1
     */
    @Column(name = "caiinv_devise1_reel")
    private Double caiinvDevise1Reel = 0D;

    /**
     * total devise 2
     */
    @Column(name = "caiinv_devise2_reel")
    private Double caiinvDevise2Reel = 0D;

    /**
     * total devise 3
     */
    @Column(name = "caiinv_devise3_reel")
    private Double caiinvDevise3Reel = 0D;

    /**
     * total devise 4
     */
    @Column(name = "caiinv_devise4_reel")
    private Double caiinvDevise4Reel = 0D;

    /**
     * total devise 5
     */
    @Column(name = "caiinv_devise5_reel")
    private Double caiinvDevise5Reel = 0D;

    /**
     * ecart
     */
    @Column(name = "caiinv_ecart_reel")
    private Double caiinvEcartReel = 0D;

    /**
     * date impression
     */
    @Column(name = "caiinv_date_impression")
    private LocalDate caiinvDateImpression;

    /**
     * modele impression
     */
    @Column(name = "caiinv_modele_imp")
    private String caiinvModeleImp;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_espece_ecart")
    private Double caiinvSoldeEspeceEcart = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_cheque_ecart")
    private Double caiinvSoldeChequeEcart = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_virement_ecart")
    private Double caiinvSoldeVirementEcart = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_traite_ecart")
    private Double caiinvSoldeTraiteEcart = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_tpe_ecart")
    private Double caiinvSoldeTpeEcart = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_epaiement_ecart")
    private Double caiinvSoldeEpaiementEcart = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_transfert_ecart")
    private Double caiinvSoldeTransfertEcart = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_credoc_ecart")
    private Double caiinvSoldeCredocEcart = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_factor_ecart")
    private Double caiinvSoldeFactorEcart = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_compense_ecart")
    private Double caiinvSoldeCompenseEcart = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_terme_ecart")
    private Double caiinvSoldeTermeEcart = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caiinv_solde_bon_caisse_ecart")
    private Double caiinvSoldeBonCaisseEcart = 0D;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b1_ecart")
    private Integer caiinvB1Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b2_ecart")
    private Integer caiinvB2Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b3_ecart")
    private Integer caiinvB3Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b4_ecart")
    private Integer caiinvB4Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b5_ecart")
    private Integer caiinvB5Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b6_ecart")
    private Integer caiinvB6Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b7_ecart")
    private Integer caiinvB7Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b8_ecart")
    private Integer caiinvB8Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b9_ecart")
    private Integer caiinvB9Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_b10_ecart")
    private Integer caiinvB10Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p1_ecart")
    private Integer caiinvP1Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p2_ecart")
    private Integer caiinvP2Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p3_ecart")
    private Integer caiinvP3Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p4_ecart")
    private Integer caiinvP4Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p5_ecart")
    private Integer caiinvP5Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p6_ecart")
    private Integer caiinvP6Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p7_ecart")
    private Integer caiinvP7Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p8_ecart")
    private Integer caiinvP8Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p9_ecart")
    private Integer caiinvP9Ecart = 0;

    /**
     * nombre billet
     */
    @Column(name = "caiinv_p10_ecart")
    private Integer caiinvP10Ecart = 0;

    /**
     * total des bons
     */
    @Column(name = "caiinv_bon_ecart")
    private Double caiinvBonEcart = 0D;

    /**
     * total des espece
     */
    @Column(name = "caiinv_espece_ecart")
    private Double caiinvEspeceEcart = 0D;

    /**
     * total des timbres
     */
    @Column(name = "caiinv_timbre_ecart")
    private Double caiinvTimbreEcart = 0D;

    /**
     * total des hors especes
     */
    @Column(name = "caiinv_autre_ecart")
    private Double caiinvAutreEcart = 0D;

    /**
     * total devise 1
     */
    @Column(name = "caiinv_devise1_ecart")
    private Double caiinvDevise1Ecart = 0D;

    /**
     * total devise 2
     */
    @Column(name = "caiinv_devise2_ecart")
    private Double caiinvDevise2Ecart = 0D;

    /**
     * total devise 3
     */
    @Column(name = "caiinv_devise3_ecart")
    private Double caiinvDevise3Ecart = 0D;

    /**
     * total devise 4
     */
    @Column(name = "caiinv_devise4_ecart")
    private Double caiinvDevise4Ecart = 0D;

    /**
     * total devise 5
     */
    @Column(name = "caiinv_devise5_ecart")
    private Double caiinvDevise5Ecart = 0D;

    /**
     * ecart
     */
    @Column(name = "caiinv_ecart_ecart")
    private Double caiinvEcartEcart = 0D;

    @Column(name = "execai_id", nullable = false)
    private Long execaiId;

}
