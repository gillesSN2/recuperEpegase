package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cai_caisses_jour")
public class CaiCaissesJour implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "caijou_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caijouId;

    /**
     * date de cloture
     */
    @Column(name = "caijou_date_cloture")
    private LocalDateTime caijouDateCloture;

    /**
     * user utilisation de cloture
     */
    @Column(name = "caijou_user_id_cloture")
    private Long caijouUserIdCloture = 0L;

    /**
     * date de transfert
     */
    @Column(name = "caijou_date_transfert")
    private LocalDateTime caijouDateTransfert;

    /**
     * user utilisation de transfert
     */
    @Column(name = "caijou_user_id_transfert")
    private Long caijouUserIdTransfert = 0L;

    /**
     * code caisse
     */
    @Column(name = "caijou_code")
    private String caijouCode;

    /**
     * periode MMAAAA
     */
    @Column(name = "caijou_periode")
    private String caijouPeriode;

    /**
     * date du jour
     */
    @Column(name = "caijou_date")
    private LocalDate caijouDate;

    /**
     * user utilisation caisse
     */
    @Column(name = "caijou_user_id_caisse")
    private Long caijouUserIdCaisse = 0L;

    /**
     * 0=journal ferme 1=journal ouvert
     */
    @Column(name = "caijou_open_journal")
    private Integer caijouOpenJournal = 0;

    /**
     * nom utilisateur en cours
     */
    @Column(name = "caijou_open_user_journal")
    private String caijouOpenUserJournal = "0";

    /**
     * = concatenation caijou_code : caijou_periode
     */
    @Column(name = "caijou_cle1")
    private String caijouCle1 = "0";

    /**
     * 0=en cours 1=cloture mensuelle 2=transfert en compta
     */
    @Column(name = "caijou_etat")
    private Integer caijouEtat = 0;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caijou_solde_espece")
    private Double caijouSoldeEspece = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caijou_solde_cheque")
    private Double caijouSoldeCheque = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caijou_solde_virement")
    private Double caijouSoldeVirement = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caijou_solde_traite")
    private Double caijouSoldeTraite = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caijou_solde_tpe")
    private Double caijouSoldeTpe = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caijou_solde_epaiement")
    private Double caijouSoldeEpaiement = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caijou_solde_transfert")
    private Double caijouSoldeTransfert = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caijou_solde_credoc")
    private Double caijouSoldeCredoc = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caijou_solde_factor")
    private Double caijouSoldeFactor = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caijou_solde_compense")
    private Double caijouSoldeCompense = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caijou_solde_terme")
    private Double caijouSoldeTerme = 0D;

    @Column(name = "execai_id", nullable = false)
    private Long execaiId;

    /**
     * nombre billet
     */
    @Column(name = "caijou_b1")
    private Integer caijouB1 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_b2")
    private Integer caijouB2 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_b3")
    private Integer caijouB3 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_b4")
    private Integer caijouB4 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_b5")
    private Integer caijouB5 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_b6")
    private Integer caijouB6 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_b7")
    private Integer caijouB7 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_b8")
    private Integer caijouB8 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_b9")
    private Integer caijouB9 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_b10")
    private Integer caijouB10 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_p1")
    private Integer caijouP1 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_p2")
    private Integer caijouP2 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_p3")
    private Integer caijouP3 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_p4")
    private Integer caijouP4 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_p5")
    private Integer caijouP5 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_p6")
    private Integer caijouP6 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_p7")
    private Integer caijouP7 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_p8")
    private Integer caijouP8 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_p9")
    private Integer caijouP9 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caijou_p10")
    private Integer caijouP10 = 0;

    /**
     * total des bons
     */
    @Column(name = "caijou_bon")
    private Double caijouBon = 0D;

    /**
     * total des espece
     */
    @Column(name = "caijou_espece")
    private Double caijouEspece = 0D;

    /**
     * total des timbres
     */
    @Column(name = "caijou_timbre")
    private Double caijouTimbre = 0D;

    /**
     * total des hors especes
     */
    @Column(name = "caijou_autre")
    private Double caijouAutre = 0D;

    /**
     * total devise 1
     */
    @Column(name = "caijou_devise1")
    private Double caijouDevise1 = 0D;

    /**
     * total devise 2
     */
    @Column(name = "caijou_devise2")
    private Double caijouDevise2 = 0D;

    /**
     * total devise 3
     */
    @Column(name = "caijou_devise3")
    private Double caijouDevise3 = 0D;

    /**
     * total devise 4
     */
    @Column(name = "caijou_devise4")
    private Double caijouDevise4 = 0D;

    /**
     * total devise 5
     */
    @Column(name = "caijou_devise5")
    private Double caijouDevise5 = 0D;

    /**
     * ecart
     */
    @Column(name = "caijou_ecart")
    private Double caijouEcart = 0D;

    /**
     * observation sur la journee
     */
    @Column(name = "caijou_observation")
    private String caijouObservation;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caijou_solde_bon_caisse")
    private Double caijouSoldeBonCaisse = 0D;

    /**
     * total des espece theorique
     */
    @Column(name = "caijou_espece_theorique")
    private Double caijouEspeceTheorique = 0D;

    /**
     * total des espece apres comptage
     */
    @Column(name = "caijou_espece_reel")
    private Double caijouEspeceReel = 0D;

    /**
     * date de contrle
     */
    @Column(name = "caijou_controle")
    private LocalDate caijouControle;

}
