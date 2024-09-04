package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class VteContratEcheanceQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

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

    private Long crtId;

}
