package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class MedPatientProtDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long patprtId;


    /**
     * date de debut du protocole
     */
    private LocalDate patprtDateDebut;


    /**
     * date de fin du protocole
     */
    private LocalDate patptrDateFin;


    /**
     * code du protocole
     */
    private String patptrCode;


    /**
     * libelle du protocole
     */
    private String patptrLibelle;

    private Long patId;

}
