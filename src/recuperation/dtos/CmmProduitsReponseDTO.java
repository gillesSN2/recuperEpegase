package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmProduitsReponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long prorepId;


    /**
     * 0=reponse predefinie 1=conclusion predefinie
     */
    private Integer prorepType;


    /**
     * texte de la reponse
     */
    private String prorepReponse;


    /**
     * ordre des reponses
     */
    private Integer prorepOrdre;


    /**
     * question
     */
    private String prorepQuestion;


    /**
     * 0=sans reponse 1=reponse positive 2=reponse negative
     */
    private Integer prorepResultat;


    /**
     * action positive
     */
    private String prorepActionPositive;


    /**
     * action negative
     */
    private String prorepActionNegative;

    private Long prolabId;

    private Long prodetId;

    private Long proId;


    /**
     * code produit
     */
    private String prorepCode;


    /**
     * libelle examen
     */
    private String prorepLibelle;

}
