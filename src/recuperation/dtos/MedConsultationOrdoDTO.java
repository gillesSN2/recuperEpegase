package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class MedConsultationOrdoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cslordId;


    /**
     * code produit
     */
    private String cslordProduit;


    /**
     * libelle produit
     */
    private String cslordLibelle;


    /**
     * posologie
     */
    private String cslordPoso;


    /**
     * observations
     */
    private String cslordObs;

    private Long csgId;


    /**
     * dci
     */
    private String cslordDci;


    /**
     * forme
     */
    private String cslordForme;

}
