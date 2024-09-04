package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PaySalariesCapitalisationDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long salcapId;


    /**
     * date de creation
     */
    private LocalDateTime salcapDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime salcapDateModif;


    /**
     * utilisateur de creation
     */
    private Long salcapUserCreat;


    /**
     * utilisateur de modification
     */
    private Long salcapUserModif;


    /**
     * montant initial
     */
    private Double salcapInital;


    /**
     * montant du versement
     */
    private Double salcapMontant;


    /**
     * rubrique de versement automatique
     */
    private String salcapRubVersement;


    /**
     * rubrique de versement spontanee
     */
    private String salcapRubSpontanee;


    /**
     * rubrique de retrait
     */
    private String salcapRubRetrait;


    /**
     * 0=non valide 1=valide
     */
    private Integer salcapEtat;


    /**
     * date de validation
     */
    private LocalDateTime salcapDateValide;


    /**
     * date impression
     */
    private LocalDateTime salcapDateImp;

    private Long salId;

}
