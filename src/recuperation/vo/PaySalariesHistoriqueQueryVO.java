package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PaySalariesHistoriqueQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long salhisId;


    /**
     * numero contrat
     */
    private String salhisContrat;


    /**
     * code rubrique
     */
    private String salhisCode;


    /**
     * libelle rubrique
     */
    private String salhisLibelle;


    /**
     * date historique
     */
    private LocalDate salhisDate;


    /**
     * valeur colonne E
     */
    private Double salhisValeurCole;

    private Long salId;

    private Long exepayId;

}
