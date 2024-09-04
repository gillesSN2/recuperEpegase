package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchExercicesAchatsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long exeachId;


    /**
     * date de creation
     */
    private LocalDateTime exeachDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime exeachDateModif;


    /**
     * date de cloture
     */
    private LocalDateTime exeachDateCloture;


    /**
     * user de creation
     */
    private Long exeachUserCreat;


    /**
     * user de cloture
     */
    private Long exeachUserCloture;


    /**
     * user de modification
     */
    private Long exeachUserModif;


    /**
     * date debut exercice
     */
    private LocalDate exeachDateDebut;


    /**
     * date fin exercice
     */
    private LocalDate exeachDateFin;


    /**
     * etat 0=en cours 1=cloture
     */
    private Integer exeachEtat;

}
