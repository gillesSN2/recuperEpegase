package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "vte_contrat_echeance")
public class VteContratEcheance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "crtech_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crtechId;

    /**
     * MM:AAAA
     */
    @Column(name = "crtech_periode")
    private String crtechPeriode;

    /**
     * date theorique de facturation
     */
    @Column(name = "crtech_date_theo")
    private LocalDate crtechDateTheo;

    /**
     * ht theorique
     */
    @Column(name = "crtech_ht_theo")
    private Double crtechHtTheo = 0D;

    /**
     * tva theorique
     */
    @Column(name = "crtech_tva_theo")
    private Double crtechTvaTheo = 0D;

    /**
     * tc theorique
     */
    @Column(name = "crtech_tc_theo")
    private Double crtechTcTheo = 0D;

    /**
     * ttc theorique
     */
    @Column(name = "crtech_ttc_theo")
    private Double crtechTtcTheo = 0D;

    /**
     * date reelle de facturation
     */
    @Column(name = "crtech_date_reel")
    private LocalDate crtechDateReel;

    /**
     * ht reel
     */
    @Column(name = "crtech_ht_reel")
    private Double crtechHtReel = 0D;

    /**
     * tva reel
     */
    @Column(name = "crtech_tva_reel")
    private Double crtechTvaReel = 0D;

    /**
     * tc reel
     */
    @Column(name = "crtech_tc_reel")
    private Double crtechTcReel = 0D;

    /**
     * ttc reel
     */
    @Column(name = "crtech_ttc_reel")
    private Double crtechTtcReel = 0D;

    /**
     * numero de facture
     */
    @Column(name = "crtech_num_fac")
    private String crtechNumFac;

    @Column(name = "crt_id", nullable = false)
    private Long crtId;

}
