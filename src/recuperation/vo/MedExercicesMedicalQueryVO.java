package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class MedExercicesMedicalQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long exemedId;


    /**
     * date de creation de l exercice
     */
    private LocalDate exemedDateCreat;


    /**
     * date de modification de l exercice
     */
    private LocalDate exemedDateModif;


    /**
     * date de cloture de l exercice
     */
    private LocalDate exemedDateCloture;


    /**
     * utilisateur de creation de l exericce
     */
    private Long exemedUserCreat;


    /**
     * utilisateur qui a fait la cloture
     */
    private Long exemedUserCloture;


    /**
     * utilisateur de modification de l exercice
     */
    private Long exemedUserModif;


    /**
     * date de debut de l exercice
     */
    private LocalDate exemedDateDebut;


    /**
     * date de fin de l exercice
     */
    private LocalDate exemedDateFin;


    /**
     * 0=exercice en cours 1=exercice cloture
     */
    private Integer exemedEtat;

}
