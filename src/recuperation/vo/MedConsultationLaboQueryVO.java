package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class MedConsultationLaboQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long csllabId;


    /**
     * code produit
     */
    private String csllabProduit;


    /**
     * libelle produit
     */
    private String csllabLibelle;


    /**
     * observations
     */
    private String csllabObs;

    private Long csgId;

}
