package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class CmmSmsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "smsId can not null")
    private Long smsId;


    /**
     * date envoi sms
     */
    private LocalDateTime smsDate;


    /**
     * numero campagne sms
     */
    private String smsNum;


    /**
     * texte du sms
     */
    private String smsTexte;


    /**
     * status du sms
     */
    private String smsStatus;


    /**
     * mobile du contact
     */
    private String smsMobile;


    /**
     * nom du contact
     */
    private String smsNomContact;


    /**
     * civilite du contact
     */
    private String smsCiviliteContzct;


    /**
     * id du contact
     */
    private Long smsIdContact;


    /**
     * type du tiers 0=tiers 1=agents 2=salaries 4=patients 5=eleves 90=achats sms 99=sms initial
     */
    private Integer smsTypeTiers;


    /**
     * nom du tiers
     */
    private String smsNomTiers;


    /**
     * id du tiers
     */
    private Long smsIdTiers;


    /**
     * qte operation
     */
    private Integer smsQte;

    private Long usrId;

}
