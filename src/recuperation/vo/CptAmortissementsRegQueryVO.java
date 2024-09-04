package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CptAmortissementsRegQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long amoregId;


    /**
     * date de creation
     */
    private LocalDateTime amoregDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime amoregDateModif;


    /**
     * utilisateur de creation
     */
    private Long amoregUserCreat;


    /**
     * utilisateur de modification
     */
    private Long amoregUserModif;


    /**
     * date de reglement
     */
    private LocalDate amoregDateReg;


    /**
     * montant payee par le client
     */
    private Double amoregMontant;

    private Long amoId;

}
