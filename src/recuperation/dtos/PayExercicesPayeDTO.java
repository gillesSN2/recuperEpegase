package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PayExercicesPayeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long exepayId;


    /**
     * date de creation
     */
    private LocalDateTime exepayDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime exepayDateModif;


    /**
     * date de cloture
     */
    private LocalDateTime exepayDateCloture;


    /**
     * user de creation
     */
    private Long exepayUserCreat;


    /**
     * user de cloture
     */
    private Long exepayUserCloture;


    /**
     * user de modification
     */
    private Long exepayUserModif;


    /**
     * date debut exercice
     */
    private LocalDate exepayDateDebut;


    /**
     * date fin exercice
     */
    private LocalDate exepayDateFin;


    /**
     * etat 0=en cours 1=cloture
     */
    private Integer exepayEtat;


    /**
     * numero de bordereau
     */
    private String exepayNumBrd01;


    /**
     * numero de bordereau
     */
    private String exepayNumBrd02;


    /**
     * numero de bordereau
     */
    private String exepayNumBrd03;


    /**
     * numero de bordereau
     */
    private String exepayNumBrd04;


    /**
     * numero de bordereau
     */
    private String exepayNumBrd05;


    /**
     * numero de bordereau
     */
    private String exepayNumBrd06;


    /**
     * numero de bordereau
     */
    private String exepayNumBrd07;


    /**
     * numero de bordereau
     */
    private String exepayNumBrd08;


    /**
     * numero de bordereau
     */
    private String exepayNumBrd09;


    /**
     * numero de bordereau
     */
    private String exepayNumBrd10;


    /**
     * numero de bordereau
     */
    private String exepayNumBrd11;


    /**
     * numero de bordereau
     */
    private String exepayNumBrd12;


    /**
     * date de versement
     */
    private LocalDate exepayDteBrd01;


    /**
     * date de versement
     */
    private LocalDate exepayDteBrd02;


    /**
     * date de versement
     */
    private LocalDate exepayDteBrd03;


    /**
     * date de versement
     */
    private LocalDate exepayDteBrd04;


    /**
     * date de versement
     */
    private LocalDate exepayDteBrd05;


    /**
     * date de versement
     */
    private LocalDate exepayDteBrd06;


    /**
     * date de versement
     */
    private LocalDate exepayDteBrd07;


    /**
     * date de versement
     */
    private LocalDate exepayDteBrd08;


    /**
     * date de versement
     */
    private LocalDate exepayDteBrd09;


    /**
     * date de versement
     */
    private LocalDate exepayDteBrd10;


    /**
     * date de versement
     */
    private LocalDate exepayDteBrd11;


    /**
     * date de versement
     */
    private LocalDate exepayDteBrd12;


    /**
     * honoraires redevances
     */
    private Double exepayRedevance;

}
