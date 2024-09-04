package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmProduitsGrpQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long progrpId;


    /**
     * code produit constituant
     */
    private String progrpCode;


    /**
     * libelle produit constituant
     */
    private String progrpLibelle;


    /**
     * depot du produit constituant
     */
    private String progrpDepot;


    /**
     * quantite concernee
     */
    private Float progrpQte;


    /**
     * unite
     */
    private String progrpUnite;


    /**
     * pump du produit constrituant
     */
    private Double progrpPump;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer progrpInactif;

    private Long proId;

}
