package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CmmProduitsHistoRefQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long prohrfId;


    /**
     * reference founisseur
     */
    private String prohrfReference;


    /**
     * date de debut d utilisation
     */
    private LocalDate prohrfDateDebut;


    /**
     * date de fin d utilisation
     */
    private LocalDate prohrfDateFin;


    /**
     * observations
     */
    private String prohrfObs;

    private Long proId;

}
