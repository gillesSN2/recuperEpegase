package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CptComplementInformationsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cplmenId;


    /**
     * type 0=activites 1=dirigeants 2=actionnaires 3=mca 4=filiales
     */
    private Integer cplmenType;


    /**
     * nom
     */
    private String cplmenNom;


    /**
     * prenom
     */
    private String cplmenPrenom;


    /**
     * nationnamlite
     */
    private String cplmenNation;


    /**
     * qualite
     */
    private String cplmenQualite;


    /**
     * identification fiscale
     */
    private String cplmenFiscal;


    /**
     * designation
     */
    private String cplmenDesignation;


    /**
     * adresse
     */
    private String cplmenAdresse;


    /**
     * code
     */
    private String cplmenCode;


    /**
     * libelle
     */
    private String cplmenLibelle;


    /**
     * total
     */
    private Double cplmenTotal;


    /**
     * % de repartition
     */
    private Float cplmenPourcentage;

    private Long execptId;

}
