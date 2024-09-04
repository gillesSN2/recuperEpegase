package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pay_exercices_paye")
public class PayExercicesPaye implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "exepay_id", nullable = false)
    private Long exepayId;

    /**
     * date de creation
     */
    @Column(name = "exepay_date_creat")
    private LocalDateTime exepayDateCreat;

    /**
     * date de modification
     */
    @Column(name = "exepay_date_modif")
    private LocalDateTime exepayDateModif;

    /**
     * date de cloture
     */
    @Column(name = "exepay_date_cloture")
    private LocalDateTime exepayDateCloture;

    /**
     * user de creation
     */
    @Column(name = "exepay_user_creat")
    private Long exepayUserCreat = 0L;

    /**
     * user de cloture
     */
    @Column(name = "exepay_user_cloture")
    private Long exepayUserCloture = 0L;

    /**
     * user de modification
     */
    @Column(name = "exepay_user_modif")
    private Long exepayUserModif = 0L;

    /**
     * date debut exercice
     */
    @Column(name = "exepay_date_debut")
    private LocalDate exepayDateDebut;

    /**
     * date fin exercice
     */
    @Column(name = "exepay_date_fin")
    private LocalDate exepayDateFin;

    /**
     * etat 0=en cours 1=cloture
     */
    @Column(name = "exepay_etat")
    private Integer exepayEtat = 0;

    /**
     * numero de bordereau
     */
    @Column(name = "exepay_num_brd_01")
    private String exepayNumBrd01;

    /**
     * numero de bordereau
     */
    @Column(name = "exepay_num_brd_02")
    private String exepayNumBrd02;

    /**
     * numero de bordereau
     */
    @Column(name = "exepay_num_brd_03")
    private String exepayNumBrd03;

    /**
     * numero de bordereau
     */
    @Column(name = "exepay_num_brd_04")
    private String exepayNumBrd04;

    /**
     * numero de bordereau
     */
    @Column(name = "exepay_num_brd_05")
    private String exepayNumBrd05;

    /**
     * numero de bordereau
     */
    @Column(name = "exepay_num_brd_06")
    private String exepayNumBrd06;

    /**
     * numero de bordereau
     */
    @Column(name = "exepay_num_brd_07")
    private String exepayNumBrd07;

    /**
     * numero de bordereau
     */
    @Column(name = "exepay_num_brd_08")
    private String exepayNumBrd08;

    /**
     * numero de bordereau
     */
    @Column(name = "exepay_num_brd_09")
    private String exepayNumBrd09;

    /**
     * numero de bordereau
     */
    @Column(name = "exepay_num_brd_10")
    private String exepayNumBrd10;

    /**
     * numero de bordereau
     */
    @Column(name = "exepay_num_brd_11")
    private String exepayNumBrd11;

    /**
     * numero de bordereau
     */
    @Column(name = "exepay_num_brd_12")
    private String exepayNumBrd12;

    /**
     * date de versement
     */
    @Column(name = "exepay_dte_brd_01")
    private LocalDate exepayDteBrd01;

    /**
     * date de versement
     */
    @Column(name = "exepay_dte_brd_02")
    private LocalDate exepayDteBrd02;

    /**
     * date de versement
     */
    @Column(name = "exepay_dte_brd_03")
    private LocalDate exepayDteBrd03;

    /**
     * date de versement
     */
    @Column(name = "exepay_dte_brd_04")
    private LocalDate exepayDteBrd04;

    /**
     * date de versement
     */
    @Column(name = "exepay_dte_brd_05")
    private LocalDate exepayDteBrd05;

    /**
     * date de versement
     */
    @Column(name = "exepay_dte_brd_06")
    private LocalDate exepayDteBrd06;

    /**
     * date de versement
     */
    @Column(name = "exepay_dte_brd_07")
    private LocalDate exepayDteBrd07;

    /**
     * date de versement
     */
    @Column(name = "exepay_dte_brd_08")
    private LocalDate exepayDteBrd08;

    /**
     * date de versement
     */
    @Column(name = "exepay_dte_brd_09")
    private LocalDate exepayDteBrd09;

    /**
     * date de versement
     */
    @Column(name = "exepay_dte_brd_10")
    private LocalDate exepayDteBrd10;

    /**
     * date de versement
     */
    @Column(name = "exepay_dte_brd_11")
    private LocalDate exepayDteBrd11;

    /**
     * date de versement
     */
    @Column(name = "exepay_dte_brd_12")
    private LocalDate exepayDteBrd12;

    /**
     * honoraires redevances
     */
    @Column(name = "exepay_redevance")
    private Double exepayRedevance = 0D;

}
