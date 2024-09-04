package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class McfExercicesMicrofinanceDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long exemcfId;


    /**
     * date de creation
     */
    private LocalDateTime exemcfDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime exemcfDateModif;


    /**
     * date de cloture
     */
    private LocalDateTime exemcfDateCloture;


    /**
     * user de creation
     */
    private Long exemcfUserCreat;


    /**
     * user de cloture
     */
    private Long exemcfUserCloture;


    /**
     * user de modification
     */
    private Long exemcfUserModif;


    /**
     * date debut exercice
     */
    private LocalDate exemcfDateDebut;


    /**
     * date fin exercice
     */
    private LocalDate exemcfDateFin;


    /**
     * etat 0=en cours 1=cloture
     */
    private Integer exemcfEtat;

}
