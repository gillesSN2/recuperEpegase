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
public class VteContratEcheanceVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "crtechId can not null")
    private Long crtechId;


    /**
     * MM:AAAA
     */
    private String crtechPeriode;


    /**
     * date theorique de facturation
     */
    private LocalDate crtechDateTheo;


    /**
     * ht theorique
     */
    private Double crtechHtTheo;


    /**
     * tva theorique
     */
    private Double crtechTvaTheo;


    /**
     * tc theorique
     */
    private Double crtechTcTheo;


    /**
     * ttc theorique
     */
    private Double crtechTtcTheo;


    /**
     * date reelle de facturation
     */
    private LocalDate crtechDateReel;


    /**
     * ht reel
     */
    private Double crtechHtReel;


    /**
     * tva reel
     */
    private Double crtechTvaReel;


    /**
     * tc reel
     */
    private Double crtechTcReel;


    /**
     * ttc reel
     */
    private Double crtechTtcReel;


    /**
     * numero de facture
     */
    private String crtechNumFac;

    @NotNull(message = "crtId can not null")
    private Long crtId;

}
