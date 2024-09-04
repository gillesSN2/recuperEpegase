package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmProduitsDetailDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long prodetId;


    /**
     * ordre des reponses
     */
    private Integer prodetOrdre;


    /**
     * nom item en FR
     */
    private String prodetLibelle;


    /**
     * 0=titre 1=numerique 2=date 3=image 4=texte 5=reponse unique 6=reponse unique + action 7=reponse multiple
     */
    private Integer prodetType;


    /**
     * unite usuelle
     */
    private String prodetUnite;


    /**
     * coefficient de convertion
     */
    private Float prodetCoef;


    /**
     * unite convertie
     */
    private String prodetUniteConv;


    /**
     * norme statique
     */
    private String prodetNorme;

    private Long prolabId;

    private Long proId;


    /**
     * code produit
     */
    private String prodetCode;

}
