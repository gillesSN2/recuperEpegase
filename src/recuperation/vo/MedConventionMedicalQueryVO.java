package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MedConventionMedicalQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long cvnId;


    /**
     * date de creation
     */
    private LocalDateTime cvnDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime cvnDateModif;


    /**
     * user de creation
     */
    private Long cvnUserCreat;


    /**
     * user de modification
     */
    private Long cvnUserModif;


    /**
     * type (lettre, produit...)
     */
    private String cvnType;


    /**
     * code lettre
     */
    private String cvnLettre;


    /**
     * libelle
     */
    private String cvnLibelle;


    /**
     * valeur de la lettre
     */
    private Double cvnValeur;

    private Long exemedId;

    private Long tieId;

    private Long exevteId;

}
