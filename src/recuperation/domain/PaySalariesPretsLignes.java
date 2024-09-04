package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pay_salaries_prets_lignes")
public class PaySalariesPretsLignes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salprelig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salpreligId;

    /**
     * numero du pret
     */
    @Column(name = "salprelig_num")
    private String salpreligNum;

    /**
     * montant theorique
     */
    @Column(name = "salprelig_montant_theo")
    private Double salpreligMontantTheo = 0D;

    /**
     * date theorique de remboursement
     */
    @Column(name = "salprelig_date_theo")
    private LocalDate salpreligDateTheo;

    /**
     * montant reel
     */
    @Column(name = "salprelig_montant_reel")
    private Double salpreligMontantReel = 0D;

    /**
     * date reelle de remboursement
     */
    @Column(name = "salprelig_date_reel")
    private LocalDate salpreligDateReel;

    /**
     * reference de paiement
     */
    @Column(name = "salprelig_reference")
    private String salpreligReference;

    /**
     * date paiement
     */
    @Column(name = "salprelig_date_paiement")
    private LocalDate salpreligDatePaiement;

    /**
     * caisse de paiement
     */
    @Column(name = "salprelig_caisse")
    private String salpreligCaisse;

    @Column(name = "salpre_id", nullable = false)
    private Long salpreId;

    @Column(name = "sal_id")
    private Long salId;

}
