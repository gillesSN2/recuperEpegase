package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cai_caisses_mois")
public class CaiCaissesMois implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "caimen_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caimenId;

    /**
     * date de cloture
     */
    @Column(name = "cai_date_cloture")
    private LocalDateTime caiDateCloture;

    /**
     * user utilisation de cloture
     */
    @Column(name = "caimen_user_id_cloture")
    private Long caimenUserIdCloture = 0L;

    /**
     * date de transfert
     */
    @Column(name = "cai_date_transfert")
    private LocalDateTime caiDateTransfert;

    /**
     * user utilisation de transfert
     */
    @Column(name = "caimen_user_id_transfert")
    private Long caimenUserIdTransfert = 0L;

    /**
     * code caisse
     */
    @Column(name = "caimen_code")
    private String caimenCode;

    /**
     * periode MMAAAA
     */
    @Column(name = "caimen_periode")
    private String caimenPeriode;

    /**
     * date du jour
     */
    @Column(name = "caimen_date")
    private LocalDate caimenDate;

    /**
     * user utilisation caisse
     */
    @Column(name = "caimen_user_id_caisse")
    private Long caimenUserIdCaisse = 0L;

    /**
     * 0=journal ferme 1=journal ouvert
     */
    @Column(name = "caimen_open_journal")
    private Integer caimenOpenJournal = 0;

    /**
     * nom utilisateur en cours
     */
    @Column(name = "caimen_open_user_journal")
    private String caimenOpenUserJournal = "0";

    /**
     * = concatenation caimen_code : caimen_periode
     */
    @Column(name = "caimen_cle1")
    private String caimenCle1 = "0";

    /**
     * 0=en cours 1=cloture mensuelle 2=transfert en compta
     */
    @Column(name = "caimen_etat")
    private Integer caimenEtat = 0;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caimen_solde_espece")
    private Double caimenSoldeEspece = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caimen_solde_cheque")
    private Double caimenSoldeCheque = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caimen_solde_virement")
    private Double caimenSoldeVirement = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caimen_solde_traite")
    private Double caimenSoldeTraite = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caimen_solde_tpe")
    private Double caimenSoldeTpe = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caimen_solde_epaiement")
    private Double caimenSoldeEpaiement = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caimen_solde_transfert")
    private Double caimenSoldeTransfert = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caimen_solde_credoc")
    private Double caimenSoldeCredoc = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caimen_solde_factor")
    private Double caimenSoldeFactor = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caimen_solde_compense")
    private Double caimenSoldeCompense = 0D;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caimen_solde_terme")
    private Double caimenSoldeTerme = 0D;

    @Column(name = "execai_id", nullable = false)
    private Long execaiId;

    /**
     * date de cloture
     */
    @Column(name = "caimen_date_cloture")
    private LocalDateTime caimenDateCloture;

    /**
     * date de transfert
     */
    @Column(name = "caimen_date_transfert")
    private LocalDateTime caimenDateTransfert;

    /**
     * nombre billet
     */
    @Column(name = "caimen_b1")
    private Integer caimenB1 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_b2")
    private Integer caimenB2 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_b3")
    private Integer caimenB3 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_b4")
    private Integer caimenB4 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_b5")
    private Integer caimenB5 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_b6")
    private Integer caimenB6 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_b7")
    private Integer caimenB7 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_b8")
    private Integer caimenB8 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_b9")
    private Integer caimenB9 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_b10")
    private Integer caimenB10 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_p1")
    private Integer caimenP1 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_p2")
    private Integer caimenP2 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_p3")
    private Integer caimenP3 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_p4")
    private Integer caimenP4 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_p5")
    private Integer caimenP5 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_p6")
    private Integer caimenP6 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_p7")
    private Integer caimenP7 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_p8")
    private Integer caimenP8 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_p9")
    private Integer caimenP9 = 0;

    /**
     * nombre billet
     */
    @Column(name = "caimen_p10")
    private Integer caimenP10 = 0;

    /**
     * total des bons
     */
    @Column(name = "caimen_bon")
    private Double caimenBon = 0D;

    /**
     * total des espece
     */
    @Column(name = "caimen_espece")
    private Double caimenEspece = 0D;

    /**
     * total des timbres
     */
    @Column(name = "caimen_timbre")
    private Double caimenTimbre = 0D;

    /**
     * total des hors especes
     */
    @Column(name = "caimen_autre")
    private Double caimenAutre = 0D;

    /**
     * total devise 1
     */
    @Column(name = "caimen_devise1")
    private Double caimenDevise1 = 0D;

    /**
     * total devise 2
     */
    @Column(name = "caimen_devise2")
    private Double caimenDevise2 = 0D;

    /**
     * total devise 3
     */
    @Column(name = "caimen_devise3")
    private Double caimenDevise3 = 0D;

    /**
     * total devise 4
     */
    @Column(name = "caimen_devise4")
    private Double caimenDevise4 = 0D;

    /**
     * total devise 5
     */
    @Column(name = "caimen_devise5")
    private Double caimenDevise5 = 0D;

    /**
     * ecart
     */
    @Column(name = "caimen_ecart")
    private Double caimenEcart = 0D;

    /**
     * observation sur la mois
     */
    @Column(name = "caimen_observation")
    private String caimenObservation;

    /**
     * solde de la caisse anterieur
     */
    @Column(name = "caimen_solde_bon_caisse")
    private Double caimenSoldeBonCaisse = 0D;

    /**
     * total des espece
     */
    @Column(name = "caimen_espece_theorique")
    private Double caimenEspeceTheorique = 0D;

    /**
     * total des espece apres comptage
     */
    @Column(name = "caimen_espece_reel")
    private Double caimenEspeceReel = 0D;

    /**
     * date de contrle
     */
    @Column(name = "caimen_controle")
    private LocalDate caimenControle;

}
