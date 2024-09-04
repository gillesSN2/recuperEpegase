package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CaiExercicesCaisseQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long execaiId;


    /**
     * date de creation
     */
    private LocalDateTime execaiDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime execaiDateModif;


    /**
     * date de cloture
     */
    private LocalDateTime execaiDateCloture;


    /**
     * user de creation
     */
    private Long execaiUserCreat;


    /**
     * user de cloture
     */
    private Long execaiUserCloture;


    /**
     * user de modification
     */
    private Long execaiUserModif;


    /**
     * date debut exercice
     */
    private LocalDate execaiDateDebut;


    /**
     * date fin exercice
     */
    private LocalDate execaiDateFin;


    /**
     * etat 0=en cours 1=cloture
     */
    private Integer execaiEtat;

}
