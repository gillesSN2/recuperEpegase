package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmDouanesPositionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long douposId;


    /**
     * code zone commerciale
     */
    private String douposZone;


    /**
     * code douane
     */
    private String douposCode;


    /**
     * nom activite en FR
     */
    private String douposLibFr;


    /**
     * nom activite en UK
     */
    private String douposLibUk;


    /**
     * nom activite en SP
     */
    private String douposLibSp;


    /**
     * unite
     */
    private String douposUnite;


    /**
     * droit de douane
     */
    private Float douposDd;


    /**
     * risque de solidarite
     */
    private Float douposRs;


    /**
     * taux ??
     */
    private Float douposPcs;


    /**
     * droit accise
     */
    private Float douposDa;


    /**
     * autre droit
     */
    private Float douposAd;


    /**
     * tva
     */
    private Float douposTva;


    /**
     * taux cumule
     */
    private Float douposCumul;


    /**
     * chapitre
     */
    private String douposChapitre;


    /**
     * code chapitre
     */
    private String douposCodeChapitre;


    /**
     * section
     */
    private String douposSection;


    /**
     * code section
     */
    private String douposCodeSection;


    /**
     * 0=non utilise 1=utilise
     */
    private Integer douposUtil;

}
