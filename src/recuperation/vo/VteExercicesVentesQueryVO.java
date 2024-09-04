package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VteExercicesVentesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long exevteId;


    /**
     * date de creation
     */
    private LocalDateTime exevteDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime exevteDateModif;


    /**
     * date de cloture
     */
    private LocalDateTime exevteDateCloture;


    /**
     * user de creation
     */
    private Long exevteUserCreat;


    /**
     * user de cloture
     */
    private Long exevteUserCloture;


    /**
     * user de modification
     */
    private Long exevteUserModif;


    /**
     * date debut exercice
     */
    private LocalDate exevteDateDebut;


    /**
     * date fin exercice
     */
    private LocalDate exevteDateFin;


    /**
     * etat 0=en cours 1=cloture
     */
    private Integer exevteEtat;

}
