package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PaySalariesPretsLignesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long salpreligId;


    /**
     * numero du pret
     */
    private String salpreligNum;


    /**
     * montant theorique
     */
    private Double salpreligMontantTheo;


    /**
     * date theorique de remboursement
     */
    private LocalDate salpreligDateTheo;


    /**
     * montant reel
     */
    private Double salpreligMontantReel;


    /**
     * date reelle de remboursement
     */
    private LocalDate salpreligDateReel;


    /**
     * reference de paiement
     */
    private String salpreligReference;


    /**
     * date paiement
     */
    private LocalDate salpreligDatePaiement;


    /**
     * caisse de paiement
     */
    private String salpreligCaisse;

    private Long salpreId;

    private Long salId;

}
