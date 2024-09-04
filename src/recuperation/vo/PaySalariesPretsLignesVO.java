package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class PaySalariesPretsLignesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "salpreligId can not null")
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

    @NotNull(message = "salpreId can not null")
    private Long salpreId;

    private Long salId;

}
